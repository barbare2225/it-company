package com.solvd.itcompany.threads;

import com.solvd.itcompany.threads.connectionpool.Connection;
import com.solvd.itcompany.threads.connectionpool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SecondThread extends Thread {

    private static final Logger LOGGER = LogManager.getLogger(SecondThread.class);

    private final String threadName;

    public SecondThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            ConnectionPool pool = ConnectionPool.getInstance(5);

            Connection connection = pool.getConnection();

            LOGGER.info("{} Thread acquired connection {}", threadName, connection.id());

            connection.executeQuery();

            Thread.sleep(5000);

            LOGGER.info("{} released connection {}", threadName, connection.id());

            pool.releaseConnection(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
