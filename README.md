    Book and Category Management:
        Implemented CRUD operations for books and categories, enabling seamless addition, retrieval, update, and deletion of book records.
        Utilized Spring Data JPA repositories for efficient database interaction and management.

    User Authentication and Authorization:
        Integrated Spring Security to enforce role-based access control, distinguishing between regular users and administrators.
        Configured security rules to permit browsing of books for all users, while restricting purchase functionality to administrators only.

    Purchase Request Handling:
        Designed a streamlined process for handling purchase requests, allowing users to submit requests for books.
        Implemented purchase request processing logic, ensuring secure and efficient handling of client requests.

    Exception Handling:
        Implemented a robust exception handling mechanism to provide informative error messages and maintain system reliability.
        Utilized controller advice to globally handle exceptions and return standardized error responses.

    Password Security:
        Employed BCryptPasswordEncoder for secure password hashing and storage, ensuring data confidentiality and integrity.

    RESTful API Design:
        Developed a RESTful API to expose bookstore functionalities, enabling seamless integration with frontend applications or other services.
