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
`effectiveTime` INT(5) NOT  NULL,			/*有效期*/
`minMon` INT(2) NOT NULL,			/*最小下限 */
`maxMon` INT(2) NOT NULL,			/*最大下限 */
`isBlend` INT(2) NOT NULL,			/* 是否是混合版*/
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
   `userId`  INT(11) NOT NULL,	
   `agreement` VARCHAR(200)  NULL,   
   `isActivation` INT(2) NULL,     
   `realAgreement`  VARCHAR(200)  NULL,    
   `ServiceTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;
CREATE TABLE goodslistUpgrade
(
   `id` INT(11) NOT NULL AUTO_INCREMENT ,
   `goodsId` INT(11) NOT NULL ,
   `UpgradeGoodsId` INT(11) NOT NULL ,`orderStatus`
    `dateManufacture` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;
CREATE TABLE `serviceArticle`
(
 `serviceArticleNum` INT(11) NOT NULL AUTO_INCREMENT , /* 文章编号*/
 `serviceArticleTitle` VARCHAR(50) NOT NULL,  /* 文章标题 */
 `goodsId` INT(11) NOT NULL,             /* 商品类型ID*/
 `serviceTypeId` INT(11) NOT NULL,	     /* 服务id*/
 `isOriginal` VARCHAR(50) NOT NULL,		/*是否原创*/
 `currentDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /* 当前时间*/
 `thumbnail` VARCHAR(200) NOT NULL,	/* 缩略图*/
 `targetTime` VARCHAR(50) NOT NULL,	/*目标发送时间*/
 `author` VARCHAR(50) NOT NULL,		/*作者*/
 `articleContent` TEXT NOT NULL,	/*文章内容*/
 `pointNumber` INT(11) NOT NULL,        /*点赞数*/
  `readingNumber` INT(11) NOT NULL,     /* 阅读数*/
   PRIMARY KEY (`serviceArticleNum`)
 )ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;
 CREATE  TABLE `serviceArticleType`
 (
 `serviceTypeId` INT(11) NOT NULL,
 `serviceTypeName` VARCHAR(50) NOT NULL,
 `serviceTypeImage` VARCHAR(50) NULL
 )
 CREATE TABLE `serviceArticleDetails`
 (
 `serviceArticleDetailsId` INT(11) NOT NULL  AUTO_INCREMENT,  /* 评论的序列号自动生成*/
 `serviceArticleNum` INT(11) NOT NULL,			/*被评论的文章*/
 `evaluateId` INT(11) NOT NULL,				/* 评价人*/
 `evaluateCent` VARCHAR(200) NOT NULL,			/*  评价内容*/
 `pointNumber` INT(11) NOT NULL,			/* 该评论被赞同的次数*/
 `issecondary` INT(11) NOT NULL,			/*该评论的父级 */
 `isOk` INT(2) NOT NULL,				/*是否展示	*/
 `currentDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`serviceArticleDetailsId`)
 )ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;
 CREATE TABLE `serviceArticleDetailsHelper`
 (
 `detailsHelpId` INT(11) NOT NULL  AUTO_INCREMENT,  /* 评论的序列号自动生成*/
 `evaluateId` INT(11) NOT NULL,			/*被评论的用户*/
 `toevaluateId` INT (11) NOT NULL,		/* 评论的用户*/
 `insertTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`detailsHelpId`)
 )ENGINE=INNODB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8;
 CREATE TABLE `serviceArticleHelper`
 (
 `helpId` INT(11) NOT NULL  AUTO_INCREMENT,  /* 评论的序列号自动生成*/
 `serviceArticleDetailsId` INT(11) NOT NULL,			/*被评论的文章*/
 `userId` INT (11) NOT NULL,			/* 评论ID*/
 `insertTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`helpId`)
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

INSERT INTO `serviceArticleType`(`serviceTypeId`,`serviceTypeName`)
VALUES(1,'早报')

INSERT INTO `serviceArticleType`(`serviceTypeId`,`serviceTypeName`)
VALUES(2,'中报')

INSERT INTO `serviceArticleType`(`serviceTypeId`,`serviceTypeName`)
VALUES(3,'晚报')

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
SELECT gl.*,gt.`goodsTypeName` FROM goodstypes AS gts INNER JOIN goodslist AS gl ON gl.`goodsId`=gts.`goodsId` INNER JOIN goodsType AS gt ON gt.`goodsTypeId`=gts.`goodsTypeId` WHERE 1=1 AND gts.`goodsTypeId`=2 AND isShelves = 1 ORDER BY `weight` 

SELECT * FROM goodslistUpgrade AS gu
INNER JOIN  `goodslist` AS gl1 ON  gu.goodsId=gl1.goodsId
INNER JOIN `goodslist`  AS gl2 ON gu.UpgradeGoodsId=gl2.goodsId
SELECT * FROM goodslistUpgrade AS gu INNER JOIN `goodslist` AS gl1 ON gu.goodsId=gl1.goodsId INNER JOIN `goodslist` AS gl2 ON gu.UpgradeGoodsId=gl2.goodsId 
SELECT gu.*,gl1.*,gl2.* FROM goodslistUpgrade AS gu INNER JOIN `goodslist` AS gl1 ON gu.goodsId=gl1.goodsId INNER JOIN `goodslist` AS gl2 ON gu.UpgradeGoodsId=gl2.goodsId 
SELECT gu.*,gl1.*,gl2.*
		FROM
		goodslistUpgrade AS gu
		INNER JOIN `goodslist` AS gl1 ON
		gu.goodsId=goodsId
		INNER JOIN `goodslist` AS gl2 ON
		gu.UpgradeGoodsId=gl2.goodsId
 GRANT ALL PRIVILEGES ON *.* TO 'myuser'@'%'IDENTIFIED BY 'mypassword' WITH GRANT OPTION;
 GRANT ALL PRIVILEGES ON *.* TO`business``business` 'root'@'%'WITH GRANT OPTION;
 SELECT * FROM `serviceTime` AS st
		INNER JOIN goodsList AS gl ON st.goodsId=gl.goodsId
		
SELECT * FROM `serviceTime` AS st INNER JOIN goodsList AS gl ON st.goodsId=gl.goodsId WHERE 1=1 a`user`nd st.`userId`=4 

	`orderform`SELECT * FROM `serviceTime` AS st INNER JOIN goodsList AS gl ON st.goodsId=gl.goodsId WHERE 1=1 AND st.`goodsId`=? AND st.`userId`=? 
	
	
	
SELECT * FROM `serviceTime` AS st INNER JOIN goodsList AS gl ON st.goodsId=gl.goodsId WHERE 1=1 AND st.`goodsId`=10034 AND st.`userId`=4
SELECT * FROM `serviceTime` AS st INNER JOIN goodsList AS gl ON st.goodsId=gl.goodsId WHERE 1=1 AND st.`goodsId`=10034 AND st.`userId`=4
SELECT * FROM `serviceTime` AS st INNER JOIN goodsList AS gl ON st.goodsId=gl.goodsId WHERE 1=1 AND st.`goodsId`=? AND st.`userId`=? 

SELECT * FROM  `servicearticle`  AS st
INNER JOIN  `servicearticletype` AS stt ON st.`serviceTypeId`=stt.`serviceTypeId`
INNER JOIN  `goodsType` AS gt ON gt.`goodsTypeId`=st.`goodsTypeId`
SELECT * FROM orderActivationCode WHERE `activationCode`='aHFrBJWG' AND isActivation='false' 
SELECT * FROM `orderform` AS of INNER JOIN `goodsList` AS gl ON of.`goodsId`=gl.`goodsId` INNER JOIN `user` AS us ON us.`userId`=of.`userId` LEFT JOIN `orderactivationcode` AS oatc ON oatc.`orderSerialNumber`=of.`orderSerialNumber` WHERE 1=1 AND of.`orderSerialNumber`='367622338193129472'
SELECT * FROM `servicearticle` AS st INNER JOIN `servicearticletype` AS stt ON st.`serviceTypeId`=stt.`serviceTypeId` INNER JOIN `goodsType` AS gt ON gt.`goodsTypeId`=st.`goodsTypeId` WHERE 1=1 

SELECT
		* FROM `servicearticle` AS st
		INNER JOIN `servicearticletype` AS
		stt ON
		st.`serviceTypeId`=stt.`serviceTypeId`
		INNER JOIN `goodslist` AS
		gl ON gl.`goodsId`=st.`goodsId`
		SELECT * FROM `servicearticle` AS st INNER JOIN `servicearticletype` AS stt ON st.`serviceTypeId`=stt.`serviceTypeId` INNER JOIN `goodslist` AS gl ON gl.`goodsId`=st.`goodsId` WHERE 1=1 AND st.`currentDate` NOT LIKE CONCAT('%', '2017-10-14', '%') AND st.`goodsId`=10027 ORDER BY st.`serviceTypeId` 



SELECT * FROM `servicearticle` AS st INNER JOIN `servicearticletype` AS stt ON st.`serviceTypeId`=stt.`serviceTypeId` INNER JOIN `goodslist` AS gl ON gl.`goodsId`=st.`goodsId` 
WHERE 1=1 AND st.`currentDate` NOT LIKE CONCAT('%', '2017-10-14', '%') AND st.`goodsId`=10027 AND st.`serviceTypeId`=1 ORDER BY st.`currentDate` DESC 

SELECT * FROM `serviceArticleHelper` WHERE `serviceArticleDetailsId`=0 AND `userId`=4
SELECT	* FROM `serviceArticleDetails` AS sad
INNER JOIN  `user` AS us ON us.`userId`=sad.`evaluateId`
INNER JOIN `mpUserentity` AS ms ON ms.`openid`=us.`openId`

		WHERE 1=1
SELECT * FROM `serviceArticleDetails` AS sad INNER JOIN `user` AS us ON us.`userId`=sad.`evaluateId` 
INNER JOIN `mpUserentity` AS ms ON ms.`openid`=us.`openId` AND sad.`serviceArticleNum`=1 ORDER BY `pointNumber` DESC 

		UPDATE
		`serviceTime`
		SET
		`serviceDay`=`serviceDay`-1
		WHERE `serviceDay`>0 AND `isActivation`==1
		`serviceDay`
		
`business`