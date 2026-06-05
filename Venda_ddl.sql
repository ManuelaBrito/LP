-- =========================================
-- TABELA CLIENTE
-- =========================================
CREATE TABLE cliente (
    cli_codigo        NUMBER CONSTRAINT pk_cli_codigo PRIMARY KEY,
    cli_nome          VARCHAR(100) NOT NULL,
    cli_cpf           VARCHAR(11) NOT NULL UNIQUE,
    cli_lograudouro         VARCHAR(30) NOT NULL,
    cli_cidade           VARCHAR(30) NOT NULL,
    cli_cep              VARCHAR(10) NOT NULL,
    cli_estado           VARCHAR(2) NOT NULL,
    cli_bairro           VARCHAR (20) NOT NULL
);



-- =========================================
-- TABELA VENDEDOR
-- =========================================
CREATE TABLE vendedor (
    ven_codigo        NUMBER CONSTRAINT pk_ven_codigo PRIMARY KEY,
    ven_nome          VARCHAR(100) NOT NULL,
    ven_salario_fixo  NUMBER(10,2) NOT NULL
);

-- =========================================
-- TABELA PRODUTO
-- =========================================
CREATE TABLE produto (
    pro_codigo            NUMBER CONSTRAINT pk_pro_codigo PRIMARY KEY,
    pro_descricao         VARCHAR(100) NOT NULL,
    pro_valor_unidade     NUMBER(10,2) NOT NULL,
    CONSTRAINT chk_pro_valor CHECK (pro_valor_unidade > 0),
    pro_quantidade        NUMBER
);

-- =========================================
-- TABELA PEDIDO
-- =========================================
CREATE TABLE pedido (
    ped_numero        NUMBER CONSTRAINT pk_ped_numero PRIMARY KEY,
    ped_data          DATE NOT NULL,
    cli_codigo        NUMBER NOT NULL,
    ven_codigo        NUMBER NOT NULL,
    ped_valor_total   NUMBER (10,2),
    ped_prazo_entrega number,
    CONSTRAINT fk_pedido_cliente FOREIGN KEY (cli_codigo)
        REFERENCES cliente(cli_codigo),
        
    CONSTRAINT fk_pedido_vendedor FOREIGN KEY (ven_codigo)
        REFERENCES vendedor(ven_codigo)
);

-- =========================================
-- TABELA ITEM DO PEDIDO
-- =========================================
CREATE TABLE item_pedido (
    ped_numero        NUMBER,
    pro_codigo        NUMBER,
    item_quantidade   NUMBER NOT NULL,
    item_valor        NUMBER(10,2),
    CONSTRAINT pk_item_pedido PRIMARY KEY (ped_numero, pro_codigo),
    
    CONSTRAINT fk_item_pedido FOREIGN KEY (ped_numero)
        REFERENCES pedido(ped_numero),
        
    CONSTRAINT fk_item_produto FOREIGN KEY (pro_codigo)
        REFERENCES produto(pro_codigo),
        
    CONSTRAINT chk_item_quantidade CHECK (item_quantidade > 0)
);

-- =========================================
-- TABELA PAGAMENTO 
-- =========================================
CREATE TABLE pagamento (
    pag_codigo        NUMBER,
    ped_numero        NUMBER NOT NULL,
    pag_tipo          VARCHAR(30) NOT NULL,
    pag_valor         NUMBER(10,2) NOT NULL,
        CONSTRAINT fk_pagamento_pedido FOREIGN KEY (ped_numero)
        REFERENCES pedido(ped_numero),
        
    CONSTRAINT chk_pag_valor CHECK (pag_valor > 0),
    CONSTRAINT pk_pagamento PRIMARY KEY(pag_codigo, ped_numero)
);

CREATE TABLE telefone (
    tel_codigo      NUMBER,
    cli_codigo      NUMBER NOT NULL,
    tel_numero      VARCHAR(15) NOT NULL,
    tel_tipo        VARCHAR(20),
    
    CONSTRAINT fk_telefone_cliente FOREIGN KEY (cli_codigo)
        REFERENCES cliente(cli_codigo),
        
    CONSTRAINT pk_telefone primary key (cli_codigo, tel_codigo),
    
    CONSTRAINT chk_tel_tipo CHECK (tel_tipo IN ('Residencial', 'Celular', 'Comercial'))
);