DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addUserLog`(in username varchar(50), in ipaddress varchar(15))
BEGIN
INSERT INTO `book`.`userlog`
(userlog_loginname,
userlog_ipaddress,
userlog_timestamp)
VALUES
(username,
ipaddress,
(select current_timestamp));
END$$
DELIMITER ;
