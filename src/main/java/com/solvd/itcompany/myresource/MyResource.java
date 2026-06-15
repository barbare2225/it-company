package com.solvd.itcompany.myresource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyResource implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(MyResource.class);

    @Override
    public void close() throws Exception {
        LOGGER.info("my resource closed");
    }
}
