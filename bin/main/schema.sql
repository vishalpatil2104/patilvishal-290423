CREATE TABLE customer (
	id BIGINT primary key not null,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	mobile_number varchar(15) not null
);
ALTER TABLE customer ADD CONSTRAINT customer_uk1 UNIQUE (mobile_number);

-- CREATE TABLE `MobileNumber` (
--   `id` BIGINT primary key NOT NULL AUTO_INCREMENT,
--   `number` varchar(20) NOT NULL,
--   `customer_id` int NOT NULL,
--   FOREIGN KEY (`customer_id`) REFERENCES `customer`(`id`)
-- );
