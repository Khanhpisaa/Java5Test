package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Getter
@Setter
@Table(name = "mau_sac")

public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ma_mau;

    private String ten_mau;

    private String trang_thai;

    private Date ngay_sua;

    private Date ngay_tao;
}
