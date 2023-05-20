package com.graduation.graduation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.graduation.mapper.BmsClubMapper;
import com.graduation.graduation.mapper.BmsClubMemberMapper;
import com.graduation.graduation.mapper.UmsUserMapper;
import com.graduation.graduation.model.entity.BmsClub;
import com.graduation.graduation.model.entity.BmsClubMember;
import com.graduation.graduation.model.entity.UmsUser;
import com.graduation.graduation.service.IBmsClubMemberService;
import com.graduation.graduation.service.IBmsClubService;
import com.graduation.graduation.service.IUmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class IBmsClubMemberServiceImpl extends ServiceImpl<BmsClubMemberMapper, BmsClubMember> implements IBmsClubMemberService {
    @Resource
    private UmsUserMapper umsUserMapper;
    @Autowired
    private IUmsUserService iUmsUserService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BmsClubMember join(BmsClub byId, UmsUser user) {
        // 封装
        BmsClubMember clubMember = BmsClubMember.builder()
                .userId(user.getId())
                .clubId(byId.getId())
                .date(byId.getDate())
                .content(byId.getContent())
                .societies(byId.getSocieties())
                .place(byId.getPlace())
                .beginTime(byId.getBeginTime())
                .endTime(byId.getEndTime())
                .build();
        clubMember.setJoinTime(new Date());
        this.baseMapper.insert(clubMember);
        return clubMember;
    }
}