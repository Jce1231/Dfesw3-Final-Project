DROP TABLE IF EXISTS `charact` CASCADE;
CREATE TABLE `charact` (
  `charact_id` bigint NOT NULL AUTO_INCREMENT,
  `con` int NOT NULL,
  `dex` int NOT NULL,
  `dmg` int NOT NULL,
  `health` int NOT NULL,
  `intel` int NOT NULL,
  `speed` int NOT NULL,
  `str` int NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`charact_id`));