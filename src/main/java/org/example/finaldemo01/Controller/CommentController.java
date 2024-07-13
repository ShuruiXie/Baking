package org.example.finaldemo01.Controller;


import org.example.finaldemo01.mapper.CommentMapper;
import org.example.finaldemo01.mapper.ContentMapper;
import org.example.finaldemo01.pojo.dto.CommentDTO;
import org.example.finaldemo01.pojo.entity.Comment;
import org.example.finaldemo01.pojo.vo.UserVO;
import org.example.finaldemo01.response.JsonResult;
import org.example.finaldemo01.response.StatusCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("v1/comments")
public class CommentController {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    private ContentMapper contentMapper;

    @PostMapping("add-new")
    public JsonResult addNew(@RequestBody CommentDTO commentDTO, HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute("user");
        if(userVO == null){
            return new JsonResult(StatusCode.NOT_LOGIN);
        }
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO,comment);
        comment.setCreateTime(new Date());
        System.out.println(comment.getContentId());
        commentMapper.insertComment(comment);
        contentMapper.updateCommentCountById(commentDTO.getContentId());
        return JsonResult.ok();

    }

    @GetMapping("{id}")
    public JsonResult select(@PathVariable Long id){
        return JsonResult.ok(commentMapper.selectCommentByContentId(id));
    }
}
