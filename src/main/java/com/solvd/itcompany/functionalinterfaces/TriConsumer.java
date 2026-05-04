package com.solvd.itcompany.functionalinterfaces;

@FunctionalInterface
public interface TriConsumer<T, D, E> {

    void accept(T t, D d, E e);

}
