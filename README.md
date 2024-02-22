    Entities:
        There are entities like Book, Category, Items, Request, and User, representing various entities in the bookstore domain.

    Repositories:
        Repositories like BookRepo, CategoryRepo, and ClientRepo provide CRUD (Create, Read, Update, Delete) operations for their respective entities using Spring Data JPA.

    Services:
        Service classes like BookService, CategoryService, and PurchaseServiceImpl contain business logic for operations related to books, categories, and purchase requests respectively. They interact with repositories to perform CRUD operations and other business logic.

    DTOs (Data Transfer Objects):
        PurchaseRequest and PurchaseResponse are used for transferring data related to purchase requests between the client and server.

    Exception Handling:
        ApiRequestException and ApiException classes handle exceptions and provide a structured response format for API errors. ApiExceptionHandler is a controller advice class that handles ApiRequestException globally and returns a standardized error response.

    Security Configuration:
        SpringSecurity class configures security settings for the application. It defines security rules for different endpoints, enables CORS (Cross-Origin Resource Sharing) support, disables CSRF (Cross-Site Request Forgery) protection, and sets up basic form-based and HTTP Basic authentication.
        UserDetailService is a custom implementation of UserDetailsService interface, used for loading user-specific data during authentication. It retrieves user details from the database and provides an implementation of UserDetails interface, which Spring Security uses for authentication and authorization.

    PasswordEncoder:
        BCryptPasswordEncoder is used for encoding passwords securely. It hashes passwords before storing them in the database and verifies hashed passwords during authentication.
