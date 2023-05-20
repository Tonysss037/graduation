package com.graduation.graduation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.graduation.common.api.ApiResult;
import com.graduation.graduation.mapper.BmsTagMapper;
import com.graduation.graduation.mapper.BmsTeamMapper;
import com.graduation.graduation.mapper.BmsTopicMapper;
import com.graduation.graduation.mapper.UmsUserMapper;
import com.graduation.graduation.model.dto.CreateTeamDTO;
import com.graduation.graduation.model.dto.CreateTopicDTO;
import com.graduation.graduation.model.entity.*;
import com.graduation.graduation.model.vo.PostVO;
import com.graduation.graduation.model.vo.TeamVO;
import com.graduation.graduation.model.vo.ProfileVO;
import com.graduation.graduation.service.IBmsTagService;
import com.graduation.graduation.service.IBmsTeamService;
import com.graduation.graduation.service.IUmsUserService;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class IBmsTeamServiceImpl extends ServiceImpl<BmsTeamMapper, BmsTeam> implements IBmsTeamService {
    @Resource
    private UmsUserMapper umsUserMapper;

    @Autowired
    private IUmsUserService iUmsUserService;

//    @Autowired
//    private com.graduation.graduation.service.IBmsTeamTagService IBmsTeamTagService;
    //查询各种体育类型数据
    @Override
    public Page<TeamVO> getListFootball(Page<TeamVO> page, String tab) {
        Page<TeamVO> iPage = this.baseMapper.searchByKey(page, "足球");
        return iPage;
    }
    @Override
    public Page<TeamVO> getListBasketball(Page<TeamVO> page, String tab) {
        Page<TeamVO> iPage = this.baseMapper.searchByKey(page, "篮球");
        return iPage;
    }
    @Override
    public Page<TeamVO> getListVolleyball(Page<TeamVO> page, String tab) {
        Page<TeamVO> iPage = this.baseMapper.searchByKey(page, "排球");
        return iPage;
    }
    @Override
    public Page<TeamVO> getListBadminton(Page<TeamVO> page, String tab) {
        Page<TeamVO> iPage = this.baseMapper.searchByKey(page, "羽毛球");
        return iPage;
    }
    @Override
    public Page<TeamVO> getListPingPong(Page<TeamVO> page, String tab) {
        Page<TeamVO> iPage = this.baseMapper.searchByKey(page, "乒乓球");
        return iPage;
    }
    @Override
    public Page<TeamVO> getListTennis(Page<TeamVO> page, String tab) {
        Page<TeamVO> iPage = this.baseMapper.searchByKey(page, "网球");
        return iPage;
    }
    @Override
    public Page<TeamVO> getListOther(Page<TeamVO> page, String tab) {
        Page<TeamVO> iPage = this.baseMapper.searchByKey2(page, "其他");
        return iPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BmsTeam create(CreateTeamDTO dto, UmsUser user) {
//        BmsTeam team1 = this.baseMapper.selectOne(new LambdaQueryWrapper<BmsTeam>().eq(BmsTeam::getTitle, dto.getTitle()));
//        Assert.isNull(team1, "话题已存在，请修改");
        // 封装
        BmsTeam team = BmsTeam.builder()
                .userId(user.getId())
                .title(dto.getTitle())
                .tags(dto.getTags())
                .createTime(new Date())
                .view(dto.getView())
                .build();
        this.baseMapper.insert(team);
        return team;
    }
    @Override
    public Map<String, Object> viewTeam(String id) {
        Map<String, Object> map = new HashMap<>(16);
        BmsTeam team = this.baseMapper.selectById(id);
        Assert.notNull(team, "当前话题不存在,或已被作者删除");
        // 查询话题详情
//        team.setView(team.getView() + 1);
        this.baseMapper.updateById(team);
        map.put("team", team);
        ProfileVO user = iUmsUserService.getUserProfile(team.getUserId());
        map.put("user", user);
        return map;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BmsTeam join(BmsTeam byId, UmsUser user) {
//        team.setModifyTime(new Date());
//        iBmsTeamService.updateById(team);
//        return ApiResult.success(team);
//        byId.setModifyTime();
        // 封装
        BmsTeam team = BmsTeam.builder()
                .userId(user.getId())
                .title(byId.getTitle())
                .tags(byId.getTags())
                .createTime(byId.getCreateTime())
                .view(byId.getView())
                .isteam(1)
                .build();
        team.setModifyTime(new Date());
        this.baseMapper.insert(team);

        return team;
    }
}