package org.example.finaldemo01.Controller;


import org.example.finaldemo01.mapper.ContentMapper;
import org.example.finaldemo01.pojo.dto.ContentDTO;
import org.example.finaldemo01.pojo.entity.Content;
import org.example.finaldemo01.pojo.vo.ContentIndexVO;
import org.example.finaldemo01.pojo.vo.ContentUpdateVO;
import org.example.finaldemo01.pojo.vo.UserVO;
import org.example.finaldemo01.response.JsonResult;
import org.example.finaldemo01.response.StatusCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/contents")
public class ContentController {

    @Autowired
    private ContentMapper contentMapper;

    //发布新稿件
    @PostMapping("add-new")
    public JsonResult addNew(@RequestBody ContentDTO contentDTO, HttpSession session){
        Content content = new Content();
        BeanUtils.copyProperties(contentDTO,content);
        if(contentDTO.getId()!=null){
            UserVO user = (UserVO)session.getAttribute("user");
            content.setUpdateTime(new Date());
            contentMapper.updateContentInfo(content);
            return JsonResult.ok();
        }
        content.setCreateTime(new Date());
        contentMapper.insertContent(content);
        return JsonResult.ok();
    }

    //个人稿件管理
    @GetMapping("/{type}/management")
    public JsonResult management(@PathVariable int type, HttpSession session){
        UserVO user = (UserVO) session.getAttribute("user");

        if (user == null) {
            System.out.println("User is null");
            return new JsonResult(StatusCode.USERNAME_ERROR);
        }
        return JsonResult.ok(contentMapper.selectContentByTypeAndUserId(type, user.getId()));
    }

    //修改个人稿件
    @GetMapping("/{id}/update")
    public JsonResult selectForUpdate(@PathVariable Long id){
        return JsonResult.ok(contentMapper.selectUpdateInfoById(id));
    }

    //删除个人稿件
    @PostMapping("/{id}/delete")
    public JsonResult delete(@PathVariable Long id){
        ContentUpdateVO contentUpdateVO = contentMapper.selectUpdateInfoById(id);
        new File("D:/Desktop/file + contentUpdateVO.file").delete();
        if(contentUpdateVO.getType()==2){
            new File("D:/Desktop/file + contentUpdateVO.videoUrl").delete();
        }
        contentMapper.deleteContentById(id);
        return JsonResult.ok();
    }


    //首页根据一级分类查询该分类下的所有稿件
    @GetMapping("/{type}/{categoryId}/index")
    public JsonResult selectIndex(@PathVariable int type, @PathVariable Long categoryId){
        List<ContentIndexVO>list = contentMapper.selectContentByTypeAndCategoryId(type, categoryId);
        return JsonResult.ok(list);
    }

    //根据稿件的id查询稿件详细内容
    @GetMapping("{id}/detail")
    public JsonResult selectDetail(@PathVariable Long id){
        contentMapper.updateViewCountById(id);
        return JsonResult.ok(contentMapper.selectContentDetailById(id));

    }

    //根据作者id查询作者的其他稿件
    @GetMapping("{userId}/{contentId}/other")
    public JsonResult selectOther(@PathVariable Long userId, @PathVariable Long contentId){
        return JsonResult.ok(contentMapper.selectContentOtherInfoByUserId(userId, contentId));
    }

    //首页最上面的选择分类
    @GetMapping("{type}/list")
    public JsonResult selectList(@PathVariable int type){

        return JsonResult.ok(contentMapper.selectContentByType(type));
    }

    @GetMapping("{wd}/search")
    public JsonResult selectSearch(@PathVariable String wd){
        return JsonResult.ok(contentMapper.selectContentByWd(wd));
    }

    @GetMapping("hot")
    public JsonResult selectHot(){
        return JsonResult.ok(contentMapper.selectContentHot());
    }


}
