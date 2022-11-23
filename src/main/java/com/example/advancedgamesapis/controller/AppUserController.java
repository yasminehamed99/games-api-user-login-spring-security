package com.example.advancedgamesapis.controller;

import com.example.advancedgamesapis.dto.GetUserInfo;
import com.example.advancedgamesapis.dto.RegisterationRequest;
import com.example.advancedgamesapis.service.AppUserService;
import com.example.advancedgamesapis.service.RegisterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")

public class AppUserController {
    private final AppUserService appUserService;
    @Autowired
    private RegisterationService registerationService;
@Autowired
    public AppUserController(AppUserService appUserService, RegisterationService registerationService) {
        this.appUserService = appUserService;
        this.registerationService = registerationService;
    }

    @PostMapping()
    public String register(@RequestBody RegisterationRequest request){
        return registerationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {

        return registerationService.confirmToken(token);
    }
    @GetMapping(path = "getuser")
    public GetUserInfo getUserInfo() throws Exception {

        return appUserService.getUserInfo();
    }


}
