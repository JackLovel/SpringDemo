package com.wcc.controller;

import com.wcc.dao.BookMapper;
import com.wcc.model.Book;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/list")
    public String bookList(Model model) {
        List<Book> books = bookMapper.queryAllBook();
        model.addAttribute("books",  books);
        return "book/list";
    }

    @RequestMapping("/{id}/info")
    public String bookInfo(@PathVariable Integer id, Model model) {
        Book book = bookMapper.queryBookById(id);
        model.addAttribute("book",  book);
        return "book/info";
    }

    @GetMapping("/add")
    public String toBookAdd() {
        return "book/add";
    }

    @PostMapping("/add")
    public String bookAdd(Book book) {
        bookMapper.addBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/{id}/update")
    public String toInput(@PathVariable Integer id, Model model) {
        Book book = bookMapper.queryBookById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }

    @PostMapping("/update")
    public String post(Book book) {
        bookMapper.updateBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/{id}/delete")
    public String bookDelete(@PathVariable Integer id, RedirectAttributes attributes) {
        bookMapper.deleteBookById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/book/list";
    }
}
