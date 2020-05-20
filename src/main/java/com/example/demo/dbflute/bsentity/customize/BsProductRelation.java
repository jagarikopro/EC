package com.example.demo.dbflute.bsentity.customize;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.CustomizeEntity;
import com.example.demo.dbflute.exentity.customize.*;

/**
 * The entity of ProductRelation. <br>
 * <pre>
 * [primary-key]
 *     
 *
 * [column]
 *     product_id, name, description, price, unit, image, created, stock_id, stock_num, temporary_sales
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer productId = entity.getProductId();
 * String name = entity.getName();
 * String description = entity.getDescription();
 * java.math.BigDecimal price = entity.getPrice();
 * String unit = entity.getUnit();
 * String image = entity.getImage();
 * java.time.LocalDateTime created = entity.getCreated();
 * Integer stockId = entity.getStockId();
 * Integer stockNum = entity.getStockNum();
 * Integer temporarySales = entity.getTemporarySales();
 * entity.setProductId(productId);
 * entity.setName(name);
 * entity.setDescription(description);
 * entity.setPrice(price);
 * entity.setUnit(unit);
 * entity.setImage(image);
 * entity.setCreated(created);
 * entity.setStockId(stockId);
 * entity.setStockNum(stockNum);
 * entity.setTemporarySales(temporarySales);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsProductRelation extends AbstractEntity implements CustomizeEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** product_id: {INT(11), refers to product.product_id} */
    protected Integer _productId;

    /** name: {VARCHAR(50), refers to product.name} */
    protected String _name;

    /** description: {VARCHAR(5592405), refers to product.description} */
    protected String _description;

    /** price: {DOUBLE(23), refers to product.price} */
    protected java.math.BigDecimal _price;

    /** unit: {VARCHAR(50), refers to product.unit} */
    protected String _unit;

    /** image: {VARCHAR(50), refers to product.image} */
    protected String _image;

    /** created: {TIMESTAMP(19), refers to product.created} */
    protected java.time.LocalDateTime _created;

    /** stock_id: {INT(11), refers to stock.stock_id} */
    protected Integer _stockId;

    /** stock_num: {INT(11), refers to stock.stock_num} */
    protected Integer _stockNum;

    /** temporary_sales: {INT(11), refers to stock.temporary_sales} */
    protected Integer _temporarySales;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return com.example.demo.dbflute.bsentity.customize.dbmeta.ProductRelationDbm.getInstance();
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "ProductRelation";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        return false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsProductRelation) {
            BsProductRelation other = (BsProductRelation)obj;
            if (!xSV(_productId, other._productId)) { return false; }
            if (!xSV(_name, other._name)) { return false; }
            if (!xSV(_description, other._description)) { return false; }
            if (!xSV(_price, other._price)) { return false; }
            if (!xSV(_unit, other._unit)) { return false; }
            if (!xSV(_image, other._image)) { return false; }
            if (!xSV(_created, other._created)) { return false; }
            if (!xSV(_stockId, other._stockId)) { return false; }
            if (!xSV(_stockNum, other._stockNum)) { return false; }
            if (!xSV(_temporarySales, other._temporarySales)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _productId);
        hs = xCH(hs, _name);
        hs = xCH(hs, _description);
        hs = xCH(hs, _price);
        hs = xCH(hs, _unit);
        hs = xCH(hs, _image);
        hs = xCH(hs, _created);
        hs = xCH(hs, _stockId);
        hs = xCH(hs, _stockNum);
        hs = xCH(hs, _temporarySales);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_productId));
        sb.append(dm).append(xfND(_name));
        sb.append(dm).append(xfND(_description));
        sb.append(dm).append(xfND(_price));
        sb.append(dm).append(xfND(_unit));
        sb.append(dm).append(xfND(_image));
        sb.append(dm).append(xfND(_created));
        sb.append(dm).append(xfND(_stockId));
        sb.append(dm).append(xfND(_stockNum));
        sb.append(dm).append(xfND(_temporarySales));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        return "";
    }

    @Override
    public ProductRelation clone() {
        return (ProductRelation)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] product_id: {INT(11), refers to product.product_id} <br>
     * @return The value of the column 'product_id'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getProductId() {
        checkSpecifiedProperty("productId");
        return _productId;
    }

    /**
     * [set] product_id: {INT(11), refers to product.product_id} <br>
     * @param productId The value of the column 'product_id'. (NullAllowed: null update allowed for no constraint)
     */
    public void setProductId(Integer productId) {
        registerModifiedProperty("productId");
        _productId = productId;
    }

    /**
     * [get] name: {VARCHAR(50), refers to product.name} <br>
     * @return The value of the column 'name'. (NullAllowed even if selected: for no constraint)
     */
    public String getName() {
        checkSpecifiedProperty("name");
        return _name;
    }

    /**
     * [set] name: {VARCHAR(50), refers to product.name} <br>
     * @param name The value of the column 'name'. (NullAllowed: null update allowed for no constraint)
     */
    public void setName(String name) {
        registerModifiedProperty("name");
        _name = name;
    }

    /**
     * [get] description: {VARCHAR(5592405), refers to product.description} <br>
     * @return The value of the column 'description'. (NullAllowed even if selected: for no constraint)
     */
    public String getDescription() {
        checkSpecifiedProperty("description");
        return _description;
    }

    /**
     * [set] description: {VARCHAR(5592405), refers to product.description} <br>
     * @param description The value of the column 'description'. (NullAllowed: null update allowed for no constraint)
     */
    public void setDescription(String description) {
        registerModifiedProperty("description");
        _description = description;
    }

    /**
     * [get] price: {DOUBLE(23), refers to product.price} <br>
     * @return The value of the column 'price'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getPrice() {
        checkSpecifiedProperty("price");
        return _price;
    }

    /**
     * [set] price: {DOUBLE(23), refers to product.price} <br>
     * @param price The value of the column 'price'. (NullAllowed: null update allowed for no constraint)
     */
    public void setPrice(java.math.BigDecimal price) {
        registerModifiedProperty("price");
        _price = price;
    }

    /**
     * [get] unit: {VARCHAR(50), refers to product.unit} <br>
     * @return The value of the column 'unit'. (NullAllowed even if selected: for no constraint)
     */
    public String getUnit() {
        checkSpecifiedProperty("unit");
        return _unit;
    }

    /**
     * [set] unit: {VARCHAR(50), refers to product.unit} <br>
     * @param unit The value of the column 'unit'. (NullAllowed: null update allowed for no constraint)
     */
    public void setUnit(String unit) {
        registerModifiedProperty("unit");
        _unit = unit;
    }

    /**
     * [get] image: {VARCHAR(50), refers to product.image} <br>
     * @return The value of the column 'image'. (NullAllowed even if selected: for no constraint)
     */
    public String getImage() {
        checkSpecifiedProperty("image");
        return _image;
    }

    /**
     * [set] image: {VARCHAR(50), refers to product.image} <br>
     * @param image The value of the column 'image'. (NullAllowed: null update allowed for no constraint)
     */
    public void setImage(String image) {
        registerModifiedProperty("image");
        _image = image;
    }

    /**
     * [get] created: {TIMESTAMP(19), refers to product.created} <br>
     * @return The value of the column 'created'. (NullAllowed even if selected: for no constraint)
     */
    public java.time.LocalDateTime getCreated() {
        checkSpecifiedProperty("created");
        return _created;
    }

    /**
     * [set] created: {TIMESTAMP(19), refers to product.created} <br>
     * @param created The value of the column 'created'. (NullAllowed: null update allowed for no constraint)
     */
    public void setCreated(java.time.LocalDateTime created) {
        registerModifiedProperty("created");
        _created = created;
    }

    /**
     * [get] stock_id: {INT(11), refers to stock.stock_id} <br>
     * @return The value of the column 'stock_id'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getStockId() {
        checkSpecifiedProperty("stockId");
        return _stockId;
    }

    /**
     * [set] stock_id: {INT(11), refers to stock.stock_id} <br>
     * @param stockId The value of the column 'stock_id'. (NullAllowed: null update allowed for no constraint)
     */
    public void setStockId(Integer stockId) {
        registerModifiedProperty("stockId");
        _stockId = stockId;
    }

    /**
     * [get] stock_num: {INT(11), refers to stock.stock_num} <br>
     * @return The value of the column 'stock_num'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getStockNum() {
        checkSpecifiedProperty("stockNum");
        return _stockNum;
    }

    /**
     * [set] stock_num: {INT(11), refers to stock.stock_num} <br>
     * @param stockNum The value of the column 'stock_num'. (NullAllowed: null update allowed for no constraint)
     */
    public void setStockNum(Integer stockNum) {
        registerModifiedProperty("stockNum");
        _stockNum = stockNum;
    }

    /**
     * [get] temporary_sales: {INT(11), refers to stock.temporary_sales} <br>
     * @return The value of the column 'temporary_sales'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getTemporarySales() {
        checkSpecifiedProperty("temporarySales");
        return _temporarySales;
    }

    /**
     * [set] temporary_sales: {INT(11), refers to stock.temporary_sales} <br>
     * @param temporarySales The value of the column 'temporary_sales'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTemporarySales(Integer temporarySales) {
        registerModifiedProperty("temporarySales");
        _temporarySales = temporarySales;
    }
}
