package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author zxb
 * @date 2021-05-10 23:08
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias(value="user1")
public class User {
    private Integer id;

    private String name;

    private String password;

    private Integer age;

    private Integer sex;

}
