package kr.co.bootpay.demo.controller;

import kr.co.bootpay.demo.daoService.UserDaoService;
import kr.co.bootpay.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service;

    //find all
    // get /users
    @GetMapping("/users")
    public List<User> retrieveAllUser() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }


    //input -details of user
    //output - CREATED & Return the created URI
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        User savedUser = service.save(user);
    }
}
