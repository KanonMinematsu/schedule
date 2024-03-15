CREATE TABLE `privates`(
	`id` SERIAL NOT NULL,
	`number` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`day` DATE,
	`time` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`title` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`task` VARCHAR(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;