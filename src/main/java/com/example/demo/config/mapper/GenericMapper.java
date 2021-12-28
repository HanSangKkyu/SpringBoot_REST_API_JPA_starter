package com.example.demo.config.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface GenericMapper<D, E> {

    D toDto(E e);
    List<D> toDtoList(List<E> eList);

    E toEntity(D d);
    List<E> toEntityList(List<D> dList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // CRUD의 update할 때 사용한다.
    void updateFromDto(D dto, @MappingTarget E entity);
}
