create table if not exists application_mapping(
	id int unsigned auto_increment primary key,
	nbs_domain varchar(16),
	service_tier1_id int unsigned,
	service_tier2_id int unsigned,
	service_tier3_id int unsigned,
	application varchar(16),
	service_owner_id bigint,
	business_analyst bigint,
	solution_owner_id bigint,
	ims varchar(16),
	ams varchar(16),
	service_status varchar(2),
	service_description varchar(1024)
);
