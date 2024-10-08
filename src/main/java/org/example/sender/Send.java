package org.example.sender;

import com.rabbitmq.client.*;

public class Send {

    private final static String QUEUE_NAME = "hello";
    public static void main(String[] argv) throws Exception {

        // Setup Socket
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        // Connect to socket
        try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {

            // Connect to correct queue
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            // Send data to queue
            String dataToSend = "Hello, World!";
            channel.basicPublish("", QUEUE_NAME, null, dataToSend.getBytes());

            System.out.println(" [x] Sent '" + dataToSend + "'");

        }

    }

}
