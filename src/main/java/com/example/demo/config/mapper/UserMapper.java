package com.example.demo.config.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.mysql.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN) // @Mapper라고만 작성하면 뒤에 ()안을 작성하지 않으면 bean으로 인식하지 못한다.
public interface UserMapper extends GenericMapper<UserDto, User>{

}
