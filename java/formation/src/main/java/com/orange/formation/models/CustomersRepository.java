package com.orange.formation.models;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orange.formation.models.Customer;
import java.util.List;

public interface CustomersRepository extends JpaRepository<Customer, Long> {
    Customer findByMsisdn(String msisdn);
}
