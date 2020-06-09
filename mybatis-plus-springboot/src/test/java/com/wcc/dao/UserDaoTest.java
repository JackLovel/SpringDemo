package com.wcc.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcc.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {
    @Autowired
    private UserDao userDao;

    // 查询所有
    @Test
    public void testFindAll() {
        List<User> users = userDao.selectList(null);
        users.forEach(u -> System.out.println("user = " + u.getName()));
    }

    // 根据主键查询一个
    @Test
    public void testFindById() {
        User user = userDao.selectById("1");
        System.out.println(user.getName());
    }

    // 条件查询
    @Test
    public void testFind() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("age", 12);
//        wrapper.lt("age", 20);
        wrapper.le("age", 12);

        List<User> users = userDao.selectList(wrapper);
        users.forEach(u -> System.out.println(u.getName()));
    }

    // 模糊查询
    @Test
    public void testFindLike() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // likeRight: 以XX开头的
        wrapper.likeRight("name", "小");

        List<User> users = userDao.selectList(wrapper);
        users.forEach(u -> System.out.println(u.getName()));
    }

    // 保存
    @Test
    public void testSave() {
        User user = new User();
        user.setName("老陈").setAge(55).setBirth(new Date());
        userDao.insert(user);
    }

    // 基于 主键 id 进行数据的修改
    @Test
    public void testUpdateById() {
        User user = userDao.selectById("2");
        user.setName("wcc");
        userDao.updateById(user);
    }

    // 批量修改
    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("永远的神");
        user.setBirth(null).setAge(null); // 不做修改
        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        updateWrapper.eq("age", 12);
        userDao.update(user, updateWrapper);
    }

    // 基于 主键 id 删除一个
    @Test
    public void testDeleteById() {
        userDao.deleteById("2");
    }

    // 基于条件进行删除
    @Test
    public void testDelete() {
        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        updateWrapper.gt("age", 100);
        userDao.delete(updateWrapper);
    }

    // 分页查询使用
    @Test
    public void testFindPage() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.gt("age", 100);
        // 参数1： 当前页 默认值 参数2：每页显示记录数 默认值 10
        IPage<User> page = new Page<>(1, 2);
        IPage<User> userIPage = userDao.selectPage(page, query);
        long total = userIPage.getTotal();
        System.out.println("总记录数：" + total);
        page.getRecords().forEach(u -> System.out.println("user = " + u));
    }
}











