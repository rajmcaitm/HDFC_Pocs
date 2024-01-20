package com.springframework.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springframework.config.JwtGeneratorInterface;
import com.springframework.exception.UserNotFoundException;
import com.springframework.model.User;
import com.springframework.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private UserService userService;
    private JwtGeneratorInterface jwtGenerator;

    @Autowired
    public UserController(UserService userService, JwtGeneratorInterface jwtGenerator){
        this.userService=userService;
        this.jwtGenerator=jwtGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody User user){
        try{
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws FileNotFoundException {
        try {
            if(user.getCustId()==0 || user.getPassword() == null) {
                throw new UserNotFoundException("CustId or Password is Empty");
            }
            User userData = userService.findByCustIdAndPassword(user.getCustId(), user.getPassword());
            if(userData == null){
                throw new UserNotFoundException("CustId or Password is Invalid");
            }
             PrintWriter myWriter= new PrintWriter("jwt.txt");
        	 myWriter.println(jwtGenerator.generateToken(user));
              myWriter.flush();
              myWriter.close();
              Map<String, String> jwtToken= jwtGenerator.generateToken(user);
              System.out.println("jwtToken"+jwtToken);
            return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);           
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
