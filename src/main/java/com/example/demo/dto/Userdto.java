package com.example.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
 *
 * 用来处理实体的文档
 *
 * */
@ApiModel
@EnableSwagger2
@Builder
@Data
public class Userdto {

    @ApiModelProperty(value = "主码")
    private Integer id;
    @ApiModelProperty(value = "用户姓名")
    private String name;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户的角色")
    private String Role;
    @ApiModelProperty(value = "用户的电话")
    private String tel;
    @ApiModelProperty(value = "用户的email")
    private String email;
    @ApiModelProperty(value = "用户的年龄")
    private int age;
}
