package com.graduation.graduation.controller;

import com.graduation.graduation.common.api.ApiResult;
import com.graduation.graduation.model.entity.BmsPromotion;
import com.graduation.graduation.service.IBmsPromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/promotion")
public class BmsPromotionController extends BaseController {

    @Resource
    private IBmsPromotionService bmsPromotionService;

    @GetMapping("/all")
    public ApiResult<List<BmsPromotion>> list() {
        List<BmsPromotion> list = bmsPromotionService.list();
        return ApiResult.success(list);
    }

}