package com.example.demo1.model.mapper;

import java.util.List;

public interface EntityMapper <D, E>{
    D toDTO(E entity);

    E toEntity(D dto);

    List<D> toDTOs(List<E> entities);

    List<E> toEntities(List<D> dtos);
}
