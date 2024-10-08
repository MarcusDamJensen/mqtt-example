# Setup
To start the docker container navigate to ./tools/rabbit-compose-test/
here use the following command

```
docker-compose up -d
```

This should start a docker container with RabbitMQ. This should also preconfigure two queues: 'hello' and 'hello2'm an exhange 'exchange-name' with 'fanout' mode enabled.

# Buidling the project
now that the container is setup, we can build the project, this should generate the jar files needed for the examples.

navigate to the root folder and run the command:

```
gradle build
```

now two folders 'basic' and 'exchange' should be present in the following directory: ./build/libs/

# Examples
## Basic
in the folder ./build/libs/basic/ a send and a recv jar files should be located. Run the recv file with the following command:

```
java -jar .\build\libs\basic\recv-1.0-SNAPSHOT.jar
```

Now open a new console and run the send jar file with the following command:

```
java -jar .\build\libs\basic\send-1.0-SNAPSHOT.jar
```

When this is done you should be able to see that the recv program has received a message and the send should have sent a message.

## Exchange
The following example is much similar to the basic example. However this time we will create two listeners on different queues.

Navigate to the ./build/libs/ folder. In here open two new consoles and run the following commands in them:

```
java -jar .\build\libs\exchange\recv-1.0-SNAPSHOT.jar hello
```

```
java -jar .\build\libs\exchange\recv-1.0-SNAPSHOT.jar hello2
```

Now we can send a message, and here we should be able to see that both queues will receive the message from our sender. In another console use the following command:

```
java -jar .\build\libs\exchange\send-1.0-SNAPSHOT.jar my data is awesome!
```

Here both queues should print the message from the sender.