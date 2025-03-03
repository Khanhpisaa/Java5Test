package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Getter
@Setter
@Table(name = "san_pham")

public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Mã sản phẩm không được để trống")
    private String ma_san_pham;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String ten_san_pham;

    @NotBlank(message = "Trạng thái không được để trống")
    private String trang_thai;

    private Date ngay_tao;
    private Date ngay_sua;
    private String mo_ta;

    @NotNull(message = "Danh mục không được để trống")
    @ManyToOne
    @JoinColumn(name = "id_danh_muc")
    private DanhMuc danhMuc;
}
