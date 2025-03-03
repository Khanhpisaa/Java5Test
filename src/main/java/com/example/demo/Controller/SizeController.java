package com.example.demo.Controller;

import com.example.demo.Model.MauSac;
import com.example.demo.Model.Size;
import com.example.demo.Repository.MauSacRepository;
import com.example.demo.Repository.SizeRepository;
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
@RequestMapping("/size")
public class SizeController {
    @Autowired
    SizeRepository sizeRepository;

    @GetMapping("/hien-thi")
    public String hienthi(Model model){
        model.addAttribute("ListSize",sizeRepository.findAll());
        return "/Size/Size.html";
    }

    @PostMapping("/add")
    public String add(Size size){
        size.setNgay_sua(Date.valueOf(LocalDate.now()));
        size.setNgay_tao(Date.valueOf(LocalDate.now()));
        sizeRepository.save(size);
        return "redirect:/size/hien-thi";
    }
    @GetMapping("/xoa/{id}")
    public String xoa(@PathVariable("id") Integer id){
        sizeRepository.deleteById(id);
        return "redirect:/size/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        Size size = sizeRepository.findById(id).get();
        model.addAttribute("size",size);
        return "/Size/SizeDetail.html";
    }
    @PostMapping("/update/{id}")
    public String update(Size size){
        size.setNgay_sua(Date.valueOf(LocalDate.now()));
        sizeRepository.save(size);
        return "redirect:/size/hien-thi";
    }
}
