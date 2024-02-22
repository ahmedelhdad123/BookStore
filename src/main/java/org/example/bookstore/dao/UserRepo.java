package org.example.bookstore.dao;

import org.example.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    List<User> findUserByEmail(String email);
}
