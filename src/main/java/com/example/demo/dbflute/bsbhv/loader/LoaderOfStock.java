package com.example.demo.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.example.demo.dbflute.exbhv.*;
import com.example.demo.dbflute.exentity.*;

/**
 * The referrer loader of stock as TABLE. <br>
 * <pre>
 * [primary key]
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
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfStock {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Stock> _selectedList;
    protected BehaviorSelector _selector;
    protected StockBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfStock ready(List<Stock> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected StockBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(StockBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Stock> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
