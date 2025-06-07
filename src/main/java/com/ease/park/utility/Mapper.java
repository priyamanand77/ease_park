package com.ease.park.utility;

import org.modelmapper.ModelMapper;

public class Mapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T> T toEntity(Object source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

    public static <T> T toDto(Object source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

}
