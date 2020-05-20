package com.example.demo.dbflute.bsentity.customize;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.CustomizeEntity;
import com.example.demo.dbflute.exentity.customize.*;

/**
 * The entity of CartInProductDitails. <br>
 * <pre>
 * [primary-key]
 *     
 *
 * [column]
 *     cart_id, cart_num, product_id, name, description, price, unit, image
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
 * Integer cartId = entity.getCartId();
 * Integer cartNum = entity.getCartNum();
 * Integer productId = entity.getProductId();
 * String name = entity.getName();
 * String description = entity.getDescription();
 * java.math.BigDecimal price = entity.getPrice();
 * String unit = entity.getUnit();
 * String image = entity.getImage();
 * entity.setCartId(cartId);
 * entity.setCartNum(cartNum);
 * entity.setProductId(productId);
 * entity.setName(name);
 * entity.setDescription(description);
 * entity.setPrice(price);
 * entity.setUnit(unit);
 * entity.setImage(image);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCartInProductDitails extends AbstractEntity implements CustomizeEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** cart_id: {INT(11), refers to cart.cart_id} */
    protected Integer _cartId;

    /** cart_num: {INT(11), refers to cart.cart_num} */
    protected Integer _cartNum;

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

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return com.example.demo.dbflute.bsentity.customize.dbmeta.CartInProductDitailsDbm.getInstance();
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "CartInProductDitails";
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
        if (obj instanceof BsCartInProductDitails) {
            BsCartInProductDitails other = (BsCartInProductDitails)obj;
            if (!xSV(_cartId, other._cartId)) { return false; }
            if (!xSV(_cartNum, other._cartNum)) { return false; }
            if (!xSV(_productId, other._productId)) { return false; }
            if (!xSV(_name, other._name)) { return false; }
            if (!xSV(_description, other._description)) { return false; }
            if (!xSV(_price, other._price)) { return false; }
            if (!xSV(_unit, other._unit)) { return false; }
            if (!xSV(_image, other._image)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _cartId);
        hs = xCH(hs, _cartNum);
        hs = xCH(hs, _productId);
        hs = xCH(hs, _name);
        hs = xCH(hs, _description);
        hs = xCH(hs, _price);
        hs = xCH(hs, _unit);
        hs = xCH(hs, _image);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_cartId));
        sb.append(dm).append(xfND(_cartNum));
        sb.append(dm).append(xfND(_productId));
        sb.append(dm).append(xfND(_name));
        sb.append(dm).append(xfND(_description));
        sb.append(dm).append(xfND(_price));
        sb.append(dm).append(xfND(_unit));
        sb.append(dm).append(xfND(_image));
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
    public CartInProductDitails clone() {
        return (CartInProductDitails)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] cart_id: {INT(11), refers to cart.cart_id} <br>
     * @return The value of the column 'cart_id'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getCartId() {
        checkSpecifiedProperty("cartId");
        return _cartId;
    }

    /**
     * [set] cart_id: {INT(11), refers to cart.cart_id} <br>
     * @param cartId The value of the column 'cart_id'. (NullAllowed: null update allowed for no constraint)
     */
    public void setCartId(Integer cartId) {
        registerModifiedProperty("cartId");
        _cartId = cartId;
    }

    /**
     * [get] cart_num: {INT(11), refers to cart.cart_num} <br>
     * @return The value of the column 'cart_num'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getCartNum() {
        checkSpecifiedProperty("cartNum");
        return _cartNum;
    }

    /**
     * [set] cart_num: {INT(11), refers to cart.cart_num} <br>
     * @param cartNum The value of the column 'cart_num'. (NullAllowed: null update allowed for no constraint)
     */
    public void setCartNum(Integer cartNum) {
        registerModifiedProperty("cartNum");
        _cartNum = cartNum;
    }

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
}
