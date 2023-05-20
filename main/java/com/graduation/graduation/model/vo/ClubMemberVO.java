package com.graduation.graduation.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubMemberVO implements Serializable {
    private static final long serialVersionUID = -261082150965211545L;

    /**
     * 组队成员id
     */
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 活动ID
     */
    private String clubId;
    /**
     * 用户昵称
     */
    private String alias;
    /**
     * 账号
     */
    private String username;
    /**
     * 活动日期
     */
    private String date;
    /**
     * 活动内容
     */
    private String content;
    /**
     * 社团名称
     */
    private String societies;
    /**
     * 活动地点
     */
    private String place;
    /**
     * 开始时间
     */
    private Time begin;
    /**
     * 结束时间
     */
    private Time end;
}