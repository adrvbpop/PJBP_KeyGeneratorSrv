INSERT INTO LLAVES_SPI (
    TIPO_LLAVE,
    NUMERO_LLAVE,
    TIPO_IDENTIFICACION,
    NUMERO_IDENTIFICACION,
    TIPO_DE_PERSONA,
    NOMBRE_PERSONA_JURIDICA,
    PRIMER_NOMBRE_PN,
    SEGUNDO_NOMBRE_PN,
    PRIMER_APELLIDO_PN,
    SEGUNDO_APELLIDO_PN,
    NIT_ENTIDAD_EMISORA,
    TIPO_MEDIO_DE_PAGO,
    NUMERO_MEDIO_DE_PAGO,
    FECHA_CREACION,
    FECHA_MODIFICACION,
    ESTADO_DE_LLAVE,
    CODIGO_BANCO_AVAL,
    LLAVE_FAVORITA,
    ACCION,
    NOMBRE_DE_ARCHIVO,
    NUMERO_LINEA_DE_REGISTRO,
    ESTADO_LLAVE_BANCO
) VALUES (
    'P', -- TIPO_LLAVE (ejemplo: P = personal, C = corporativo)
    '12345678901234567890', -- NUMERO_LLAVE
    'CC', -- TIPO_IDENTIFICACION (ejemplo: CC = cédula, NIT = número de identificación tributaria)
    '123456789', -- NUMERO_IDENTIFICACION
    'PN', -- TIPO_DE_PERSONA (PN = persona natural, PJ = persona jurídica)
    NULL, -- NOMBRE_PERSONA_JURIDICA (nulo porque es persona natural)
    'Juan', -- PRIMER_NOMBRE_PN
    'Carlos', -- SEGUNDO_NOMBRE_PN
    'Pérez', -- PRIMER_APELLIDO_PN
    'Gómez', -- SEGUNDO_APELLIDO_PN
    123456789, -- NIT_ENTIDAD_EMISORA
    'TARJ', -- TIPO_MEDIO_DE_PAGO (ejemplo: TARJ = tarjeta, EFEC = efectivo)
    12345, -- NUMERO_MEDIO_DE_PAGO
    '2024-12-09 10:30:00', -- FECHA_CREACION (formato: AAAA-MM-DD HH:MI:SS)
    '2024-12-09 10:45:00', -- FECHA_MODIFICACION
    'ACTIVO', -- ESTADO_DE_LLAVE
    0002, -- CODIGO_BANCO_AVAL
    'N', -- LLAVE_FAVORITA (S = sí, N = no)
    'I', -- ACCION (I = insertar, U = actualizar, D = eliminar)
    'archivo_prueba.txt', -- NOMBRE_DE_ARCHIVO
    1, -- NUMERO_LINEA_DE_REGISTRO
    'Activo y funcional' -- ESTADO_LLAVE_BANCO
);



INSERT INTO LLAVES_SPI (
    TIPO_LLAVE,
    NUMERO_LLAVE,
    TIPO_IDENTIFICACION,
    NUMERO_IDENTIFICACION,
    TIPO_DE_PERSONA,
    NOMBRE_PERSONA_JURIDICA,
    PRIMER_NOMBRE_PN,
    SEGUNDO_NOMBRE_PN,
    PRIMER_APELLIDO_PN,
    SEGUNDO_APELLIDO_PN,
    NIT_ENTIDAD_EMISORA,
    TIPO_MEDIO_DE_PAGO,
    NUMERO_MEDIO_DE_PAGO,
    FECHA_CREACION,
    FECHA_MODIFICACION,
    ESTADO_DE_LLAVE,
    CODIGO_BANCO_AVAL,
    LLAVE_FAVORITA,
    ACCION,
    NOMBRE_DE_ARCHIVO,
    NUMERO_LINEA_DE_REGISTRO,
    ESTADO_LLAVE_BANCO
) VALUES (
    'P', -- TIPO_LLAVE (ejemplo: P = personal, C = corporativo)
    '@BPARV059', -- NUMERO_LLAVE
    'CC', -- TIPO_IDENTIFICACION (ejemplo: CC = cédula, NIT = número de identificación tributaria)
    '1053', -- NUMERO_IDENTIFICACION
    'PN', -- TIPO_DE_PERSONA (PN = persona natural, PJ = persona jurídica)
    NULL, -- NOMBRE_PERSONA_JURIDICA (nulo porque es persona natural)
    'Andres', -- PRIMER_NOMBRE_PN
    'David', -- SEGUNDO_NOMBRE_PN
    'Rodriguez', -- PRIMER_APELLIDO_PN
    'Vargas', -- SEGUNDO_APELLIDO_PN
    1025686, -- NIT_ENTIDAD_EMISORA
    'TARJ', -- TIPO_MEDIO_DE_PAGO (ejemplo: TARJ = tarjeta, EFEC = efectivo)
    12345, -- NUMERO_MEDIO_DE_PAGO
    '2024-12-09 10:30:00', -- FECHA_CREACION (formato: AAAA-MM-DD HH:MI:SS)
    '2024-12-09 10:45:00', -- FECHA_MODIFICACION
    'ACTIVO', -- ESTADO_DE_LLAVE
    0002, -- CODIGO_BANCO_AVAL
    'N', -- LLAVE_FAVORITA (S = sí, N = no)
    'I', -- ACCION (I = insertar, U = actualizar, D = eliminar)
    'archivo_prueba.txt', -- NOMBRE_DE_ARCHIVO
    1, -- NUMERO_LINEA_DE_REGISTRO
    'Activo y funcional' -- ESTADO_LLAVE_BANCO
);
