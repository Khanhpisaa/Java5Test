package com.example.demo.Controller;

import com.example.demo.Model.DanhMuc;
import com.example.demo.Model.Size;
import com.example.demo.Repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/danh-muc")
public class DanhMucController {
    @Autowired
    DanhMucRepository danhMucRepository;

    @GetMapping("/hien-thi")
    public String hienthi(Model model){
        model.addAttribute("ListDM",danhMucRepository.findAll());
        return "/DanhMuc/DanhMuc.html";
    }
    @PostMapping("/add")
    public String add(DanhMuc danhMuc){
        danhMuc.setNgay_sua(Date.valueOf(LocalDate.now()));
        danhMuc.setNgay_tao(Date.valueOf(LocalDate.now()));
        danhMucRepository.save(danhMuc);
        return "redirect:/danh-muc/hien-thi";
    }
    @GetMapping("/xoa/{id}")
    public String xoa(@PathVariable("id") Integer id){
        danhMucRepository.deleteById(id);
        return "redirect:/danh-muc/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        DanhMuc danhMuc = danhMucRepository.findById(id).get();
        model.addAttribute("danhMuc",danhMuc);
        return "/DanhMuc/DetailDanhMuc.html";
    }
    @PostMapping("/update/{id}")
    public String update(DanhMuc danhMuc){
        danhMuc.setNgay_sua(Date.valueOf(LocalDate.now()));
        danhMucRepository.save(danhMuc);
        return "redirect:/danh-muc/hien-thi";
    }
}
