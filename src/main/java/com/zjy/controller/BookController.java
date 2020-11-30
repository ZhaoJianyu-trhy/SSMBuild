package com.zjy.controller;

import com.zjy.pojo.Books;
import com.zjy.service.BookService;
import com.zjy.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {


    @Resource
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("books", books);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/addBook")
    public String toAddBook() {
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/add")
    public String addBook(Books books) {
        System.out.println("addBook=>" + books);
        bookService.addBook(books);
        return "redirect:/book/allBook";//重定向
    }

    /**
     * 跳转到修稿书籍页面
     * @return
     */
    @RequestMapping("/updateBook")
    public String toUpdatePage(int id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("qBooks", books);
        return "updateBook";
    }

    @RequestMapping("update")
    public String updateBook(Books books) {
        System.out.println("修改了~~" + books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/searchBook")
    public String searchBook(@RequestParam("bookName") String name, Model model) {
        Books book = bookService.searchBookByName(name);
        System.out.println("book = " + book);
        List<Books> books = new ArrayList<>();
        if (book == null) {
            books = bookService.queryAllBooks();
            model.addAttribute("error", "未查到书籍");
        }
        else books.add(book);
        model.addAttribute("books", books);
        return "allBook";
    }
}
