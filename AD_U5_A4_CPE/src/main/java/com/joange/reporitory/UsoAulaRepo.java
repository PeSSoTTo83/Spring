package com.joange.reporitory;

import com.joange.model.UsoAula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsoAulaRepo extends JpaRepository<UsoAula, Long> {
}
