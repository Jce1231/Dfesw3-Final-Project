DROP TABLE IF EXISTS `users` CASCADE;
CREATE TABLE
`users`
(`user_id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(255) DEFAULT NULL,
PRIMARY KEY (`user_id`));