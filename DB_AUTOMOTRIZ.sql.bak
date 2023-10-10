--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4
-- Dumped by pg_dump version 14.4

-- Started on 2022-07-03 15:51:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 16437)
-- Name: inventarioautomotriz; Type: SCHEMA; Schema: -; Owner: root
--

CREATE SCHEMA inventarioautomotriz;


ALTER SCHEMA inventarioautomotriz OWNER TO root;

--
-- TOC entry 3336 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA inventarioautomotriz; Type: COMMENT; Schema: -; Owner: root
--

COMMENT ON SCHEMA inventarioautomotriz IS 'Inventario de mercancia automotriz';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 16439)
-- Name: cargo; Type: TABLE; Schema: inventarioautomotriz; Owner: root
--

CREATE TABLE inventarioautomotriz.cargo (
    idcargo integer NOT NULL,
    nombre character varying(50) NOT NULL
);


ALTER TABLE inventarioautomotriz.cargo OWNER TO root;

--
-- TOC entry 210 (class 1259 OID 16438)
-- Name: cargo_idcargo_seq; Type: SEQUENCE; Schema: inventarioautomotriz; Owner: root
--

CREATE SEQUENCE inventarioautomotriz.cargo_idcargo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventarioautomotriz.cargo_idcargo_seq OWNER TO root;

--
-- TOC entry 3337 (class 0 OID 0)
-- Dependencies: 210
-- Name: cargo_idcargo_seq; Type: SEQUENCE OWNED BY; Schema: inventarioautomotriz; Owner: root
--

ALTER SEQUENCE inventarioautomotriz.cargo_idcargo_seq OWNED BY inventarioautomotriz.cargo.idcargo;


--
-- TOC entry 215 (class 1259 OID 16469)
-- Name: mercancia; Type: TABLE; Schema: inventarioautomotriz; Owner: root
--

CREATE TABLE inventarioautomotriz.mercancia (
    idmercancia integer NOT NULL,
    nombre_producto character varying(50),
    cantidad integer,
    fecha_ingreso date,
    usuarioid integer,
    usuarioidmodificacion integer,
    fecha_modificacion date
);


ALTER TABLE inventarioautomotriz.mercancia OWNER TO root;

--
-- TOC entry 214 (class 1259 OID 16468)
-- Name: mercancia_idmercancia_seq; Type: SEQUENCE; Schema: inventarioautomotriz; Owner: root
--

CREATE SEQUENCE inventarioautomotriz.mercancia_idmercancia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventarioautomotriz.mercancia_idmercancia_seq OWNER TO root;

--
-- TOC entry 3338 (class 0 OID 0)
-- Dependencies: 214
-- Name: mercancia_idmercancia_seq; Type: SEQUENCE OWNED BY; Schema: inventarioautomotriz; Owner: root
--

ALTER SEQUENCE inventarioautomotriz.mercancia_idmercancia_seq OWNED BY inventarioautomotriz.mercancia.idmercancia;


--
-- TOC entry 213 (class 1259 OID 16455)
-- Name: usuario; Type: TABLE; Schema: inventarioautomotriz; Owner: root
--

CREATE TABLE inventarioautomotriz.usuario (
    idusuario integer NOT NULL,
    nombre character varying(50),
    edad character varying,
    fecha_ingreso date,
    cargoid integer
);


ALTER TABLE inventarioautomotriz.usuario OWNER TO root;

--
-- TOC entry 212 (class 1259 OID 16454)
-- Name: usuario_idusuario_seq; Type: SEQUENCE; Schema: inventarioautomotriz; Owner: root
--

CREATE SEQUENCE inventarioautomotriz.usuario_idusuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventarioautomotriz.usuario_idusuario_seq OWNER TO root;

--
-- TOC entry 3339 (class 0 OID 0)
-- Dependencies: 212
-- Name: usuario_idusuario_seq; Type: SEQUENCE OWNED BY; Schema: inventarioautomotriz; Owner: root
--

