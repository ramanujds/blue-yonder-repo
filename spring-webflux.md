### Spring WebFlux:

Spring WebFlux is a reactive programming framework introduced in Spring 5 that provides an alternative to the traditional Spring MVC framework. It is designed to handle asynchronous and non-blocking operations, making it well-suited for building reactive applications.

### Get, Put, Post, Delete Operations in Reactive World:

In a reactive world, HTTP operations (GET, PUT, POST, DELETE) are handled in a non-blocking and asynchronous manner using Spring WebFlux. The following examples demonstrate how to perform these operations in a reactive manner using Spring WebFlux.

#### 1. **GET Operation:**

```java
@RestController
public class ReactiveController {

    @GetMapping("/api/resource/{id}")
    public Mono<Resource> getResource(@PathVariable String id) {
        // Reactive operation to retrieve a resource by ID
        return resourceService.findById(id);
    }
}
```

#### 2. **PUT Operation:**

```java
@RestController
public class ReactiveController {

    @PutMapping("/api/resource/{id}")
    public Mono<Resource> updateResource(@PathVariable String id, @RequestBody Resource updatedResource) {
        // Reactive operation to update a resource by ID
        return resourceService.update(id, updatedResource);
    }
}
```

#### 3. **POST Operation:**

```java
@RestController
public class ReactiveController {

    @PostMapping("/api/resource")
    public Mono<Resource> createResource(@RequestBody Resource newResource) {
        // Reactive operation to create a new resource
        return resourceService.create(newResource);
    }
}
```

#### 4. **DELETE Operation:**

```java
@RestController
public class ReactiveController {

    @DeleteMapping("/api/resource/{id}")
    public Mono<Void> deleteResource(@PathVariable String id) {
        // Reactive operation to delete a resource by ID
        return resourceService.delete(id);
    }
}
```

In these examples:
- `Mono` represents a result that may be available asynchronously.
- `@GetMapping`, `@PutMapping`, `@PostMapping`, and `@DeleteMapping` annotations are used to map HTTP operations to corresponding methods.
- `@PathVariable` is used to extract values from the URI.
- `@RequestBody` is used to extract the request body.


`RestTemplate` and `WebClient` are both HTTP clients in the Spring ecosystem used for making requests to RESTful services. However, there are key differences in terms of design, features, and usage.

### RestTemplate:

1. **Design:**
   - Synchronous: `RestTemplate` is a synchronous blocking client, which means that a thread making a request will be blocked until the response is received.
   - Traditional: It has been part of the Spring framework for a long time and is widely used in Spring MVC applications.

2. **Thread Model:**
   - Uses a traditional thread-per-request model, which can be less suitable for highly concurrent and scalable applications.

3. **Features:**
   - Limited support for reactive programming.
   - Suitable for traditional synchronous applications where blocking I/O is acceptable.

4. **Example:**
   ```java
   RestTemplate restTemplate = new RestTemplate();
   String result = restTemplate.getForObject("https://example.com/api/resource", String.class);
   ```

### WebClient:

1. **Design:**
   - Asynchronous: `WebClient` is designed for asynchronous, non-blocking operations. It is part of the Spring WebFlux module.
   - Reactive: It fits well with the reactive programming model, making it suitable for building reactive applications.

2. **Thread Model:**
   - Uses reactive programming principles, allowing for efficient use of resources in highly concurrent scenarios.

3. **Features:**
   - Built-in support for reactive programming and the ability to handle streams of data.
   - Better suited for building responsive and scalable applications.

4. **Example:**
   ```java
   WebClient webClient = WebClient.create("https://example.com");
   String result = webClient.get()
                            .uri("/api/resource")
                            .retrieve()
                            .bodyToMono(String.class)
                            .block();
   ```

   
```java
WebClient webClient = WebClient.create("https://example.com");

webClient.get()
        .uri("/api/resource")
        .retrieve()
        .bodyToMono(String.class)
        .subscribe(result -> {
            // Handle the result asynchronously
            System.out.println(result);
        });

```

### Choosing Between RestTemplate and WebClient:

- **Use RestTemplate if:**
  - You are working in a traditional Spring MVC application.
  - You are not concerned about reactive programming and prefer a synchronous, blocking approach.

- **Use WebClient if:**
  - You are working in a reactive Spring WebFlux application.
  - You need to make non-blocking, asynchronous calls.
  - You want better support for reactive streams and handling large numbers of concurrent requests efficiently.

## Exception handling in the reactive world

### 1. **Error Signal Handling with `onError` Operator:**

In reactive programming, errors are signaled through the stream using the `onError` operator. You can handle errors by subscribing to the `onError` signal and providing a callback function.

```java
Flux<Integer> flux = Flux.just(1, 2, 3)
        .concatWith(Mono.error(new RuntimeException("Something went wrong")));

flux.subscribe(
        value -> System.out.println("Received: " + value),
        error -> System.err.println("Error: " + error.getMessage()),
        () -> System.out.println("Completed")
);
```

### 2. **Exception Handling in WebFlux Controllers:**

In Spring WebFlux controllers, you can handle exceptions using the `@ExceptionHandler` annotation. This allows you to centralize exception handling for specific exceptions or custom exceptions.

```java
@RestController
public class ReactiveController {

    @GetMapping("/api/resource/{id}")
    public Mono<Resource> getResource(@PathVariable String id) {
        return resourceService.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Resource not found")));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return Mono.just(new ErrorResponse(ex.getMessage()));
    }
}
```

### 3. **Global Exception Handling with `@ControllerAdvice`:**

You can use `@ControllerAdvice` in Spring WebFlux to create a global exception handler that applies to all controllers.

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ErrorResponse> handleException(Exception ex) {
        return Mono.just(new ErrorResponse("Internal Server Error: " + ex.getMessage()));
    }
}
```

### 4. **Reactive WebClient Exception Handling:**

When using `WebClient`, you can handle exceptions using the `onError` method.

```java
WebClient webClient = WebClient.create("https://example.com");

webClient.get()
        .uri("/api/resource")
        .retrieve()
        .onStatus(HttpStatus::is4xxClientError, clientResponse ->
            Mono.error(new CustomClientException("Client error"))
        )
        .bodyToMono(String.class)
        .subscribe(
            result -> System.out.println("Received: " + result),
            error -> System.err.println("Error: " + error.getMessage())
        );
```

### 5. **Logging and Monitoring:**

Consider using logging frameworks and monitoring tools to log and monitor exceptions in your reactive application. This can provide insights into the health of your application in production.

```java
Flux<Integer> flux = Flux.just(1, 2, 3)
        .concatWith(Mono.error(new RuntimeException("Something went wrong")));

flux
    .doOnError(error -> log.error("Error in reactive stream: {}", error.getMessage()))
    .subscribe(
        value -> System.out.println("Received: " + value),
        error -> System.err.println("Error: " + error.getMessage()),
        () -> System.out.println("Completed")
    );
```
