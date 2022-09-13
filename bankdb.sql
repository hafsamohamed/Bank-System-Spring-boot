CREATE DATABASE IF NOT EXISTS `bankdb`;
USE `bankdb`;

-- DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user`(
	`id` int(11) NOT NULL auto_increment,
    `user_name` varchar(45) default null,
    `password` varchar(45) default null,
	`is_admin` character default null,
    primary key (`id`)
);
    
-- DROP TABLE IF EXISTS `account_nature`;
CREATE TABLE IF NOT EXISTS `account_nature`(
	`id` int(11) NOT NULL auto_increment,
    `nature` varchar(45) NOT NULL,
    primary key (`id`)
);

-- DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS`account`(
	`id` int(16) NOT NULL,
    -- `account_id` int(16) unique NOT NULL,
    `account_nature_id` int not null,
	`balance` int default 0,
    `user_id` int not null,
    primary key (`id`),
    foreign key(`user_id`) references `user`(`id`) ,
    foreign key(`account_nature_id`) references `account_nature`(`id`)
);
    

    
-- DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction`(
	`id` int(11) NOT NULL auto_increment,
    `from` varchar(16) NOT NULL,
    `to` varchar(16) NOT NULL,
    primary key (`id`),
	foreign key(`from`) references `account`(`id`),
    foreign key(`to`) references `account`(`id`)
);
    