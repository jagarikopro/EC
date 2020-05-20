/*
 [df:title]
  selectCartInTotalPrice

 [df:description]
  カートにある全ての商品の合計金額を取得

*/

-- #df:entity#

-- !df:pmb!
-- !!AutoDetect!!
-- !!Integer UserId!!

select sum(c.cart_num * p.price) as total_price
  from cart c
  join product p on c.product_id = p.product_id
  where
  c.user_id = /*pmb.UserId*/1
