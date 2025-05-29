package com.samuelmaia1.github.orderapi.exceptions;

public class OrderIsEmptyException extends RuntimeException{
    public OrderIsEmptyException() {
        super("Não é possível criar um pedido sem itens!");
    }

    public OrderIsEmptyException(String message) {
        super(message);
    }
}
