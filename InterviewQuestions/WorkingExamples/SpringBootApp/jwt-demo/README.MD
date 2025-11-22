
**Make a single code to get token and set make the actual code**


TOKEN=$(curl -s -X POST http://localhost:9090/auth/login \
-H "Content-Type: application/json" \
-d '{"username":"user","password":"password"}' | grep -o '"token":"[^"]*"' | cut -d'"' -f4) && \
curl -i http://localhost:9090/api/hello -H "Authorization: Bearer $TOKEN"


            Steps to implement spring security

* Created a Spring Boot project with Web + Security + JWT dependencies.
* Added /auth/login endpoint to authenticate user and return JWT token.
* Implemented JwtService to generate and validate tokens using a secret key (HS256).
* Built JwtAuthFilter extending OncePerRequestFilter to intercept requests and validate tokens.
* Configured SecurityConfig to disable CSRF, form login, and basic auth, set session stateless, and add JWT filter before UsernamePasswordAuthenticationFilter.
* Allowed /auth/** as public and secured all other endpoints.
* Tested with curl: first obtained token from /auth/login, then accessed protected /api/hello using Authorization: Bearer <token>.
* Verified stateless JWT-based authentication working (no sessions, only token validation).