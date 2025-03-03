package com.example.demo.Controller;

import com.example.demo.Model.ChiTietSanPham;
import com.example.demo.Model.MauSac;
import com.example.demo.Model.SanPham;
import com.example.demo.Model.Size;
import com.example.demo.Repository.CTSPRepsitory;
import com.example.demo.Repository.MauSacRepository;
import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/chi-tiet-san-pham")
public class CTSPcontroller {
    @Autowired
    CTSPRepsitory ctspRepsitory;

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    MauSacRepository mauSacRepository;

    @Autowired
    SizeRepository sizeRepository;

    @GetMapping("/hien-thi")
    public String hienthi(Model model){
       model.addAttribute("ListCTSP",ctspRepsitory.findAll());
       model.addAttribute("ListSP",sanPhamRepository.findAll());
       model.addAttribute("ListMS",mauSacRepository.findAll());
       model.addAttribute("ListSize",sizeRepository.findAll());
        return "/CTSP/CTSP.html";
    }
    @GetMapping("/xoa/{id}")
    public String Xoa(@PathVariable("id") Integer id){
        ctspRepsitory.deleteById(id);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute ChiTietSanPham chiTietSanPham){
        chiTietSanPham.setNgay_sua(Date.valueOf(LocalDate.now())) ;
        chiTietSanPham.setNgay_tao(Date.valueOf(LocalDate.now())) ;
        ctspRepsitory.save(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        ChiTietSanPham chiTietSanPham = ctspRepsitory.findById(id).get();
        model.addAttribute("ctsp",chiTietSanPham);

        List<SanPham> listSP = sanPhamRepository.findAll();
        model.addAttribute("ListSP",listSP);

        List<MauSac> listMS = mauSacRepository.findAll();
        model.addAttribute("ListMS",listMS);

        List<Size> ListSize = sizeRepository.findAll();
        model.addAttribute("ListSize",ListSize);
        return "/CTSP/DetailCTSP.html";
    }
    @PostMapping("/update/{id}")
    public String update(ChiTietSanPham chiTietSanPham){
        chiTietSanPham.setNgay_sua(Date.valueOf(LocalDate.now())) ;
        ctspRepsitory.save(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
}
