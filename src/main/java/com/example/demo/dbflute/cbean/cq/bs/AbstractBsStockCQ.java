package com.example.demo.dbflute.cbean.cq.bs;

import java.util.*;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.ckey.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.ordering.*;
import org.dbflute.cbean.scoping.*;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.dbmeta.DBMetaProvider;
import com.example.demo.dbflute.allcommon.*;
import com.example.demo.dbflute.cbean.*;
import com.example.demo.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of stock.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsStockCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsStockCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    public String asTableDbName() {
        return "stock";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     * @param stockId The value of stockId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockId_Equal(Integer stockId) {
        doSetStockId_Equal(stockId);
    }

    protected void doSetStockId_Equal(Integer stockId) {
        regStockId(CK_EQ, stockId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     * @param stockId The value of stockId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockId_NotEqual(Integer stockId) {
        doSetStockId_NotEqual(stockId);
    }

    protected void doSetStockId_NotEqual(Integer stockId) {
        regStockId(CK_NES, stockId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     * @param stockId The value of stockId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockId_GreaterThan(Integer stockId) {
        regStockId(CK_GT, stockId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     * @param stockId The value of stockId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockId_LessThan(Integer stockId) {
        regStockId(CK_LT, stockId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     * @param stockId The value of stockId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockId_GreaterEqual(Integer stockId) {
        regStockId(CK_GE, stockId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     * @param stockId The value of stockId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockId_LessEqual(Integer stockId) {
        regStockId(CK_LE, stockId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     * @param minNumber The min number of stockId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of stockId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setStockId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setStockId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     * @param minNumber The min number of stockId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of stockId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setStockId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueStockId(), "stock_id", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     * @param stockIdList The collection of stockId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStockId_InScope(Collection<Integer> stockIdList) {
        doSetStockId_InScope(stockIdList);
    }

    protected void doSetStockId_InScope(Collection<Integer> stockIdList) {
        regINS(CK_INS, cTL(stockIdList), xgetCValueStockId(), "stock_id");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     * @param stockIdList The collection of stockId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStockId_NotInScope(Collection<Integer> stockIdList) {
        doSetStockId_NotInScope(stockIdList);
    }

    protected void doSetStockId_NotInScope(Collection<Integer> stockIdList) {
        regINS(CK_NINS, cTL(stockIdList), xgetCValueStockId(), "stock_id");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     */
    public void setStockId_IsNull() { regStockId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * stock_id: {PK, ID, NotNull, INT(10)}
     */
    public void setStockId_IsNotNull() { regStockId(CK_ISNN, DOBJ); }

    protected void regStockId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueStockId(), "stock_id"); }
    protected abstract ConditionValue xgetCValueStockId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * product_id: {UQ, NotNull, INT(10)}
     * @param productId The value of productId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setProductId_Equal(Integer productId) {
        doSetProductId_Equal(productId);
    }

    protected void doSetProductId_Equal(Integer productId) {
        regProductId(CK_EQ, productId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * product_id: {UQ, NotNull, INT(10)}
     * @param productId The value of productId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setProductId_NotEqual(Integer productId) {
        doSetProductId_NotEqual(productId);
    }

    protected void doSetProductId_NotEqual(Integer productId) {
        regProductId(CK_NES, productId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * product_id: {UQ, NotNull, INT(10)}
     * @param productId The value of productId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setProductId_GreaterThan(Integer productId) {
        regProductId(CK_GT, productId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * product_id: {UQ, NotNull, INT(10)}
     * @param productId The value of productId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setProductId_LessThan(Integer productId) {
        regProductId(CK_LT, productId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * product_id: {UQ, NotNull, INT(10)}
     * @param productId The value of productId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setProductId_GreaterEqual(Integer productId) {
        regProductId(CK_GE, productId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * product_id: {UQ, NotNull, INT(10)}
     * @param productId The value of productId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setProductId_LessEqual(Integer productId) {
        regProductId(CK_LE, productId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * product_id: {UQ, NotNull, INT(10)}
     * @param minNumber The min number of productId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of productId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setProductId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setProductId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * product_id: {UQ, NotNull, INT(10)}
     * @param minNumber The min number of productId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of productId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setProductId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueProductId(), "product_id", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * product_id: {UQ, NotNull, INT(10)}
     * @param productIdList The collection of productId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setProductId_InScope(Collection<Integer> productIdList) {
        doSetProductId_InScope(productIdList);
    }

    protected void doSetProductId_InScope(Collection<Integer> productIdList) {
        regINS(CK_INS, cTL(productIdList), xgetCValueProductId(), "product_id");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * product_id: {UQ, NotNull, INT(10)}
     * @param productIdList The collection of productId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setProductId_NotInScope(Collection<Integer> productIdList) {
        doSetProductId_NotInScope(productIdList);
    }

    protected void doSetProductId_NotInScope(Collection<Integer> productIdList) {
        regINS(CK_NINS, cTL(productIdList), xgetCValueProductId(), "product_id");
    }

    protected void regProductId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueProductId(), "product_id"); }
    protected abstract ConditionValue xgetCValueProductId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_num: {NotNull, INT(10)}
     * @param stockNum The value of stockNum as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockNum_Equal(Integer stockNum) {
        doSetStockNum_Equal(stockNum);
    }

    protected void doSetStockNum_Equal(Integer stockNum) {
        regStockNum(CK_EQ, stockNum);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_num: {NotNull, INT(10)}
     * @param stockNum The value of stockNum as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockNum_NotEqual(Integer stockNum) {
        doSetStockNum_NotEqual(stockNum);
    }

    protected void doSetStockNum_NotEqual(Integer stockNum) {
        regStockNum(CK_NES, stockNum);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_num: {NotNull, INT(10)}
     * @param stockNum The value of stockNum as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockNum_GreaterThan(Integer stockNum) {
        regStockNum(CK_GT, stockNum);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_num: {NotNull, INT(10)}
     * @param stockNum The value of stockNum as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockNum_LessThan(Integer stockNum) {
        regStockNum(CK_LT, stockNum);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_num: {NotNull, INT(10)}
     * @param stockNum The value of stockNum as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockNum_GreaterEqual(Integer stockNum) {
        regStockNum(CK_GE, stockNum);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * stock_num: {NotNull, INT(10)}
     * @param stockNum The value of stockNum as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStockNum_LessEqual(Integer stockNum) {
        regStockNum(CK_LE, stockNum);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * stock_num: {NotNull, INT(10)}
     * @param minNumber The min number of stockNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of stockNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setStockNum_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setStockNum_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * stock_num: {NotNull, INT(10)}
     * @param minNumber The min number of stockNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of stockNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setStockNum_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueStockNum(), "stock_num", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * stock_num: {NotNull, INT(10)}
     * @param stockNumList The collection of stockNum as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStockNum_InScope(Collection<Integer> stockNumList) {
        doSetStockNum_InScope(stockNumList);
    }

    protected void doSetStockNum_InScope(Collection<Integer> stockNumList) {
        regINS(CK_INS, cTL(stockNumList), xgetCValueStockNum(), "stock_num");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * stock_num: {NotNull, INT(10)}
     * @param stockNumList The collection of stockNum as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStockNum_NotInScope(Collection<Integer> stockNumList) {
        doSetStockNum_NotInScope(stockNumList);
    }

    protected void doSetStockNum_NotInScope(Collection<Integer> stockNumList) {
        regINS(CK_NINS, cTL(stockNumList), xgetCValueStockNum(), "stock_num");
    }

    protected void regStockNum(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueStockNum(), "stock_num"); }
    protected abstract ConditionValue xgetCValueStockNum();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * temporary_sales: {NotNull, INT(10)}
     * @param temporarySales The value of temporarySales as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setTemporarySales_Equal(Integer temporarySales) {
        doSetTemporarySales_Equal(temporarySales);
    }

    protected void doSetTemporarySales_Equal(Integer temporarySales) {
        regTemporarySales(CK_EQ, temporarySales);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * temporary_sales: {NotNull, INT(10)}
     * @param temporarySales The value of temporarySales as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setTemporarySales_NotEqual(Integer temporarySales) {
        doSetTemporarySales_NotEqual(temporarySales);
    }

    protected void doSetTemporarySales_NotEqual(Integer temporarySales) {
        regTemporarySales(CK_NES, temporarySales);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * temporary_sales: {NotNull, INT(10)}
     * @param temporarySales The value of temporarySales as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setTemporarySales_GreaterThan(Integer temporarySales) {
        regTemporarySales(CK_GT, temporarySales);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * temporary_sales: {NotNull, INT(10)}
     * @param temporarySales The value of temporarySales as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setTemporarySales_LessThan(Integer temporarySales) {
        regTemporarySales(CK_LT, temporarySales);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * temporary_sales: {NotNull, INT(10)}
     * @param temporarySales The value of temporarySales as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setTemporarySales_GreaterEqual(Integer temporarySales) {
        regTemporarySales(CK_GE, temporarySales);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * temporary_sales: {NotNull, INT(10)}
     * @param temporarySales The value of temporarySales as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setTemporarySales_LessEqual(Integer temporarySales) {
        regTemporarySales(CK_LE, temporarySales);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * temporary_sales: {NotNull, INT(10)}
     * @param minNumber The min number of temporarySales. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of temporarySales. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setTemporarySales_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setTemporarySales_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * temporary_sales: {NotNull, INT(10)}
     * @param minNumber The min number of temporarySales. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of temporarySales. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setTemporarySales_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueTemporarySales(), "temporary_sales", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * temporary_sales: {NotNull, INT(10)}
     * @param temporarySalesList The collection of temporarySales as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setTemporarySales_InScope(Collection<Integer> temporarySalesList) {
        doSetTemporarySales_InScope(temporarySalesList);
    }

    protected void doSetTemporarySales_InScope(Collection<Integer> temporarySalesList) {
        regINS(CK_INS, cTL(temporarySalesList), xgetCValueTemporarySales(), "temporary_sales");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * temporary_sales: {NotNull, INT(10)}
     * @param temporarySalesList The collection of temporarySales as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setTemporarySales_NotInScope(Collection<Integer> temporarySalesList) {
        doSetTemporarySales_NotInScope(temporarySalesList);
    }

    protected void doSetTemporarySales_NotInScope(Collection<Integer> temporarySalesList) {
        regINS(CK_NINS, cTL(temporarySalesList), xgetCValueTemporarySales(), "temporary_sales");
    }

    protected void regTemporarySales(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueTemporarySales(), "temporary_sales"); }
    protected abstract ConditionValue xgetCValueTemporarySales();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * created: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]}
     * @param created The value of created as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setCreated_Equal(java.time.LocalDateTime created) {
        regCreated(CK_EQ,  created);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * created: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]}
     * @param created The value of created as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCreated_GreaterThan(java.time.LocalDateTime created) {
        regCreated(CK_GT,  created);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * created: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]}
     * @param created The value of created as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCreated_LessThan(java.time.LocalDateTime created) {
        regCreated(CK_LT,  created);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * created: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]}
     * @param created The value of created as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCreated_GreaterEqual(java.time.LocalDateTime created) {
        regCreated(CK_GE,  created);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * created: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]}
     * @param created The value of created as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCreated_LessEqual(java.time.LocalDateTime created) {
        regCreated(CK_LE, created);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * created: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]}
     * <pre>e.g. setCreated_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of created. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of created. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setCreated_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setCreated_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * created: {NotNull, TIMESTAMP(19), default=[CURRENT_TIMESTAMP]}
     * <pre>e.g. setCreated_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of created. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of created. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setCreated_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "created"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueCreated(), nm, op);
    }

    protected void regCreated(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCreated(), "created"); }
    protected abstract ConditionValue xgetCValueCreated();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO = (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StockCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, StockCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO &lt;&gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StockCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, StockCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br>
     * {where FOO &gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StockCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, StockCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br>
     * {where FOO &lt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StockCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, StockCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br>
     * {where FOO &gt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StockCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, StockCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;StockCB&gt;() {
     *     public void query(StockCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<StockCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, StockCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        StockCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(StockCQ sq);

    protected StockCB xcreateScalarConditionCB() {
        StockCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected StockCB xcreateScalarConditionPartitionByCB() {
        StockCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<StockCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        StockCB cb = new StockCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "stock_id";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(StockCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<StockCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(StockCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        StockCB cb = new StockCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "stock_id";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(StockCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<StockCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        StockCB cb = new StockCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(StockCQ sq);

    // ===================================================================================
    //                                                                        Manual Order
    //                                                                        ============
    /**
     * Order along manual ordering information.
     * <pre>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param opLambda The callback for option of manual-order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderOptionCall opLambda) { // is user public!
        xdoWithManualOrder(cMOO(opLambda));
    }

    // ===================================================================================
    //                                                                    Small Adjustment
    //                                                                    ================
    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected StockCB newMyCB() {
        return new StockCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return StockCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
