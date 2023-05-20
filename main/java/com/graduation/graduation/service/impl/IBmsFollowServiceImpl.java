package com.graduation.graduation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.graduation.mapper.BmsFollowMapper;
import com.graduation.graduation.model.entity.BmsFollow;
import com.graduation.graduation.service.IBmsFollowService;
import org.springframework.stereotype.Service;


@Service
public class IBmsFollowServiceImpl extends ServiceImpl<BmsFollowMapper, BmsFollow> implements IBmsFollowService {
}