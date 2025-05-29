package com.samuelmaia1.github.orderapi.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum ProductCategory {
    PERIFERICOS,
    HARDWARE,
    ACESSORIOS,
    COMPUTADORES,
    MONITORES,
    ELETRONICOS,
    VIDEOGAMES
}
