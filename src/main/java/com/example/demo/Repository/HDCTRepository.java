package com.example.demo.Repository;

import com.example.demo.Model.HDCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HDCTRepository extends JpaRepository<HDCT, Integer> {
}
