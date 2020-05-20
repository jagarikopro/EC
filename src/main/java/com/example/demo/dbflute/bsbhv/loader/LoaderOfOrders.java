package com.example.demo.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.example.demo.dbflute.exbhv.*;
import com.example.demo.dbflute.exentity.*;

/**
 * The referrer loader of orders as TABLE. <br>
 * <pre>
 * [primary key]
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
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfOrders {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Orders> _selectedList;
    protected BehaviorSelector _selector;
    protected OrdersBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfOrders ready(List<Orders> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected OrdersBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(OrdersBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Orders> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
