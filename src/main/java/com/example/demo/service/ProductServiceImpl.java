package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.exception.EntityAlreadyDeletedException;
import org.dbflute.exception.EntityDuplicatedException;
import org.dbflute.optional.OptionalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dbflute.exbhv.ProductBhv;
import com.example.demo.dbflute.exbhv.StockBhv;
import com.example.demo.dbflute.exbhv.pmbean.ProductRelationPmb;
import com.example.demo.dbflute.exentity.Product;
import com.example.demo.dbflute.exentity.Stock;
import com.example.demo.dbflute.exentity.customize.ProductRelation;
import com.example.demo.dto.ProductForm;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductBhv productBhv;
	
	@Autowired
	private StockBhv stockBhv;

	@Override
	public List<ProductRelation> getAll() {

		ProductRelationPmb pmb = new ProductRelationPmb();
		ListResultBean<ProductRelation> productList = productBhv.outsideSql().selectList(pmb);	
		// ListResultBean<Product> productList = productBhv.selectList( cb -> {
		// cb.query().addOrderBy_ProductId_Desc();
		// });

		return productList;
	}

	@Override
	public void insert(ProductForm productForm) {

		Product product = new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		product.setPrice(productForm.getPrice());
		product.setUnit(productForm.getUnit());
		product.setImage(productForm.getImage());
		product.setCreated(LocalDateTime.now());
		productBhv.insert(product);

		Stock stock = new Stock();
		stock.setProductId(product.getProductId());
		stock.setStockNum(productForm.getStock());
		stock.setTemporarySales(productForm.getStemporary_salestock());
		stock.setCreated(LocalDateTime.now());
		stockBhv.insert(stock);
	}

	@Override
	public void deleteById(int id) {
		try {
			// Productを更新 idがなければ例外発生
			Product product = new Product();
			product.setProductId(id);
			productBhv.delete(product);

			Stock stock = new Stock();
			stock.uniqueBy(id);
			stockBhv.delete(stock);
		} catch (EntityAlreadyDeletedException e) {
			throw new NotFoundException("削除する商品が存在しません");
		}
	}

	@Override
	public OptionalEntity<ProductRelation> getProduct(int id) {

//		OptionalEntity<Product> product = productBhv.selectEntity( cb -> {
//			cb.query().setProductId_Equal(id);
//		});
		ProductRelationPmb pmb = new ProductRelationPmb();
		pmb.setProductId(id);
		OptionalEntity<ProductRelation> product = productBhv.outsideSql().selectEntity(pmb);

		return product;
	}

	@Override
	public void update(Product product, Stock stock) {

		try{
			// Taskを更新 idが無ければ例外発生
			productBhv.update(product);
			stockBhv.update(stock);
		} catch(EntityDuplicatedException e){
			throw new NotFoundException("更新する商品が存在しません");
		}
	}
}
