package com.xupeng.vueprotal.controller;

import com.xupeng.vueprotal.dao.VueBookDao;
import com.xupeng.vueprotal.entity.VueBook;
import com.xupeng.vueprotal.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private VueBookDao vueBookDao;

    @RequestMapping("/list/{page}/{pageSize}")
    @ResponseBody
    public Page<VueBook> list(@PathVariable Integer page, @PathVariable Integer pageSize){
        return vueBookDao.findAll(PageRequest.of(page, pageSize));
    }

    @PostMapping("save")
    public String save(VueBook vueBook){
        try {
            vueBookDao.save(vueBook);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
