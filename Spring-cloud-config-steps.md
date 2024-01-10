**Spring Config Server Setup Steps:**

1. **Create a Spring Boot Project:**
   - Use the Spring Initializer or your preferred IDE to create a new Spring Boot project.
   - Include the `Config Server` dependency.

2. **Create a Git Repository (Local/Remote):**
   - Initialize a Git repository either locally or on a remote Git server.

3. **Add Config Server Properties:**
   - Open `application.properties` or `application.yml`.
   - Add the following properties for Config Server:
     ```yaml
     spring:
       cloud:
         config:
           server:
             git:
               uri: [git-repo-url]
               clone-on-start: true
           default-label: main
     ```

4. **Enable Config Server:**
   - Add `@EnableConfigServer` annotation to the main application class.

**Configuring Client Service (Order-Service):**

1. **Add Config Client Dependency:**
   - Include the `Config Client` dependency in the `order-service` project.

2. **Configure Config Client Properties:**
   - Open `application.properties` or `application.yml` in the `order-service` project.
   - Add the following properties to connect to the Config Server:
     ```yaml
     spring:
       config:
         import: optional:configserver:http://localhost:8888
     ```

3. **Read Property with @Value Annotation:**
   - In your code, use the `@Value` annotation to read a property (e.g., message).
     ```java
     @Value("${message: No Message available}")
     private String message;
     ```

4. **Refreshing Properties Dynamically:**
   - Add the Actuator dependency to your `order-service` project.
   - Enable the required Actuator endpoints in `application.properties` or `application.yml`:
     ```yaml
     management:
       endpoints:
         web:
           exposure:
             include: refresh, beans, env
     ```
   - Add `@RefreshScope` annotation on top of the class where properties need to be refreshed (e.g., `OrderServiceController`).
   - To refresh properties dynamically, make a POST request to `/actuator/refresh`.

With these steps, you should have a Spring Config Server set up along with a client service (order-service) configured to dynamically fetch and refresh properties from the server.
