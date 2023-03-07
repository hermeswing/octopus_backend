DROP TABLE IF EXISTS T_CODE_M;

CREATE TABLE IF NOT EXISTS T_CODE_M (
    P_CD VARCHAR(50) NOT NULL,
    P_CD_NM VARCHAR(200) NOT NULL,
    USE_YN VARCHAR(1) NOT NULL,
    WD_OPT_NM_1 VARCHAR(200),
    WD_OPT_NM_2 VARCHAR(200),
    WD_OPT_NM_3 VARCHAR(200),
    WD_OPT_NM_4 VARCHAR(200),
    WD_OPT_NM_5 VARCHAR(200),
    NUM_OPT_NM_1 VARCHAR(200),
    NUM_OPT_NM_2 VARCHAR(200),
    NUM_OPT_NM_3 VARCHAR(200),
    NUM_OPT_NM_4 VARCHAR(200),
    NUM_OPT_NM_5 VARCHAR(200),
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
    WD_OPT_1 VARCHAR(200),
    WD_OPT_2 VARCHAR(200),
    WD_OPT_3 VARCHAR(200),
    WD_OPT_4 VARCHAR(200),
    WD_OPT_5 VARCHAR(200),
    NUM_OPT_1 INTEGER,
    NUM_OPT_2 INTEGER,
    NUM_OPT_3 INTEGER,
    NUM_OPT_4 INTEGER,
    NUM_OPT_5 INTEGER,
    RMK VARCHAR(1000),
    CRT_ID VARCHAR(20),
    CRT_DT TIMESTAMP,
    MDF_ID VARCHAR(20),
    MDF_DT TIMESTAMP,
    CONSTRAINT PK_CODE_D PRIMARY KEY (P_CD, CD)
);
