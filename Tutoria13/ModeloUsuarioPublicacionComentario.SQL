/*
Created: 13/5/2024
Modified: 13/5/2024
Model: Oracle 18c
Database: Oracle 18c
*/


-- Create sequences section -------------------------------------------------

CREATE SEQUENCE USUARIOS_SEQ01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 MINVALUE 0
 NOCACHE
;

CREATE SEQUENCE PUBLICACION_SEQ01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 MINVALUE 0
 NOCACHE
;

CREATE SEQUENCE COMENTARIO_SEQ01
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 MINVALUE 0
 NOCACHE
;

-- Create tables section -------------------------------------------------

-- Table USUARIOS

CREATE TABLE USUARIOS(
  usu_id Number NOT NULL,
  usu_nombre Varchar2(30 ) NOT NULL,
  usu_primerApellido Varchar2(30 ) NOT NULL,
  usu_segundoApellido Varchar2(30 ),
  usu_genero Varchar2(1 ) NOT NULL,
  usu_correo Varchar2(60 ) NOT NULL,
  CONSTRAINT USUARIOS_CK01 CHECK (usu_genero in ('F','M'))
)
;

-- Create indexes for table USUARIOS

CREATE INDEX usuarios_unq01 ON USUARIOS (usu_id)
;

-- Add keys for table USUARIOS

ALTER TABLE USUARIOS ADD CONSTRAINT USUARIOS_PK PRIMARY KEY (usu_id)
;

-- Table PUBLICACION

CREATE TABLE PUBLICACION(
  pub_id Number NOT NULL,
  pub_titulo Varchar2(30 ) NOT NULL,
  pub_contenido Varchar2(30 ) NOT NULL,
  pub_fecha_publicacion Date NOT NULL,
  usu_id Number
)
;

-- Create indexes for table PUBLICACION

CREATE INDEX publicacion_unq01 ON PUBLICACION (pub_id)
;

CREATE INDEX USU_PUBLICACION_FK01 ON PUBLICACION (usu_id)
;

-- Add keys for table PUBLICACION

ALTER TABLE PUBLICACION ADD CONSTRAINT PK_PUBLICACION PRIMARY KEY (pub_id)
;

-- Table COMENTARIO

CREATE TABLE COMENTARIO(
  com_id Number NOT NULL,
  com_contenido Varchar2(30 ) NOT NULL,
  com_fecha_comentario Date NOT NULL,
  usu_id Number,
  pub_id Number
)
;

-- Create indexes for table COMENTARIO

CREATE INDEX comentario_unq01 ON COMENTARIO (com_id)
;

CREATE INDEX USU_COMENTARIO_FK01 ON COMENTARIO (usu_id)
;

CREATE INDEX PUB_COMENTARIO_FK01 ON COMENTARIO (pub_id)
;

-- Add keys for table COMENTARIO

ALTER TABLE COMENTARIO ADD CONSTRAINT PK_COMENTARIO PRIMARY KEY (com_id)
;

-- Trigger for sequence USUARIOS_SEQ01 for column usu_id in table USUARIOS ---------
CREATE OR REPLACE TRIGGER USUARIOS_TGR01 BEFORE INSERT
ON USUARIOS FOR EACH ROW
BEGIN
	if :new.usu_id is null or :new.usu_id <=0 then
		:new.usu_id := USUARIOS_SEQ01.nextval;
	end if;
END;
/
CREATE OR REPLACE TRIGGER USUARIOS_TGR02 AFTER UPDATE OF usu_id
ON USUARIOS FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column usu_id in table USUARIOS as it uses sequence.');
END;
/

-- Trigger for sequence PUBLICACION_SEQ01 for column pub_id in table PUBLICACION ---------
CREATE OR REPLACE TRIGGER PUBLICACION_TGR01 BEFORE INSERT
ON PUBLICACION FOR EACH ROW
BEGIN
	if :new.pub_id is null or :new.pub_id <=0 then
		:new.pub_id := PUBLICACION_SEQ01.nextval;
	end if;
END;
/
CREATE OR REPLACE TRIGGER PUBLICACION_TGR02 AFTER UPDATE OF pub_id
ON PUBLICACION FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column pub_id in table PUBLICACION as it uses sequence.');
END;
/

-- Trigger for sequence COMENTARIO_SEQ01 for column com_id in table COMENTARIO ---------
CREATE OR REPLACE TRIGGER COMENTARIO_TGR01 BEFORE INSERT
ON COMENTARIO FOR EACH ROW
BEGIN
	if :new.com_id is null or :new.com_id <=0 then
		:new.com_id := COMENTARIO_SEQ01.nextval;
	end if;
END;
/
CREATE OR REPLACE TRIGGER COMENTARIO_TGR02 AFTER UPDATE OF com_id
ON COMENTARIO FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column com_id in table COMENTARIO as it uses sequence.');
END;
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE PUBLICACION ADD CONSTRAINT USU_PUBLICACION_FK01 FOREIGN KEY (usu_id) REFERENCES USUARIOS (usu_id)
;


ALTER TABLE COMENTARIO ADD CONSTRAINT USU_COMENTARIO_FK01 FOREIGN KEY (usu_id) REFERENCES USUARIOS (usu_id)
;


ALTER TABLE COMENTARIO ADD CONSTRAINT PUB_COMENTARIO_FK01 FOREIGN KEY (pub_id) REFERENCES PUBLICACION (pub_id)
;




-- Grant permissions section -------------------------------------------------


