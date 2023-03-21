DROP TABLE IF EXISTS T_CODE_M;

CREATE TABLE IF NOT EXISTS T_CODE_M (
    P_CD VARCHAR(50) NOT NULL,
    P_CD_NM VARCHAR(200) NOT NULL,
    USE_YN VARCHAR(1) NOT NULL,
    WD_OPT_NM1 VARCHAR(200),
    WD_OPT_NM2 VARCHAR(200),
    WD_OPT_NM3 VARCHAR(200),
    WD_OPT_NM4 VARCHAR(200),
    WD_OPT_NM5 VARCHAR(200),
    NUM_OPT_NM1 VARCHAR(200),
    NUM_OPT_NM2 VARCHAR(200),
    NUM_OPT_NM3 VARCHAR(200),
    NUM_OPT_NM4 VARCHAR(200),
    NUM_OPT_NM5 VARCHAR(200),
    RMK VARCHAR(1000),
    CRT_ID VARCHAR(20),
    CRT_DT TIMESTAMP,
    MDF_ID VARCHAR(20),
    MDF_DT TIMESTAMP,
    CONSTRAINT PK_CODE_M PRIMARY KEY (P_CD)
);

DROP TABLE IF EXISTS T_CODE_D;

CREATE TABLE IF NOT EXISTS T_CODE_D (
    P_CD VARCHAR(50) NOT NULL,
    CD VARCHAR(50) NOT NULL,
    CD_NM VARCHAR(200) NOT NULL,
    USE_YN VARCHAR(1) NOT NULL,
    SORT_SEQ INTEGER,
    WD_OPT1 VARCHAR(200),
    WD_OPT2 VARCHAR(200),
    WD_OPT3 VARCHAR(200),
    WD_OPT4 VARCHAR(200),
    WD_OPT5 VARCHAR(200),
    NUM_OPT1 INTEGER,
    NUM_OPT2 INTEGER,
    NUM_OPT3 INTEGER,
    NUM_OPT4 INTEGER,
    NUM_OPT5 INTEGER,
    RMK VARCHAR(1000),
    CRT_ID VARCHAR(20),
    CRT_DT TIMESTAMP,
    MDF_ID VARCHAR(20),
    MDF_DT TIMESTAMP,
    CONSTRAINT PK_CODE_D PRIMARY KEY (P_CD, CD)
);
