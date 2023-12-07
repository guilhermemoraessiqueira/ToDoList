package todo.list.moraes.toDoList.authentication.auth.controller;

import todo.list.moraes.toDoList.authentication.auth.service.AuthorizationService;
import todo.list.moraes.toDoList.authentication.user.dto.AutheticationDto;
import todo.list.moraes.toDoList.authentication.user.dto.RegisterDto;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    AuthorizationService authorizationService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AutheticationDto autheticationDto){
        return authorizationService.login(autheticationDto);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterDto registerDto){
        return authorizationService.register(registerDto);
    }
}