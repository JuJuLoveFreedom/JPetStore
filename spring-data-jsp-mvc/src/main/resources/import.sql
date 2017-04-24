use jpetstore;
INSERT INTO user(username,password) VALUES ('pikachu','123');
INSERT INTO profile (id,language) VALUES (1,'中文');

INSERT INTO level (id, img, name) VALUES (1, '', '普通会员');

INSERT INTO account ( email, name, nickname, phone, qq, city, country, province, street, zip, level_id)
 VALUES ('2931408816@qq.com', '杨浩', '大黄老鼠', '15084909943', '29314088165',
          '长沙', '中国', '湖南', '天心区青园路56号', '415100',1);
INSERT INTO account (id, email, name, nickname, phone, qq, city, country, province, street, zip, level_id) VALUES (1,)
/*
DELETE FROM account;
DELETE FROM level;
DELETE FROM profile;
DELETE FROM jpetstore.user;
*/