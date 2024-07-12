package org.example.finaldemo01.Controller;


import org.example.finaldemo01.mapper.CategoryMapper;
import org.example.finaldemo01.response.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;


    @GetMapping("/{type}/sub")
    public JsonResult sub(@PathVariable Integer type) {
        return JsonResult.ok(categoryMapper.selectCategoryByType(type));
    }



}
