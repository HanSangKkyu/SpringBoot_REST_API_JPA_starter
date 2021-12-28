package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor // 이게 있어야 @AutoWired를 생략할 수 있다.
@RequestMapping("/api/user/") // 마지막에 '/'를 빠드리지 말자
public class UserController {

    private final UserService userService;// @RequiredArgsConstructor가 있기 때문에 @Autowired 없이도 의존성 주입이 된다.

    @GetMapping(value = "/{id}")
    UserDto getById(@PathVariable("id") long id){
        log.info("checkMap 실행완료",userService.getById(id));
        return userService.getById(id);
    }

    @GetMapping(value = "/")
    List<UserDto> getUsers(){
        return userService.findAll();
    }

    @PostMapping(value = "/")
    UserDto createUser(@RequestBody UserDto userDto){
        return userService.create(userDto);
    }

    @PutMapping(value = "/{id}")
    UserDto updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto){
        return userService.update(id, userDto);
    }

    @DeleteMapping(value = "/{id}")
    void deleteById(@PathVariable("id") Long id){
        userService.deleteById(id);
    }
}
