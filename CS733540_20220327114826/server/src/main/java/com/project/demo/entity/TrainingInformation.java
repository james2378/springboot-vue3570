package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *培训信息：(TrainingInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "TrainingInformation")
public class TrainingInformation implements Serializable {

    //TrainingInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_information_id")
    private Integer training_information_id;
   // 培训科目名称
   @Basic
    private String name_of_training_subject;
   // 培训类型
   @Basic
    private String training_type;
   // 培训费用
   @Basic
    private String training_costs;
   // 教师来源
   @Basic
    private String source_of_teachers;
   // 主办部门
   @Basic
    private String host_department;
   // 培训日期
   @Basic
    private Timestamp training_date;
   // 结束日期
   @Basic
    private Timestamp end_date;
   // 培训封面
   @Basic
    private String training_cover;
   // 备注
   @Basic
    private String remarks;
   // 参训员工
   @Basic
    private String trainees;
   // 培训详情
   @Basic
    private String training_details;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
