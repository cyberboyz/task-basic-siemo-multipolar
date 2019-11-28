package com.karyawan.repository;

import com.karyawan.model.EmployeeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeGroupRepository extends JpaRepository<EmployeeGroup, Long>{

}
