package com.wcc.controller;

import com.wcc.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/book")
public class BookController {
    @PostMapping("/")
    public String addBook(String name) {
        return "receive:" + name;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        return String.valueOf(id);
    }
}
