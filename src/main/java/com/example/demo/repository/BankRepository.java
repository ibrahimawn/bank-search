package com.example.demo.repository;

import com.example.demo.domain.Bank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    @Query(value = "select ifsc, bank_name, branch, state, city, district, address from bank_branches where ifsc = :ifsc ORDER BY ?#{#pageable}",
            countQuery = "select count(*) from branches where ifsc = :ifsc ORDER BY ?#{#pageable}",
            nativeQuery = true)
    Page<Object[]> findByIfsc(@Param("ifsc") String ifsc, Pageable pageable);
}
