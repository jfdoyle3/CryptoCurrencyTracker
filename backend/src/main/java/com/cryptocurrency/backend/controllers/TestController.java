package com.cryptocurrency.backend.controllers;



import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/test")
public class TestController {



    @GetMapping("/public")
    public String allAccess() {
    	System.out.println("get some data");
        return "public content";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User content";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String modAccess() {
        return "Mod content";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "admin content";
    }
    
    @GetMapping("/data")
    public static void getAPIData() {
    	System.out.println("get some data");
      //  return "public content";
    }
    
    
}

