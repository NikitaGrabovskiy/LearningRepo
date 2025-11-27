

      ***Can you make different access modifiers for methods in child classes? ***

Yes. When overriding a method in a child class, you can only make the access more open, never more restricted.

Allowed:
private (can't override), default → protected → public (more open)

Not allowed:
You cannot go from public → protected/private or make visibility smaller.

                   ***  What is the difference between Runnable and Callable? ***

✅ Runnable — Detailed Explanation

Runnable represents a task that can run on a separate thread, but it does not produce any result.

What it actually does

Defines a unit of work that runs in the background.

You implement the run() method with the logic you want to execute.

You pass a Runnable to a Thread or an ExecutorService.

The thread executes the run() logic asynchronously.

Because run() returns void, the task cannot give you any output, only side effects (logging, updating DB, etc).

Typical use cases

Fire-and-forget tasks
(logging, email sending, cache cleanup)

Repeated tasks in schedulers

When you do NOT need a return value

Key limitation

No result and no checked exceptions → you can't know if it succeeded.

✅ Callable — Detailed Explanation

Callable<V> represents a task that runs in the background AND returns a result of type V.

What it actually does

It is similar to Runnable, but designed to produce a value.

You implement the call() method.

You submit it to an ExecutorService.

The executor returns a Future<V>, which represents the pending result.

You can call future.get() to retrieve the result, waiting for completion.

Callable can:

return data

throw checked exceptions

be combined with Future/ExecutorService for asynchronous programming

Typical use cases

Tasks where the result matters:

reading from DB

calling APIs

computing values

parallel computation (divide-and-conquer)

🚀 Runnable vs Callable — What they do (high-level)
Runnable

Runs in the background

Performs actions

Has no return value

Cannot throw checked exceptions

Task is “fire-and-forget”

Callable

Runs in the background

Performs actions

Returns data (via Future)

Can throw exceptions

Suitable for multi-threading where results are needed

🎯 Interview-Perfect Explanation

“Runnable represents a background task that executes some code but does not return a result and cannot throw checked exceptions. Callable is designed for tasks that must produce a value or throw exceptions; it works with ExecutorService to run asynchronously and retrieve the result using a Future. Use Runnable for fire-and-forget actions, and Callable when your background task must return data.”





*** What is polimorphysm:

Polymorphism means the ability of different objects to respond to the same operation (method call) in different ways.
Polymorphism in OOP allows the same method call to behave differently depending on the actual object.
It enables multiple classes to implement the same interface or inherit the same base class and provide their own version of a method.

Two main types of polymorphism
1. Compile-time Polymorphism (Static Polymorphism)

Achieved through method overloading.
The method signature determines which method is called.

Same method name, different parameters.

void draw(Circle c)
void draw(Square s)

2. Runtime Polymorphism (Dynamic Polymorphism)

Achieved through method overriding.
The decision of which method to run happens at runtime based on the actual object.

One interface, many behaviors.

class Shape {
void draw() {}
}

class Circle extends Shape {
void draw() { System.out.println("Drawing circle"); }
}

class Square extends Shape {
void draw() { System.out.println("Drawing square"); }
}

Shape s = new Circle();
s.draw();  // → "Drawing circle"

✅ Short Interview-Ready Definition

Polymorphism in OOP allows the same method call to behave differently depending on the actual object. It enables multiple classes to implement the same interface or inherit the same base class and provide their own version of a method.



*** How do you secure api calls with JWT tokens ? (Practice in code) :

Note: 
* Created a Spring Boot project with Web + Security + JWT dependencies.
* Added /auth/login endpoint to authenticate user and return JWT token.
* Implemented JwtService to generate and validate tokens using a secret key (HS256).
* Built JwtAuthFilter extending OncePerRequestFilter to intercept requests and validate tokens.
* Configured SecurityConfig to disable CSRF, form login, and basic auth, set session stateless, and add JWT filter before UsernamePasswordAuthenticationFilter.
* Allowed /auth/** as public and secured all other endpoints.
* Tested with curl: first obtained token from /auth/login, then accessed protected /api/hello using Authorization: Bearer <token>.
* Verified stateless JWT-based authentication working (no sessions, only token validation).

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
