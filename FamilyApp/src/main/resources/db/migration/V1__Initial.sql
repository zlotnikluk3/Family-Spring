CREATE TABLE familyapp.family
(
    id_f integer NOT NULL,
    family_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nr_of_adults integer NOT NULL,
    nr_of_children integer NOT NULL,
    nr_of_infants integer NOT NULL,
    CONSTRAINT family_pkey PRIMARY KEY (id_f)
)

TABLESPACE pg_default;

ALTER TABLE familyapp.family
    OWNER to postgres;