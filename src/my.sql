CREATE DATABASE `business`  DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
/*客服人员 */
CREATE TABLE `salesman`
(
`userId` INT(11)  NOT NULL AUTO_INCREMENT , 
`userName` VARCHAR(50) NOT NULL,
`passWord` VARCHAR(50) NOT NULL,
`phone` VARCHAR(50) NOT NULL,
`type` INT NOT NULL,
`insertTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`userId`)
)ENGINE=INNODB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
/* */
/* 商品 */
CREATE TABLE `goodsList`
(
`goodsId` INT(11) NOT NULL AUTO_INCREMENT,
`goodsPrice` INT(11) NOT NULL,
`goodsName` VARCHAR(50) NOT NULL,
`imageUrl` VARCHAR(50)  NOT NULL,	
`inventory` INT(11) NOT NULL,
`salesVolume` INT(11) NOT NULL,
`isShelves` INT(11) NOT NULL, 
`weight` INT(11) NOT NULL,
`dateManufacture` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`goodsId`)
)ENGINE=INNODB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

CREATE TABLE `goodsTypes`
(
  `autoId` INT NOT NULL AUTO_INCREMENT,
  `goodsId` INT(11) NOT NULL ,
  `goodsTypeId` INT(11) NOT NULL ,
  PRIMARY KEY (`autoId`)
)ENGINE=INNODB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;
CREATE TABLE `goodsType`
(
  `goodsTypeId` INT(11) NOT NULL AUTO_INCREMENT,
  `goodsTypeName` VARCHAR(50) NOT NULL,
   PRIMARY KEY (`goodsTypeId`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/* 商品 */

SELECT gl.*,gt.`goodsTypeName` FROM goodstypes AS gts
INNER JOIN goodslist AS gl ON gl.`goodsId`=gts.`goodsId`
INNER JOIN goodType AS gt ON gt.`goodsTypeId`=gts.`goodsTypeId`
WHERE gt.`goodsTypeId`
AND gts.`goodsTypeId`


SELECT gl.*,gt.`goodsTypeName` FROM goodstypes AS gts INNER JOIN goodslist AS gl ON gl.`goodsId`=gts.`goodsId` INNER JOIN goodsType AS gt ON gt.`goodsTypeId`=gts.`goodsTypeId` WHERE 1=1 AND 
 gts.`goodsTypeId`=1