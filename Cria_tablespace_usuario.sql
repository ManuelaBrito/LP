---------------------
-- CRIA TABLESPACE --
---------------------
CREATE TABLESPACE  TS_DB_2026_venda3
DATAFILE  'C:\BD\ts_db_2026_venda3.dbf' SIZE 1M
AUTOEXTEND ON;
----------------------------
--------------------------------
--SEM prefixo C##
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
------------------
------------------
-- CRIA USUÁRIO --
------------------
CREATE USER USER_VENDAS
IDENTIFIED BY aluno
DEFAULT TABLESPACE TS_DB_2026_venda3
TEMPORARY TABLESPACE TEMP
QUOTA UNLIMITED ON TS_DB_2026_venda3;
-----------------
-- PRIVILÉGIOS --
-----------------
GRANT DBA TO USER_VENDAS WITH ADMIN OPTION;

 


