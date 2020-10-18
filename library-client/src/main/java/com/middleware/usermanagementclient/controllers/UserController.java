package com.middleware.usermanagementclient.controllers;

import com.middleware.usermanagementclient.entity.Book;
import com.middleware.usermanagementclient.entity.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class UserController {

    //home page mapping
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("Home");
        return modelAndView;
    }

    //view users mapping
    @GetMapping("/users")
    public ModelAndView getUsers() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://localhost:8081/api/users";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        System.out.println(response.getBody());
        ModelAndView modelAndView = new ModelAndView("ViewUsers");
        modelAndView.addObject("User", response.getBody());
        return modelAndView;
    }

    //add new user
    @RequestMapping("/addUser")
    public RedirectView addUser(User user) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/users";
        restTemplate.postForEntity(url, user, Object.class);
        return new RedirectView("/users");
    }

    //get user by userId
    @RequestMapping("/getUser")
    public ModelAndView getUser(@RequestParam(value = "id") int userId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/users/" + userId;
        Object object = restTemplate.getForObject(url, Object.class);
        ModelAndView modelAndView = new ModelAndView("UpdateUser");
        modelAndView.addObject("User", object);
        return modelAndView;
    }

    //delete user by userId
    @RequestMapping("/deleteUser/{id}")
    public RedirectView deleteUser(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/users/" + id;
        restTemplate.delete(url);
        return new RedirectView("/users");
    }

    //update user by userId
    @RequestMapping("/updateUser")
    public RedirectView updateUser(User user, HttpServletRequest req) {
        String userId = req.getParameter("id");
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/users/" + userId;
        restTemplate.put(url, user);
        return new RedirectView("/users");
    }

    //navigate to add new user
    @RequestMapping("/addUserUI")
    public String AddUser() {
        System.out.println("addUserUI");
        return "AddUser";
    }


    //cancel form
    @RequestMapping("/cancelUser")
    public RedirectView cancel() {
        return new RedirectView("/users");
    }















    //view books mapping
    @GetMapping("/books")
    public ModelAndView getBooks() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://localhost:8081/api/books";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        System.out.println(response.getBody());
        ModelAndView modelAndView = new ModelAndView("ViewBooks");
        modelAndView.addObject("Book", response.getBody());
        return modelAndView;
    }

    //add new book
    @RequestMapping("/addBook")
    public RedirectView addBook(Book book) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/books";
        restTemplate.postForEntity(url, book, Object.class);
        return new RedirectView("/books");
    }

    //get book by bookId
    @RequestMapping("/getBook")
    public ModelAndView getBook(@RequestParam(value = "id") int bookId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/books/" + bookId;
        Object object = restTemplate.getForObject(url, Object.class);
        ModelAndView modelAndView = new ModelAndView("UpdateBook");
        modelAndView.addObject("Book", object);
        return modelAndView;
    }

    //delete book by bookId
    @RequestMapping("/deleteBook/{id}")
    public RedirectView deleteBook(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/books/" + id;
        restTemplate.delete(url);
        return new RedirectView("/books");
    }

    //update book by bookId
    @RequestMapping("/updateBook")
    public RedirectView updateBook(Book book, HttpServletRequest req) {
        String bookId = req.getParameter("id");
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/books/" + bookId;
        restTemplate.put(url, book);
        return new RedirectView("/books");
    }

    //navigate to add new book
    @RequestMapping("/addBookUI")
    public String AddBook() {
        System.out.println("addBookUI");
        return "AddBook";
    }


    //cancel form
    @RequestMapping("/cancelBook")
    public RedirectView cancelBook() {
        return new RedirectView("/books");
    }


}
