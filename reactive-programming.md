### Functional Programming - Introduction:

Functional Programming (FP) is a paradigm that treats computation as the evaluation of mathematical functions.

**Example:**
```java
// Traditional approach without functional programming
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> squaredNumbers = new ArrayList<>();
for (Integer number : numbers) {
    squaredNumbers.add(number * number);
}

// Functional programming approach using streams and lambda expressions
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> squaredNumbers = numbers.stream()
                                     .map(x -> x * x)
                                     .collect(Collectors.toList());
System.out.println(squaredNumbers);  // Output: [1, 4, 9, 16, 25]
```

### Reactive Architecture - Pros and Cons:

Reactive architecture focuses on building systems that are responsive, resilient, and scalable. It embraces an event-driven programming model, where components react to changes and propagate them through the system.

**Pros:**
1. **Responsiveness:** Improves user experience by reacting to events promptly.
2. **Resilience:** Handles failures gracefully, ensuring system stability.
3. **Scalability:** Scales easily to handle increased loads.

**Cons:**
1. **Complexity:** Implementing reactive systems can be more complex.
2. **Learning Curve:** Developers may need time to learn new paradigms and libraries.

### Reactive Streams:

Reactive Streams is a standard for asynchronous stream processing with non-blocking backpressure. It provides a common API for reactive programming in Java, ensuring interoperability between different reactive libraries.

### Mono, Flux - Introduction:

1. **Mono:**
   - Represents a publisher that emits at most one item.
   - Useful for handling asynchronous operations that produce a single result.

   ```java
   Mono<String> monoValue = Mono.just("Hello, Mono!");
   monoValue.subscribe(System.out::println);  // Output: Hello, Mono!
   ```

2. **Flux:**
   - Represents a publisher that can emit multiple items (zero to N items).
   - Suitable for handling asynchronous operations that produce a stream of data.

   ```java
   Flux<Integer> fluxNumbers = Flux.range(1, 5);
   fluxNumbers.subscribe(System.out::println);  // Output: 1 2 3 4 5
   ```

### Reactive Operators (map, filter, flatMap, transform):

1. **map:**
   - Transforms each element emitted by a publisher using a provided function.

   ```java
   Flux<Integer> original = Flux.just(1, 2, 3);
   Flux<String> mapped = original.map(x -> "Number: " + x);
   mapped.subscribe(System.out::println);  // Output: Number: 1 Number: 2 Number: 3
   ```

2. **filter:**
   - Filters elements emitted by a publisher based on a given predicate.

   ```java
   Flux<Integer> original = Flux.just(1, 2, 3, 4);
   Flux<Integer> filtered = original.filter(x -> x % 2 == 0);
   filtered.subscribe(System.out::println);  // Output: 2 4
   ```

3. **flatMap:**
   - Transforms each element into a sequence of elements and flattens the resulting sequences.

   ```java
   Flux<String> original = Flux.just("apple", "banana", "cherry");
   Flux<Character> flattened = original.flatMap(s -> Flux.fromArray(s.toCharArray()));
   flattened.subscribe(System.out::println);  // Output: a p p l e b a n a n a c h e r r y
   ```

4. **transform:**
   - Applies a transformation to the entire Flux or Mono.

   ```java
   Flux<Integer> original = Flux.just(1, 2, 3);
   Flux<String> transformed = original.transform(flux -> flux.map(x -> "Number: " + x));
   transformed.subscribe(System.out::println);  // Output: Number: 1 Number: 2 Number: 3
   ```
   
