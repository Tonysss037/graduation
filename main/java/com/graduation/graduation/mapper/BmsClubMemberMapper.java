package com.graduation.graduation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduation.graduation.model.entity.BmsClub;
import com.graduation.graduation.model.entity.BmsClubMember;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BmsClubMemberMapper extends BaseMapper<BmsClubMember> {
}