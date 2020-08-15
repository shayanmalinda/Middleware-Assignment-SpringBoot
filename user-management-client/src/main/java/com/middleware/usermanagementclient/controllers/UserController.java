package com.middleware.usermanagementclient.controllers;

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
    public ModelAndView getUsers() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://localhost:8081/api/users";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

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
        return new RedirectView("/");
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
        return new RedirectView("/");
    }

    //update user by userId
    @RequestMapping("/updateUser")
    public RedirectView updateUser(User user, HttpServletRequest req) {
        String userId = req.getParameter("id");
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/users/" + userId;
        restTemplate.put(url, user);
        return new RedirectView("/");
    }

    //navigate to add new user
    @RequestMapping("/addUserUI")
    public String AddUser() {
        System.out.println("addUser");
        return "AddUser";
    }

    //cancel form
    @RequestMapping("/cancel")
    public RedirectView cancel() {
        return new RedirectView("/");
    }


}
