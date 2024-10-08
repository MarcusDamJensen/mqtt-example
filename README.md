# Setup
To run this start the following Docker container with this command:
```
docker run -d --rm --name rabbitmq -p 5552:5552 -p 15672:15672 -p 5672:5672 -e RABBITMQ_SERVER_ADDITIONAL_ERL_ARGS='-rabbitmq_stream advertised_host localhost' rabbitmq:3.13
```

# Starting the Program
Use IntelliJ to run Recv, This will consume from the queue

Next, use IntelliJ to run Send, this will add a message to the queue.
