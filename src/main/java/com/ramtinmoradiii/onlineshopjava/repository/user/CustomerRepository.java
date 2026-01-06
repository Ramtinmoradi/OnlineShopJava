package com.ramtinmoradiii.onlineshopjava.repository.user;

import com.ramtinmoradiii.onlineshopjava.entity.user.Customer;
import com.ramtinmoradiii.onlineshopjava.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUser(User user);
    Optional<Customer> findByUserId(Long userId);
}