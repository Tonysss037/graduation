package com.graduation.graduation.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.graduation.model.dto.CreateTeamDTO;
import com.graduation.graduation.model.dto.CreateTopicDTO;
import com.graduation.graduation.model.entity.BmsPost;
import com.graduation.graduation.model.entity.BmsTeam;
import com.graduation.graduation.model.entity.UmsUser;
import com.graduation.graduation.model.vo.PostVO;
import com.graduation.graduation.model.vo.TeamVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public interface IBmsTeamService extends IService<BmsTeam> {

    /**
     * 获取各种组队信息
     *
     * @param page
     * @param tab
     * @return
     */
    Page<TeamVO> getListFootball(Page<TeamVO> page, String tab);
    Page<TeamVO> getListBasketball(Page<TeamVO> page, String tab);
    Page<TeamVO> getListVolleyball(Page<TeamVO> page, String tab);
    Page<TeamVO> getListBadminton(Page<TeamVO> page, String tab);
    Page<TeamVO> getListPingPong(Page<TeamVO> page, String tab);
    Page<TeamVO> getListTennis(Page<TeamVO> page, String tab);
    Page<TeamVO> getListOther(Page<TeamVO> page, String tab);

    /**
     * 发布
     *
     * @param dto
     * @param principal
     * @return
     */
    BmsTeam create(CreateTeamDTO dto, UmsUser principal);

    /**
     * 查看话题详情
     *
     * @param id
     * @return
     */
    Map<String, Object> viewTeam(String id);

    /**
     * 加入组队
     *
     * @param byId
     * @param principal
     * @return
     */
    BmsTeam join(BmsTeam byId, UmsUser principal);

}