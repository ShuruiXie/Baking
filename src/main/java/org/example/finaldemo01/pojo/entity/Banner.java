package org.example.finaldemo01.pojo.entity;

import lombok.Data;

import java.util.Date;
//@Data
public class Banner {
    private Long id;
    /**
     * 轮播图的存储路径
     */
    private String imgUrl;
    /**
     * 轮播图的现实顺序
     */
    private Integer sort;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
