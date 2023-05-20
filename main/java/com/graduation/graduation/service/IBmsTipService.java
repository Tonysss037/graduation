package com.graduation.graduation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.graduation.model.entity.BmsTip;

public interface IBmsTipService extends IService<BmsTip> {
    BmsTip getRandomTip();
}