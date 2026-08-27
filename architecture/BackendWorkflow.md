                         AUTHENTICATION
                               │
             ┌─────────────────┴─────────────────┐
             │                                   │
          REGISTER                             LOGIN
             │                                   │
             ▼                                   ▼
       AuthController                      AuthController
             │                                   │
             ▼                                   ▼
       AuthService                         AuthService
             │                                   │
             ▼                                   ▼
      AuthServiceImpl                    AuthServiceImpl
                                                 │
                                                 ▼
                                      AuthenticationManager
                                                 │
                                                 ▼
                                      AuthenticationProvider
                                                 │
                                                 ▼
                                      CustomUserDetailsService
                                                 │
                                                 ▼
                                             User DB
                                                 │
                                                 ▼
                                      Authentication SUCCESS
                                                 │
                                                 ▼
                                          JWTService
                                                 │
                                                 ▼
                                             JWT TOKEN
                                                 │
                                                 ▼
                                             CLIENT





                                             CLIENT
                                                │
                                                │ Authorization: Bearer <JWT>
                                                ▼
                                                JwtAuthenticationFilter
                                                │
                                                ▼
                                                JWTService
                                                │
                                                ├── Is token valid?
                                                ├── Who is the user?
                                                └── Is token expired?
                                                │
                                                ▼
                                                CustomUserDetailsService
                                                │
                                                ▼
                                                Authentication
                                                │
                                                ▼
                                                SecurityContext
                                                │
                                                ▼
                                                Protected Controller