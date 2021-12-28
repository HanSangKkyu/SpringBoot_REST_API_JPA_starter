package com.example.demo.service;

import com.example.demo.config.mapper.UserMapper;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.mysql.User;
import com.example.demo.repository.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor // 이게 있어야 @AutoWired를 생략할 수 있다.
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

//    @Autowired // @RequiredArgsConstructor를 추가해서 생략가능
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Transactional(readOnly = true)
    public UserDto getById(Long id){
        return userMapper.toDto(userRepository.getById(id));
    }

    @Transactional(readOnly = true)
    public List<UserDto> findAll(){
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Transactional
    public UserDto create(UserDto userDto){
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }

    @Transactional
    public UserDto update(Long id, UserDto userDto){
        User target = userRepository.getById(id);
        userMapper.updateFromDto(userDto, target); // target.setName(userDto.getName()); 와 같은 것이다.
        return userMapper.toDto(userRepository.save(target));
    }

    @Transactional
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}

