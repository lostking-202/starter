create table if not exists buiness_service(
	id int unsigned auto_increment primary key ,
	tier1_name varchar(64) unique not null
);
insert into business_service(id,tier1_name)values(1,'End User Computing');
insert into business_service(id,tier1_name)values(2,'Identity & Access Management');
insert into business_service(id,tier1_name)values(3,'Public Cloud services');
insert into business_service(id,tier1_name)values(4,'Integration and API');
insert into business_service(id,tier1_name)values(5,'IT tools');
insert into business_service(id,tier1_name)values(6,'Group Functions');
insert into business_service(id,tier1_name)values(7,'BI and analytics Offering');
insert into business_service(id,tier1_name)values(8,'Source and Deliver');
insert into business_service(id,tier1_name)values(9,'Enterprise Computing');
insert into business_service(id,tier1_name)values(10,'ITIL Tools');
insert into business_service(id,tier1_name)values(11,'Communication & Collaboration');
insert into business_service(id,tier1_name)values(12,'Procure');
insert into business_service(id,tier1_name)values(13,'Contract Management');
insert into business_service(id,tier1_name)values(14,'Messaging & Collaboration');
insert into business_service(id,tier1_name)values(15,'Office Network');
insert into business_service(id,tier1_name)values(16,'Commercial Marketing');
insert into business_service(id,tier1_name)values(17,'Smart Campus');
insert into business_service(id,tier1_name)values(18,'Value Flow');
insert into business_service(id,tier1_name)values(19,'Corporate Finance');
insert into business_service(id,tier1_name)values(20,'Output Device');
insert into business_service(id,tier1_name)values(21,'Enterprise WeChat');
insert into business_service(id,tier1_name)values(22,'Hardware repair delivery service');
insert into business_service(id,tier1_name)values(23,'Execute');
insert into business_service(id,tier1_name)values(24,'Network Security');
insert into business_service(id,tier1_name)values(25,'Care');
insert into business_service(id,tier1_name)values(26,'Competence Development (EDU)');
insert into business_service(id,tier1_name)values(27,'WAN & Internet');
insert into business_service(id,tier1_name)values(28,'IT Service');
insert into business_service(id,tier1_name)values(29,'ERP Platform');
insert into business_service(id,tier1_name)values(30,'RPA');
insert into business_service(id,tier1_name)values(31,'Workstation');
insert into business_service(id,tier1_name)values(32,'AIGC');
insert into business_service(id,tier1_name)values(33,'Cloud Devops');
