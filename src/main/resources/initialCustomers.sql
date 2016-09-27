-- customer table

INSERT INTO customer(id, name, phone, tstamp) values( nextval( 'hibernate_sequence') , 'Sam','(925)-123-4567', NOW());
INSERT INTO customer(id, name, phone, tstamp) values( nextval( 'hibernate_sequence') , 'Sergey','(925)-223-4567', NOW());
INSERT INTO customer(id, name, phone, tstamp) values( nextval( 'hibernate_sequence') , 'Bob', ,'(925)-323-4567', NOW());
INSERT INTO customer(id, name, phone, tstamp) values( nextval( 'hibernate_sequence') , 'Robert','(925)-423-4567', NOW());

-- location table

INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 1 , NOW(), 128.123, 35.44);
INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 2 , NOW(), 128.12, 35.43);
INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 3 , NOW(), 128.127, 35.44);
INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 1 , NOW(), 128.12, 35.44);
INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 2 , NOW(), 128.121, 35.43);
INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 3 , NOW(), 128.12, 35.44);
INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 1 , NOW(), 128.123, 35.44);
INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 2 , NOW(), 128.12, 35.43);
INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 3 , NOW(), 128.127, 35.44);
INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 1 , NOW(), 128.12, 35.44);
INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 2 , NOW(), 128.121, 35.43);
INSERT INTO location(id, deviceId, tmStmp, lat, lng) values(nextval( 'hibernate_sequence') , 3 , NOW(), 128.12, 35.44);
