DROP TABLE IF EXISTS `leaderboard` CASCADE;
CREATE TABLE `leaderboard` 
(`leaderboard_id` int NOT NULL AUTO_INCREMENT,
`losses` int NOT NULL,
`wins` int NOT NULL,
`charact_id` int DEFAULT NULL,
PRIMARY KEY (`leaderboard_id`));