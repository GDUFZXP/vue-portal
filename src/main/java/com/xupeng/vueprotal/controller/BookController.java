package com.xupeng.vueprotal.controller;

import com.xupeng.vueprotal.dao.VueBookDao;
import com.xupeng.vueprotal.entity.VueBook;
import com.xupeng.vueprotal.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
