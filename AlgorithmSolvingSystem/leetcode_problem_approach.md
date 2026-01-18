# How to Approach LeetCode Problems (Step-by-Step)

This is a **repeatable framework** you should use for **every LeetCode problem**.
It works both for **learning** and **technical interviews**.

---

## 1️⃣ Read & Restate the Problem

Do **not** code immediately.

- Read the problem carefully
- RESTATE THE PROBLEM IN YOUR WORDS IN ENGLISH ALOUD ! NEVER SKIP THIS STEP, IMPORTANT FOR SOFT SKILL PRACTICE !
- Identify:
  - Inputs
  - Outputs
  - Constraints

---

## 2️⃣ Understand the normal case, minimal input and edge cases

```
nums = [2,7,11,15], target = 9
output = [0,1]
```

Always try:
- Normal case
- Edge case
- Minimum input

---

## 3️⃣ Identify the Pattern (CRITICAL STEP)

You need to find one of 15 categories from the list!!! Most important step

Before thinking about code, ask these questions **in order**:

### Core Pattern Questions

- Is this a **contiguous subarray or substring** problem?
  → Sliding Window

- Do I need **fast lookup, counting, or value → index mapping**?
  → HashMap / HashSet

- Is the input **sorted** or can sorting help?
  → Binary Search / Two Pointers

- Do I need **next / previous greater or smaller elements**?
  → Stack / Monotonic Stack

- Do I need **min / max repeatedly** or **top K elements**?
  → Heap / Priority Queue

- Am I dealing with **ranges or time intervals**?
  → Interval Pattern

- Am I making a **locally optimal decision at each step**?
  → Greedy

- Am I asked to generate **all combinations / permutations / subsets**?
  → Backtracking

- Is the data structured as a **tree or hierarchy**?
  → Tree DFS / BFS

- Is the problem about **connectivity, dependencies, or components**?
  → Graph / Union-Find

- Are there **overlapping subproblems** with an **optimal substructure**?
  → Dynamic Programming


📌 If you **cannot confidently map the problem to a pattern**, stop and analyze more.
Most mistakes happen at this step.

---

## 4️⃣ Think of the Brute Force Solution

Always start here.

- What is the simplest solution?
- What is its time complexity?

Example:
```
Two Sum brute force → O(n²)
```

---

## 5️⃣ Optimize the Brute Force

Ask:
> What am I recalculating that I can remember or reuse?

Common optimizations:
- Replace nested loops with hash lookups
- Use two pointers instead of extra loops
- Store intermediate results

Target:
- **O(n)** or **O(log n)** time

---

## 6️⃣ Explain the Algorithm in Plain English

Before coding, you must be able to say:

> I will iterate once, store needed information, and return the result when a condition is met.

If you can’t explain it simply, you don’t understand it yet.

NEVER SKIP THE STEP - EXPLAIN THE SOLUTION ALOUD ! IMPORTANT FOR SOFTSKILLS

---

## 7️⃣ Choose Data Structures Explicitly

Be intentional:
- `HashMap` → frequency, index mapping
- `HashSet` → existence checks
- `ArrayDeque / Stack` → monotonic behavior
- `PriorityQueue` → min/max access
- `int[]` → fixed range frequency

---

## 8️⃣ Code Cleanly

Rules:
- Code in LeetCode IDE - helps with remembering Java syntax
- Use meaningful variable names
- Avoid clever tricks
- Handle edge cases
- Keep logic readable
- Create a variable for a value what will get several time from array or list

---

## 9️⃣ Analyze Time & Space Complexity

Always finish with complexity analysis.
Do it myself and when ask chatgpt to confirm my understanding

Analyze both 

- Time: O(n), O(n log n), or O(log n)
- Space: O(n) or O(1)

---

## 🔁 10️⃣ Re-run the Solution on Examples

Mentally simulate:
- First iteration
- Boundary conditions
- Edge cases

Input edge cases to Leetcode test input

Check if possible to create objects outside loop or avoid object creation

---

## 🔁 11 Submit to LeetCode

Check how it perform compare to other people solutions

---

## 🔁 ️12  Review code and check what can be improved (Ask chatgpt after)

---


## 🔁 ️13  Save the code solution to the learning repo so it can be printed and reviewed later

---

## 🔁 ️14  After complete 15 (1 of each category) repeat by coding them again from memory

---

## 🧠 Interview Mindset

> Interviewers evaluate **how you think**, not what you memorized.

Show your reasoning clearly at every step.
