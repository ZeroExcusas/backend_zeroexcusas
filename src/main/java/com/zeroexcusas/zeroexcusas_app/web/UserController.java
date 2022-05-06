package com.zeroexcusas.zeroexcusas_app.web;

import com.zeroexcusas.zeroexcusas_app.model.TrainingFocus;
import com.zeroexcusas.zeroexcusas_app.model.User;
import com.zeroexcusas.zeroexcusas_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping( value = "/register", method = RequestMethod.POST )
    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody User user) throws Exception{
        System.out.println(user.toString());
        return ResponseEntity.ok( userService.save(user));
    }
}
