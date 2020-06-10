package com.wcc.entity;

import com.wcc.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountTest {

    @Autowired
    private AccountMapper mapper;

    @Test
    public void testFindAll() {
        List<Account> accounts = mapper.queryAll();
        accounts.forEach(a -> System.out.println(a));
    }

    @Test
    public void testQueryById() {
        Account account = mapper.queryById(1);
        System.out.println(account.getUsername());
    }

    @Test
    public void testAdd() {
        Account account = new Account();
        account.setAge(11);
        account.setUsername("uzi");
        account.setPassword("22");

        mapper.add(account);
    }

//    void update(Account account);
    @Test
    public void testUpdate() {
        Account account = mapper.queryById(1);
        account.setPassword("25");

        mapper.update(account);
    }

    @Test
    public void testDelete() {
        mapper.deleteById(4);
    }
}