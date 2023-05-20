package com.graduation.graduation.controller;

import com.graduation.graduation.common.api.ApiResult;
import com.graduation.graduation.mapper.BmsClubMapper;
import com.graduation.graduation.model.dto.CreateTopicDTO;
import com.graduation.graduation.model.entity.*;
import com.graduation.graduation.model.vo.ClubMemberVO;
import com.graduation.graduation.service.IBmsClubService;
import com.graduation.graduation.service.IBmsPromotionService;
import com.graduation.graduation.service.IUmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.graduation.graduation.jwt.JwtUtil.USER_NAME;


@RestController
@RequestMapping("/club")
public class BmsClubController extends BaseController {

    @Resource
    private IBmsClubService iBmsClubService;
    @Resource
    private IBmsClubService iBmsClubMemberService;
    @Autowired
    private BmsClubMapper bmsClubMapper;
    @Resource
    private IUmsUserService umsUserService;

    @GetMapping("/list")
    public ApiResult<List<BmsClub>> list() {
        List<BmsClub> list = iBmsClubService.list();
        return ApiResult.success(list);
    }
    @GetMapping("/getClub")
    public ApiResult<BmsClub> view(@RequestParam("date") String date) {
        BmsClub club =  bmsClubMapper.selectByDate(date);
        return ApiResult.success(club);
    }
//    @RequestMapping(value = "/join/{id}", method = RequestMethod.POST)
//    public ApiResult<BmsClubMember> join(@RequestHeader(value = USER_NAME) String userName, @PathVariable("id") String id) {
//        UmsUser user = umsUserService.getUserByUsername(userName);
//        BmsClub byId = iBmsClubMemberService.getById(id);
//        BmsClubMember clubMember = iBmsClubMemberService.join(byId, user);
//        return ApiResult.success(clubMember);
//    }
    //    @PostMapping(value = "/create")
//    public ApiResult<BmsClub> create(@RequestBody BmsClub club) {
//        BmsClub club = bmsClubService.create(club);
//        return ApiResult.success(club);
//    }

}