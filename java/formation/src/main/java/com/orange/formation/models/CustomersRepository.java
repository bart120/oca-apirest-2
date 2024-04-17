package com.orange.formation.models;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orange.formation.models.Customer;

public interface CustomersRepository extends JpaRepository<Customer, Long> {

}
