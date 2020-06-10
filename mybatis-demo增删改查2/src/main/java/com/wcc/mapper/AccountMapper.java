package com.wcc.mapper;

import com.wcc.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {
    List<Account> queryAll();
    Account queryById(Integer id);
    void add(Account account);
    void update(Account account);
    void deleteById(Integer id);
}
