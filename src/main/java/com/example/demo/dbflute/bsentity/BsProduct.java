package com.example.demo.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import com.example.demo.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.demo.dbflute.exentity.*;

/**
 * The entity of product as TABLE. <br>
 * <pre>
 * [primary-key]
 *     product_id
 *
 * [column]
 *     product_id, name, description, price, unit, image, created
 *
 * [sequence]
 *     
 *
 * [identity]
 *     product_id
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
 * entity.setProductId(productId);
 * entity.setName(name);
 * entity.setDescription(description);
 * entity.setPrice(price);
 * entity.setUnit(unit);
 * entity.setImage(image);
 * entity.setCreated(created);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsProduct extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** product_id: {PK, ID, NotNull, INT(10)} */
    protected Integer _productId;

    /** name: {NotNull, VARCHAR(50)} */
    protected String _name;

    /** description: {MEDIUMTEXT(16777215)} */
    protected String _description;

    /** price: {NotNull, DOUBLE(22)} */
    protected java.math.BigDecimal _price;

    /** unit: {NotNull, VARCHAR(50), default=[yen]} */
    protected String _unit;

    /** image: {VARCHAR(50)} */
    protected String _image;

    /** created: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]} */
    protected java.time.LocalDateTime _created;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "product";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_productId == null) { return false; }
        return true;
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
        if (obj instanceof BsProduct) {
            BsProduct other = (BsProduct)obj;
            if (!xSV(_productId, other._productId)) { return false; }
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
    public Product clone() {
        return (Product)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] product_id: {PK, ID, NotNull, INT(10)} <br>
     * @return The value of the column 'product_id'. (basically NotNull if selected: for the constraint)
     */
    public Integer getProductId() {
        checkSpecifiedProperty("productId");
        return _productId;
    }

    /**
     * [set] product_id: {PK, ID, NotNull, INT(10)} <br>
     * @param productId The value of the column 'product_id'. (basically NotNull if update: for the constraint)
     */
    public void setProductId(Integer productId) {
        registerModifiedProperty("productId");
        _productId = productId;
    }

    /**
     * [get] name: {NotNull, VARCHAR(50)} <br>
     * @return The value of the column 'name'. (basically NotNull if selected: for the constraint)
     */
    public String getName() {
        checkSpecifiedProperty("name");
        return _name;
    }

    /**
     * [set] name: {NotNull, VARCHAR(50)} <br>
     * @param name The value of the column 'name'. (basically NotNull if update: for the constraint)
     */
    public void setName(String name) {
        registerModifiedProperty("name");
        _name = name;
    }

    /**
     * [get] description: {MEDIUMTEXT(16777215)} <br>
     * @return The value of the column 'description'. (NullAllowed even if selected: for no constraint)
     */
    public String getDescription() {
        checkSpecifiedProperty("description");
        return _description;
    }

    /**
     * [set] description: {MEDIUMTEXT(16777215)} <br>
     * @param description The value of the column 'description'. (NullAllowed: null update allowed for no constraint)
     */
    public void setDescription(String description) {
        registerModifiedProperty("description");
        _description = description;
    }

    /**
     * [get] price: {NotNull, DOUBLE(22)} <br>
     * @return The value of the column 'price'. (basically NotNull if selected: for the constraint)
     */
    public java.math.BigDecimal getPrice() {
        checkSpecifiedProperty("price");
        return _price;
    }

    /**
     * [set] price: {NotNull, DOUBLE(22)} <br>
     * @param price The value of the column 'price'. (basically NotNull if update: for the constraint)
     */
    public void setPrice(java.math.BigDecimal price) {
        registerModifiedProperty("price");
        _price = price;
    }

    /**
     * [get] unit: {NotNull, VARCHAR(50), default=[yen]} <br>
     * @return The value of the column 'unit'. (basically NotNull if selected: for the constraint)
     */
    public String getUnit() {
        checkSpecifiedProperty("unit");
        return _unit;
    }

    /**
     * [set] unit: {NotNull, VARCHAR(50), default=[yen]} <br>
     * @param unit The value of the column 'unit'. (basically NotNull if update: for the constraint)
     */
    public void setUnit(String unit) {
        registerModifiedProperty("unit");
        _unit = unit;
    }

    /**
     * [get] image: {VARCHAR(50)} <br>
     * @return The value of the column 'image'. (NullAllowed even if selected: for no constraint)
     */
    public String getImage() {
        checkSpecifiedProperty("image");
        return _image;
    }

    /**
     * [set] image: {VARCHAR(50)} <br>
     * @param image The value of the column 'image'. (NullAllowed: null update allowed for no constraint)
     */
    public void setImage(String image) {
        registerModifiedProperty("image");
        _image = image;
    }

    /**
     * [get] created: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]} <br>
     * @return The value of the column 'created'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getCreated() {
        checkSpecifiedProperty("created");
        return _created;
    }

    /**
     * [set] created: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]} <br>
     * @param created The value of the column 'created'. (basically NotNull if update: for the constraint)
     */
    public void setCreated(java.time.LocalDateTime created) {
        registerModifiedProperty("created");
        _created = created;
    }
}
