--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    customer_id character varying(255) NOT NULL,
    created_by character varying(255),
    created_date timestamp(6) with time zone NOT NULL,
    last_modified_by character varying(255),
    last_modified_date timestamp(6) with time zone NOT NULL,
    address character varying(255),
    customer_name character varying(255),
    phone character varying(255)
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- Name: order_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_detail (
    order_detail_id character varying(255) NOT NULL,
    created_by character varying(255),
    created_date timestamp(6) with time zone NOT NULL,
    last_modified_by character varying(255),
    last_modified_date timestamp(6) with time zone NOT NULL,
    evaluate integer,
    order_id character varying(255),
    service_id character varying(255)
);


ALTER TABLE public.order_detail OWNER TO postgres;

--
-- Name: order_service; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_service (
    order_id character varying(255) NOT NULL,
    created_by character varying(255),
    created_date timestamp(6) with time zone NOT NULL,
    last_modified_by character varying(255),
    last_modified_date timestamp(6) with time zone NOT NULL,
    order_name character varying(255),
    customer_id character varying(255)
);


ALTER TABLE public.order_service OWNER TO postgres;

--
-- Name: service; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.service (
    service_id character varying(255) NOT NULL,
    created_by character varying(255),
    created_date timestamp(6) with time zone NOT NULL,
    last_modified_by character varying(255),
    last_modified_date timestamp(6) with time zone NOT NULL,
    description character varying(255),
    service_name character varying(255),
    supplier_id character varying(255)
);


ALTER TABLE public.service OWNER TO postgres;

--
-- Name: supplier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supplier (
    supplier_id character varying(255) NOT NULL,
    created_by character varying(255),
    created_date timestamp(6) with time zone NOT NULL,
    last_modified_by character varying(255),
    last_modified_date timestamp(6) with time zone NOT NULL,
    address character varying(255),
    phone character varying(255),
    posx double precision,
    posy double precision,
    supplier_name character varying(255),
    supplier_parent_id character varying(255)
);


ALTER TABLE public.supplier OWNER TO postgres;

--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (customer_id, created_by, created_date, last_modified_by, last_modified_date, address, customer_name, phone) FROM stdin;
bc3364cc-376b-4445-9168-f408aed98338	\N	2023-12-14 11:08:36.293185+07	\N	2023-12-14 11:08:36.293185+07	Hà Đông, Hà Nội	Khách hàng 1	0123456789
3e138e67-5877-48ed-9d6b-4e6236a1e679	\N	2023-12-14 11:09:29.732114+07	\N	2023-12-14 11:09:29.732114+07	Thành phố Phủ Lý, tỉnh Hà Nam	Khách hàng 2	0123456789
bee79995-e5d2-4bb0-b0f0-58c7cc8ad25a	\N	2023-12-14 11:09:58.605486+07	\N	2023-12-14 11:09:58.605486+07	Thành phố Nam Định, tỉnh Nam Định	Khách hàng 3	0123456789
\.


--
-- Data for Name: order_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_detail (order_detail_id, created_by, created_date, last_modified_by, last_modified_date, evaluate, order_id, service_id) FROM stdin;
568d9571-b213-49ef-a76b-89034a9b31f8	\N	2023-12-14 15:04:13.013858+07	\N	2023-12-14 15:04:13.013858+07	1	2146c947-afa9-4754-845d-790c7ca984fd	3edb75c0-41ac-493c-ac9b-2fa83e290316
167b476d-a469-4692-809f-f2fe7aa77d93	\N	2023-12-14 15:18:15.88119+07	\N	2023-12-14 15:18:15.88119+07	0	bc8cde9b-9f78-44f8-a212-4b77406b530c	3edb75c0-41ac-493c-ac9b-2fa83e290316
\.


--
-- Data for Name: order_service; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_service (order_id, created_by, created_date, last_modified_by, last_modified_date, order_name, customer_id) FROM stdin;
2146c947-afa9-4754-845d-790c7ca984fd	\N	2023-12-14 15:04:11.328459+07	\N	2023-12-14 15:04:11.328459+07	Hoá đơn đặt dịch vụ bảo hiểm	bee79995-e5d2-4bb0-b0f0-58c7cc8ad25a
bc8cde9b-9f78-44f8-a212-4b77406b530c	\N	2023-12-14 15:18:15.694705+07	\N	2023-12-14 15:18:15.694705+07	Hoá đơn đặt dịch vụ bảo hiểm 2	bee79995-e5d2-4bb0-b0f0-58c7cc8ad25a
\.


