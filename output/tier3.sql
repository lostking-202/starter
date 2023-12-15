create table if not exists it_service_offering_module(
	id int unsigned auto_increment primary key ,
	tier2_id int unsigned unique,
	tier3_name varchar(64) unique not null
);
insert into it_service_offering_module(id,tier2_id,tier3_name)values(1,17,'MTR Devices');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(2,17,'Collaboration Device');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(3,18,'NSB Webcast');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(4,24,'Desktop Phone/PBX');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(5,24,'Voice call center');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(6,18,'Digital media service');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(7,55,'DNS/DHCP/NTP');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(8,55,'IPAM (IP Management)');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(9,62,'LAN/Cabling');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(10,62,'WLAN');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(11,18,'Virtual meeting and Digital Event');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(12,71,'Mobile voice service');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(13,99,'SAP SB1 Finance');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(14,99,'SAP SB1 Logistics');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(15,71,'Softphone service');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(16,71,'Telecom expense management');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(17,118,'ICP Registration');
insert into it_service_offering_module(id,tier2_id,tier3_name)values(18,118,'Public Network Security Registration');
