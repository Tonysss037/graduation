//package com.graduation.graduation.controller;
//
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.vdurmont.emoji.EmojiParser;
//import com.wky.seuprojectbackend.common.api.ApiResult;
//import com.wky.seuprojectbackend.model.dto.CreateTopicDTO;
//import com.wky.seuprojectbackend.model.entity.Post;
//import com.wky.seuprojectbackend.model.entity.User;
//import com.wky.seuprojectbackend.model.vo.PostVO;
//import com.wky.seuprojectbackend.service.PostService;
//import com.wky.seuprojectbackend.service.UserService;
//import org.springframework.util.Assert;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//
//import java.util.Date;
//import java.util.Map;
//
//import static com.wky.seuprojectbackend.jwt.JwtUtil.USER_NAME;
//
///**
// * @author WuKangyu
// * @create 2022/2/5
// */
//
//@RestController
//@RequestMapping("/post")
//public class PostController extends BaseController{
//
//    @Resource
//    private PostService postService;
//
//    @Resource
//    private UserService userService;
//
//    @GetMapping("/list")
//    public ApiResult<Page<PostVO>> list(@RequestParam(value = "tab", defaultValue = "latest") String tab,
//                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
//                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
//        Page<PostVO> list = postService.getList(new Page<>(pageNo, pageSize), tab);
//        return ApiResult.success(list);
//    }
//
//    @GetMapping("/listbasketball")
//    public ApiResult<Page<PostVO>> listbasketball
//                                        (@RequestParam(value = "tab", defaultValue = "latest") String tab,
//                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
//                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
//        Page<PostVO> list = postService.getListbasketball(new Page<>(pageNo, pageSize), tab);
//        return ApiResult.success(list);
//    }
//
//    @GetMapping("/listfootball")
//    public ApiResult<Page<PostVO>> listfootball
//            (@RequestParam(value = "tab", defaultValue = "latest") String tab,
//             @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
//             @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
//        Page<PostVO> list = postService.getListfootball(new Page<>(pageNo, pageSize), tab);
//        return ApiResult.success(list);
//    }
//
//    @GetMapping("/listvolleyball")
//    public ApiResult<Page<PostVO>> listvolleyball
//            (@RequestParam(value = "tab", defaultValue = "latest") String tab,
//             @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
//             @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
//        Page<PostVO> list = postService.getListvolleyball(new Page<>(pageNo, pageSize), tab);
//        return ApiResult.success(list);
//    }
//
//    @GetMapping("/listbadmintonball")
//    public ApiResult<Page<PostVO>> listbadmintonball
//            (@RequestParam(value = "tab", defaultValue = "latest") String tab,
//             @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
//             @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
//        Page<PostVO> list = postService.getListbadmintonball(new Page<>(pageNo, pageSize), tab);
//        return ApiResult.success(list);
//    }
//
//    @GetMapping("/listpingpongball")
//    public ApiResult<Page<PostVO>> listpingpongball
//            (@RequestParam(value = "tab", defaultValue = "latest") String tab,
//             @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
//             @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
//        Page<PostVO> list = postService.getListpingpongball(new Page<>(pageNo, pageSize), tab);
//        return ApiResult.success(list);
//    }
//
//    @GetMapping("/listtennisball")
//    public ApiResult<Page<PostVO>> listtennisball
//            (@RequestParam(value = "tab", defaultValue = "latest") String tab,
//             @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
//             @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
//        Page<PostVO> list = postService.getListtennisball(new Page<>(pageNo, pageSize), tab);
//        return ApiResult.success(list);
//    }
//
//    @GetMapping("/listother")
//    public ApiResult<Page<PostVO>> listother
//            (@RequestParam(value = "tab", defaultValue = "latest") String tab,
//             @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
//             @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
//        Page<PostVO> list = postService.getListother(new Page<>(pageNo, pageSize), tab);
//        return ApiResult.success(list);
//    }
//
//    @GetMapping("/listbycomment")
//    public ApiResult<Page<PostVO>> listbycomment(@RequestParam(value = "tab", defaultValue = "latest") String tab,
//                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
//                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
//        Page<PostVO> list = postService.getListbycomment(new Page<>(pageNo, pageSize), tab);
//        return ApiResult.success(list);
//    }
//
//    @GetMapping("/listbyviews")
//    public ApiResult<Page<PostVO>> listbyviews(@RequestParam(value = "tab", defaultValue = "latest") String tab,
//                                                 @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
//                                                 @RequestParam(value = "size", defaultValue = "10") Integer pageSize){
//        Page<PostVO> list = postService.getListbyviews(new Page<>(pageNo, pageSize), tab);
//        return ApiResult.success(list);
//    }
//
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public ApiResult<Post> create(@RequestHeader(value = USER_NAME) String userName
//            , @RequestBody CreateTopicDTO dto) {
//        User user = userService.getUserByUsername(userName);
//        Post topic = postService.create(dto, user);
//        return ApiResult.success(topic);
//    }
//
//    @GetMapping()
//    public ApiResult<Map<String,Object>> view(@RequestParam("id") String id){
//        Map<String,Object> map=postService.viewTopic(id);
//        return ApiResult.success(map);
//    }
//
//    @PostMapping("/update")
//    public ApiResult<Post> update(@RequestHeader(value = USER_NAME) String userName, @Valid @RequestBody Post post) {
//        User umsUser = userService.getUserByUsername(userName);
//        Assert.isTrue(umsUser.getId().equals(post.getUserId()), "非本人无权修改");
//        post.setModifyTime(new Date());
//        post.setContent(EmojiParser.parseToAliases(post.getContent()));
//        postService.updateById(post);
//        return ApiResult.success(post);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ApiResult<String> delete(@RequestHeader(value = USER_NAME) String userName, @PathVariable("id") String id) {
//        User umsUser = userService.getUserByUsername(userName);
//        Post byId = postService.getById(id);
//        Assert.notNull(byId, "来晚一步，话题已不存在");
//        Assert.isTrue(byId.getUserId().equals(umsUser.getId()), "你为什么可以删除别人的话题？？？");
//        postService.removeById(id);
//        postService.deleteCommentswhiledeletePost(id);
//        return ApiResult.success(null,"删除成功");
//    }
//
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
//
//    @DeleteMapping("/join2/{id}")
//    public ApiResult<String> jointhem2(@PathVariable("id") String id) {
////        User umsUser = userService.getUserByUsername(userName);
////        Post byId = postService.getById(id);
////        Assert.notNull(byId, "来晚一步，话题已不存在");
////        Assert.isTrue(byId.getUserId().equals(umsUser.getId()), "你为什么可以删除别人的话题？？？");
//        postService.jointhem2(id);
////        postService.deleteCommentswhiledeletePost(id);
//        return ApiResult.success(null,"成功");
//    }
//}
//
//
//
