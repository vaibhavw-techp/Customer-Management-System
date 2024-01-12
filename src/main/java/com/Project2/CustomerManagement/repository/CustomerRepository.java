package com.Project2.CustomerManagement.repository;

import com.Project2.CustomerManagement.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,UUID> {

}
