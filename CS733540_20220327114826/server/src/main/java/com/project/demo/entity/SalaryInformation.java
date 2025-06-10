package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *薪资信息：(SalaryInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "SalaryInformation")
public class SalaryInformation implements Serializable {

    //SalaryInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_information_id")
    private Integer salary_information_id;
   // 员工
   @Basic
    private Integer staff;
   // 员工编号
   @Basic
    private String employee_number;
   // 姓名
   @Basic
    private String full_name;
   // 部门
   @Basic
    private String department;
   // 职务
   @Basic
    private String post;
   // 绩效
   @Basic
    private Integer achievements;
   // 基础工资
   @Basic
    private Integer basic_salary;
   // 工资总额
   @Basic
    private String total_wages;
   // 月份
   @Basic
    private String month;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
