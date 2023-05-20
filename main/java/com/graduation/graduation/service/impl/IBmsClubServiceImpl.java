package com.graduation.graduation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.graduation.mapper.BmsClubMapper;
import com.graduation.graduation.mapper.BmsTagMapper;
import com.graduation.graduation.mapper.UmsUserMapper;
import com.graduation.graduation.model.entity.*;
import com.graduation.graduation.model.vo.ClubMemberVO;
import com.graduation.graduation.model.vo.ProfileVO;
import com.graduation.graduation.service.IBmsClubService;
import com.graduation.graduation.service.IBmsTagService;
import com.graduation.graduation.service.IUmsUserService;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.*;


@Service
public class IBmsClubServiceImpl extends ServiceImpl<BmsClubMapper, BmsClub> implements IBmsClubService {
    @Resource
    private UmsUserMapper umsUserMapper;
    @Autowired
    private IUmsUserService iUmsUserService;

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public BmsClubMember join(BmsClub byId, UmsUser user) {
//        // 封装
//        BmsClubMember clubMember = BmsClubMember.builder()
//                .userId(user.getId())
//                .clubId(byId.getId())
//                .build();
//        clubMember.setJoinTime(new Date());
//        this.baseMapper.insert(clubMember);
//
//        return clubMember;
//    }
}