ALTER TABLE `side_dish`
    DROP FOREIGN KEY `fk_side_dish_image_1`;
ALTER TABLE `side_dish`
    DROP FOREIGN KEY `fk_side_dish_image_2`;
ALTER TABLE `detail_section_image`
    DROP FOREIGN KEY `fk_detail_section_image_side_dish_1`;
ALTER TABLE `thumb_image`
    DROP FOREIGN KEY `fk_thumb_image_side_dish_1`;
ALTER TABLE `category_side_dish`
    DROP FOREIGN KEY `fk_category_side_dish_side_dish_1`;
ALTER TABLE `category_side_dish`
    DROP FOREIGN KEY `fk_category_side_dish_category_1`;
ALTER TABLE `delivery_type_side_dish`
    DROP FOREIGN KEY `fk_delivery_type_side_dish_delivery_type_1`;
ALTER TABLE `delivery_type_side_dish`
    DROP FOREIGN KEY `fk_delivery_type_side_dish_side_dish_1`;
ALTER TABLE `badge_side_dish`
    DROP FOREIGN KEY `fk_badge_side_dish_badge_1`;
ALTER TABLE `badge_side_dish`
    DROP FOREIGN KEY `fk_badge_side_dish_side_dish_1`;
ALTER TABLE `side_dish`
    DROP FOREIGN KEY `fk_side_dish_food_type_1`;
ALTER TABLE `image`
    DROP FOREIGN KEY `fk_image_side_dish_1`;

DROP TABLE `side_dish`;
DROP TABLE `image`;
DROP TABLE `detail_section_image`;
DROP TABLE `thumb_image`;
DROP TABLE `category`;
DROP TABLE `category_side_dish`;
DROP TABLE `food_type`;
DROP TABLE `delivery_type`;
DROP TABLE `badge`;
DROP TABLE `delivery_type_side_dish`;
DROP TABLE `badge_side_dish`;
DROP TABLE `user`;

CREATE TABLE `side_dish`
(
    `id`            BIGINT(11)    NOT NULL AUTO_INCREMENT,
    `main_image`    BIGINT(11)    NULL,
    `top_image`     BIGINT(11)    NULL,
    `alt`           VARCHAR(255)  NULL,
    `title`         VARCHAR(255)  NULL,
    `description`   VARCHAR(1000) NULL,
    `normal_price`  INT(11)       NULL,
    `sale_price`    INT(11)       NULL,
    `point`         INT(11)       NULL,
    `delivery_info` VARCHAR(255)  NULL,
    `delivery_fee`  VARCHAR(255)  NULL,
    `food_type`     BIGINT(11)    NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `image`
(
    `id`                         BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `url`                        VARCHAR(255) NULL,
    `side_dish`                  BIGINT(11)   NULL,
    `detail_section_image_order` INT(11)      NULL,
    `thumb_image_order`          INT(11)      NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `detail_section_image`
(
    `id`            BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `url`           VARCHAR(255) NULL,
    `side_dish`     BIGINT(11)   NULL,
    `side_dish_key` INT(11)      NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `thumb_image`
(
    `id`            BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `url`           VARCHAR(255) NULL,
    `side_dish`     BIGINT(11)   NULL,
    `side_dish_key` INT(11)      NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `category`
(
    `id`   BIGINT(11)   NOT NULL,
    `name` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `category_side_dish`
(
    `id`        BIGINT(11) NOT NULL AUTO_INCREMENT,
    `category`  BIGINT(11) NULL,
    `side_dish` BIGINT(11) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `food_type`
(
    `id`   BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `delivery_type`
(
    `id`   BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `badge`
(
    `id`   BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `delivery_type_side_dish`
(
    `id`            BIGINT(11) NOT NULL,
    `delivery_type` BIGINT(11) NULL,
    `side_dish`     BIGINT(11) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `badge_side_dish`
(
    `id`        BIGINT(11) NOT NULL AUTO_INCREMENT,
    `badge`     BIGINT(11) NULL,
    `side_dish` BIGINT(11) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `user`
(
    `id`           BIGINT(11)   NOT NULL,
    `user_name`    VARCHAR(255) NULL,
    `access_token` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE `side_dish`
    ADD CONSTRAINT `fk_side_dish_image_1` FOREIGN KEY (`main_image`) REFERENCES `image` (`id`);
ALTER TABLE `side_dish`
    ADD CONSTRAINT `fk_side_dish_image_2` FOREIGN KEY (`top_image`) REFERENCES `image` (`id`);
ALTER TABLE `detail_section_image`
    ADD CONSTRAINT `fk_detail_section_image_side_dish_1` FOREIGN KEY (`side_dish`) REFERENCES `side_dish` (`id`);
ALTER TABLE `thumb_image`
    ADD CONSTRAINT `fk_thumb_image_side_dish_1` FOREIGN KEY (`side_dish`) REFERENCES `side_dish` (`id`);
ALTER TABLE `category_side_dish`
    ADD CONSTRAINT `fk_category_side_dish_side_dish_1` FOREIGN KEY (`side_dish`) REFERENCES `side_dish` (`id`);
ALTER TABLE `category_side_dish`
    ADD CONSTRAINT `fk_category_side_dish_category_1` FOREIGN KEY (`category`) REFERENCES `category` (`id`);
ALTER TABLE `delivery_type_side_dish`
    ADD CONSTRAINT `fk_delivery_type_side_dish_delivery_type_1` FOREIGN KEY (`delivery_type`) REFERENCES `delivery_type` (`id`);
ALTER TABLE `delivery_type_side_dish`
    ADD CONSTRAINT `fk_delivery_type_side_dish_side_dish_1` FOREIGN KEY (`side_dish`) REFERENCES `side_dish` (`id`);
ALTER TABLE `badge_side_dish`
    ADD CONSTRAINT `fk_badge_side_dish_badge_1` FOREIGN KEY (`badge`) REFERENCES `badge` (`id`);
ALTER TABLE `badge_side_dish`
    ADD CONSTRAINT `fk_badge_side_dish_side_dish_1` FOREIGN KEY (`side_dish`) REFERENCES `side_dish` (`id`);
ALTER TABLE `side_dish`
    ADD CONSTRAINT `fk_side_dish_food_type_1` FOREIGN KEY (`food_type`) REFERENCES `food_type` (`id`);
ALTER TABLE `image`
    ADD CONSTRAINT `fk_image_side_dish_1` FOREIGN KEY (`side_dish`) REFERENCES `side_dish` (`id`);

