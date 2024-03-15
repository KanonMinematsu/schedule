CREATE TABLE `schedules` (
	`id` SERIAL NOT NULL,
	`number` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`name` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`password` TEXT NOT NULL,
	`birthday` DATE NOT NULL,
	`phone` VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;