create database school;

use eazyschool;

create table if not exists `contact_msg` (
`contact_id` int auto_increment primary key,
`name` varchar(100) not null,
`mobile_num` varchar(10) not null,
`email` varchar(100) not null,
`subject` varchar(100) not null,
`message` varchar(500) not null,
`status` varchar(10) not null,
`created_at` timestamp not null,
`created_by` varchar(50) not null,
`updated_at` timestamp default null,
`updated_by` varchar(50) default null
)

create table if not exists `holidays` (
`day` varchar(20) not null,
`reason` varchar(100) not null,
`type` varchar(20) not null,
`created_at` timestamp not null,
`created_by` varchar(50) not null,
`updated_at` timestamp default null,
`updated_by` varchar(50) default null
)

create table if not exists `roles` (
`role_id` int not null auto_increment,
`role_name` varchar(50) not null,
`created_at` timestamp not null,
`created_by` varchar(50) not null,
`updated_at` timestamp default null,
`updated_by` varchar(50) default null,
primary key(`role_id`)
)

create table if not exists `address` (
`address_id` int not null auto_increment,
`address1` varchar(200) not null,
`address2` varchar(200) default null,
`city` varchar(50) not null,
`state` varchar(50) not null,
`zip_code` int not null,
`created_at` timestamp not null,
`created_by` varchar(50) not null,
`updated_at` timestamp default null,
`updated_by` varchar(50) default null
primary key(`address_id`)
)
























