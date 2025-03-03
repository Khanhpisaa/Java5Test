package com.example.demo.Repository;

import com.example.demo.Model.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTSPRepsitory extends JpaRepository<ChiTietSanPham,Integer> {
}
