package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *离职信息：(ResignationInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ResignationInformation")
public class ResignationInformation implements Serializable {

    //ResignationInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resignation_information_id")
    private Integer resignation_information_id;
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
   // 离职日期
   @Basic
    private Timestamp date_of_resignation;
   // 离职原因
   @Basic
    private String reasons_for_resignation;
    // 审核状态
    @Basic
    private String examine_state;
    // 审核回复
    @Basic
    private String examine_reply;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
