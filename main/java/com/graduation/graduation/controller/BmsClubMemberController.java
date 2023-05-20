package com.graduation.graduation.controller;

import com.graduation.graduation.common.api.ApiResult;
import com.graduation.graduation.mapper.BmsClubMapper;
import com.graduation.graduation.model.entity.BmsClub;
import com.graduation.graduation.model.entity.BmsClubMember;
import com.graduation.graduation.model.entity.BmsTeam;
import com.graduation.graduation.model.entity.UmsUser;
import com.graduation.graduation.service.IBmsClubService;
import com.graduation.graduation.service.IBmsClubMemberService;
import com.graduation.graduation.service.IUmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.graduation.graduation.jwt.JwtUtil.USER_NAME;


@RestController
@RequestMapping("/club")
public class BmsClubMemberController extends BaseController {
    @Resource
    private IBmsClubMemberService iBmsClubMemberService;
    @Resource
    private IBmsClubService iBmsClubService;
    @Autowired
    private BmsClubMapper bmsClubMemberMapper;
    @Resource
    private IUmsUserService umsUserService;

    @RequestMapping(value = "/join/{id}", method = RequestMethod.POST)
    public ApiResult<BmsClubMember> join(@RequestHeader(value = USER_NAME) String userName, @PathVariable("id") String id) {
        UmsUser user = umsUserService.getUserByUsername(userName);
        BmsClub byId = iBmsClubService.getById(id);
        BmsClubMember clubMember = iBmsClubMemberService.join(byId, user);
        return ApiResult.success(clubMember);
    }
    @DeleteMapping("/member/delete/{id}")
    public ApiResult<String> delete(@RequestHeader(value = USER_NAME) String userName, @PathVariable("id") String id) {
        UmsUser umsUser = umsUserService.getUserByUsername(userName);
        BmsClubMember byId = iBmsClubMemberService.getById(id);
        Assert.notNull(byId, "来晚一步，话题已不存在");
        Assert.isTrue(byId.getUserId().equals(umsUser.getId()), "你为什么可以删除别人的话题？？？");
        iBmsClubMemberService.removeById(id);
        return ApiResult.success(null,"删除成功");
    }
    //    @PostMapping(value = "/create")
//    public ApiResult<BmsClub> create(@RequestBody BmsClub club) {
//        BmsClub club = bmsClubService.create(club);
//        return ApiResult.success(club);
//    }
//    @PostMapping
//    public void save(@RequestBody BmsClub club){
//        bmsClubService.save(club);
//    }


}