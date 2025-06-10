package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *员工用户：(EmployeeUser)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EmployeeUser")
public class EmployeeUser implements Serializable {

    //EmployeeUser编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_user_id")
    private Integer employee_user_id;
   // 员工编号
   @Basic
    private String employee_number;
   // 姓名
   @Basic
    private String full_name;
   // 性别
   @Basic
    private String gender;
   // 薪资
   @Basic
    private String salary;
   // 部门
   @Basic
    private String department;
   // 职务
   @Basic
    private String post;
    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
