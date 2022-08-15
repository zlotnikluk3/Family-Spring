CREATE SEQUENCE familymemberapp.familymember_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE familymemberapp.familymember_id_seq
    OWNER TO postgres;

CREATE TABLE familymemberapp.family_member
(
    fm_id integer NOT NULL DEFAULT nextval('familymemberapp.familymember_id_seq'::regclass),
    age integer NOT NULL,
    family_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    family_id integer NOT NULL,
    given_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT familymember_pkey PRIMARY KEY (fm_id)
)

TABLESPACE pg_default;

ALTER TABLE familymemberapp.family_member
    OWNER to postgres;
