package functionalinterfaces;

@FunctionalInterface
public interface IntegerFunction<T> {
    Integer function(T t);
}
