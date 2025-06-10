package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *合同信息：(ContractInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ContractInformation")
public class ContractInformation implements Serializable {

    //ContractInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_information_id")
    private Integer contract_information_id;
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
   // 合同签订日期
   @Basic
    private Timestamp contract_signing_date;
   // 合同结束日期
   @Basic
    private Timestamp contract_end_date;
   // 合同附件
   @Basic
    private String appendices_of_a_contract;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
