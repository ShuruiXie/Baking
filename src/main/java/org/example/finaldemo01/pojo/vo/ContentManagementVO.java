package org.example.finaldemo01.pojo.vo;

import lombok.Data;

import java.util.Date;

//@Data
public class ContentManagementVO {
    private Long id;
    /**
     * 稿件标题
     */
    private String title;
    /**
     * 稿件封面(存储的是图片的路径)
     */
    private String imgUrl;
    /**
     * 稿件的一级分类
     * 1 → 食谱
     * 2 → 视频
     * 3 → 咨询
     * 优点: ①节省存储空间 ②查询性能优秀 ③后期维护方便
     */
    private Long type;
    /**
     * 访问量,新发布的稿件,访问量默认为0
     */
    private Integer viewCount;
    /**
     * 评论量,新发布的稿件,评论量默认为0
     */
    private Integer commentCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 摘要
     * 截取文章的前部分内容(无须考虑)
     */
    private String brief;
    /**
     *  category_id 关联t_category表的二级分类id
     *  通过关联的id获取对应的 分类二级标签 传入categoryName
     */
    private String categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCategoryName() {
        return categoryId;
    }

    public void setCategoryName(String categoryId) {
        this.categoryId = categoryId;
    }
}
