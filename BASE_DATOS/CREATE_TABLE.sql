-- Table: public.clientes

-- DROP TABLE public.clientes;

CREATE TABLE IF NOT EXISTS public.clientes
(
    identificacion character varying(20) COLLATE pg_catalog."default" NOT NULL,
    razonsocial character varying(150) COLLATE pg_catalog."default",
    contacto character varying(30) COLLATE pg_catalog."default",
    region character varying(60) COLLATE pg_catalog."default",
    tipocliente character varying(60) COLLATE pg_catalog."default",
    CONSTRAINT clientes_pkey PRIMARY KEY (identificacion)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.clientes
    OWNER to postgres;