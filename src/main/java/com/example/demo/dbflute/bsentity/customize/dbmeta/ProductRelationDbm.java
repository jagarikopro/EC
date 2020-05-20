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
 * The DB meta of ProductRelation. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class ProductRelationDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final ProductRelationDbm _instance = new ProductRelationDbm();
    private ProductRelationDbm() {}
    public static ProductRelationDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((ProductRelation)et).getProductId(), (et, vl) -> ((ProductRelation)et).setProductId(cti(vl)), "productId");
        setupEpg(_epgMap, et -> ((ProductRelation)et).getName(), (et, vl) -> ((ProductRelation)et).setName((String)vl), "name");
        setupEpg(_epgMap, et -> ((ProductRelation)et).getDescription(), (et, vl) -> ((ProductRelation)et).setDescription((String)vl), "description");
        setupEpg(_epgMap, et -> ((ProductRelation)et).getPrice(), (et, vl) -> ((ProductRelation)et).setPrice(ctb(vl)), "price");
        setupEpg(_epgMap, et -> ((ProductRelation)et).getUnit(), (et, vl) -> ((ProductRelation)et).setUnit((String)vl), "unit");
        setupEpg(_epgMap, et -> ((ProductRelation)et).getImage(), (et, vl) -> ((ProductRelation)et).setImage((String)vl), "image");
        setupEpg(_epgMap, et -> ((ProductRelation)et).getCreated(), (et, vl) -> ((ProductRelation)et).setCreated(ctldt(vl)), "created");
        setupEpg(_epgMap, et -> ((ProductRelation)et).getStockId(), (et, vl) -> ((ProductRelation)et).setStockId(cti(vl)), "stockId");
        setupEpg(_epgMap, et -> ((ProductRelation)et).getStockNum(), (et, vl) -> ((ProductRelation)et).setStockNum(cti(vl)), "stockNum");
        setupEpg(_epgMap, et -> ((ProductRelation)et).getTemporarySales(), (et, vl) -> ((ProductRelation)et).setTemporarySales(cti(vl)), "temporarySales");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "ProductRelation";
    protected final String _tableDispName = "ProductRelation";
    protected final String _tablePropertyName = "productRelation";
    protected final TableSqlName _tableSqlName = new TableSqlName("ProductRelation", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnProductId = cci("product_id", "product_id", null, null, Integer.class, "productId", null, false, false, false, "INT", 11, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnName = cci("name", "name", null, null, String.class, "name", null, false, false, false, "VARCHAR", 50, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDescription = cci("description", "description", null, null, String.class, "description", null, false, false, false, "VARCHAR", 5592405, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnPrice = cci("price", "price", null, null, java.math.BigDecimal.class, "price", null, false, false, false, "DOUBLE", 23, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnUnit = cci("unit", "unit", null, null, String.class, "unit", null, false, false, false, "VARCHAR", 50, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnImage = cci("image", "image", null, null, String.class, "image", null, false, false, false, "VARCHAR", 50, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnCreated = cci("created", "created", null, null, java.time.LocalDateTime.class, "created", null, false, false, false, "TIMESTAMP", 19, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnStockId = cci("stock_id", "stock_id", null, null, Integer.class, "stockId", null, false, false, false, "INT", 11, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnStockNum = cci("stock_num", "stock_num", null, null, Integer.class, "stockNum", null, false, false, false, "INT", 11, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnTemporarySales = cci("temporary_sales", "temporary_sales", null, null, Integer.class, "temporarySales", null, false, false, false, "INT", 11, 0, null, null, false, null, null, null, null, null, false);

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
    /**
     * created: {TIMESTAMP(19), refers to product.created}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCreated() { return _columnCreated; }
    /**
     * stock_id: {INT(11), refers to stock.stock_id}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnStockId() { return _columnStockId; }
    /**
     * stock_num: {INT(11), refers to stock.stock_num}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnStockNum() { return _columnStockNum; }
    /**
     * temporary_sales: {INT(11), refers to stock.temporary_sales}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnTemporarySales() { return _columnTemporarySales; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnProductId());
        ls.add(columnName());
        ls.add(columnDescription());
        ls.add(columnPrice());
        ls.add(columnUnit());
        ls.add(columnImage());
        ls.add(columnCreated());
        ls.add(columnStockId());
        ls.add(columnStockNum());
        ls.add(columnTemporarySales());
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
    public String getEntityTypeName() { return "com.example.demo.dbflute.exentity.customize.ProductRelation"; }
    public String getConditionBeanTypeName() { return null; }
    public String getBehaviorTypeName() { return null; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<ProductRelation> getEntityType() { return ProductRelation.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public ProductRelation newEntity() { return new ProductRelation(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((ProductRelation)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((ProductRelation)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
