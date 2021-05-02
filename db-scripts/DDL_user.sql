CREATE TABLE `user` (
	`id` BIGINT(19) NOT NULL,
	`first_name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`last_name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`email` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`created_date` DATE NULL DEFAULT NULL,
	`modified_date` DATE NULL DEFAULT NULL,
	`created_by` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`modified_by` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
;

ALTER TABLE user  MODIFY COLUMN created_date DATETIME NOT NULL;
ALTER TABLE user  MODIFY COLUMN  modified_date DATETIME NOT NULL;