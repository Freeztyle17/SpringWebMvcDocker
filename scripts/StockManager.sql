--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

-- Started on 2024-01-14 17:38:57

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = on;

DROP DATABASE IF EXISTS "StockManager";
--
-- TOC entry 4854 (class 1262 OID 16535)
-- Name: StockManager; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "StockManager" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';


ALTER DATABASE "StockManager" OWNER TO postgres;

\connect "StockManager"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = on;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 223 (class 1259 OID 16807)
-- Name: claim; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.claim (
    id integer NOT NULL,
    provider_id integer NOT NULL,
    date_of_claim character varying(50),
    delivery_or_refund character varying(50),
    comment character varying(50),
    status character varying(50)
);


ALTER TABLE public.claim OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16543)
-- Name: invoice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.invoice (
    id bigint NOT NULL,
    date_of_supply character varying(10) DEFAULT NULL::character varying,
    invoice_number integer NOT NULL,
    invoice_summ integer,
    nomenclature_count integer,
    provider_id bigint NOT NULL
);


ALTER TABLE public.invoice OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16547)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id bigint NOT NULL,
    nomenclature character varying(255) DEFAULT NULL::character varying,
    price_purch integer,
    mark_up_percent integer,
    price_retail integer,
    count integer,
    provider_id bigint NOT NULL
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16551)
-- Name: product_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_detail (
    id bigint NOT NULL,
    prod_id bigint NOT NULL,
    invoice_number integer NOT NULL,
    count integer,
    series integer,
    date_of_delive character varying(10) DEFAULT NULL::character varying
);


ALTER TABLE public.product_detail OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16555)
-- Name: providers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.providers (
    id bigint NOT NULL,
    name character varying(255) DEFAULT NULL::character varying,
    invoices_count bigint,
    comment character varying(255) DEFAULT NULL::character varying
);


ALTER TABLE public.providers OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16560)
-- Name: receipt; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.receipt (
    id bigint NOT NULL,
    date_of_operation character varying(10) DEFAULT NULL::character varying,
    nomenclature_count bigint,
    price_result integer
);


ALTER TABLE public.receipt OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16564)
-- Name: receipt_story; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.receipt_story (
    id bigint NOT NULL,
    receipt_id bigint NOT NULL,
    nomenclature_id bigint NOT NULL,
    count integer,
    price_retail integer
);


ALTER TABLE public.receipt_story OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16567)
-- Name: rejected_invoice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rejected_invoice (
    id bigint NOT NULL,
    provider character varying(255) DEFAULT NULL::character varying,
    date_of_supply character varying(10) DEFAULT NULL::character varying,
    invoice_number integer NOT NULL,
    nomenclature_count integer,
    inn integer
);


ALTER TABLE public.rejected_invoice OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16572)
-- Name: rejected_invoice_products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rejected_invoice_products (
    id bigint NOT NULL,
    invoice_number integer NOT NULL,
    nomenclature character varying(255) DEFAULT NULL::character varying,
    price_purch integer,
    mark_up_percent integer,
    series integer,
    count_by_doc integer
);


ALTER TABLE public.rejected_invoice_products OWNER TO postgres;

--
-- TOC entry 4848 (class 0 OID 16807)
-- Dependencies: 223
-- Data for Name: claim; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.claim (id, provider_id, date_of_claim, delivery_or_refund, comment, status) VALUES (1, 2, '2023-06-13', 'Довоз', 'Не хватает 1 бинта серии 2', 'Закрыто') ON CONFLICT DO NOTHING;


