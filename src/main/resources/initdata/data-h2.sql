INSERT INTO T_CODE_M(P_CD, P_CD_NM, USE_YN, CRT_ID, CRT_DT, MDF_ID, MDF_DT) VALUES ('USE_YN', '사용여부', 'Y', 'admin', NOW(), 'admin', NOW());
INSERT INTO T_CODE_M(P_CD, P_CD_NM, USE_YN, CRT_ID, CRT_DT, MDF_ID, MDF_DT) VALUES ('LANG_CD', '언어코드', 'Y', 'admin', NOW(), 'admin', NOW());

INSERT INTO T_CODE_D(P_CD, CD, CD_NM, USE_YN, SORT_SEQ, CRT_ID, CRT_DT, MDF_ID, MDF_DT) VALUES ('USE_YN', 'Y', '사용', 'Y', 10, 'admin', NOW(), 'admin', NOW());
INSERT INTO T_CODE_D(P_CD, CD, CD_NM, USE_YN, SORT_SEQ, CRT_ID, CRT_DT, MDF_ID, MDF_DT) VALUES ('USE_YN', 'N', '미사용', 'Y', 20, 'admin', NOW(), 'admin', NOW());
INSERT INTO T_CODE_D(P_CD, CD, CD_NM, USE_YN, SORT_SEQ, CRT_ID, CRT_DT, MDF_ID, MDF_DT) VALUES ('LANG_CD', 'KO', '한글', 'Y', 10, 'admin', NOW(), 'admin', NOW());
INSERT INTO T_CODE_D(P_CD, CD, CD_NM, USE_YN, SORT_SEQ, CRT_ID, CRT_DT, MDF_ID, MDF_DT) VALUES ('LANG_CD', 'EN', '영어', 'Y', 20, 'admin', NOW(), 'admin', NOW());