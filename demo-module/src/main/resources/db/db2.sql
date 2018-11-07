-- db2 人员表
CREATE TABLE `db2_person2` (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
	`gmt_create` datetime NOT NULL COMMENT '创建时间',
	`gmt_modified` datetime NOT NULL  COMMENT '修改时间',
	`user_create` int(11) NOT NULL  COMMENT '创建用户',
	`user_modified` int(11) NOT NULL  COMMENT '修改用户',
	`deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除:1正常, 0删除',
	`name` varchar(20) NOT NULL COMMENT '名称',
	`age` int NOT NULL COMMENT '年龄',
	PRIMARY KEY (`id`)
) COMMENT='人员表';
