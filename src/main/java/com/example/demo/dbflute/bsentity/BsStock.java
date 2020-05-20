package com.example.demo.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import com.example.demo.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.demo.dbflute.exentity.*;

/**
 * The entity of stock as TABLE. <br>
 * <pre>
 * [primary-key]
 *     stock_id
 *
 * [column]
 *     stock_id, product_id, stock_num, temporary_sales, created
 *
 * [sequence]
 *     
 *
 * [identity]
 *     stock_id
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
 * Integer stockId = entity.getStockId();
 * Integer productId = entity.getProductId();
 * Integer stockNum = entity.getStockNum();
 * Integer temporarySales = entity.getTemporarySales();
 * java.time.LocalDateTime created = entity.getCreated();
 * entity.setStockId(stockId);
 * entity.setProductId(productId);
 * entity.setStockNum(stockNum);
 * entity.setTemporarySales(temporarySales);
 * entity.setCreated(created);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsStock extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** stock_id: {PK, ID, NotNull, INT(10)} */
    protected Integer _stockId;

    /** product_id: {UQ, NotNull, INT(10)} */
    protected Integer _productId;

    /** stock_num: {NotNull, INT(10)} */
    protected Integer _stockNum;

    /** temporary_sales: {NotNull, INT(10)} */
    protected Integer _temporarySales;

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
        return "stock";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_stockId == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param productId : UQ, NotNull, INT(10). (NotNull)
     */
    public void uniqueBy(Integer productId) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("productId");
        setProductId(productId);
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
        if (obj instanceof BsStock) {
            BsStock other = (BsStock)obj;
            if (!xSV(_stockId, other._stockId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _stockId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_stockId));
        sb.append(dm).append(xfND(_productId));
        sb.append(dm).append(xfND(_stockNum));
        sb.append(dm).append(xfND(_temporarySales));
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
    public Stock clone() {
        return (Stock)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] stock_id: {PK, ID, NotNull, INT(10)} <br>
     * @return The value of the column 'stock_id'. (basically NotNull if selected: for the constraint)
     */
    public Integer getStockId() {
        checkSpecifiedProperty("stockId");
        return _stockId;
    }

    /**
     * [set] stock_id: {PK, ID, NotNull, INT(10)} <br>
     * @param stockId The value of the column 'stock_id'. (basically NotNull if update: for the constraint)
     */
    public void setStockId(Integer stockId) {
        registerModifiedProperty("stockId");
        _stockId = stockId;
    }

    /**
     * [get] product_id: {UQ, NotNull, INT(10)} <br>
     * @return The value of the column 'product_id'. (basically NotNull if selected: for the constraint)
     */
    public Integer getProductId() {
        checkSpecifiedProperty("productId");
        return _productId;
    }

    /**
     * [set] product_id: {UQ, NotNull, INT(10)} <br>
     * @param productId The value of the column 'product_id'. (basically NotNull if update: for the constraint)
     */
    public void setProductId(Integer productId) {
        registerModifiedProperty("productId");
        _productId = productId;
    }

    /**
     * [get] stock_num: {NotNull, INT(10)} <br>
     * @return The value of the column 'stock_num'. (basically NotNull if selected: for the constraint)
     */
    public Integer getStockNum() {
        checkSpecifiedProperty("stockNum");
        return _stockNum;
    }

    /**
     * [set] stock_num: {NotNull, INT(10)} <br>
     * @param stockNum The value of the column 'stock_num'. (basically NotNull if update: for the constraint)
     */
    public void setStockNum(Integer stockNum) {
        registerModifiedProperty("stockNum");
        _stockNum = stockNum;
    }

    /**
     * [get] temporary_sales: {NotNull, INT(10)} <br>
     * @return The value of the column 'temporary_sales'. (basically NotNull if selected: for the constraint)
     */
    public Integer getTemporarySales() {
        checkSpecifiedProperty("temporarySales");
        return _temporarySales;
    }

    /**
     * [set] temporary_sales: {NotNull, INT(10)} <br>
     * @param temporarySales The value of the column 'temporary_sales'. (basically NotNull if update: for the constraint)
     */
    public void setTemporarySales(Integer temporarySales) {
        registerModifiedProperty("temporarySales");
        _temporarySales = temporarySales;
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
