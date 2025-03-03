package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ma_size;

    private String ten_size;

    private String trang_thai;

    private Date ngay_sua;

    private Date ngay_tao;
}
