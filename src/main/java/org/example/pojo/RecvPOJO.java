package org.example.pojo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RecvPOJO {

    private final static String EXCHANGE_NAME = "exchange-name";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("marcus");
        factory.setPassword("admin");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // Declare new queue + Bind it to the exchange
        final String queueName;
        if (argv.length < 1) {
            queueName = channel.queueDeclare().getQueue();
        } else {
            queueName = String.join(" ", argv);
        }

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());

            System.out.println("Received message: " + message);

            POJOBase item = POJOBase.JsonToPojo(message, ItemPOJO.class);

            System.out.println(" [" + queueName + "] Received '" + item.toString() + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });

    }

}
