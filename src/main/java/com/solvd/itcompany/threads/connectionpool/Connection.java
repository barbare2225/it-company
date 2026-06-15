package com.solvd.itcompany.threads.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public record Connection(int id) {

    private static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public void executeQuery() {
        LOGGER.info("Executing query on connection {}", id);
    }
}
