-- MySQL Workbench Synchronization
-- Generated: 2023-12-21 11:07
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Vũ Khánh Quốc

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER SCHEMA `social_network`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

ALTER TABLE `social_network`.`msg_member` 
DROP FOREIGN KEY `member_id`,
DROP FOREIGN KEY `user_join_target_msg_folder`;

ALTER TABLE `social_network`.`msg` 
DROP FOREIGN KEY `msg_to_target_msg_folder`;

ALTER TABLE `social_network`.`user` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `id` `id` VARCHAR(100) NOT NULL ,
CHANGE COLUMN `name` `name` NVARCHAR(100) NOT NULL ;

ALTER TABLE `social_network`.`post` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `created_at` `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ;

ALTER TABLE `social_network`.`comment` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `created_at` `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ;

ALTER TABLE `social_network`.`like` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `created_at` `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ;

ALTER TABLE `social_network`.`msg_folder` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `created_at` `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ;

ALTER TABLE `social_network`.`msg_member` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `join_at` `join_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ;

ALTER TABLE `social_network`.`msg` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `created_at` `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ;

ALTER TABLE `social_network`.`msg_member` 
ADD CONSTRAINT `member_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `social_network`.`user` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `user_join_target_msg_folder`
  FOREIGN KEY (`msg_folder_id`)
  REFERENCES `social_network`.`msg_folder` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `social_network`.`msg` 
DROP FOREIGN KEY `user_send_msg`;

ALTER TABLE `social_network`.`msg` ADD CONSTRAINT `user_send_msg`
  FOREIGN KEY (`user_id`)
  REFERENCES `social_network`.`user` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `msg_to_target_msg_folder`
  FOREIGN KEY (`msg_folder_id`)
  REFERENCES `social_network`.`msg_folder` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
