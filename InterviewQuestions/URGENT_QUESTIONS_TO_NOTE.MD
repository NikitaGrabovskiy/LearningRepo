
*** How do you protect Endpoint using JWT token  ? (Practice in code) :


*** What agorithms exist ?
  
1. Searching Algorithms

Used to find an element in a data structure.

Linear Search
Binary Search
Depth-First Search (DFS)
Breadth-First Search (BFS)

2. Sorting Algorithms

Arrange data in a particular order (usually ascending).

QuickSort
MergeSort
Bubble Sort
Insertion Sort
Selection Sort

3. Graph Algorithms
Operate on graph structures (nodes + edges).
Dijkstra’s Shortest Path
Bellman–Ford
Floyd–Warshall
Kruskal’s MST
Prim’s MST
Topological Sort
Kosaraju / Tarjan (Strongly Connected Components)

A*

4. Dynamic Programming (DP) Algorithms
Used for optimization problems by breaking them into subproblems.
Fibonacci (DP version)
Longest Common Subsequence
Longest Increasing Subsequence
0/1 Knapsack
Coin Change
Matrix Chain Multiplication
Edit Distance (Levenshtein)

5. Greedy Algorithms

Make the locally optimal choice at each step.
Activity Selection
Huffman Coding
Kruskal’s MST
Prim’s MST
Fractional Knapsack
Interval Scheduling

6. Divide and Conquer Algorithms
Recursively split the problem into smaller parts.
MergeSort
QuickSort
Binary Search
Strassen’s Matrix Multiplication
Closest Pair of Points


                **** Difference between Constructor, field and setter dependency injection ****

Types of Dependency Injection

There are three main types of Dependency Injection:

1. Constructor Injection (Most recommended)

Dependencies are provided through the class constructor.

Why use it:

Makes dependencies explicit

Allows immutability

Easy to test

No hidden magic

2. Setter Injection (Method Injection)

Dependencies are provided using setter methods.

@Autowired
public void setPaymentService(PaymentService ps) { ... }

Spring (or even you manually) can call the setter method again, which means the injected dependency can be changed at runtime.

Use when:

Dependency is optional

You want the ability to change the dependency at runtime

For some configuration classes

3. Field Injection

Dependencies are injected directly into class fields, usually with @Autowired.

@Autowired
private PaymentService paymentService;


Use when:

Quick prototypes

Legacy code

Framework-managed classes (tests, config classes)

Not recommended for production code.

Summery

In Spring, dependency injection can be done through constructor, setter, and field injection. Constructor injection is preferred because it clearly defines all required dependencies up front, allows the use of final fields, prevents nulls, and makes unit testing straightforward. Setter injection is useful when a dependency is optional, when you want to allow changing the dependency after object creation, or when working with configuration objects. Field injection, while simple, is discouraged in production code because it hides dependencies and complicates testing, but it can still be acceptable in legacy systems, quick prototypes, test classes, or Spring-managed classes like configuration files where constructors are not practical.”




               *** What parameters of @Transactionals annotation do you know ? ***

✅ Main Parameters of @Transactional
1. propagation

Defines how the transaction should behave when there is already an existing transaction.
Examples:

REQUIRED (default)

REQUIRES_NEW

MANDATORY

SUPPORTS

NOT_SUPPORTED

NEVER

NESTED

2. isolation

Controls how isolated this transaction is from others.
Examples:

READ_COMMITTED

READ_UNCOMMITTED

REPEATABLE_READ

SERIALIZABLE

3. rollbackFor

Specifies exceptions that should trigger rollback.

@Transactional(rollbackFor = Exception.class)

4. noRollbackFor

Specifies exceptions that should NOT trigger rollback.

@Transactional(noRollbackFor = IllegalArgumentException.class)

5. readOnly

Marks a transaction as read-only to optimize performance (no writes allowed).

@Transactional(readOnly = true)

6. timeout

Sets a timeout in seconds for the transaction.

@Transactional(timeout = 5)

7. value / transactionManager

Specifies a specific transaction manager if multiple DBs or managers are present.

@Transactional("primaryTxManager")


                  *** What is a Future and how is it used? *** 

✅ What is a Future and How Is It Used?
What is a Future?

