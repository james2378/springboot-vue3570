package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *部门信息：(DepartmentInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DepartmentInformation")
public class DepartmentInformation implements Serializable {

    //DepartmentInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_information_id")
    private Integer department_information_id;
   // 部门名称
   @Basic
    private String department_name;
   // 部门规模
   @Basic
    private String sector_size;
   // 部门负责人
   @Basic
    private String department_head;
   // 负责人联系方式
   @Basic
    private String contact_information_of_person_in_charge;
   // 部门人员
   @Basic
    private String department_personnel;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
