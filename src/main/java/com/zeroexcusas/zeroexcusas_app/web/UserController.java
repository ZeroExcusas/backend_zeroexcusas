package com.zeroexcusas.zeroexcusas_app.web;

import com.zeroexcusas.zeroexcusas_app.exceptions.ApiRequestException;
import com.zeroexcusas.zeroexcusas_app.exceptions.NotFoundException;
import com.zeroexcusas.zeroexcusas_app.model.ActivityLevel;
import com.zeroexcusas.zeroexcusas_app.model.TrainingFocus;
import com.zeroexcusas.zeroexcusas_app.model.User;
import com.zeroexcusas.zeroexcusas_app.service.ActivityLevelService;
import com.zeroexcusas.zeroexcusas_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    ActivityLevelService activityLevelService;

    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody User user) throws Exception{
        System.out.println(user.toString());
        return ResponseEntity.ok( userService.save(user));
    }

    @PostMapping("/register/{activityLeveLId}")
    public ResponseEntity<?> addUser(@RequestBody User user, @PathVariable(value = "activityLeveLId") Integer activityLevelId) throws Exception{
        ActivityLevel activityLevel = activityLevelService.getActivityLevel(activityLevelId);
        if (activityLevel == null) {
            throw new NotFoundException().throwIt(); // Custom Exception
        }
        else {
           // System.out.println("Activity level 2: "+activityLevel.getName());
        }
        user.set_activityLevel(activityLevel);

        return ResponseEntity.ok( userService.save(user));
        //return ResponseEntity.ok(user);
    }

}
