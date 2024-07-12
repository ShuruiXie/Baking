package org.example.finaldemo01.pojo.vo;

import lombok.Data;

//@Data
public class CategoryVO {
    /**
     * 分类编号
     */
    private Integer id;
    /**
     * 分类名
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
