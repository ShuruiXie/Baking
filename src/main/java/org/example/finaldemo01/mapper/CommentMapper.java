package org.example.finaldemo01.mapper;

import org.example.finaldemo01.pojo.entity.Comment;
import org.example.finaldemo01.pojo.vo.CategoryVO;
import org.example.finaldemo01.pojo.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     * 新增评论
     * @param comment 传入过来一个评论对象
     * @return
     */
    int insertComment(Comment comment);

    /**
     *  查询一个稿件的所有评论
     * @param contentId 传入一个稿件id
     * @return
     */
    List<CommentVO> selectCommentByContentId(Long contentId);
}
