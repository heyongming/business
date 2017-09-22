SELECT  * FROM `user`
WHERE idCard LIKE '%046096' 

CREATE TABLE `activityC`
(
`userId` INT(11)  NOT NULL AUTO_INCREMENT , 
`userName` VARCHAR(50) NOT NULL,
`phone` VARCHAR(50) NOT NULL,
`type` INT NOT NULL,
`insertTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`userId`)
)ENGINE=INNODB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;



SELECT * FROM `user` AS u
		WHERE u.`userId` = (
		SELECT
		of.`userId` FROM `orderform`AS of
		WHERE of.``serviceId``serviceId`` ='1'
		)
		AND u.`idCard` LIKE  CONCAT('%',#{idCard})`mpservice`