A Future in Java represents the result of an asynchronous computation.
It is a placeholder object returned immediately when you submit a task to an ExecutorService, while the task itself continues running in the background.

Think of a Future as a promise that a result will be available later.

✅ What Future Actually Does

A Future lets you:

1. Check if the task is done
   future.isDone();

2. Cancel the task
   future.cancel(true);

3. Get the result (waits if necessary)
   Integer result = future.get();

4. Get the result with timeout
   Integer result = future.get(2, TimeUnit.SECONDS);

5. Handle exceptions thrown inside the task

If the task throws an exception, future.get() will wrap it in an ExecutionException.

✅ How Future Is Used (Step-by-Step)
1. Submit a Callable to ExecutorService
   ExecutorService service = Executors.newFixedThreadPool(2);

Future<Integer> future = service.submit(() -> {
Thread.sleep(1000);
return 42;
});

2. Do something else while task runs
   System.out.println("Doing other work...");

3. Retrieve the result
   Integer value = future.get();  // blocks until ready
   System.out.println("Result: " + value);

4. Shutdown
   service.shutdown();

🧠 Why Future is Useful

Allows asynchronous programming

Avoids blocking on long tasks

Lets you retrieve results later

Prevents thread explosion by using thread pools

Helps break a large task into parallel subtasks (divide-and-conquer)

⭐ Perfect Interview Summary

“A Future represents the result of an asynchronous computation. When you submit a Callable to an ExecutorService, it returns a Future that you can use to check if the task is done, cancel it, or retrieve the result with get(). It allows asynchronous programming by letting the main thread continue working while the background task completes.”

            *** difference between Future and CompletableFuture ***

✅ Future vs CompletableFuture (Interview-Ready Answer)
1. Future — Basic asynchronous result

Future is a simple placeholder for a result of an asynchronous task.

Limitations of Future

Cannot complete manually

Cannot chain tasks

Cannot combine multiple tasks

No callback support

get() blocks the calling thread

Hard to handle dependent async operations

Cannot run tasks asynchronously without an ExecutorService

Future is basically “asynchronous but still blocking when you need the result.”

2. CompletableFuture — Advanced, non-blocking async programming

CompletableFuture is a powerful class introduced in Java 8 that lets you build non-blocking, composable, async pipelines.

Capabilities of CompletableFuture

Run tasks asynchronously without manually dealing with threads:

CompletableFuture.supplyAsync(() -> compute());


Chain tasks:

future.thenApply(result -> process(result));


Run callbacks when done (non-blocking):

future.thenAccept(result -> System.out.println(result));


Combine multiple futures:

future1.thenCombine(future2, (a, b) -> a + b);


Handle exceptions:

future.exceptionally(e -> -1);


Complete manually:

future.complete(100);


Supports async timeouts, allOf(), anyOf(), etc.

⭐ Even Stronger 2–3 Sentence Version

“Future is a simple handle to an asynchronous computation, but it is limited—you can’t chain tasks, attach callbacks, or avoid blocking when retrieving the result. CompletableFuture is a more advanced, flexible API for asynchronous and reactive programming; it supports non-blocking callbacks, task chaining, composition, exception handling, and manual completion. It’s the modern way to build async flows in Java.”


      *** Have you migrated to latest java version ? What challenges you faced ? ***

Yes, I’ve worked on Java version upgrades. The main challenges I faced were:

Deprecated or removed APIs
Some older libraries relied on APIs that were deprecated or removed in newer Java versions, especially when moving from Java 8 → 11 → 17.
I had to update libraries or refactor the code.

Third-party library incompatibility
Not all dependencies support newer Java versions immediately.
I needed to upgrade dependencies, replace outdated ones, or adjust code to match new versions.

Build and CI/CD updates
Maven and Gradle plugins sometimes required updates to support newer Java versions.
Build pipelines also needed JDK changes.


         *** Spring questions ***

         *** How do you disable auto-configuration for a specific class? *** 

In Spring Boot, you disable auto-configuration for a specific class using the exclude attribute on @SpringBootApplication (or @EnableAutoConfiguration).

✅ Short Interview-Ready Answer

You can disable auto-configuration for a specific class by using the exclude attribute of @SpringBootApplication, for example:

