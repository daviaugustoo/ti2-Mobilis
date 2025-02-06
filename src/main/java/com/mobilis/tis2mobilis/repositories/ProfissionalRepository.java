package com.mobilis.tis2mobilis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mobilis.tis2mobilis.models.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    
}