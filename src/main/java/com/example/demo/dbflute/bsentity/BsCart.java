package com.example.demo.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import com.example.demo.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.demo.dbflute.exentity.*;

/**
 * The entity of cart as TABLE. <br>
 * <pre>
 * [primary-key]
 *     cart_id
 *
 * [column]
 *     cart_id, user_id, product_id, cart_num, created
 *
 * [sequence]
 *     
 *
 * [identity]
 *     cart_id
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
 * Integer userId = entity.getUserId();
 * Integer productId = entity.getProductId();
 * Integer cartNum = entity.getCartNum();
 * java.time.LocalDateTime created = entity.getCreated();
 * entity.setCartId(cartId);
 * entity.setUserId(userId);
 * entity.setProductId(productId);
 * entity.setCartNum(cartNum);
 * entity.setCreated(created);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCart extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** cart_id: {PK, ID, NotNull, INT(10)} */
    protected Integer _cartId;

    /** user_id: {IX, NotNull, INT(10)} */
    protected Integer _userId;

    /** product_id: {IX, NotNull, INT(10)} */
    protected Integer _productId;

    /** cart_num: {NotNull, INT(10)} */
    protected Integer _cartNum;

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
        return "cart";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_cartId == null) { return false; }
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
        if (obj instanceof BsCart) {
            BsCart other = (BsCart)obj;
            if (!xSV(_cartId, other._cartId)) { return false; }
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
        sb.append(dm).append(xfND(_userId));
        sb.append(dm).append(xfND(_productId));
        sb.append(dm).append(xfND(_cartNum));
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
    public Cart clone() {
        return (Cart)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] cart_id: {PK, ID, NotNull, INT(10)} <br>
     * @return The value of the column 'cart_id'. (basically NotNull if selected: for the constraint)
     */
    public Integer getCartId() {
        checkSpecifiedProperty("cartId");
        return _cartId;
    }

    /**
     * [set] cart_id: {PK, ID, NotNull, INT(10)} <br>
     * @param cartId The value of the column 'cart_id'. (basically NotNull if update: for the constraint)
     */
    public void setCartId(Integer cartId) {
        registerModifiedProperty("cartId");
        _cartId = cartId;
    }

    /**
     * [get] user_id: {IX, NotNull, INT(10)} <br>
     * @return The value of the column 'user_id'. (basically NotNull if selected: for the constraint)
     */
    public Integer getUserId() {
        checkSpecifiedProperty("userId");
        return _userId;
    }

    /**
     * [set] user_id: {IX, NotNull, INT(10)} <br>
     * @param userId The value of the column 'user_id'. (basically NotNull if update: for the constraint)
     */
    public void setUserId(Integer userId) {
        registerModifiedProperty("userId");
        _userId = userId;
    }

    /**
     * [get] product_id: {IX, NotNull, INT(10)} <br>
     * @return The value of the column 'product_id'. (basically NotNull if selected: for the constraint)
     */
    public Integer getProductId() {
        checkSpecifiedProperty("productId");
        return _productId;
    }

    /**
     * [set] product_id: {IX, NotNull, INT(10)} <br>
     * @param productId The value of the column 'product_id'. (basically NotNull if update: for the constraint)
     */
    public void setProductId(Integer productId) {
        registerModifiedProperty("productId");
        _productId = productId;
    }

    /**
     * [get] cart_num: {NotNull, INT(10)} <br>
     * @return The value of the column 'cart_num'. (basically NotNull if selected: for the constraint)
     */
    public Integer getCartNum() {
        checkSpecifiedProperty("cartNum");
        return _cartNum;
    }

    /**
     * [set] cart_num: {NotNull, INT(10)} <br>
     * @param cartNum The value of the column 'cart_num'. (basically NotNull if update: for the constraint)
     */
    public void setCartNum(Integer cartNum) {
        registerModifiedProperty("cartNum");
        _cartNum = cartNum;
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
