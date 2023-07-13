-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler version: 1.0.4
-- PostgreSQL version: 15.0
-- Project Site: pgmodeler.io
-- Model Author: Mikhail Batukhtin

-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
-- Database creation must be performed outside a multi lined SQL file.
-- These commands were put in this file only as a convenience.
-- object: right_code | type: DATABASE --
-- DROP DATABASE IF EXISTS right_code;
CREATE DATABASE right_code
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.UTF-8'
    LC_CTYPE = 'en_US.UTF-8'
    TABLESPACE = pg_default
    OWNER = postgres;
-- ddl-end --


-- object: dev | type: SCHEMA --
-- DROP SCHEMA IF EXISTS dev CASCADE;
CREATE SCHEMA dev;
-- ddl-end --
ALTER SCHEMA dev OWNER TO postgres;
-- ddl-end --

SET search_path TO pg_catalog,public,dev;
-- ddl-end --

-- object: dev.article | type: TABLE --
-- DROP TABLE IF EXISTS dev.article CASCADE;
CREATE TABLE dev.article
(
    id                     serial       NOT NULL,
    header                 varchar(255) NOT NULL,
    content                text         NOT NULL,
    publication_date       date,
    publication_end_date   date,
    creation_date          date         NOT NULL,
    is_main_article        boolean      NOT NULL DEFAULT FALSE,
    is_publicly_accessible boolean      NOT NULL DEFAULT TRUE,
    category_id            integer      NOT NULL,
    status_id              integer      NOT NULL,
    editor_id              integer,
    delete_id              integer,
    CONSTRAINT article_pk PRIMARY KEY (id),
    CONSTRAINT publication_end_date_check CHECK (publication_end_date > publication_date)
);
-- ddl-end --
ALTER TABLE dev.article
    OWNER TO postgres;
-- ddl-end --

