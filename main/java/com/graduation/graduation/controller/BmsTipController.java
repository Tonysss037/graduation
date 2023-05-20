package com.graduation.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.graduation.graduation.common.api.ApiResult;
import com.graduation.graduation.model.entity.BmsBillboard;
import com.graduation.graduation.model.entity.BmsTip;
import com.graduation.graduation.service.IBmsBillboardService;
import com.graduation.graduation.service.IBmsTipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tip")
public class BmsTipController extends BaseController {
    @Resource
    private IBmsTipService bmsTipService;

    @GetMapping("/today")
    public ApiResult<BmsTip> getRandomTip() {
        BmsTip tip = bmsTipService.getRandomTip();
        return ApiResult.success(tip);
    }
}