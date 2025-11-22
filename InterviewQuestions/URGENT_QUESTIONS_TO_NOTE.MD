
                            **Study these first - NOTE**

*** Difference between Abstract class and Interface

*** Java 9, 14, 17, and 21 Features 

✅ Java 9 – Key Features

Module System (JPMS) – Introduced modularity to Java and the JDK.

JShell (REPL) – Interactive shell for trying Java commands quickly.

Improved Streams API – Added new methods to make streaming more powerful.

Private Methods in Interfaces – Interfaces can contain private helper methods.

HTTP/2 Client (Incubator) – Modern, asynchronous HTTP client.

Multi-release JARs – Single JAR supporting multiple Java versions.

✅ Java 14 – Key Features

Switch Expressions – Switch becomes an expression with a more concise syntax.

Records (Preview) – Lightweight, immutable data carriers.

Pattern Matching for instanceof (Preview) – Cleaner type checks.

Text Blocks – Multi-line string literals.

Helpful NullPointerExceptions – JVM shows which variable caused the NPE.

Improved Packaging Tool – Create native installers for applications.

✅ Java 17 (LTS) – Key Features

Sealed Classes – Restrict which classes can extend or implement a type.

Records (Final) – Records officially become a stable feature.

Pattern Matching for Switch (Preview) – More powerful switch statements.

Enhanced Pseudo-Random Number Generators – New algorithms and interfaces.

Foreign Function & Memory API (Incubator) – Safe, modern alternative to JNI.

Strong Encapsulation of JDK Internals – JDK internal APIs strongly restricted.

Removed Legacy Features – Removal of Applets and experimental JIT/AOT tools.

✅ Java 21 (LTS) – Key Features

Virtual Threads (Project Loom) – Lightweight threads for massive concurrency.

Pattern Matching for Switch (Final) – Fully standardized after previews.

Record Patterns (Final) – Direct deconstruction of record components.

Sequenced Collections – Consistent first/last element operations across lists, sets, and maps.

String Templates (Preview) – Safer, more powerful string interpolation.

Unnamed Classes and Instance Main (Preview) – Simplifies starting small programs.

Foreign Function & Memory API (Final) – Full replacement for unsafe native access.

Scoped Values (Incubator) – Safer alternative to thread-locals for sharing data.



*** What is polimorphysm:

Polymorphism means the ability of different objects to respond to the same operation (method call) in different ways.
Polymorphism in OOP allows the same method call to behave differently depending on the actual object. It enables multiple classes to implement the same interface or inherit the same base class and provide their own version of a method.

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

