package org.example.finaldemo01.pojo.entity;

import lombok.Data;

import java.util.Date;
//@Data
public class Comment {
    private Long id;
    /*评论内容*/
    private String content;
    /*评论者id*/
    private Long userId;
    /*评论所属稿件id*/
    private Integer contentId;
    /*评论创建时间*/
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
