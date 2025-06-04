package com.samuelmaia1.github.orderapi.interfaces;

public interface Mapper<E, D> {
    D toDto(E entity);
}
