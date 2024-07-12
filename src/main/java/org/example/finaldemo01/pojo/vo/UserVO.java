package org.example.finaldemo01.pojo.vo;

import lombok.Data;

/**
 * userVO  封装后端查询的数据 并返回给前端的类 统称为XXXVO类
 */
//@Data
public class UserVO {
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String password;

    private String nickName;
    /**
     * 是否是管理员
     * 0 → 普通用户(默认值)
     * 1 → 管理员
     */
    private Integer isAdmin;
    /**
     * 头像路径
     */
    private String imgUrl;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
