/*
 [df:title]
  selectCartInProductDitails

 [df:description]
  カート一覧ページに必要な情報を取得
*/

-- #df:entity#

-- !df:pmb!
-- !!AutoDetect!!
-- !!Integer UserId!!
-- !!Integer ProductId!!

select c.cart_id, c.cart_num, p.product_id, p.name, p.description, p.price, p.unit, p.image
  from cart c
  join product p on c.product_id = p.product_id
  where
  c.user_id = /*pmb.UserId*/1
  /*IF pmb.ProductId != null*/
  AND p.product_id = /*pmb.ProductId*/1
  /*END*/
 order by c.created asc;
