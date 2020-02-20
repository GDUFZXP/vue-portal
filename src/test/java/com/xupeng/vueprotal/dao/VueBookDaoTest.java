package com.xupeng.vueprotal.dao;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xupeng.vueprotal.entity.VueBook;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VueBookDaoTest {
    @Autowired
    private VueBookDao vueBookDao;

    @Test
    public void  testFindAll(){
        System.out.println(JSONObject.toJSON(vueBookDao.findAll()));
    }

    @Test
    public void testPage(){
        PageRequest pageRequest = PageRequest.of(0,100);
        Page<VueBook> resultPage = vueBookDao.findAll(pageRequest);
        System.out.println("totalPage:"+resultPage.getTotalPages()+";currentPageSize:"+resultPage.getSize());
        resultPage.forEach(new Consumer<VueBook>() {
            @Override
            public void accept(VueBook vueBook) {
                System.out.println(JSONObject.toJSON(vueBook));
            }
        });
    }

    @Test
    public void testSave(){
        VueBook vueBook = new VueBook();
        vueBook.setName("精通JavaScript");
        vueBook.setAuthor("张龙");
        VueBook data = vueBookDao.save(vueBook);
        System.out.println(JSONObject.toJSON(data));
    }

    @Test
    public void testDel(){
        VueBook vueBook = new VueBook();
        vueBook.setId(29L);
        try {
            vueBookDao.delete(vueBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        vueBookDao.updateById(9L, "钟南山", "哈利波特的魔法");

        VueBook prob = new VueBook();
        prob.setId(9L);
        Optional<VueBook> result = vueBookDao.findOne(Example.of(prob));
        if(result.isPresent()) {
            System.out.println(JSONObject.toJSON(result.get()));
        }
    }
}