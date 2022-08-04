package com.interview.datamodel.mapper;

/**
 * @author jason.yang
 * @Description mapstruct实现对象属性映射
 * @Date 2021-07-09 9:29
 */

import com.interview.datamodel.entity.UserDO;
import com.interview.datamodel.entity.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userDo2Dto(UserDO userDO);

}