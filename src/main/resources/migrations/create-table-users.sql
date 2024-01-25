CREATE TABLE master_users (
	id bigserial NOT NULL,
	username varchar(50) NOT NULL,
	"name" varchar(50) NOT NULL,
	phone varchar(50) NULL,
	role_id int8 NOT NULL,
	created_by varchar(50) NULL,
	created_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	modified_by varchar(50) NULL,
	modified_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	is_active bool NULL DEFAULT true,
	CONSTRAINT master_users_pkey PRIMARY KEY (id)
);


CREATE TABLE public.master_role (
	id bigserial NOT NULL,
	role_name varchar(50) NULL,
	"insert" bool NULL DEFAULT false,
	"read" bool NULL DEFAULT false,
	"update" bool NULL DEFAULT false,
	"delete" bool NULL DEFAULT false,
	is_active bool NULL DEFAULT true,
	CONSTRAINT master_role_pkey PRIMARY KEY (id)
);