@SpringBootApplication(
exclude = {
DataSourceAutoConfiguration.class
}
)
public class MyApp {
public static void main(String[] args) {
SpringApplication.run(MyApp.class, args);
}
}

✅ Alternative: @SpringBootApplication(excludeName = "...")

If you don’t want to reference the class directly:

@SpringBootApplication(
excludeName = {
"org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration"
}
)
public class MyApp {}

🔧 Also possible in application.properties
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration


            *** How do you bind configuration properties to a POJO (@ConfigurationProperties)? ***

✅ How to Bind Configuration Properties to a POJO

Create a POJO that holds your properties.

Annotate it with @ConfigurationProperties(prefix = "your.prefix").

Register it as a Spring bean using @Component or by enabling configuration properties.

📌 Example
1. application.yml
   app:
   name: EuroAsianBakery
   timeout: 5000

2. POJO with @ConfigurationProperties
   @Component
   @ConfigurationProperties(prefix = "app")
   public class AppProperties {

   private String name;
   private int timeout;

   // getters and setters
   }

3. Alternatively: Enable it in a config class

(If you don’t want @Component on the POJO)

@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class AppConfig {
}

🔍 How It Works

Spring Boot scans application.properties / application.yml

Finds all keys under app.*

Automatically maps them to fields in the POJO based on name matching

⭐ Optional: Validate Configuration Properties
@ConfigurationProperties(prefix = "app")
@Validated
public class AppProperties {

    @NotBlank
    private String name;

    @Min(1000)
    private int timeout;
}


               *** Difference between @Value and @ConfigurationProperties? ***

✅ Difference Between @Value and @ConfigurationProperties
1. Purpose
   @Value

Injects single values from properties or environment variables.

@ConfigurationProperties

Binds groups of properties (structured configuration) into a POJO.

✅ 2. Usage
@Value (simple, one-off values)
@Value("${app.name}")
private String name;

@ConfigurationProperties (multiple related fields)
@ConfigurationProperties(prefix = "app")
public class AppProperties {
private String name;
private int timeout;
}

✅ 3. Binding type
Feature	@Value	@ConfigurationProperties
Supports complex/nested properties	❌ No	✅ Yes
Supports type conversion	⚠️ Limited	✅ Strong (lists, maps, durations, etc.)
Bulk binding	❌ No	✅ Yes
Relaxed binding (app-name, app_name)	❌ No	✅ Yes
✅ 4. When to Use Which?
Use @Value when:

You need one or two simple values.

Example: a single URL, a flag, or a timeout.

Use @ConfigurationProperties when:

You have multiple related properties.

Need type-safe configuration.

Need nested structures, lists, maps.

Example: DB settings, AWS credentials, custom API config.

✅ 5. Performance

@ConfigurationProperties is more efficient for many properties (bound once).

@Value performs expression evaluation (SpEL) for each injection → slower if heavily used.


               *** What is the purpose of @Profile and how do you activate a profile? *** 

✅ What is the purpose of @Profile?

@Profile is used to conditionally enable beans or configuration classes depending on the active Spring environment profile.

Purpose

To load different beans for dev, test, prod, etc.

To separate environment-specific logic.

To avoid running unwanted beans in certain environments (e.g., mock services in dev, real services in prod).

Example:
@Profile("dev")
@Service
public class DevEmailService implements EmailService { ... }

@Profile("prod")
@Service
public class ProdEmailService implements EmailService { ... }


Spring will create only the bean that matches the active profile.

✅ How do you activate a profile?

You can activate a profile in several ways:

1. In application.properties
   spring.profiles.active=dev

2. In application.yml
   spring:
   profiles:
   active: dev

3. From command line
   java -jar app.jar --spring.profiles.active=prod

4. Using environment variables
   export SPRING_PROFILES_ACTIVE=dev

5. In tests
   @ActiveProfiles("test")
   class MyTests { }

               ***  *** 

By default, Spring Boot defines four different values as the health Status:

UP — The component or subsystem is working as expected

DOWN — The component is not working

OUT_OF_SERVICE — The component is out of service temporarily

UNKNOWN — The component state is unknown

               *** health statuses provided by SpringBoot Actuator *** 