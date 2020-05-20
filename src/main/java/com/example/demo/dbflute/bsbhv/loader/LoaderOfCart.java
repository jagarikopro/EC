package com.example.demo.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.example.demo.dbflute.exbhv.*;
import com.example.demo.dbflute.exentity.*;

/**
 * The referrer loader of cart as TABLE. <br>
 * <pre>
 * [primary key]
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
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfCart {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Cart> _selectedList;
    protected BehaviorSelector _selector;
    protected CartBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfCart ready(List<Cart> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected CartBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(CartBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Cart> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
