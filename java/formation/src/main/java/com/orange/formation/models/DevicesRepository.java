package com.orange.formation.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DevicesRepository extends JpaRepository<Device, Long> {
    List<Device> findAllByCustomerId(int customerId);
}
