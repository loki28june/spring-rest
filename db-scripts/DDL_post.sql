

CREATE TABLE `post` (
	`id` INT(19) NOT NULL,
	`description` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`user_id` INT(19) NULL ,
	`created_date` DATETIME NOT NULL,
	`modified_date` DATETIME NOT NULL,
	`created_by` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`modified_by` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;

ALTER TABLE post ADD CONSTRAINT user_foreign_key FOREIGN KEY (user_id) REFERENCES user(id);