package org.example.pojo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SendPOJO {
    private final static String EXCHANGE_NAME = "exchange-name";

    public static void main(String[] argv) throws Exception {

        // Validate we have enough arguments
        if (argv.length < 3) {
            System.out.println("Not enough arguments expects exactly 4 arguments! str str int");
            return;
        }

        // Setup Socket
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("marcus");
        factory.setPassword("admin");

        // Connect to socket
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // Setup POJO
            POJOBase item = new ItemPOJO(
                    argv[0],
                    argv[1],
                    Integer.parseInt(argv[2])
            );

            // Serialize data
            String serializedItem = POJOBase.PojoToString(item);

            // Send data to queue
            channel.basicPublish(EXCHANGE_NAME, "", null, serializedItem.getBytes());

            System.out.println(" [x] Sent '" + serializedItem + "'");
        }
    }

}
