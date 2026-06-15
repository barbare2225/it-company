package com.solvd.itcompany.threads.connectionpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConnectionPool {

    private static volatile ConnectionPool instance;

    private final BlockingQueue<Connection> connections;

    private ConnectionPool(int connectionsCount) {
        this.connections = IntStream.range(0, connectionsCount)
                .mapToObj(i -> new Connection(i))
                .collect(Collectors.toCollection(
                        () -> new ArrayBlockingQueue<>(connectionsCount)
                ));
    }

    public static ConnectionPool getInstance(int connectionsCount) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(connectionsCount);
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(Connection connection)
            throws InterruptedException {
        connections.put(connection);
    }
}
