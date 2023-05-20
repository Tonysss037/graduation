package com.graduation.graduation.controller;


import com.graduation.graduation.common.api.ApiResult;
import com.graduation.graduation.model.dto.RegisterDTO;
import com.graduation.graduation.model.entity.BmsClubMember;
import com.graduation.graduation.model.entity.BmsTeam;
import com.graduation.graduation.model.entity.UmsUser;
import com.graduation.graduation.service.IBmsClubMemberService;
import com.graduation.graduation.service.IBmsTeamService;
import com.graduation.graduation.service.IUmsUserService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import com.graduation.graduation.model.dto.LoginDTO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduation.graduation.model.entity.BmsPost;
import com.graduation.graduation.service.IBmsPostService;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.Assert;
import static com.graduation.graduation.jwt.JwtUtil.USER_NAME;


@RestController
@RequestMapping("/ums/user")
public class UmsUserController extends BaseController {
    @Resource
    private IUmsUserService iUmsUserService;
    @Resource
    private IBmsPostService iBmsPostService;
    @Resource
    private IBmsTeamService iBmsTeamService;
    @Resource
    private IBmsClubMemberService iBmsClubMemberService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> register(@Valid @RequestBody RegisterDTO dto) {
        UmsUser user = iUmsUserService.executeRegister(dto);
        if (ObjectUtils.isEmpty(user)) {
            return ApiResult.failed("账号注册失败");
        }
        Map<String, Object> map = new HashMap<>(16);
        map.put("user", user);
        return ApiResult.success(map);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult<Map<String, String>> login(@Valid @RequestBody LoginDTO dto) {
        String token = iUmsUserService.executeLogin(dto);
        if (ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("账号密码错误");
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("token", token);
        return ApiResult.success(map, "登录成功");
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ApiResult<UmsUser> getUser(@RequestHeader(value = USER_NAME) String userName) {
        UmsUser user = iUmsUserService.getUserByUsername(userName);
        return ApiResult.success(user);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ApiResult<Object> logOut() {
        return ApiResult.success(null, "注销成功");
    }

    @GetMapping("/{username}")
    public ApiResult<Map<String, Object>> getUserByName(@PathVariable("username") String username,
                                                        @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        UmsUser user = iUmsUserService.getUserByUsername(username);
        Assert.notNull(user, "用户不存在");
        Page<BmsPost> page = iBmsPostService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<BmsPost>().eq(BmsPost::getUserId, user.getId())
                        .orderByDesc(BmsPost::getCreateTime));
        map.put("user", user);
        map.put("topics", page);
        return ApiResult.success(map);
    }
    @GetMapping("/T/{username}")
    public ApiResult<Map<String, Object>> getUserByNameT(@PathVariable("username") String username,
                                                        @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        UmsUser user = iUmsUserService.getUserByUsername(username);
        Assert.notNull(user, "用户不存在");
        Page<BmsTeam> page = iBmsTeamService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<BmsTeam>().eq(BmsTeam::getUserId, user.getId())
                        .orderByDesc(BmsTeam::getCreateTime));
        map.put("user", user);
        map.put("teams", page);
        return ApiResult.success(map);
    }
    @GetMapping("/C/{username}")
    public ApiResult<Map<String, Object>> getUserByNameC(@PathVariable("username") String username,
                                                         @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {

        Map<String, Object> map = new HashMap<>(16);
        UmsUser user = iUmsUserService.getUserByUsername(username);
        Assert.notNull(user, "用户不存在");
        Page<BmsClubMember> page = iBmsClubMemberService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<BmsClubMember>().eq(BmsClubMember::getUserId, user.getId())
                        .orderByDesc(BmsClubMember::getJoinTime));
        map.put("user", user);
        map.put("clubs", page);
        return ApiResult.success(map);
    }
    @PostMapping("/update")
    public ApiResult<UmsUser> updateUser(@RequestBody UmsUser umsUser) {
        iUmsUserService.updateById(umsUser);
        return ApiResult.success(umsUser);
    }
}