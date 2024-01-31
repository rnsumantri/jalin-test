CREATE TABLE public.master_users (
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
     hash_password varchar NOT NULL,
     CONSTRAINT master_users_pkey PRIMARY KEY (id),
     CONSTRAINT master_users_unique UNIQUE (username)
);


CREATE TABLE public.master_role (
    id bigserial NOT NULL,
    role varchar(50) NOT NULL,
    "insert" bool NULL DEFAULT false,
    "read" bool NULL DEFAULT false,
    "update" bool NULL DEFAULT false,
    "delete" bool NULL DEFAULT false,
    is_active bool NULL DEFAULT true,
    CONSTRAINT master_role_pkey PRIMARY KEY (id),
    CONSTRAINT master_role_unique UNIQUE (role)
);

INSERT INTO public.master_role
(role, "insert", "read", "update", "delete", is_active)
VALUES('admin', true, true, true, true, true);

INSERT INTO public.master_users
(username, "name", phone, role_id, created_by, created_date, modified_by, modified_date, is_active, hash_password)
VALUES('Muhlis', 'Muhlis', '08777777', 1, 'admin', '2024-01-25 21:41:30.552', 'admin', '2024-01-25 21:41:30.552', true, 'cGFzc3dvcmQ=');

