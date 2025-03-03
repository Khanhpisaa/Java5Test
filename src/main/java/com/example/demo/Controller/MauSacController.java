package com.example.demo.Controller;

import com.example.demo.Model.MauSac;
import com.example.demo.Repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    MauSacRepository mauSacRepository;

    @GetMapping("/hien-thi")
    public String hienthi(Model model){
        model.addAttribute("ListMS",mauSacRepository.findAll());
        return "/MauSac/MauSac.html";
    }

    @PostMapping("/add")
    public String add(MauSac mauSac){
        mauSac.setNgay_sua(Date.valueOf(LocalDate.now()));
        mauSac.setNgay_tao(Date.valueOf(LocalDate.now()));
        mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("/xoa/{id}")
    public String xoa(@PathVariable("id") Integer id){
        mauSacRepository.deleteById(id);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        MauSac mauSac = mauSacRepository.findById(id).get();
        model.addAttribute("mauSac",mauSac);
        return "/MauSac/MauSacDetail.html";
    }
    @PostMapping("/update/{id}")
    public String update(MauSac mauSac){
        mauSac.setNgay_sua(Date.valueOf(LocalDate.now()));
        mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}
