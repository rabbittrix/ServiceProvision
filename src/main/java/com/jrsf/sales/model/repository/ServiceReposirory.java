package com.jrsf.sales.model.repository;

import com.jrsf.sales.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceReposirory extends JpaRepository<Service, Integer> {
}
