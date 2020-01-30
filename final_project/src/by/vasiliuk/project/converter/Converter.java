package main.java.by.vasiliuk.converter;

public interface Converter<T, U> {
    T convert(U u);
}
