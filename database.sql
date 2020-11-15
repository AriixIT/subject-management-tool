--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-11-15 18:46:15

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
-- TOC entry 210 (class 1255 OID 36881)
-- Name: update_subject_average(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.update_subject_average() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
	UPDATE subject s SET average = (SELECT ((SUM(e.mark))/(COUNT(e.mark))) FROM exam e JOIN subject s ON e.subject = s.id) WHERE s.id = NEW.subject;

	RETURN NEW;
END;
$$;


ALTER FUNCTION public.update_subject_average() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 36782)
-- Name: authorities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authorities (
    id character varying(255) NOT NULL,
    name character varying(255)
);


ALTER TABLE public.authorities OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 36790)
-- Name: exam; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exam (
    id character varying(255) NOT NULL,
    mark real,
    name character varying(255),
    subject character varying(255) NOT NULL,
    date character varying
);


ALTER TABLE public.exam OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 36798)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id character varying(255) NOT NULL,
    name character varying(255)
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 36806)
-- Name: role_authorities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_authorities (
    roles_id character varying(255) NOT NULL,
    authorities_id character varying(255) NOT NULL
);


ALTER TABLE public.role_authorities OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 36814)
-- Name: semester; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.semester (
    id character varying(255) NOT NULL,
    name character varying(255),
    user_id character varying(255) NOT NULL
);


ALTER TABLE public.semester OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 36822)
-- Name: subject; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.subject (
    id character varying(255) NOT NULL,
    name character varying(255),
    semester character varying(255) NOT NULL,
    average real
);


ALTER TABLE public.subject OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 36830)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id character varying(255) NOT NULL,
    email character varying(255),
    firstname character varying(255),
    lastname character varying(255),
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 36838)
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_roles (
    users_id character varying(255) NOT NULL,
    roles_id character varying(255) NOT NULL
);


ALTER TABLE public.users_roles OWNER TO postgres;

--
-- TOC entry 2872 (class 0 OID 36782)
-- Dependencies: 202
-- Data for Name: authorities; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.authorities (id, name) FROM stdin;
\.


--
-- TOC entry 2873 (class 0 OID 36790)
-- Dependencies: 203
-- Data for Name: exam; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exam (id, mark, name, subject, date) FROM stdin;
402881ef75c6f8bb0175c747ed4c0008	5	exam1	402881ef75c6f8bb0175c747d2c90007	
402881ef75c6f8bb0175c7480c840009	3	exam2	402881ef75c6f8bb0175c747d2c90007	
\.


--
-- TOC entry 2874 (class 0 OID 36798)
-- Dependencies: 204
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (id, name) FROM stdin;
\.


--
-- TOC entry 2875 (class 0 OID 36806)
-- Dependencies: 205
-- Data for Name: role_authorities; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role_authorities (roles_id, authorities_id) FROM stdin;
\.


--
-- TOC entry 2876 (class 0 OID 36814)
-- Dependencies: 206
-- Data for Name: semester; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.semester (id, name, user_id) FROM stdin;
402881ef75c6f8bb0175c6fa2e300000	test	402881ef758d480e01758d535bd20000
\.


--
-- TOC entry 2877 (class 0 OID 36822)
-- Dependencies: 207
-- Data for Name: subject; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.subject (id, name, semester, average) FROM stdin;
402881ef75c6f8bb0175c747d2c90007	franz	402881ef75c6f8bb0175c6fa2e300000	4
\.


--
-- TOC entry 2878 (class 0 OID 36830)
-- Dependencies: 208
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, email, firstname, lastname, password, username) FROM stdin;
402881ef758d480e01758d535bd20000	test	test	test	test	test
\.


--
-- TOC entry 2879 (class 0 OID 36838)
-- Dependencies: 209
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users_roles (users_id, roles_id) FROM stdin;
\.


--
-- TOC entry 2723 (class 2606 OID 36789)
-- Name: authorities authorities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (id);


--
-- TOC entry 2725 (class 2606 OID 36797)
-- Name: exam exam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam
    ADD CONSTRAINT exam_pkey PRIMARY KEY (id);


--
-- TOC entry 2729 (class 2606 OID 36813)
-- Name: role_authorities role_authorities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_authorities
    ADD CONSTRAINT role_authorities_pkey PRIMARY KEY (roles_id, authorities_id);


--
-- TOC entry 2727 (class 2606 OID 36805)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 2731 (class 2606 OID 36821)
-- Name: semester semester_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.semester
    ADD CONSTRAINT semester_pkey PRIMARY KEY (id);


--
-- TOC entry 2733 (class 2606 OID 36829)
-- Name: subject subject_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subject
    ADD CONSTRAINT subject_pkey PRIMARY KEY (id);


--
-- TOC entry 2735 (class 2606 OID 36837)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2737 (class 2606 OID 36845)
-- Name: users_roles users_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT users_roles_pkey PRIMARY KEY (users_id, roles_id);


--
-- TOC entry 2745 (class 2620 OID 36889)
-- Name: exam update_average; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER update_average AFTER INSERT OR DELETE OR UPDATE ON public.exam FOR EACH ROW EXECUTE FUNCTION public.update_subject_average();


--
-- TOC entry 2743 (class 2606 OID 36871)
-- Name: users_roles fk15d410tj6juko0sq9k4km60xq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fk15d410tj6juko0sq9k4km60xq FOREIGN KEY (roles_id) REFERENCES public.role(id);


--
-- TOC entry 2742 (class 2606 OID 36866)
-- Name: subject fk2570ppm8x2je25how3q1q3dx8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subject
    ADD CONSTRAINT fk2570ppm8x2je25how3q1q3dx8 FOREIGN KEY (semester) REFERENCES public.semester(id);


--
-- TOC entry 2738 (class 2606 OID 36846)
-- Name: exam fk3csjssdryi00tqvoi4qc86jv0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam
    ADD CONSTRAINT fk3csjssdryi00tqvoi4qc86jv0 FOREIGN KEY (subject) REFERENCES public.subject(id);


--
-- TOC entry 2739 (class 2606 OID 36851)
-- Name: role_authorities fk6638rxtfvgs26pi4ypm2b75ab; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_authorities
    ADD CONSTRAINT fk6638rxtfvgs26pi4ypm2b75ab FOREIGN KEY (authorities_id) REFERENCES public.authorities(id);


--
-- TOC entry 2741 (class 2606 OID 36861)
-- Name: semester fkeifft103mrwn9ta13095yrrj4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.semester
    ADD CONSTRAINT fkeifft103mrwn9ta13095yrrj4 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 2740 (class 2606 OID 36856)
-- Name: role_authorities fkfpp0q10grms0m757ogf1wuug1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_authorities
    ADD CONSTRAINT fkfpp0q10grms0m757ogf1wuug1 FOREIGN KEY (roles_id) REFERENCES public.role(id);


--
-- TOC entry 2744 (class 2606 OID 36876)
-- Name: users_roles fkml90kef4w2jy7oxyqv742tsfc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fkml90kef4w2jy7oxyqv742tsfc FOREIGN KEY (users_id) REFERENCES public.users(id);


-- Completed on 2020-11-15 18:46:16

--
-- PostgreSQL database dump complete
--

