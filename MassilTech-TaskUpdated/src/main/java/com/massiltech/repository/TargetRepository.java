package com.massiltech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.massiltech.entity.Target;

@Repository
public interface TargetRepository extends JpaRepository<Target, Integer> {

	public Target findByPatientId(Integer logId);

}
