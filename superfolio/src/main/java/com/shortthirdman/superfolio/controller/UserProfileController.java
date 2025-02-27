package com.shortthirdman.superfolio.controller;

import com.shortthirdman.superfolio.model.User;
import com.shortthirdman.superfolio.service.IUserService;
import com.shortthirdman.superfolio.swagger.GetUserProfile;
import com.shortthirdman.superfolio.swagger.RemoveUserFragment;
import com.shortthirdman.superfolio.swagger.SaveUserFragment;
import com.shortthirdman.superfolio.swagger.UpdateUserFragment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/userprofile")
public class UserProfileController {

    private final IUserService userService;

    public UserProfileController(IUserService userService) {
        this.userService = userService;
    }

    @SaveUserFragment
    @PostMapping(path = "/{fragment}")
    public ResponseEntity<Boolean> saveUserProfile(@PathVariable String fragment, @RequestBody Map<String, Object> details) {
        return new ResponseEntity<>(userService.saveUserDetailFragment(fragment, details), HttpStatus.CREATED);
    }

    @UpdateUserFragment
    @PutMapping(path = "/{fragment}")
    public ResponseEntity<Boolean> updateUserProfile(@PathVariable String fragment, @RequestBody Map<String, Object> details) {
        return new ResponseEntity<>(userService.updateUserDetailFragment(fragment, details), HttpStatus.OK);
    }

    @GetUserProfile
    @GetMapping(path = "/{fragment}")
    public ResponseEntity<User> getUserProfile(@PathVariable(required = false) String fragment) {
        return new ResponseEntity<>(userService.getUserDetails(fragment), HttpStatus.OK);
    }

    @RemoveUserFragment
    @DeleteMapping(path = "/{fragment}")
    public ResponseEntity<Boolean> deleteUserProfile(@PathVariable(required = false) String fragment) {
        return new ResponseEntity<>(userService.deleteUserDetailFragment(fragment), HttpStatus.OK);
    }
}
