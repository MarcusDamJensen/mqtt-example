package org.example.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SendExchange {
    private final static String EXCHANGE_NAME = "exchange-name";
    private final static String EXCHANGE_MODE = "fanout";

    public static void main(String[] argv) throws Exception {

        // Setup Socket
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        // Connect to socket
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // Declare exchange
            channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_MODE);

            // Send data to queue
            String dataToSend = argv.length < 1 ? "info: Hello world!" :
                    String.join(" ", argv);
            channel.basicPublish(EXCHANGE_NAME, "", null, dataToSend.getBytes());

            System.out.println(" [x] Sent '" + dataToSend + "'");
        }
    }
}
