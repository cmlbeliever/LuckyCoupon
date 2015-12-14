-- SELECT * FROM t_user_coupon
DROP PROCEDURE IF EXISTS init;

CREATE PROCEDURE init (couponId INT) BEGIN DECLARE initSize INT;

SET initSize = 0;



WHILE initSize < 100000 DO INSERT INTO t_user_coupon ( coupon_id, use_flg, create_date, update_date ) VALUES (couponId, 0, now(), now());
     SET initSize = initSize + 1;
END WHILE;



END