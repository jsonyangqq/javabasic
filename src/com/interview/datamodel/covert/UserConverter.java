package com.interview.datamodel.covert;

import com.interview.datamodel.entity.UserDO;
import com.interview.datamodel.entity.UserDTO;
import com.interview.datamodel.mapper.UserMapper;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-07-09 9:42
 */
public class UserConverter {



    public static UserDTO convertToDTO(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userDO.getName());
        userDTO.setAge(userDO.getAge());
        userDTO.setNickName(userDO.getNickName());
        userDTO.setBirthDay(userDO.getBirthDay());
        return userDTO;
    }

}