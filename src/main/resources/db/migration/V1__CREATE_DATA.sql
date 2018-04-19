CREATE TABLE ALAT (
  ID VARCHAR(255),
  HARGA   DOUBLE PRECISION DEFAULT NULL,
  NAMA    VARCHAR(64) NOT NULL,
  UNIQUE (NAMA),
  PRIMARY KEY (ID)
);

CREATE TABLE PESAN (
  ID  VARCHAR(255),
  TGL_PESAN  DATE NOT NULL,
  CATATAN    VARCHAR(255) DEFAULT NULL,
  TGL_DATANG DATE NOT NULL,
  TOTAL      DOUBLE PRECISION,
  PRIMARY KEY (ID)
);



CREATE TABLE DETAIL_PESAN (
  ID CHARACTER VARYING(255),
  ID_ALAT         CHARACTER VARYING(255) NOT NULL,
  ID_PESAN        CHARACTER VARYING(255) NOT NULL,
  JUMLAH          INTEGER                NOT NULL,
  DISKON          DOUBLE PRECISION       NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_DETAIL_PO1 FOREIGN KEY (ID_ALAT) REFERENCES ALAT (ID),
  CONSTRAINT FK_DETAIL_PO2 FOREIGN KEY (ID_PESAN) REFERENCES PESAN (ID)
);


