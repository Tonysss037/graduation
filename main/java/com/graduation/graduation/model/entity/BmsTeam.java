package com.graduation.graduation.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@TableName("bms_team")
@AllArgsConstructor
@NoArgsConstructor
public class BmsTeam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 标题
     */
    @NotBlank(message = "标题不可以为空")
    @TableField(value = "title")
    private String title;

    /**
     * 标签
     */
    @NotBlank(message = "标签不可以为空")
    @TableField(value ="tags")
    private String tags;

    /**
     * 作者ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 浏览数
     */
    @TableField("view")
    @Builder.Default
    private Integer view = 0;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.UPDATE)
    private Date modifyTime;

    /**
     * 组队判断
     */
    @TableField("isteam")
    @Builder.Default
    private Integer isteam = 0;
}