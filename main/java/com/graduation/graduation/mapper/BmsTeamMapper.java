package com.graduation.graduation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.graduation.model.entity.BmsPost;
import com.graduation.graduation.model.entity.BmsTeam;
import com.graduation.graduation.model.vo.PostVO;
import com.graduation.graduation.model.vo.TeamVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BmsTeamMapper extends BaseMapper<BmsTeam> {
    /**
     * 分页查询首页话题列表
     * <p>
     *
     * @param page
     * @param tab
     * @return
     */
    Page<TeamVO> selectListAndPage(@Param("page") Page<TeamVO> page, @Param("tab") String tab);

    /**
     * 全文检索
     *
     * @param page
     * @param keyword
     * @return
     */
    Page<TeamVO> searchByKey(@Param("page") Page<TeamVO> page, @Param("keyword") String keyword);
    Page<TeamVO> searchByKey2(@Param("page") Page<TeamVO> page, @Param("keyword") String keyword);



}
