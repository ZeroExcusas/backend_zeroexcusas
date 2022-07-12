package com.zeroexcusas.zeroexcusas_app.controller;

import com.zeroexcusas.zeroexcusas_app.common.ZEStrings;
import com.zeroexcusas.zeroexcusas_app.exceptions.NotFoundException;
import com.zeroexcusas.zeroexcusas_app.model.ActivityLevel;
import com.zeroexcusas.zeroexcusas_app.model.User;
import com.zeroexcusas.zeroexcusas_app.service.ActivityLevelService;
import com.zeroexcusas.zeroexcusas_app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "Usuarios", description = "Gestion de Usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    ActivityLevelService activityLevelService;


    @Operation(summary = ZEStrings.MESSAGE_POST)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody User user) throws Exception{
        return ResponseEntity.ok( userService.save(user));
    }

    @PostMapping("/register/{activityLeveLId}")
    public ResponseEntity<?> addUser(@RequestBody User user, @PathVariable(value = "activityLeveLId") Integer activityLevelId) throws Exception{
        ActivityLevel activityLevel = activityLevelService.getActivityLevel(activityLevelId);
        if (activityLevel == null) {
           throw new NotFoundException().throwIt();
           // throw new AlexandraException().throwIt();
        }
        else {
           // System.out.println("Activity level 2: "+activityLevel.getName());
        }
        user.set_activityLevel(activityLevel);

        return ResponseEntity.ok( userService.save(user));
        //return ResponseEntity.ok(user);
    }

}