--
-- Data for Name: service; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.service (service_id, created_by, created_date, last_modified_by, last_modified_date, description, service_name, supplier_id) FROM stdin;
b38e6d3c-31a3-4ad2-b55a-d0bd9994050d	\N	2023-12-13 15:02:52.561314+07	\N	2023-12-13 15:02:52.561314+07	Lãi thấp 0.02%	Dịch vụ cho vay tín dụng	ec771b13-f8df-478b-8346-c4adff8a3142
bc24a3e5-b243-4748-86cd-0aeefdca5c3f	\N	2023-12-13 15:04:35.250972+07	\N	2023-12-13 15:04:35.250972+07	Bảo hiểm lên tới 50%	Dịch vụ bảo hiểm ngân hàng	c7d2bf5a-09fe-4ef4-883d-ab43b423f8b5
52f9bb61-22f9-4a53-af71-b1e6bafde92a	\N	2023-12-13 15:39:47.577593+07	\N	2023-12-13 15:39:47.577593+07	Bảo hiểm lên tới 50%	Dịch vụ bảo hiểm ngân hàng	1830047a-0470-4b0a-b0dd-3d811fba94e8
3edb75c0-41ac-493c-ac9b-2fa83e290316	\N	2023-12-14 10:34:16.495449+07	\N	2023-12-14 10:34:16.495449+07	Giải ngân nhanh chóng, lãi suất thấp	Dịch vụ thế chấp tài sản cá nhân	ec771b13-f8df-478b-8346-c4adff8a3142
\.


--
-- Data for Name: supplier; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supplier (supplier_id, created_by, created_date, last_modified_by, last_modified_date, address, phone, posx, posy, supplier_name, supplier_parent_id) FROM stdin;
c7d2bf5a-09fe-4ef4-883d-ab43b423f8b5	\N	2023-12-13 14:58:46.716045+07	\N	2023-12-13 14:58:46.716045+07	Hà Đông, Hà Nội	0123456789	56.25	10.25	Ngân hàng MB	\N
ec771b13-f8df-478b-8346-c4adff8a3142	\N	2023-12-13 15:00:16.669742+07	\N	2023-12-13 15:00:16.669742+07	56 Trần Hưng Đạo, thành phố Nam Định, tỉnh Nam Định	0123456789	102.25	40.25	Ngân hàng MB - Chi nhánh Nam Định	c7d2bf5a-09fe-4ef4-883d-ab43b423f8b5
1830047a-0470-4b0a-b0dd-3d811fba94e8	\N	2023-12-13 15:39:18.888949+07	\N	2023-12-13 15:39:18.888949+07	12 thành phố Phủ Lý, tỉnh Hà Nam	0123456789	96.78	42.25	Ngân hàng MB - Chi nhánh Hà Nam	c7d2bf5a-09fe-4ef4-883d-ab43b423f8b5
\.


--
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);


--
-- Name: order_detail order_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT order_detail_pkey PRIMARY KEY (order_detail_id);


--
-- Name: order_service order_service_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_service
    ADD CONSTRAINT order_service_pkey PRIMARY KEY (order_id);


--
-- Name: service service_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service
    ADD CONSTRAINT service_pkey PRIMARY KEY (service_id);


--
-- Name: supplier supplier_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supplier
    ADD CONSTRAINT supplier_pkey PRIMARY KEY (supplier_id);


--
-- Name: order_detail fk6da5tsd1yoa8yn3o32n40uiqj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fk6da5tsd1yoa8yn3o32n40uiqj FOREIGN KEY (service_id) REFERENCES public.service(service_id);


--
-- Name: service fk7e25rr8xu6adyi4gh3ieifp5c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service
    ADD CONSTRAINT fk7e25rr8xu6adyi4gh3ieifp5c FOREIGN KEY (supplier_id) REFERENCES public.supplier(supplier_id);


--
-- Name: order_detail fke9v4msbhcduqoafdakp1kg41o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_detail
    ADD CONSTRAINT fke9v4msbhcduqoafdakp1kg41o FOREIGN KEY (order_id) REFERENCES public.order_service(order_id);


--
-- Name: order_service fkol2vu7e6s7d0njimc7gos97rq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_service
    ADD CONSTRAINT fkol2vu7e6s7d0njimc7gos97rq FOREIGN KEY (customer_id) REFERENCES public.customer(customer_id);


--
-- PostgreSQL database dump complete
--

