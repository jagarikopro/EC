package com.example.demo.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import com.example.demo.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.demo.dbflute.exentity.*;

/**
 * The entity of orders as TABLE. <br>
 * <pre>
 * [primary-key]
 *     order_id
 *
 * [column]
 *     order_id, user_id, product_id, order_num, created
 *
 * [sequence]
 *     
 *
 * [identity]
 *     order_id
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
 * Integer orderId = entity.getOrderId();
 * Integer userId = entity.getUserId();
 * Integer productId = entity.getProductId();
 * Integer orderNum = entity.getOrderNum();
 * java.time.LocalDateTime created = entity.getCreated();
 * entity.setOrderId(orderId);
 * entity.setUserId(userId);
 * entity.setProductId(productId);
 * entity.setOrderNum(orderNum);
 * entity.setCreated(created);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsOrders extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** order_id: {PK, ID, NotNull, INT(10)} */
    protected Integer _orderId;

    /** user_id: {IX, NotNull, INT(10)} */
    protected Integer _userId;

    /** product_id: {IX, NotNull, INT(10)} */
    protected Integer _productId;

    /** order_num: {NotNull, INT(10)} */
    protected Integer _orderNum;

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
        return "orders";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_orderId == null) { return false; }
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
        if (obj instanceof BsOrders) {
            BsOrders other = (BsOrders)obj;
            if (!xSV(_orderId, other._orderId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _orderId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_orderId));
        sb.append(dm).append(xfND(_userId));
        sb.append(dm).append(xfND(_productId));
        sb.append(dm).append(xfND(_orderNum));
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
    public Orders clone() {
        return (Orders)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] order_id: {PK, ID, NotNull, INT(10)} <br>
     * @return The value of the column 'order_id'. (basically NotNull if selected: for the constraint)
     */
    public Integer getOrderId() {
        checkSpecifiedProperty("orderId");
        return _orderId;
    }

    /**
     * [set] order_id: {PK, ID, NotNull, INT(10)} <br>
     * @param orderId The value of the column 'order_id'. (basically NotNull if update: for the constraint)
     */
    public void setOrderId(Integer orderId) {
        registerModifiedProperty("orderId");
        _orderId = orderId;
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
     * [get] order_num: {NotNull, INT(10)} <br>
     * @return The value of the column 'order_num'. (basically NotNull if selected: for the constraint)
     */
    public Integer getOrderNum() {
        checkSpecifiedProperty("orderNum");
        return _orderNum;
    }

    /**
     * [set] order_num: {NotNull, INT(10)} <br>
     * @param orderNum The value of the column 'order_num'. (basically NotNull if update: for the constraint)
     */
    public void setOrderNum(Integer orderNum) {
        registerModifiedProperty("orderNum");
        _orderNum = orderNum;
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
