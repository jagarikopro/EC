/*
 [df:title]
  selectProductRelation

 [df:description]
  商品に関する全てのテーブルを検索

*/

-- #df:entity#

-- !df:pmb!
-- !!AutoDetect!!
-- !!Integer ProductId!!
-- !!String ProductName:likeContain!!

select p.product_id, p.name, p.description, p.price, p.unit, p.image, p.created, s.stock_id, s.stock_num, s.temporary_sales 
  from product p
  join stock s on p.product_id = s.product_id
  /*IF pmb.ProductId != null || pmb.ProductName != null */
   where
   /*END*/
  /*IF pmb.ProductId != null*/
   p.product_id = /*pmb.ProductId*/1
  /*END*/
  /*IF pmb.ProductName != null*/
    /*IF pmb.ProductId != null*/
    AND
    /*END*/
   p.name like /*pmb.ProductName*/'%商品%'
  /*END*/
 order by p.product_id desc;
