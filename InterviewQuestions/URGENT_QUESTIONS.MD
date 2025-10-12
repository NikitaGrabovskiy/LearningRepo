
                            **Study these first**

1) How do you secure api calls with JWT tokens ? (Practice in code)
2) Difference between where and having
3) Difference between @RestController and @Controller





Temp answer: 

1) WHERE filters rows before grouping, while HAVING filters groups after the GROUP BY clause.
In other words, WHERE works on individual rows, and HAVING works on aggregated results.

-- Filters rows before grouping
SELECT department, SUM(salary)
FROM employees
WHERE salary > 50000
GROUP BY department;

-- Filters groups after aggregation
SELECT department, SUM(salary)
FROM employees
GROUP BY department
HAVING SUM(salary) > 200000;


2) Difference between @RestController and @Controller
“In Spring MVC, @Controller and @RestController both define classes that handle web requests, but they’re used for different purposes.
@Controller is used in traditional web applications that return views—like JSP, 
Thymeleaf, or HTML templates. 
The method usually returns a view name, and Spring’s ViewResolver renders the corresponding page.
If you want to return raw data (JSON or XML) from a @Controller, you must also use @ResponseBody on the method.
On the other hand, @RestController is designed for RESTful APIs. 
It’s a convenience annotation that combines @Controller and @ResponseBody,
meaning all methods automatically return the response body 
(usually JSON) instead of a view. So you don’t need to annotate each method with @ResponseBody.

In short, @Controller is for server-side rendered web pages, and @RestController
is for building APIs that return data directly to clients like Angular, React, or mobile apps.”