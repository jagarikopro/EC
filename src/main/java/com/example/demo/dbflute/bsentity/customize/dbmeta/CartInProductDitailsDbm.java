package com.example.demo.dbflute.bsentity.customize.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.example.demo.dbflute.allcommon.*;
import com.example.demo.dbflute.exentity.customize.*;

/**
 * The DB meta of CartInProductDitails. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class CartInProductDitailsDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final CartInProductDitailsDbm _instance = new CartInProductDitailsDbm();
    private CartInProductDitailsDbm() {}
    public static CartInProductDitailsDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((CartInProductDitails)et).getCartId(), (et, vl) -> ((CartInProductDitails)et).setCartId(cti(vl)), "cartId");
        setupEpg(_epgMap, et -> ((CartInProductDitails)et).getCartNum(), (et, vl) -> ((CartInProductDitails)et).setCartNum(cti(vl)), "cartNum");
        setupEpg(_epgMap, et -> ((CartInProductDitails)et).getProductId(), (et, vl) -> ((CartInProductDitails)et).setProductId(cti(vl)), "productId");
        setupEpg(_epgMap, et -> ((CartInProductDitails)et).getName(), (et, vl) -> ((CartInProductDitails)et).setName((String)vl), "name");
        setupEpg(_epgMap, et -> ((CartInProductDitails)et).getDescription(), (et, vl) -> ((CartInProductDitails)et).setDescription((String)vl), "description");
        setupEpg(_epgMap, et -> ((CartInProductDitails)et).getPrice(), (et, vl) -> ((CartInProductDitails)et).setPrice(ctb(vl)), "price");
        setupEpg(_epgMap, et -> ((CartInProductDitails)et).getUnit(), (et, vl) -> ((CartInProductDitails)et).setUnit((String)vl), "unit");
        setupEpg(_epgMap, et -> ((CartInProductDitails)et).getImage(), (et, vl) -> ((CartInProductDitails)et).setImage((String)vl), "image");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "CartInProductDitails";
    protected final String _tableDispName = "CartInProductDitails";
    protected final String _tablePropertyName = "cartInProductDitails";
    protected final TableSqlName _tableSqlName = new TableSqlName("CartInProductDitails", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnCartId = cci("cart_id", "cart_id", null, null, Integer.class, "cartId", null, false, false, false, "INT", 11, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnCartNum = cci("cart_num", "cart_num", null, null, Integer.class, "cartNum", null, false, false, false, "INT", 11, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnProductId = cci("product_id", "product_id", null, null, Integer.class, "productId", null, false, false, false, "INT", 11, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnName = cci("name", "name", null, null, String.class, "name", null, false, false, false, "VARCHAR", 50, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDescription = cci("description", "description", null, null, String.class, "description", null, false, false, false, "VARCHAR", 5592405, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnPrice = cci("price", "price", null, null, java.math.BigDecimal.class, "price", null, false, false, false, "DOUBLE", 23, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnUnit = cci("unit", "unit", null, null, String.class, "unit", null, false, false, false, "VARCHAR", 50, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnImage = cci("image", "image", null, null, String.class, "image", null, false, false, false, "VARCHAR", 50, 0, null, null, false, null, null, null, null, null, false);

    /**
     * cart_id: {INT(11), refers to cart.cart_id}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCartId() { return _columnCartId; }
    /**
     * cart_num: {INT(11), refers to cart.cart_num}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCartNum() { return _columnCartNum; }
    /**
     * product_id: {INT(11), refers to product.product_id}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnProductId() { return _columnProductId; }
    /**
     * name: {VARCHAR(50), refers to product.name}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnName() { return _columnName; }
    /**
     * description: {VARCHAR(5592405), refers to product.description}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDescription() { return _columnDescription; }
    /**
     * price: {DOUBLE(23), refers to product.price}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPrice() { return _columnPrice; }
    /**
     * unit: {VARCHAR(50), refers to product.unit}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUnit() { return _columnUnit; }
    /**
     * image: {VARCHAR(50), refers to product.image}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnImage() { return _columnImage; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnCartId());
        ls.add(columnCartNum());
        ls.add(columnProductId());
        ls.add(columnName());
        ls.add(columnDescription());
        ls.add(columnPrice());
        ls.add(columnUnit());
        ls.add(columnImage());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() {
        throw new UnsupportedOperationException("The table does not have primary key: " + getTableDbName());
    }
    public boolean hasPrimaryKey() { return false; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.demo.dbflute.exentity.customize.CartInProductDitails"; }
    public String getConditionBeanTypeName() { return null; }
    public String getBehaviorTypeName() { return null; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<CartInProductDitails> getEntityType() { return CartInProductDitails.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public CartInProductDitails newEntity() { return new CartInProductDitails(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((CartInProductDitails)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((CartInProductDitails)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
