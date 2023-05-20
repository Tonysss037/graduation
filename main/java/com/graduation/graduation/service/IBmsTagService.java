package com.graduation.graduation.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.graduation.model.entity.BmsPost;
import com.graduation.graduation.model.entity.BmsTag;
import com.graduation.graduation.model.entity.BmsTeam;

import java.util.List;


public interface IBmsTagService extends IService<BmsTag> {
    /**
     * 插入标签
     *
     * @param tags
     * @return
     */
    List<BmsTag> insertTags(List<String> tags);

    /**
     * 获取标签关联话题
     *
     * @param topicPage
     * @param id
     * @return
     */
    Page<BmsPost> selectTopicsByTagId(Page<BmsPost> topicPage, String id);
//    /**
//     * 获取标签关联组队
//     *
//     * @param teamPage
//     * @param id
//     * @return
//     */
//    Page<BmsTeam> selectTeamsByTagId(Page<BmsTeam> teamPage, String id);
}