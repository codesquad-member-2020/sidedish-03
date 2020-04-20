ALTER TABLE `sidedish`.`side_dish`
    DROP FOREIGN KEY `fk_side_dish_image_1`;
ALTER TABLE `sidedish`.`side_dish`
    DROP FOREIGN KEY `fk_side_dish_image_2`;
ALTER TABLE `sidedish`.`detail_section_image`
    DROP FOREIGN KEY `fk_detail_section_image_side_dish_1`;
ALTER TABLE `sidedish`.`thumb_image`
    DROP FOREIGN KEY `fk_thumb_image_side_dish_1`;
ALTER TABLE `sidedish`.`category_side_dish`
    DROP FOREIGN KEY `fk_category_side_dish_side_dish_1`;
ALTER TABLE `sidedish`.`category_side_dish`
    DROP FOREIGN KEY `fk_category_side_dish_category_1`;
ALTER TABLE `sidedish`.`delivery_type_side_dish`
    DROP FOREIGN KEY `fk_delivery_type_side_dish_delivery_type_1`;
ALTER TABLE `sidedish`.`delivery_type_side_dish`
    DROP FOREIGN KEY `fk_delivery_type_side_dish_side_dish_1`;
ALTER TABLE `sidedish`.`badge_side_dish`
    DROP FOREIGN KEY `fk_badge_side_dish_badge_1`;
ALTER TABLE `sidedish`.`badge_side_dish`
    DROP FOREIGN KEY `fk_badge_side_dish_side_dish_1`;
ALTER TABLE `sidedish`.`side_dish`
    DROP FOREIGN KEY `fk_side_dish_food_type_1`;

DROP TABLE IF EXISTS `sidedish`.`side_dish`;
DROP TABLE IF EXISTS `sidedish`.`image`;
DROP TABLE IF EXISTS `sidedish`.`detail_section_image`;
DROP TABLE IF EXISTS `sidedish`.`thumb_image`;
DROP TABLE IF EXISTS `sidedish`.`category`;
DROP TABLE IF EXISTS `sidedish`.`category_side_dish`;
DROP TABLE IF EXISTS `sidedish`.`food_type`;
DROP TABLE IF EXISTS `sidedish`.`delivery_type`;
DROP TABLE IF EXISTS `sidedish`.`badge`;
DROP TABLE IF EXISTS `sidedish`.`delivery_type_side_dish`;
DROP TABLE IF EXISTS `sidedish`.`badge_side_dish`;

CREATE TABLE IF NOT EXISTS `sidedish`.`side_dish`
(
    `id`            BIGINT(11)    NOT NULL AUTO_INCREMENT,
    `detail_hash`   VARCHAR(255)  NULL,
    `main_image`    BIGINT(255)   NULL,
    `top_image`     BIGINT(255)   NULL,
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
CREATE TABLE IF NOT EXISTS `sidedish`.`image`
(
    `id`  BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `url` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `sidedish`.`detail_section_image`
(
    `id`            BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `url`           VARCHAR(255) NULL,
    `side_dish`     BIGINT(11)   NULL,
    `side_dish_key` INT(11)      NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `sidedish`.`thumb_image`
(
    `id`            BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `url`           VARCHAR(255) NULL,
    `side_dish`     BIGINT(11)   NULL,
    `side_dish_key` INT(11)      NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `sidedish`.`category`
(
    `id`   BIGINT(11)   NOT NULL,
    `name` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `sidedish`.`category_side_dish`
(
    `id`        BIGINT(11) NOT NULL AUTO_INCREMENT,
    `category`  BIGINT(11) NULL,
    `side_dish` BIGINT(11) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `sidedish`.`food_type`
(
    `id`   BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `sidedish`.`delivery_type`
(
    `id`   BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `sidedish`.`badge`
(
    `id`   BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `sidedish`.`delivery_type_side_dish`
(
    `id`            BIGINT(11) NOT NULL,
    `delivery_type` BIGINT(11) NULL,
    `side_dish`     BIGINT(11) NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `sidedish`.`badge_side_dish`
(
    `id`        BIGINT(11) NOT NULL AUTO_INCREMENT,
    `badge`     BIGINT(11) NULL,
    `side_dish` BIGINT(11) NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE `sidedish`.`side_dish`
    ADD CONSTRAINT `fk_side_dish_image_1` FOREIGN KEY (`main_image`) REFERENCES `sidedish`.`image` (`id`);
ALTER TABLE `sidedish`.`side_dish`
    ADD CONSTRAINT `fk_side_dish_image_2` FOREIGN KEY (`top_image`) REFERENCES `sidedish`.`image` (`id`);
ALTER TABLE `sidedish`.`detail_section_image`
    ADD CONSTRAINT `fk_detail_section_image_side_dish_1` FOREIGN KEY (`side_dish`) REFERENCES `sidedish`.`side_dish` (`id`);
ALTER TABLE `sidedish`.`thumb_image`
    ADD CONSTRAINT `fk_thumb_image_side_dish_1` FOREIGN KEY (`side_dish`) REFERENCES `sidedish`.`side_dish` (`id`);
ALTER TABLE `sidedish`.`category_side_dish`
    ADD CONSTRAINT `fk_category_side_dish_side_dish_1` FOREIGN KEY (`side_dish`) REFERENCES `sidedish`.`side_dish` (`id`);
ALTER TABLE `sidedish`.`category_side_dish`
    ADD CONSTRAINT `fk_category_side_dish_category_1` FOREIGN KEY (`category`) REFERENCES `sidedish`.`category` (`id`);
ALTER TABLE `sidedish`.`delivery_type_side_dish`
    ADD CONSTRAINT `fk_delivery_type_side_dish_delivery_type_1` FOREIGN KEY (`delivery_type`) REFERENCES `sidedish`.`delivery_type` (`id`);
ALTER TABLE `sidedish`.`delivery_type_side_dish`
    ADD CONSTRAINT `fk_delivery_type_side_dish_side_dish_1` FOREIGN KEY (`side_dish`) REFERENCES `sidedish`.`side_dish` (`id`);
ALTER TABLE `sidedish`.`badge_side_dish`
    ADD CONSTRAINT `fk_badge_side_dish_badge_1` FOREIGN KEY (`badge`) REFERENCES `sidedish`.`badge` (`id`);
ALTER TABLE `sidedish`.`badge_side_dish`
    ADD CONSTRAINT `fk_badge_side_dish_side_dish_1` FOREIGN KEY (`side_dish`) REFERENCES `sidedish`.`side_dish` (`id`);
ALTER TABLE `sidedish`.`side_dish`
    ADD CONSTRAINT `fk_side_dish_food_type_1` FOREIGN KEY (`food_type`) REFERENCES `sidedish`.`food_type` (`id`);