ALTER SEQUENCE inventarioautomotriz.usuario_idusuario_seq OWNED BY inventarioautomotriz.usuario.idusuario;


--
-- TOC entry 3175 (class 2604 OID 16442)
-- Name: cargo idcargo; Type: DEFAULT; Schema: inventarioautomotriz; Owner: root
--

ALTER TABLE ONLY inventarioautomotriz.cargo ALTER COLUMN idcargo SET DEFAULT nextval('inventarioautomotriz.cargo_idcargo_seq'::regclass);


--
-- TOC entry 3177 (class 2604 OID 16472)
-- Name: mercancia idmercancia; Type: DEFAULT; Schema: inventarioautomotriz; Owner: root
--

ALTER TABLE ONLY inventarioautomotriz.mercancia ALTER COLUMN idmercancia SET DEFAULT nextval('inventarioautomotriz.mercancia_idmercancia_seq'::regclass);


--
-- TOC entry 3176 (class 2604 OID 16458)
-- Name: usuario idusuario; Type: DEFAULT; Schema: inventarioautomotriz; Owner: root
--

ALTER TABLE ONLY inventarioautomotriz.usuario ALTER COLUMN idusuario SET DEFAULT nextval('inventarioautomotriz.usuario_idusuario_seq'::regclass);



--
-- TOC entry 3340 (class 0 OID 0)
-- Dependencies: 210
-- Name: cargo_idcargo_seq; Type: SEQUENCE SET; Schema: inventarioautomotriz; Owner: root
--

SELECT pg_catalog.setval('inventarioautomotriz.cargo_idcargo_seq', 3, true);


--
-- TOC entry 3341 (class 0 OID 0)
-- Dependencies: 214
-- Name: mercancia_idmercancia_seq; Type: SEQUENCE SET; Schema: inventarioautomotriz; Owner: root
--

SELECT pg_catalog.setval('inventarioautomotriz.mercancia_idmercancia_seq', 10, true);


--
-- TOC entry 3342 (class 0 OID 0)
-- Dependencies: 212
-- Name: usuario_idusuario_seq; Type: SEQUENCE SET; Schema: inventarioautomotriz; Owner: root
--

SELECT pg_catalog.setval('inventarioautomotriz.usuario_idusuario_seq', 2, true);


--
-- TOC entry 3179 (class 2606 OID 16444)
-- Name: cargo cargo_pkey; Type: CONSTRAINT; Schema: inventarioautomotriz; Owner: root
--

ALTER TABLE ONLY inventarioautomotriz.cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (idcargo);


--
-- TOC entry 3183 (class 2606 OID 16474)
-- Name: mercancia mercancia_pkey; Type: CONSTRAINT; Schema: inventarioautomotriz; Owner: root
--

ALTER TABLE ONLY inventarioautomotriz.mercancia
    ADD CONSTRAINT mercancia_pkey PRIMARY KEY (idmercancia);


--
-- TOC entry 3181 (class 2606 OID 16462)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: inventarioautomotriz; Owner: root
--

ALTER TABLE ONLY inventarioautomotriz.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (idusuario);


--
-- TOC entry 3185 (class 2606 OID 16475)
-- Name: mercancia mercancia_usuarioid_fkey; Type: FK CONSTRAINT; Schema: inventarioautomotriz; Owner: root
--

ALTER TABLE ONLY inventarioautomotriz.mercancia
    ADD CONSTRAINT mercancia_usuarioid_fkey FOREIGN KEY (usuarioid) REFERENCES inventarioautomotriz.usuario(idusuario);


--
-- TOC entry 3184 (class 2606 OID 16463)
-- Name: usuario usuario_cargoid_fkey; Type: FK CONSTRAINT; Schema: inventarioautomotriz; Owner: root
--

ALTER TABLE ONLY inventarioautomotriz.usuario
    ADD CONSTRAINT usuario_cargoid_fkey FOREIGN KEY (cargoid) REFERENCES inventarioautomotriz.cargo(idcargo);


-- Completed on 2022-07-03 15:51:16

--
-- PostgreSQL database dump complete
--

