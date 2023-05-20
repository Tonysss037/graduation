package com.graduation.graduation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.graduation.model.entity.BmsClub;
import com.graduation.graduation.model.entity.BmsClubMember;
import com.graduation.graduation.model.entity.UmsUser;


public interface IBmsClubMemberService extends IService<BmsClubMember> {
    /**
     * 加入活动
     *
     * @param byId
     * @param principal
     * @return
     */
    BmsClubMember join(BmsClub byId, UmsUser principal);
}