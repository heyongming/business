CREATE DATABASE `business`  DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
/*客服人员 */
CREATE TABLE `salesman`
(
`userId` INT(11)  NOT NULL AUTO_INCREMENT ,  /* id标识列*/
`userName` VARCHAR(50) NOT NULL,	     /* 姓名	*/	
`passWord` VARCHAR(50) NOT NULL,	     /* 密码	*/
`phone` VARCHAR(50) NOT NULL,                /* 电话*/
`type` INT NOT NULL,			     /*  所属角色 1.管理员。2.服务部。3.销售部。4.合规部。5.客服 */
`insertTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,/* 插入时间*/
PRIMARY KEY (`userId`)
)ENGINE=INNODB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;
/* */
/* 商品 */
CREATE TABLE `goodsList`
(
`goodsId` INT(11) NOT NULL AUTO_INCREMENT, /*商品编号*/
`goodsPrice` INT(11) NOT NULL,		/*商品价格*/
`goodsName` VARCHAR(50) NOT NULL,	/*商品名字*/
`imageUrl` VARCHAR(200)  NOT NULL,	/*商品图片 */
`inventory` INT(11) NOT NULL,		/* 库存*/
`salesVolume` INT(11) NOT NULL, 	/*销售额*/
`isShelves` INT(11) NOT NULL, 		/* 是否上架  */
`weight` INT(11) NOT NULL,		/*  权重 */
`hotGoods` INT (2) NOT NULL,            /* 热推*/
`dateManufacture` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,  /*上架时间*/
`effectiveTime` INT(5) NULL,			/*有效期*/
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
  `userId` INT(11) NOT NULL AUTO_INCREMENT,  /*用户ID */
  `passWord` VARCHAR(50) NULL,		     /*密码 */
  `createTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /*创建时间 */
  `type` INT(11) NULL,                        /*类型 */
  `userName` VARCHAR(50) NOT NULL,            /*用户名 */
  `Email` VARCHAR(50) NULL,		      /*邮箱 */
  `openId` VARCHAR(50) NOT NULL,	      /*微信的openId*/
  `phone` VARCHAR(50) NOT NULL,               /*手机号*/
  `addRess` VARCHAR(50) NULL,		      /* 地址 */
  `integral` VARCHAR(50) NULL,		      /* 积分*/
  `Grade` VARCHAR(50) NULL,			/* 等级*/
  `userStatus` VARCHAR(50) NOT NULL,            /*审核状态 */
  `idCard` VARCHAR(50) NOT NULL,               /*  身份证 */
  `rdCode` VARCHAR(50) NOT NULL,		/* 推荐码 */
  `answer` VARCHAR(200) NOT NULL,		/* 提交的风险答案*/
  `idImage` VARCHAR(200) NOT NULL,		/* 提交的身份证图片，分正反两面中间所以,隔开*/
  
   PRIMARY KEY (`userId`)
)ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;
CREATE TABLE `salesmanAndUser`
(
  `id` INT (11)  NOT NULL AUTO_INCREMENT, /* 自动增长列*/
  `userId` INT(11) NOT NULL,  /*用户ID */
   `salesmanId` INT(11) NOT NULL, /*销售ID */
   PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
CREATE TABLE `orderForm`
(
 `orderSerialNumber` VARCHAR(50) NOT NULL ,    /* 订单号*/
 `goodsId` INT(11) NOT NULL,			/* 商品编号 */
 `purchaseTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 购买时间*/
 `memberDiscount` VARCHAR(50) NULL,		/* 会员折扣*/
 `actualPurchasePriceGoods` VARCHAR(50) NULL,	/* 总金额*/
 `orderStatus` INT(2) NOT NULL,			/*订单状态*/
 `userId` INT(11) NOT NULL,			/* 用户ID*/
 `openId` VARCHAR(50) NOT NULL,			/* 关联的微信 */
 `paymentMethod` VARCHAR(50) NOT NULL,		/* 支付方式*/
 `paymentNumber` VARCHAR(50) NOT NULL,		/* 购买的数量 */
  `rdCode` VARCHAR(50) NOT NULL,		/* 激活码*/
  `invoiceInformation` VARCHAR(50) NOT NULL,	/* 发票详情*/
  `integral` VARCHAR(50) NULL                   /* 积分*/
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
CREATE TABLE `serviceTime`
(
   `id` INT(11) NOT NULL AUTO_INCREMENT ,
   `serviceDay` INT(11) NOT NULL,
   `goodsId` INT (11) NOT NULL,
   `ServiceTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;
CREATE TABLE goodslistUpgrade
(
   `id` INT(11) NOT NULL AUTO_INCREMENT ,
   `goodsId` INT(11) NOT NULL ,
   `UpgradeGoodsId` INT(11) NOT NULL ,
    `dateManufacture` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;
CREATE TABLE `mpService`
(
  `serviceId` INT(11) NOT NULL AUTO_INCREMENT ,
  `openId` VARCHAR(50) NOT NULL,
  `term` VARCHAR(50) NOT NULL,
  `updateTime` VARCHAR(50) NOT NULL ,
  `dateManufacture` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `goodsId` VARCHAR(50) NOT NULL,
  `orderSerialNumber` VARCHAR(50) NOT NULL,
  `isFrozen` VARCHAR(50) NOT NULL,
   PRIMARY KEY (`serviceId`)
)ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;



SELECT *  FROM `user` AS u
WHERE u.`userId` = (
SELECT of.`userId` FROM `orderform`AS of
WHERE of.`orderSerialNumber` ='354269284995694592'
)  AND u.`idCard` LIKE '%6096'

SELECT goodsId  FROM goodstypes AS gss 
WHERE gss.`goodsId` IN (
SELECT  of.`goodsId` FROM `orderform`AS of
WHERE of.`orderSerialNumber` ='354269284995694592'
) AND GSS.`goodsTypeId`!='1'

SELECT * FROM `goodstype` gs
WHERE gs.`goodsTypeId`=(
SELECT *  FROM `goodstypes` AS 
(SELECT goodsId FROM orderform AS of 
WHERE of.`orderSerialNumber`='354269284995694592')

)
SELECT * FROM  goodslist AS gl
 INNER JOIN goodsTypes AS gts ON gl.`goodsId`=gts.`goodsId`
 INNER JOIN goodsType AS gt ON gts.`goodsTypeId`=gt.`goodsTypeId`
CREATE TABLE ipTable
(
 `id` INT(11) NOT NULL AUTO_INCREMENT ,
 `TemplateId` INT(11) NOT NULL,
 `ip` VARCHAR(200) NOT NULL,
  `dateManufacture` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;




SELECT * FROM `orderform` AS of
INNER JOIN `goodsList` AS gl ON of.`goodsId`=gl.`goodsId`
INNER JOIN `user` AS us ON us.`userId`=of.`userId`
LEFT JOIN `orderactivationcode` AS oatc ON oatc.`orderSerialNumber`=of.`orderSerialNumber`
WHERE of.purchaseTime>'2017-09-07'
SELECT * FROM `goodsList` WHERE 1=1 AND `hotGoods`=1

SELECT gl.*,gt.`goodsTypeName` FROM goodstypes AS gts INNER JOIN goodslist AS gl ON gl.`goodsId`=gts.`goodsId` INNER JOIN goodsType AS gt ON gt.`goodsTypeId`=gts.`goodsTypeId` WHERE 1=1 AND gts.`goodsTypeId`=2


SELECT * FROM `goodsList` 	WHERE 1=1
AND isShelves = 1
		ORDER BY `weight`
SELECT gl.*,gt.`goodsTypeName` FROM goodstypes AS gts INNER JOIN goodslist AS gl ON gl.`goodsId`=gts.`goodsId` INNER JOIN goodsType AS gt ON gt.`goodsTypeId`=gts.`goodsTypeId` where 1=1 and gts.`goodsTypeId`=2 and isShelves = 1 ORDER BY `weight` 

select * from goodslistUpgrade as gu
inner join  `goodslist` as gl1 on  gu.goodsId=gl1.goodsId
inner join `goodslist`  as gl2 on gu.UpgradeGoodsId=gl2.goodsId
SELECT * FROM goodslistUpgrade AS gu INNER JOIN `goodslist` AS gl1 ON gu.goodsId=gl1.goodsId INNER JOIN `goodslist` AS gl2 ON gu.UpgradeGoodsId=gl2.goodsId 
SELECT gu.*,gl1.*,gl2.* FROM goodslistUpgrade AS gu INNER JOIN `goodslist` AS gl1 ON gu.goodsId=gl1.goodsId INNER JOIN `goodslist` AS gl2 ON gu.UpgradeGoodsId=gl2.goodsId 
SELECT gu.*,gl1.*,gl2.*
		FROM
		goodslistUpgrade AS gu
		INNER JOIN `goodslist` AS gl1 ON
		gu.goodsId=goodsId
		INNER JOIN `goodslist` AS gl2 ON
		gu.UpgradeGoodsId=gl2.goodsId
		