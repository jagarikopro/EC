package com.example.demo.dbflute.bsentity.customize;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.CustomizeEntity;
import com.example.demo.dbflute.exentity.customize.*;

/**
 * The entity of CartInTotalPrice. <br>
 * <pre>
 * [primary-key]
 *     
 *
 * [column]
 *     total_price
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
 * java.math.BigDecimal totalPrice = entity.getTotalPrice();
 * entity.setTotalPrice(totalPrice);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCartInTotalPrice extends AbstractEntity implements CustomizeEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** total_price: {DOUBLE(18)} */
    protected java.math.BigDecimal _totalPrice;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return com.example.demo.dbflute.bsentity.customize.dbmeta.CartInTotalPriceDbm.getInstance();
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "CartInTotalPrice";
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
        if (obj instanceof BsCartInTotalPrice) {
            BsCartInTotalPrice other = (BsCartInTotalPrice)obj;
            if (!xSV(_totalPrice, other._totalPrice)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _totalPrice);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_totalPrice));
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
    public CartInTotalPrice clone() {
        return (CartInTotalPrice)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] total_price: {DOUBLE(18)} <br>
     * @return The value of the column 'total_price'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getTotalPrice() {
        checkSpecifiedProperty("totalPrice");
        return _totalPrice;
    }

    /**
     * [set] total_price: {DOUBLE(18)} <br>
     * @param totalPrice The value of the column 'total_price'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTotalPrice(java.math.BigDecimal totalPrice) {
        registerModifiedProperty("totalPrice");
        _totalPrice = totalPrice;
    }
}
