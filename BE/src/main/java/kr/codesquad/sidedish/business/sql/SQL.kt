package kr.codesquad.sidedish.business.sql

const val DISH_DETAIL_SQL: String = """
SELECT img.url AS top_image
     , sd.description AS description
     , FORMAT(sd.point, 0) AS point
     , sd.delivery_info AS delivery_info
     , sd.delivery_fee AS delivery_fee
     , FORMAT(sd.normal_price, 0) AS normal_price
     , FORMAT(sd.sale_price, 0) AS sale_price
  FROM side_dish AS sd
 INNER JOIN image AS img ON img.id = sd.top_image
 WHERE sd.id = :id;
"""

const val THUMB_IMAGE_SQL: String = """
SELECT img.url
  FROM image AS img
  LEFT OUTER JOIN side_dish AS sd ON img.side_dish = sd.id
 WHERE img.thumb_image_order IS NOT NULL
   AND sd.id = :id
 ORDER BY img.thumb_image_order;
"""

const val DETAIL_SECTION_IMAGE_SQL: String = """
SELECT img.url
  FROM image AS img
  LEFT OUTER JOIN side_dish AS sd ON img.side_dish = sd.id
 WHERE img.detail_section_image_order IS NOT NULL
   AND sd.id = :id
 ORDER BY img.detail_section_image_order;
"""

const val BADGE_SQL: String = """
SELECT b.name
     , b.color
  FROM badge_side_dish
 INNER JOIN badge b ON badge_side_dish.badge = b.id
 INNER JOIN side_dish sd ON badge_side_dish.side_dish = sd.id
 WHERE sd.id = :id;
"""