--
-- TOC entry 4840 (class 0 OID 16543)
-- Dependencies: 215
-- Data for Name: invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.invoice (id, date_of_supply, invoice_number, invoice_summ, nomenclature_count, provider_id) VALUES (1, '2023-06-11', 1, 1400, 1, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.invoice (id, date_of_supply, invoice_number, invoice_summ, nomenclature_count, provider_id) VALUES (2, '2023-06-12', 2, 700, 1, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.invoice (id, date_of_supply, invoice_number, invoice_summ, nomenclature_count, provider_id) VALUES (3, '2023-06-15', 3, 3100, 3, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.invoice (id, date_of_supply, invoice_number, invoice_summ, nomenclature_count, provider_id) VALUES (4, '2023-06-16', 3, 3100, 3, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.invoice (id, date_of_supply, invoice_number, invoice_summ, nomenclature_count, provider_id) VALUES (5, '2023-06-16', 3, 3100, 3, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.invoice (id, date_of_supply, invoice_number, invoice_summ, nomenclature_count, provider_id) VALUES (6, '2023-06-16', 4, 2600, 2, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.invoice (id, date_of_supply, invoice_number, invoice_summ, nomenclature_count, provider_id) VALUES (7, '2023-06-16', 4, 2600, 2, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.invoice (id, date_of_supply, invoice_number, invoice_summ, nomenclature_count, provider_id) VALUES (8, '2023-06-16', 4, 2600, 2, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.invoice (id, date_of_supply, invoice_number, invoice_summ, nomenclature_count, provider_id) VALUES (9, '2023-06-16', 3, 3100, 3, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.invoice (id, date_of_supply, invoice_number, invoice_summ, nomenclature_count, provider_id) VALUES (10, '2023-06-16', 3, 3100, 3, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.invoice (id, date_of_supply, invoice_number, invoice_summ, nomenclature_count, provider_id) VALUES (11, '2023-06-16', 4, 2600, 2, 2) ON CONFLICT DO NOTHING;


--
-- TOC entry 4841 (class 0 OID 16547)
-- Dependencies: 216
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product (id, nomenclature, price_purch, mark_up_percent, price_retail, count, provider_id) VALUES (1, 'Клей БФ', 600, 18, 708, 3, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.product (id, nomenclature, price_purch, mark_up_percent, price_retail, count, provider_id) VALUES (2, 'Анальгин', 700, 10, 770, 6, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.product (id, nomenclature, price_purch, mark_up_percent, price_retail, count, provider_id) VALUES (3, 'Аспирин', 500, 10, 550, 4, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.product (id, nomenclature, price_purch, mark_up_percent, price_retail, count, provider_id) VALUES (4, 'Мезим', 600, 15, 690, 7, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.product (id, nomenclature, price_purch, mark_up_percent, price_retail, count, provider_id) VALUES (5, 'Эспумизан', 700, 15, 805, 7, 2) ON CONFLICT DO NOTHING;


--
-- TOC entry 4842 (class 0 OID 16551)
-- Dependencies: 217
-- Data for Name: product_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (1, 1, 0, 0, 5, '2023-11-06') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (2, 1, 0, 0, 6, '2023-12-06') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (3, 2, 1, 0, 3, '2023-11-06') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (4, 2, 2, 0, 5, '2023-11-06') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (28, 1, 3, 0, 9, '2023-06-15') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (29, 2, 3, 0, 11, '2023-06-15') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (30, 3, 3, 0, 12, '2023-06-15') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (31, 1, 3, 0, 9, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (32, 2, 3, 0, 11, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (33, 3, 3, 1, 12, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (34, 1, 3, 0, 9, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (35, 2, 3, 2, 11, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (36, 3, 3, 1, 12, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (39, 4, 4, 1, 11, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (40, 5, 4, 1, 10, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (41, 4, 4, 2, 11, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (42, 5, 4, 2, 10, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (43, 1, 3, 1, 9, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (44, 2, 3, 2, 11, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (45, 3, 3, 1, 12, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (46, 1, 3, 2, 9, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (47, 2, 3, 2, 11, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (48, 3, 3, 1, 12, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (49, 4, 4, 2, 11, '2023-06-16') ON CONFLICT DO NOTHING;
INSERT INTO public.product_detail (id, prod_id, invoice_number, count, series, date_of_delive) VALUES (50, 5, 4, 2, 10, '2023-06-16') ON CONFLICT DO NOTHING;


--
-- TOC entry 4843 (class 0 OID 16555)
-- Dependencies: 218
-- Data for Name: providers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.providers (id, name, invoices_count, comment) VALUES (1, 'OOO «Volga»', 5, 'ХАРОШИЙ ПАСТОВЩИК') ON CONFLICT DO NOTHING;
INSERT INTO public.providers (id, name, invoices_count, comment) VALUES (2, 'OOO «Farma»', 6, 'ПЛАХОЙ ПАСТАВЩИК УУУУУУУу') ON CONFLICT DO NOTHING;


--
-- TOC entry 4844 (class 0 OID 16560)
-- Dependencies: 219
-- Data for Name: receipt; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.receipt (id, date_of_operation, nomenclature_count, price_result) VALUES (1, '2023-06-13', 2, 1478) ON CONFLICT DO NOTHING;
INSERT INTO public.receipt (id, date_of_operation, nomenclature_count, price_result) VALUES (2, '2023-06-13', 1, 1540) ON CONFLICT DO NOTHING;
INSERT INTO public.receipt (id, date_of_operation, nomenclature_count, price_result) VALUES (5, '2023-06-16', 1, 708) ON CONFLICT DO NOTHING;
INSERT INTO public.receipt (id, date_of_operation, nomenclature_count, price_result) VALUES (6, '2023-06-16', 2, 1575) ON CONFLICT DO NOTHING;


--
-- TOC entry 4845 (class 0 OID 16564)
-- Dependencies: 220
-- Data for Name: receipt_story; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.receipt_story (id, receipt_id, nomenclature_id, count, price_retail) VALUES (1, 1, 1, 1, 708) ON CONFLICT DO NOTHING;
INSERT INTO public.receipt_story (id, receipt_id, nomenclature_id, count, price_retail) VALUES (2, 1, 2, 1, 770) ON CONFLICT DO NOTHING;
INSERT INTO public.receipt_story (id, receipt_id, nomenclature_id, count, price_retail) VALUES (3, 2, 2, 2, 770) ON CONFLICT DO NOTHING;
INSERT INTO public.receipt_story (id, receipt_id, nomenclature_id, count, price_retail) VALUES (6, 7, 1, 2, 708) ON CONFLICT DO NOTHING;
INSERT INTO public.receipt_story (id, receipt_id, nomenclature_id, count, price_retail) VALUES (7, 6, 2, 2, 770) ON CONFLICT DO NOTHING;


--
-- TOC entry 4846 (class 0 OID 16567)
-- Dependencies: 221
-- Data for Name: rejected_invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.rejected_invoice (id, provider, date_of_supply, invoice_number, nomenclature_count, inn) VALUES (3, 'OOO «Volga»', '2023-06-15', 5, 2, 91133224) ON CONFLICT DO NOTHING;
INSERT INTO public.rejected_invoice (id, provider, date_of_supply, invoice_number, nomenclature_count, inn) VALUES (4, 'OOO «Farma»', '2023-06-16', 6, 1, 92211235) ON CONFLICT DO NOTHING;


--
-- TOC entry 4847 (class 0 OID 16572)
-- Dependencies: 222
-- Data for Name: rejected_invoice_products; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.rejected_invoice_products (id, invoice_number, nomenclature, price_purch, mark_up_percent, series, count_by_doc) VALUES (8, 5, 'Клафилин', 200, 20, 3, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.rejected_invoice_products (id, invoice_number, nomenclature, price_purch, mark_up_percent, series, count_by_doc) VALUES (9, 5, 'Клей БФ', 600, 18, 12, 3) ON CONFLICT DO NOTHING;
INSERT INTO public.rejected_invoice_products (id, invoice_number, nomenclature, price_purch, mark_up_percent, series, count_by_doc) VALUES (10, 6, 'Анальгин', 700, 10, 15, 3) ON CONFLICT DO NOTHING;


--
-- TOC entry 4691 (class 2606 OID 16811)
-- Name: claim claim_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.claim
    ADD CONSTRAINT claim_pkey PRIMARY KEY (id);


--
-- TOC entry 4675 (class 2606 OID 16815)
-- Name: invoice invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT invoice_pkey PRIMARY KEY (id);


--
-- TOC entry 4679 (class 2606 OID 16819)
-- Name: product_detail product_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_detail
    ADD CONSTRAINT product_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 4677 (class 2606 OID 16817)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 4681 (class 2606 OID 16821)
-- Name: providers providers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.providers
    ADD CONSTRAINT providers_pkey PRIMARY KEY (id);


--
-- TOC entry 4683 (class 2606 OID 16823)
-- Name: receipt receipt_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receipt
    ADD CONSTRAINT receipt_pkey PRIMARY KEY (id);


--
-- TOC entry 4685 (class 2606 OID 16825)
-- Name: receipt_story receipt_story_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receipt_story
    ADD CONSTRAINT receipt_story_pkey PRIMARY KEY (id);


--
-- TOC entry 4687 (class 2606 OID 16827)
-- Name: rejected_invoice rejected_invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rejected_invoice
    ADD CONSTRAINT rejected_invoice_pkey PRIMARY KEY (id);


--
-- TOC entry 4689 (class 2606 OID 16829)
-- Name: rejected_invoice_products rejected_invoice_products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rejected_invoice_products
    ADD CONSTRAINT rejected_invoice_products_pkey PRIMARY KEY (id);


--
-- TOC entry 4696 (class 2606 OID 16830)
-- Name: claim claim_provider_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.claim
    ADD CONSTRAINT claim_provider_id_fkey FOREIGN KEY (provider_id) REFERENCES public.providers(id) NOT VALID;


--
-- TOC entry 4692 (class 2606 OID 16835)
-- Name: invoice invoice_provider_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT invoice_provider_id_fkey FOREIGN KEY (provider_id) REFERENCES public.providers(id) NOT VALID;


--
-- TOC entry 4694 (class 2606 OID 16845)
-- Name: product_detail product_detail_prod_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_detail
    ADD CONSTRAINT product_detail_prod_id_fkey FOREIGN KEY (prod_id) REFERENCES public.product(id) NOT VALID;


--
-- TOC entry 4693 (class 2606 OID 16840)
-- Name: product product_provider_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_provider_id_fkey FOREIGN KEY (provider_id) REFERENCES public.providers(id) NOT VALID;


--
-- TOC entry 4695 (class 2606 OID 16850)
-- Name: receipt_story receipt_story_receipt_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receipt_story
    ADD CONSTRAINT receipt_story_receipt_id_fkey FOREIGN KEY (receipt_id) REFERENCES public.receipt(id) NOT VALID;


-- Completed on 2024-01-14 17:38:57

--
-- PostgreSQL database dump complete
--

