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
CREATE TABLE `user`
(
  `userId` INT(11) NOT NULL AUTO_INCREMENT,
  `passWord` VARCHAR(50) NULL,
  `createTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` INT(11) NULL,
  `userName` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(50) NULL,
  `openId` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(50) NOT NULL,
  `addRess` VARCHAR(50) NULL,
  `integral` VARCHAR(50) NULL,
  `Grade` VARCHAR(50) NULL,
  `userStatus` VARCHAR(50) NOT NULL,
  `idCard` VARCHAR(50) NOT NULL,
  `rdCode` VARCHAR(50) NOT NULL,
   PRIMARY KEY (`userId`)
)ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;
CREATE TABLE `orderForm`
(
 `orderSerialNumber` VARCHAR(50) NOT NULL ,
 `goodsId` INT(11) NOT NULL,
 `purchaseTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `memberDiscount` VARCHAR(50) NULL,
 `actualPurchasePriceGoods` VARCHAR(50) NULL,	
 `orderStatus` INT(2) NOT NULL,
 `userId` INT(11) NOT NULL,
 `openId` VARCHAR(50) NOT NULL,
 `paymentMethod` VARCHAR(50) NOT NULL,
 `paymentNumber` VARCHAR(50) NOT NULL,
  `rdCode` VARCHAR(50) NOT NULL,
  `invoiceInformation` VARCHAR(50) NOT NULL,
  `integral` VARCHAR(50) NULL
)DEFAULT CHARSET=utf8;
CREATE TABLE `orderActivationCode`
(
   `activationCodeId` INT(11) NOT NULL AUTO_INCREMENT,
   `orderSerialNumber` VARCHAR(50) NOT NULL,
    `isActivation` VARCHAR(50) NOT NULL,
    `activationCode` VARCHAR(50) NOT  NULL,
    `dateManufacture` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY (`activationCodeId`)

)ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;


SELECT of.* FROM `orderform` of
		INNER JOIN `user` us ON
		us.`userId`=of.`userId`
		WHERE us.`phone`='18374871374'


SELECT gl.*,gt.`goodsTypeName` FROM goodstypes AS gts
INNER JOIN goodslist AS gl ON gl.`goodsId`=gts.`goodsId`
INNER JOIN goodType AS gt ON gt.`goodsTypeId`=gts.`goodsTypeId`
WHERE gt.`goodsTypeId`
AND gts.`goodsTypeId`


SELECT gl.*,gt.`goodsTypeName` FROM goodstypes AS gts INNER JOIN goodslist AS gl ON gl.`goodsId`=gts.`goodsId` INNER JOIN goodsType AS gt ON gt.`goodsTypeId`=gts.`goodsTypeId` WHERE 1=1 AND 
 gts.`goodsTypeId`=1
 
 
`goodslist`