package org.example.finaldemo01.Controller;

import org.example.finaldemo01.mapper.BannerMapper;
import org.example.finaldemo01.pojo.vo.BannerAdminVO;
import org.example.finaldemo01.pojo.vo.BannerVO;
import org.example.finaldemo01.response.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 28293
 */
@RestController
@RequestMapping("/v1/banners")
public class BannerController {

    @Autowired
    private BannerMapper bannerMapper;

    @GetMapping
    public JsonResult select(){
        List<BannerVO> list =bannerMapper.selectAll();
        return JsonResult.ok(list);
    }

    @GetMapping("/admin")
    public JsonResult selectForAdmin() {
        List<BannerAdminVO> list = bannerMapper.selectForAdmin();
        return JsonResult.ok(list);
    }

    @GetMapping("/{id}/delete")
    public JsonResult delete(@PathVariable long id) {
        bannerMapper.deleteById(id);
        return JsonResult.ok();
    }


}
