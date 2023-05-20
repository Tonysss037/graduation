package com.graduation.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.graduation.common.api.ApiResult;
import com.graduation.graduation.model.dto.CreateTeamDTO;
import com.graduation.graduation.model.dto.CreateTopicDTO;
import com.graduation.graduation.model.entity.BmsPost;
import com.graduation.graduation.model.entity.BmsTeam;
import com.graduation.graduation.model.entity.UmsUser;
import com.graduation.graduation.model.vo.TeamVO;
import com.graduation.graduation.service.IBmsTeamService;
import com.graduation.graduation.service.IUmsUserService;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.graduation.graduation.jwt.JwtUtil.USER_NAME;


@RestController
@RequestMapping("/team")
public class BmsTeamController extends BaseController {

    @Resource
    private IBmsTeamService iBmsTeamService;
    @Resource
    private IUmsUserService umsUserService;


    @GetMapping("/list/football")
    public ApiResult<Page<TeamVO>> listFootball(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                                  @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                                  @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<TeamVO> list = iBmsTeamService.getListFootball(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }
    @GetMapping("/list/basketball")
    public ApiResult<Page<TeamVO>> listBasketball(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                                  @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                                  @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<TeamVO> list = iBmsTeamService.getListBasketball(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }
    @GetMapping("/list/volleyball")
    public ApiResult<Page<TeamVO>> listVolleyball(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                                  @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                                  @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<TeamVO> list = iBmsTeamService.getListVolleyball(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }
    @GetMapping("/list/badminton")
    public ApiResult<Page<TeamVO>> listBadminton(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                                  @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                                  @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<TeamVO> list = iBmsTeamService.getListBadminton(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }
    @GetMapping("/list/pingpong")
    public ApiResult<Page<TeamVO>> listPingPong(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                                 @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                                 @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<TeamVO> list = iBmsTeamService.getListPingPong(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }
    @GetMapping("/list/tennis")
    public ApiResult<Page<TeamVO>> listTennis(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                                @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                                @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<TeamVO> list = iBmsTeamService.getListTennis(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }
    @GetMapping("/list/other")
    public ApiResult<Page<TeamVO>> listOther(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                              @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                              @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<TeamVO> list = iBmsTeamService.getListOther(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult<BmsTeam> create(@RequestHeader(value = USER_NAME) String userName
            , @RequestBody CreateTeamDTO dto) {
        UmsUser user = umsUserService.getUserByUsername(userName);
        BmsTeam team = iBmsTeamService.create(dto, user);
        return ApiResult.success(team);
    }
    @GetMapping()
    public ApiResult<Map<String, Object>> view(@RequestParam("id") String id) {
        Map<String, Object> map = iBmsTeamService.viewTeam(id);
        return ApiResult.success(map);
    }

    @PostMapping("/update")
    public ApiResult<BmsTeam> update(@RequestHeader(value = USER_NAME) String userName, @Valid @RequestBody BmsTeam team) {
        UmsUser umsUser = umsUserService.getUserByUsername(userName);
        Assert.isTrue(umsUser.getId().equals(team.getUserId()), "非本人无权修改");
        team.setModifyTime(new Date());
        iBmsTeamService.updateById(team);
        return ApiResult.success(team);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResult<String> delete(@RequestHeader(value = USER_NAME) String userName, @PathVariable("id") String id) {
        UmsUser umsUser = umsUserService.getUserByUsername(userName);
        BmsTeam byId = iBmsTeamService.getById(id);
        Assert.notNull(byId, "来晚一步，话题已不存在");
        Assert.isTrue(byId.getUserId().equals(umsUser.getId()), "你为什么可以删除别人的话题？？？");
        iBmsTeamService.removeById(id);
        return ApiResult.success(null,"删除成功");
    }

//    @DeleteMapping("/join/{id}")
//    public ApiResult<String> jointhem(@PathVariable("id") String id) {
//        postService.jointhem(id);
//        return ApiResult.success(null,"加入成功");
//    }
    @RequestMapping(value = "/join/{id}", method = RequestMethod.POST)
    public ApiResult<BmsTeam> join(@RequestHeader(value = USER_NAME) String userName,@PathVariable("id") String id) {
        UmsUser user = umsUserService.getUserByUsername(userName);
        BmsTeam byId = iBmsTeamService.getById(id);
        byId.setModifyTime(new Date());
        byId.setView(byId.getView() + 1);
        iBmsTeamService.updateById(byId);
        BmsTeam team = iBmsTeamService.join(byId, user);
        return ApiResult.success(team);
    }
//    @DeleteMapping("/join/{id}")
//    public ApiResult<String> jointhem(@PathVariable("id") String id) {
////        User umsUser = userService.getUserByUsername(userName);
////        Post byId = postService.getById(id);
////        Assert.notNull(byId, "来晚一步，话题已不存在");
////        Assert.isTrue(byId.getUserId().equals(umsUser.getId()), "你为什么可以删除别人的话题？？？");
//            postService.jointhem(id);
////        postService.deleteCommentswhiledeletePost(id);
//        return ApiResult.success(null,"加入成功");
//    }

//    @DeleteMapping("/join2/{id}")
//    public ApiResult<String> jointhem2(@PathVariable("id") String id) {
//        postService.jointhem2(id);
//        return ApiResult.success(null, "成功");
//    }




}