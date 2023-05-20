package com.graduation.graduation.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;


@Data
@TableName("bms_club")
@Accessors(chain = true)
public class BmsClub implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 日期
     */
    @TableField("date")
    private String date;

    /**
     * 内容
     */
    @TableField("content")
    private String content;
    /**
     * 社团名称
     */
    @TableField("societies")
    private String societies;

    /**
     * 场地
     */
    @TableField("place")
    private String place;

    /**
     * 开始时间
     */
    @TableField("begin_time")
    private Time beginTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private Time endTime;
}