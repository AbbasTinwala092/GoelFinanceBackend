package com.goelfinance.goel.repository;

import com.goelfinance.goel.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