-- object: dev.category | type: TABLE --
-- DROP TABLE IF EXISTS dev.category CASCADE;
CREATE TABLE dev.category
(
    id   serial       NOT NULL,
    type varchar(255) NOT NULL,
    CONSTRAINT category_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE dev.category
    OWNER TO postgres;
-- ddl-end --

-- object: category_fk | type: CONSTRAINT --
-- ALTER TABLE dev.article DROP CONSTRAINT IF EXISTS category_fk CASCADE;
ALTER TABLE dev.article
    ADD CONSTRAINT category_fk FOREIGN KEY (category_id)
        REFERENCES dev.category (id) MATCH FULL
        ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: dev.status | type: TABLE --
-- DROP TABLE IF EXISTS dev.status CASCADE;
CREATE TABLE dev.status
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT status_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE dev.status
    OWNER TO postgres;
-- ddl-end --

-- object: status_fk | type: CONSTRAINT --
-- ALTER TABLE dev.article DROP CONSTRAINT IF EXISTS status_fk CASCADE;
ALTER TABLE dev.article
    ADD CONSTRAINT status_fk FOREIGN KEY (status_id)
        REFERENCES dev.status (id) MATCH FULL
        ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: dev.external_resource | type: TABLE --
-- DROP TABLE IF EXISTS dev.external_resource CASCADE;
CREATE TABLE dev.external_resource
(
    id               serial        NOT NULL,
    link             varchar(2083) NOT NULL,
    readable_link    varchar(255),
    description      text,
    resource_type_id integer       NOT NULL,
    CONSTRAINT external_resource_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE dev.external_resource
    OWNER TO postgres;
-- ddl-end --

-- object: dev.resource_type | type: TABLE --
-- DROP TABLE IF EXISTS dev.resource_type CASCADE;
CREATE TABLE dev.resource_type
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT resource_type_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE dev.resource_type
    OWNER TO postgres;
-- ddl-end --

-- object: resource_type_fk | type: CONSTRAINT --
-- ALTER TABLE dev.external_resource DROP CONSTRAINT IF EXISTS resource_type_fk CASCADE;
ALTER TABLE dev.external_resource
    ADD CONSTRAINT resource_type_fk FOREIGN KEY (resource_type_id)
        REFERENCES dev.resource_type (id) MATCH FULL
        ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: dev.tag | type: TABLE --
-- DROP TABLE IF EXISTS dev.tag CASCADE;
CREATE TABLE dev.tag
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT tag_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE dev.tag
    OWNER TO postgres;
-- ddl-end --

-- object: dev.author | type: TABLE --
-- DROP TABLE IF EXISTS dev.author CASCADE;
CREATE TABLE dev.author
(
    id             serial       NOT NULL,
    first_name     varchar(255) NOT NULL,
    middle_name    varchar(255),
    last_name      varchar(255) NOT NULL,
    info           text,
    author_type_id integer,
    CONSTRAINT author_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE dev.author
    OWNER TO postgres;
-- ddl-end --

-- object: dev.author_type | type: TABLE --
-- DROP TABLE IF EXISTS dev.author_type CASCADE;
CREATE TABLE dev.author_type
(
    id   serial       NOT NULL,
    type varchar(255) NOT NULL,
    CONSTRAINT author_type_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE dev.author_type
    OWNER TO postgres;
-- ddl-end --

-- object: dev.author_article | type: TABLE --
-- DROP TABLE IF EXISTS dev.author_article CASCADE;
CREATE TABLE dev.author_article
(
    author_id  integer NOT NULL,
    article_id integer NOT NULL,
    CONSTRAINT author_article_pk PRIMARY KEY (author_id, article_id)
);
-- ddl-end --
ALTER TABLE dev.author_article
    OWNER TO postgres;
-- ddl-end --

-- object: author_fk | type: CONSTRAINT --
-- ALTER TABLE dev.author_article DROP CONSTRAINT IF EXISTS author_fk CASCADE;
ALTER TABLE dev.author_article
    ADD CONSTRAINT author_fk FOREIGN KEY (author_id)
        REFERENCES dev.author (id) MATCH FULL
        ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: article_fk | type: CONSTRAINT --
-- ALTER TABLE dev.author_article DROP CONSTRAINT IF EXISTS article_fk CASCADE;
ALTER TABLE dev.author_article
    ADD CONSTRAINT article_fk FOREIGN KEY (article_id)
        REFERENCES dev.article (id) MATCH FULL
        ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: dev.external_resource_article | type: TABLE --
-- DROP TABLE IF EXISTS dev.external_resource_article CASCADE;
CREATE TABLE dev.external_resource_article
(
    external_resource_id integer NOT NULL,
    article_id           integer NOT NULL,
    CONSTRAINT external_resource_article_pk PRIMARY KEY (external_resource_id, article_id)
);
-- ddl-end --
ALTER TABLE dev.external_resource_article
    OWNER TO postgres;
-- ddl-end --

-- object: external_resource_fk | type: CONSTRAINT --
-- ALTER TABLE dev.external_resource_article DROP CONSTRAINT IF EXISTS external_resource_fk CASCADE;
ALTER TABLE dev.external_resource_article
    ADD CONSTRAINT external_resource_fk FOREIGN KEY (external_resource_id)
        REFERENCES dev.external_resource (id) MATCH FULL
        ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: article_fk | type: CONSTRAINT --
-- ALTER TABLE dev.external_resource_article DROP CONSTRAINT IF EXISTS article_fk CASCADE;
ALTER TABLE dev.external_resource_article
    ADD CONSTRAINT article_fk FOREIGN KEY (article_id)
        REFERENCES dev.article (id) MATCH FULL
        ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: dev.tag_article | type: TABLE --
-- DROP TABLE IF EXISTS dev.tag_article CASCADE;
CREATE TABLE dev.tag_article
(
    tag_id     integer NOT NULL,
    article_id integer NOT NULL,
    CONSTRAINT tag_article_pk PRIMARY KEY (tag_id, article_id)
);
-- ddl-end --
ALTER TABLE dev.tag_article
    OWNER TO postgres;
-- ddl-end --

-- object: tag_fk | type: CONSTRAINT --
-- ALTER TABLE dev.tag_article DROP CONSTRAINT IF EXISTS tag_fk CASCADE;
ALTER TABLE dev.tag_article
    ADD CONSTRAINT tag_fk FOREIGN KEY (tag_id)
        REFERENCES dev.tag (id) MATCH FULL
        ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: article_fk | type: CONSTRAINT --
-- ALTER TABLE dev.tag_article DROP CONSTRAINT IF EXISTS article_fk CASCADE;
ALTER TABLE dev.tag_article
    ADD CONSTRAINT article_fk FOREIGN KEY (article_id)
        REFERENCES dev.article (id) MATCH FULL
        ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: editor_fk | type: CONSTRAINT --
-- ALTER TABLE dev.article DROP CONSTRAINT IF EXISTS editor_fk CASCADE;
ALTER TABLE dev.article
    ADD CONSTRAINT editor_fk FOREIGN KEY (editor_id)
        REFERENCES dev.author (id) MATCH FULL
        ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: delete_fk | type: CONSTRAINT --
-- ALTER TABLE dev.article DROP CONSTRAINT IF EXISTS delete_fk CASCADE;
ALTER TABLE dev.article
    ADD CONSTRAINT delete_fk FOREIGN KEY (delete_id)
        REFERENCES dev.author (id) MATCH FULL
        ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: author_type_fk | type: CONSTRAINT --
-- ALTER TABLE dev.author DROP CONSTRAINT IF EXISTS author_type_fk CASCADE;
ALTER TABLE dev.author
    ADD CONSTRAINT author_type_fk FOREIGN KEY (author_type_id)
        REFERENCES dev.author_type (id) MATCH FULL
        ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: "grant_CU_eb94f049ac" | type: PERMISSION --
GRANT CREATE, USAGE
    ON SCHEMA public
    TO postgres;
-- ddl-end --

-- object: "grant_CU_cd8e46e7b6" | type: PERMISSION --
GRANT CREATE, USAGE
    ON SCHEMA public
    TO PUBLIC;
-- ddl-end --


