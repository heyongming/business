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
CREATE TABLE `mpUserentity`
(
   `openid` VARCHAR(50) NOT NULL,
   `nickname` VARCHAR(50) NOT NULL,
   `sex` VARCHAR(10) NOT NULL,
   `province` VARCHAR(50)  NULL,
   `city` VARCHAR(50)  NULL,
   `country` VARCHAR(50)  NULL,
   `headimgurl` VARCHAR(200)  NULL,
   `privilege` VARCHAR(400)  NULL,
   `unionid` VARCHAR(50)  NULL,
   `dateManufacture` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`openid`)
)
CREATE TABLE `mpService`
(
  `serviceId` INT(11) NOT NULL AUTO_INCREMENT ,
  `openId` VARCHAR(50) NOT NULL,
  `term` VARCHAR(50) NOT NULL,
  `updateTime` VARCHAR(50) NOT NULL ,
  `dateManufacture` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goodsType` VARCHAR(50) NOT NULL,
  `orderSerialNumber` vahrchar(50) NOT NULL
  `isFrozen` VARCHAR(50) NOT NULL,
   PRIMARY KEY (`serviceId`)
)ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;



SELECT *  FROM `user` AS u
WHERE u.`userId` = (
SELECT of.`userId` FROM `orderform`AS of
WHERE of.`orderSerialNumber` ='354269284995694592'
)  AND u.`idCard` LIKE '%6096'

SELECT *  FROM goodstypes AS gss 
WHERE gss.`goodsId` IN (
SELECT  of.`goodsId` FROM `orderform`AS of
WHERE of.`orderSerialNumber` ='354269284995694592'
) AND GSS.`goodsTypeId`!=1