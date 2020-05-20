 CREATE TABLE `product` (
	`product_id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`description` TEXT(65535) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`price` DOUBLE(22,0) NOT NULL,
	`unit` VARCHAR(50) NOT NULL DEFAULT 'yen' COLLATE 'utf8_general_ci',
	`image` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`product_id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=0
;
