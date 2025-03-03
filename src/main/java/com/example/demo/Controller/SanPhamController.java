package com.example.demo.Controller;

import com.example.demo.Model.DanhMuc;
import com.example.demo.Model.SanPham;
import com.example.demo.Repository.DanhMucRepository;
import com.example.demo.Repository.SanPhamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    DanhMucRepository danhMucRepository;

    @GetMapping("/hien-thi")
    public String hienthi(@ModelAttribute("sanPham") SanPham sanPham, Model model){
        model.addAttribute("ListSP",sanPhamRepository.findAll());
        model.addAttribute("ListDM",danhMucRepository.findAll());

        return "/SanPham/SanPham.html";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute SanPham sanPham, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("ListSP", sanPhamRepository.findAll());
            model.addAttribute("ListDM", danhMucRepository.findAll());
            return "/SanPham/SanPham.html"; // Quay lại trang nhập nếu có lỗi
        }
        sanPham.setNgay_sua(Date.valueOf(LocalDate.now()));
        sanPham.setNgay_tao(Date.valueOf(LocalDate.now()));
        sanPhamRepository.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
    @GetMapping("/xoa/{id}")
    public String xoa(@PathVariable("id") Integer id){
        sanPhamRepository.deleteById(id);
        return "redirect:/san-pham/hien-thi";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        SanPham sanPham = sanPhamRepository.findById(id).get();
        model.addAttribute("sanPham",sanPham);

        List<DanhMuc> list = danhMucRepository.findAll();
        model.addAttribute("ListDM",list);
        return "/SanPham/Detail.html";
    }

    @PostMapping("/update/{id}")
    public String sua(SanPham sanPham){
        sanPham.setNgay_sua(Date.valueOf(LocalDate.now()));
        sanPhamRepository.save(sanPham);
        return "redirect:/san-pham/hien-thi";

    }
}
