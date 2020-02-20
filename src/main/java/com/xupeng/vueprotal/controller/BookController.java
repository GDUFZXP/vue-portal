package com.xupeng.vueprotal.controller;

import com.xupeng.vueprotal.dao.VueBookDao;
import com.xupeng.vueprotal.entity.VueBook;
import com.xupeng.vueprotal.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public String save(@RequestBody VueBook vueBook){
        try {
            if(vueBook.getId() == null) {
                vueBookDao.save(vueBook);
            }else{
                vueBookDao.updateById(vueBook.getId(), vueBook.getAuthor(), vueBook.getName());
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("del/{id}")
    public String del(@PathVariable Long id){
        VueBook vueBook = new VueBook();
        vueBook.setId(id);
        try {
            vueBookDao.delete(vueBook);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public VueBook get(@PathVariable Long id){
        VueBook prob = new VueBook();
        prob.setId(id);
        Optional<VueBook> result = vueBookDao.findOne(Example.of(prob));
        if(result.isPresent()){
            return result.get();
        }else{
            return null;
        }
    }
}
