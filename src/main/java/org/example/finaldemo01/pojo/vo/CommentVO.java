package org.example.finaldemo01.pojo.vo;

import lombok.Data;

import java.util.Date;

//@Data
public class CommentVO {
    private Long id;
    /*评论内容*/
    private String content;
    /*评论者的昵称*/
    private String nickname;
    /*评论者的头像图片路径*/
    private String userImgUrl;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
