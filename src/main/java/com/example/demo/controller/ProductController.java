package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.dbflute.optional.OptionalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dbflute.exentity.Product;
import com.example.demo.dbflute.exentity.Stock;
import com.example.demo.dbflute.exentity.customize.ProductRelation;
import com.example.demo.dto.ProductForm;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
    }
    
    final static Map<String, String> UNIT_ITEMS =
    	    Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
    	    {
    	      put("円", "yen");
    	      put("USDドル", "usd");
    	    }
          });
    
    final static List<String> LIST_IMG = Collections.unmodifiableList(new ArrayList<String>() {
        {
            add(".jpg");
            add(".jpeg");
            add(".gif");
            add(".png");
        }
    });
    

    @GetMapping
    public String index(ProductForm productForm, Model model) {
        List<ProductRelation> list = productService.getAll();
        model.addAttribute("Productlist", list);
        model.addAttribute("title", "Producttitle");

        return "product/index";

    }
    
    @GetMapping("/form")
    public String productForm(ProductForm productForm, Model model) {

        productForm.setNewProduct(true);
        model.addAttribute("title", "Producform");
        model.addAttribute("unitItems", UNIT_ITEMS);
        return "product/form";

    }


    @PostMapping("/insert")
    public String insert(@Valid @ModelAttribute ProductForm productForm, BindingResult result, 
            Model model, RedirectAttributes redirectAttributes) {

        if (!result.hasErrors()) {
            MultipartFile file = productForm.getFileData();
            if(file != null && file.getSize() != 0){
                String fullPath = new File(".").getAbsoluteFile().getParent();
                fullPath += "/src/main/resources/static/images/";
                Path path = Paths.get(fullPath);
                if (!Files.exists(path)) {
                    try {
                        Files.createDirectory(path);
                    } catch (NoSuchFileException ex) {
                        System.err.println(ex);
                    } catch (IOException ex) {
                        System.err.println(ex);
                    }
                }
                int dot = file.getOriginalFilename().lastIndexOf(".");
                String fileType = file.getOriginalFilename().substring(dot).toLowerCase();
                if (!LIST_IMG.contains(fileType)) {
                    productForm.setNewProduct(true);
                    model.addAttribute("title", "ファイルの書式がおかしいよ");
                    return "product/form";
                }
                String fileName = file.getOriginalFilename();
                Path uploadfile = Paths.get(fullPath + fileName);
    
                try (OutputStream os = Files.newOutputStream(uploadfile, StandardOpenOption.CREATE)) {
                    byte[] bytes = file.getBytes();
                    os.write(bytes);
                } catch (IOException ex) {
                    System.err.println(ex);
                }
                productForm.setImage(fileName);
            }
            productService.insert(productForm);
            redirectAttributes.addFlashAttribute("complete", "商品を登録しました");
            return "redirect:/product";
        } else {
            productForm.setNewProduct(true);
            model.addAttribute("productForm", productForm);
            model.addAttribute("unitItems", UNIT_ITEMS);
            model.addAttribute("title", "タスク一覧（バリデーション）");
            return "product/form";
        }
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute ProductForm productForm, BindingResult result,
            @RequestParam("product_id") int productId, Model model, RedirectAttributes redirectAttributes) {

       Product product = new Product();
       product.setProductId(productId);
       product.setName(productForm.getName());
       product.setDescription(productForm.getDescription());
       product.setPrice(productForm.getPrice());
       product.setUnit(productForm.getUnit());
       product.setCreated(productForm.getCreated());

       Stock stock = new Stock();
       stock.uniqueBy(productId);
       stock.setStockNum(productForm.getStock());
       stock.setCreated(productForm.getCreated());

        if (!result.hasErrors()) {
            // 更新処理、フラッシュスコープの使用、リダイレクト（個々の編集ページ）
           productService.update(product, stock);
            redirectAttributes.addFlashAttribute("complete", "変更が完了しました");
            return "redirect:/product/" + productId;
        } else {
            model.addAttribute("productForm", productForm);
            model.addAttribute("unitItems", UNIT_ITEMS);
            model.addAttribute("title", "変更が失敗しました");
            return "product/form";
        }

    }

    @PostMapping("/delete")
    public String delete(@RequestParam("productId") String id, // pathvariable
            Model model, RedirectAttributes redirectAttributes) {

        // タスクを一件削除しリダイレクト
       productService.deleteById(Integer.parseInt(id));
        redirectAttributes.addFlashAttribute("complete", "商品を削除しました");
        return "redirect:/product";
    }


    @GetMapping("/{id}")
    public String showUpdate(ProductForm productForm, @PathVariable int id, Model model) {

        // Productを取得(Optionalでラップ)
        OptionalEntity<ProductRelation> productOpt = productService.getProduct(id);
//
//        // ProductFormへの詰め直し
        OptionalEntity<Object> productFormOpt = productOpt.map(p -> makeProductForm(p));
//
        // ProductFormがnullでなければ中身を取り出し
        if (productFormOpt.isPresent()) {
            productForm = (ProductForm) productFormOpt.get();
        }

        model.addAttribute("productForm", productForm);
        model.addAttribute("title", "更新用フォーム");
        model.addAttribute("unitItems", UNIT_ITEMS);

        return "product/form";
    }

    private ProductForm makeProductForm(ProductRelation p) {

        ProductForm productForm = new ProductForm();

        productForm.setProduct_id(p.getProductId());
        productForm.setName(p.getName());
        productForm.setDescription(p.getDescription());
        productForm.setPrice(p.getPrice());
        productForm.setUnit(p.getUnit());
        productForm.setStock(p.getStockNum());
        productForm.setImage(p.getImage());
        productForm.setCreated(p.getCreated());
        productForm.setNewProduct(false);

        return productForm;
    }

}
