DROP TABLE IF EXISTS `users` CASCADE;
DROP TABLE IF EXISTS `charact`;
CREATE TABLE
`users`
(`user_id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(255) DEFAULT NULL,
PRIMARY KEY (`user_id`));