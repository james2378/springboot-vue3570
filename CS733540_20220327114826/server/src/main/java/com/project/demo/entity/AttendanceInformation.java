package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *考勤信息：(AttendanceInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AttendanceInformation")
public class AttendanceInformation implements Serializable {

    //AttendanceInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_information_id")
    private Integer attendance_information_id;
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
   // 考勤状态
   @Basic
    private String attendance_status;
   // 备注
   @Basic
    private String remarks;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
