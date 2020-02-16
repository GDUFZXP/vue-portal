package com.xupeng.vueprotal.dao;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xupeng.vueprotal.entity.VueBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
        PageRequest pageRequest = PageRequest.of(1,10);
        Page<VueBook> resultPage = vueBookDao.findAll(pageRequest);
        System.out.println("totalPage:"+resultPage.getTotalPages()+";currentPageSize:"+resultPage.getSize());
        resultPage.forEach(new Consumer<VueBook>() {
            @Override
            public void accept(VueBook vueBook) {
                System.out.println(JSONObject.toJSON(vueBook));
            }
        });

    }
}