package myResource;

import exceptions.BookingException;

public class MyResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("my resource closed");
    }
}
