package com.xupeng.vueprotal.controller;

import com.xupeng.vueprotal.vo.BookVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/list")
    public List<BookVo> list(){
        List<BookVo> resultList = new ArrayList<>();
        BookVo bookVo1 = new BookVo(1L, "疯狂Java讲义","张三");
        BookVo bookVo2 = new BookVo(2L, "Kafa权威指南","李四");
        BookVo bookVo3 = new BookVo(3L, "Flink实战","王五");
        BookVo bookVo4 = new BookVo(4L, "Spring源码解析","李白");
        resultList.add(bookVo1);
        resultList.add(bookVo2);
        resultList.add(bookVo3);
        resultList.add(bookVo4);
        return resultList;
    }
}
