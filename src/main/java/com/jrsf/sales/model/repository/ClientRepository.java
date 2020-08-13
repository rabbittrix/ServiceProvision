package com.jrsf.sales.model.repository;

import com.jrsf.sales.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
