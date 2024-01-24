### Kafka: Overview and Commands

#### What is a Topic?

- **Definition:** A topic is a category or feed name to which messages are published by producers and from which messages are consumed by consumers.

- **Usage:**
  - Used to organize data inside a Kafka cluster.
  - Comparable to tables in relational databases (RDBMS).

#### Kafka Components and Terminology:

1. **Topic: order-events**
   
2. **Bootstrap Server:**
   - Servers providing initial metadata.
  
3. **Kafka Producer:**
   - Publishes messages to a Kafka topic.

4. **Kafka Consumer:**
   - Subscribes to a topic and reads messages from it.

5. **Kafka Broker:**
   - Servers managing the storage of messages in topics.

#### Workflow of Kafka:

1. **Producer Sends Message:**
   - Messages sent to a topic at regular intervals.

2. **Kafka Brokers Store Messages:**
   - All messages stored in partitions configured for the topic.

3. **Consumer Subscribes:**
   - Subscribes to a specific topic.

4. **Consumer Requests Messages:**
   - Regularly requests messages from Kafka.

5. **Consumer Processes Message:**
   - Receives and processes the message.

6. **Consumer Sends Acknowledgment:**
   - After processing, consumer sends acknowledgment to the broker.

7. **Kafka Updates Offset:**
   - Upon receiving acknowledgment, Kafka updates the offset.

#### Kafka APIs:

- **Producer API**
- **Consumer API**
- **Connector API:**
  - Source Connector
  - Sink Connector
- **Stream API**
- **Admin API**

#### Kafka Topic Commands:

1. **List Topics:**
   ```bash
   kafka-topics.sh --bootstrap-server localhost:9092 --list
   ```

2. **Create Topic:**
   ```bash
   kafka-topics.sh --bootstrap-server localhost:9092 --topic order-events --create
   ```

3. **Producer Console:**
   ```bash
   kafka-console-producer.sh --topic order-events --bootstrap-server localhost:9092
   ```

4. **Consumer Console:**
   ```bash
   kafka-console-consumer.sh --topic order-events --bootstrap-server localhost:9092
   ```

5. **Describe Topic:**
   ```bash
   kafka-topics.sh --bootstrap-server localhost:9092 --topic order-events --describe
   ```

6. **Delete Topic:**
   ```bash
   kafka-topics.sh --bootstrap-server localhost:9092 --topic order-events --delete
   ```

7. **Create Topic with Partitions:**
   ```bash
   kafka-topics.sh --bootstrap-server localhost:9092 --topic order-events --create --partitions 2
   ```

#### Kafka Consumer Groups:

- **List Consumer Groups:**
  ```bash
  kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
  ```

- **Console Consumer with Group:**
  ```bash
  kafka-console-consumer.sh --topic order-events --bootstrap-server localhost:9092 --group payment-service --property print.key=true
  ```

#### Advanced Producer Configuration:

- **Producer Console with Key and Partitioning:**
  ```bash
  kafka-console-producer.sh --topic order-events --bootstrap-server localhost:9092 --property key.separator=: --property parse.key=true --property "partitioner.class=org.apache.kafka.clients.producer.internals.DefaultPartitioner"
  ```
