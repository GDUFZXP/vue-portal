package com.xupeng.vueprotal.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookVo {
    private Long id;
    private String name;
    private String author;
}
