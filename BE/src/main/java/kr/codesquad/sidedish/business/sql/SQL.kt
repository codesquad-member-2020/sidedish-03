package kr.codesquad.sidedish.business.sql

// language=SQL
const val DISH_DETAIL_SQL: String = """
SELECT img.url          AS top_image
     , sd.description   AS description
     , sd.point         AS point
     , sd.delivery_info AS delivery_info
     , sd.delivery_fee  AS delivery_fee
     , sd.normal_price  AS normal_price
     , sd.sale_price    AS sale_price
  FROM side_dish   AS sd
  INNER JOIN image AS img ON img.id = sd.top_image
 WHERE sd.id = :id;
"""

// language=SQL
const val THUMB_IMAGE_SQL: String = """
SELECT img.url
  FROM image                AS img
  LEFT OUTER JOIN side_dish AS sd ON img.side_dish = sd.id
 WHERE img.thumb_image_order IS NOT NULL
   AND sd.id = :id
 ORDER BY img.thumb_image_order;
"""

// language=SQL
const val DETAIL_SECTION_IMAGE_SQL: String = """
SELECT img.url
  FROM image                AS img
  LEFT OUTER JOIN side_dish AS sd ON img.side_dish = sd.id
 WHERE img.detail_section_image_order IS NOT NULL
   AND sd.id = :id
 ORDER BY img.detail_section_image_order;
"""

// language=SQL
const val BADGE_SQL: String = """
SELECT b.name
     , b.color
  FROM badge_side_dish
  INNER JOIN badge     b ON badge_side_dish.badge = b.id
  INNER JOIN side_dish sd ON badge_side_dish.side_dish = sd.id
 WHERE sd.id = :id;
"""

// language=SQL
const val ALL_FOOD_TYPE_SQL: String = """
SELECT id
     , name
     , description
  FROM food_type
 WHERE 1 = 1;
"""

// language=SQL
const val FOOD_TYPE_SQL: String = """
SELECT id
     , name
     , description
  FROM food_type
 WHERE id = :id;
"""

// language=SQL
const val DISH_OVERVIEW_SQL: String = """
SELECT sd.id
     , i.url           AS main_image
     , sd.alt
     , sd.title
     , sd.description
     , sd.normal_price AS normal_price
     , sd.sale_price   AS sale_price
  FROM side_dish       sd
  INNER JOIN image     i ON sd.top_image = i.id
  INNER JOIN food_type ft ON sd.food_type = ft.id
 WHERE ft.id = :id;
"""

// language=SQL
const val DELIVERY_TYPE_SQL: String = """
SELECT dt.name
  FROM delivery_type_side_dish
  INNER JOIN delivery_type dt ON delivery_type_side_dish.delivery_type = dt.id
  INNER JOIN side_dish     sd ON delivery_type_side_dish.side_dish = sd.id
 WHERE sd.id = :id;
"""

// language=SQL
const val ALL_CATEGORIES_SQL: String = """
SELECT id, name
  FROM category
"""

// language=SQL
const val CATEGORY_SQL: String = """
SELECT id, name
  FROM category
 WHERE id = :id;
"""

// language=SQL
const val CATEGORY_DISH_OVERVIEW_SQL: String = """
SELECT sd.id
     , i.url           AS main_image
     , sd.alt
     , sd.title
     , sd.description
     , sd.normal_price AS normal_price
     , sd.sale_price   AS sale_price
  FROM category_side_dish
  INNER JOIN category  c ON category_side_dish.category = c.id
  INNER JOIN side_dish sd ON category_side_dish.side_dish = sd.id
  INNER JOIN image     i ON sd.main_image = i.id
 WHERE c.id = :id;
"""
