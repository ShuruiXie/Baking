package org.example.finaldemo01.pojo.vo;

import lombok.Data;

//@Data
public class BannerVO {
    private Long id;
    /**
     * 轮播图的存储路径
     */
    private String imgUrl;

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
}
