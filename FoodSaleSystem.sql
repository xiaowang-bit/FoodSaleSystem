SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  UNIQUE KEY `name` (`name`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100)  NOT NULL,
  `cellphone` VARCHAR(20) DEFAULT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` INT (10),
  `name` VARCHAR(100) NOT NULL,
  `price` FLOAT(8,2) DEFAULT 0,
  `imagepath` VARCHAR(300) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `category_id` INT(10) DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX (`category_id`), 
  CONSTRAINT `category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `id` VARCHAR(100) NOT NULL,
  `num` INT(11) DEFAULT NULL,
  `price` FLOAT(8,2) DEFAULT NULL,
  `status` INT(11) DEFAULT 0,
  `user_id` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_fk` (`user_id`),
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` VARCHAR(100) NOT NULL,
  `num` INT(11) DEFAULT NULL,
  `price` FLOAT(8,2) DEFAULT NULL,
  `orderInfo_id` VARCHAR(100) DEFAULT NULL,
  `food_id` INT(10) AUTO_INCREMENTfood_id,
  PRIMARY KEY (`id`),
  KEY `food_id_fk` (`food_id`),
  KEY `orderInfo_id_fk` (`orderInfo_id`),
  CONSTRAINT `food_id_fk` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderInfo_id_fk` FOREIGN KEY (`orderInfo_id`) REFERENCES `orderinfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` INT(10) AUTO_INCREMENT,
  `address` VARCHAR(100) NOT NULL,
  `user_id` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `u_id_fk` (`user_id`),
  CONSTRAINT `u_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
