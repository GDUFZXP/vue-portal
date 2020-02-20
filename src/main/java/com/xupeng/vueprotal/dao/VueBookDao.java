package com.xupeng.vueprotal.dao;

import com.xupeng.vueprotal.entity.VueBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface VueBookDao extends JpaRepository<VueBook, Integer> {
    @Modifying
    @Query("update VueBook set author=?2, name=?3 where  id=?1")
    @Transactional
    void  updateById(Long id, String author, String name);
}
