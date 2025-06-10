package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *奖罚信息：(RewardAndPunishmentInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "RewardAndPunishmentInformation")
public class RewardAndPunishmentInformation implements Serializable {

    //RewardAndPunishmentInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_and_punishment_information_id")
    private Integer reward_and_punishment_information_id;
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
   // 奖罚类型
   @Basic
    private String types_of_rewards_and_punishments;
   // 发布日期
   @Basic
    private Timestamp release_date;
   // 发布人
   @Basic
    private String publisher;
   // 奖罚详情
   @Basic
    private String details_of_rewards_and_penalties;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
