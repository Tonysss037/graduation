package com.graduation.graduation.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class JoinTeamDTO implements Serializable {
    private static final long serialVersionUID = -5957433707110390852L;

    /**
     * 标题
     */
    private String title;

    /**
     * 标签
     */
    private String tags;
    /**
     * 标签
     */
    private Integer view;

}