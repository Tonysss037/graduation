package com.graduation.graduation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.graduation.graduation.model.entity.BmsComment;
import com.graduation.graduation.model.dto.CommentDTO;
import com.graduation.graduation.model.vo.CommentVO;
import com.graduation.graduation.model.entity.UmsUser;
import java.util.List;


public interface IBmsCommentService extends IService<BmsComment> {
    /**
     *
     *
     * @param topicid
     * @return {@link BmsComment}
     */
    List<CommentVO> getCommentsByTopicID(String topicid);

    BmsComment create(CommentDTO dto, UmsUser principal);
}