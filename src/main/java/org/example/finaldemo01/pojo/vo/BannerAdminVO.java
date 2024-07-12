package org.example.finaldemo01.pojo.vo;

import lombok.Data;

import java.util.Date;

//@Data
public class BannerAdminVO {
    private Long id;
    /**
     * 轮播图的存储路径
     */
    private String imgUrl;
    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
