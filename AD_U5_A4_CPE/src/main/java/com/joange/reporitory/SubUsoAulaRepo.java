package com.joange.reporitory;

import com.joange.model.SubUsoAula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubUsoAulaRepo extends JpaRepository<SubUsoAula, Long> {
}
