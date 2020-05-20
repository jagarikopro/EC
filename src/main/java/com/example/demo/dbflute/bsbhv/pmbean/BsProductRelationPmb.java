package com.example.demo.dbflute.bsbhv.pmbean;

import java.util.*;

import org.dbflute.outsidesql.typed.*;
import org.dbflute.jdbc.*;
import org.dbflute.cbean.coption.LikeSearchOption;
import org.dbflute.outsidesql.PmbCustodial;
import org.dbflute.util.DfTypeUtil;
import com.example.demo.dbflute.allcommon.*;
import com.example.demo.dbflute.exbhv.*;
import com.example.demo.dbflute.exentity.customize.*;

/**
 * The base class for typed parameter-bean of ProductRelation. <br>
 * This is related to "<span style="color: #AD4747">selectProductRelation</span>" on ProductBhv.
 * @author DBFlute(AutoGenerator)
 */
public class BsProductRelationPmb implements ListHandlingPmb<ProductBhv, ProductRelation>, EntityHandlingPmb<ProductBhv, ProductRelation>, FetchBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The parameter of ProductId. */
    protected Integer _productId;

    /** The parameter of ProductName:likeContain. */
    protected String _productName;

    /** The option of like-search for ProductName. */
    protected LikeSearchOption _productNameInternalLikeSearchOption;

    /** The max size of safety result. */
    protected int _safetyMaxResultSize;

    /** The time-zone for filtering e.g. from-to. (NullAllowed: if null, default zone) */
    protected TimeZone _timeZone;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor for the typed parameter-bean of ProductRelation. <br>
     * This is related to "<span style="color: #AD4747">selectProductRelation</span>" on ProductBhv.
     */
    public BsProductRelationPmb() {
    }

    // ===================================================================================
    //                                                                Typed Implementation
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    public String getOutsideSqlPath() { return "selectProductRelation"; }

    /**
     * Get the type of an entity for result. (implementation)
     * @return The type instance of an entity, customize entity. (NotNull)
     */
    public Class<ProductRelation> getEntityType() { return ProductRelation.class; }

    // ===================================================================================
    //                                                                       Safety Result
    //                                                                       =============
    /**
     * {@inheritDoc}
     */
    public void checkSafetyResult(int safetyMaxResultSize) {
        _safetyMaxResultSize = safetyMaxResultSize;
    }

    /**
     * {@inheritDoc}
     */
    public int getSafetyMaxResultSize() {
        return _safetyMaxResultSize;
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    // -----------------------------------------------------
    //                                                String
    //                                                ------
    protected String filterStringParameter(String value) { return isEmptyStringParameterAllowed() ? value : convertEmptyToNull(value); }
    protected boolean isEmptyStringParameterAllowed() { return DBFluteConfig.getInstance().isEmptyStringParameterAllowed(); }
    protected String convertEmptyToNull(String value) { return PmbCustodial.convertEmptyToNull(value); }

    protected void assertLikeSearchOptionValid(String name, LikeSearchOption option) { PmbCustodial.assertLikeSearchOptionValid(name, option); }

    // -----------------------------------------------------
    //                                                  Date
    //                                                  ----
    protected Date toUtilDate(Object date) { return PmbCustodial.toUtilDate(date, _timeZone); }
    protected <DATE> DATE toLocalDate(Date date, Class<DATE> localType) { return PmbCustodial.toLocalDate(date, localType, chooseRealTimeZone()); }
    protected TimeZone chooseRealTimeZone() { return PmbCustodial.chooseRealTimeZone(_timeZone); }

    /**
     * Set time-zone, basically for LocalDate conversion. <br>
     * Normally you don't need to set this, you can adjust other ways. <br>
     * (DBFlute system's time-zone is used as default)
     * @param timeZone The time-zone for filtering. (NullAllowed: if null, default zone)
     */
    public void zone(TimeZone timeZone) { _timeZone = timeZone; }

    // -----------------------------------------------------
    //                                    by Option Handling
    //                                    ------------------
    // might be called by option handling
    protected <NUMBER extends Number> NUMBER toNumber(Object obj, Class<NUMBER> type) { return PmbCustodial.toNumber(obj, type); }
    protected Boolean toBoolean(Object obj) { return PmbCustodial.toBoolean(obj); }
    @SuppressWarnings("unchecked")
    protected <ELEMENT> ArrayList<ELEMENT> newArrayList(ELEMENT... elements) { return PmbCustodial.newArrayList(elements); }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * @return The display string of all parameters. (NotNull)
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(DfTypeUtil.toClassTitle(this)).append(":");
        sb.append(xbuildColumnString());
        return sb.toString();
    }
    protected String xbuildColumnString() {
        final String dm = ", ";
        final StringBuilder sb = new StringBuilder();
        sb.append(dm).append(_productId);
        sb.append(dm).append(_productName);
        if (sb.length() > 0) { sb.delete(0, dm.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] ProductId <br>
     * @return The value of ProductId. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public Integer getProductId() {
        return _productId;
    }

    /**
     * [set] ProductId <br>
     * @param productId The value of ProductId. (NullAllowed)
     */
    public void setProductId(Integer productId) {
        _productId = productId;
    }

    /**
     * [get] ProductName:likeContain <br>
     * @return The value of ProductName. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public String getProductName() {
        return filterStringParameter(_productName);
    }

    /**
     * [set as containSearch] ProductName:likeContain <br>
     * @param productName The value of ProductName. (NullAllowed)
     */
    public void setProductName_ContainSearch(String productName) {
        _productName = productName;
        _productNameInternalLikeSearchOption = new LikeSearchOption().likeContain();
    }

    /**
     * Get the internal option of likeSearch for ProductName. {Internal Method: Don't invoke this}
     * @return The internal option of likeSearch for ProductName. (NullAllowed)
     */
    public LikeSearchOption getProductNameInternalLikeSearchOption() {
        return _productNameInternalLikeSearchOption;
    }
}
