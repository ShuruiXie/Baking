package org.example.finaldemo01.Controller;


import org.example.finaldemo01.response.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RequestMapping("/v1")
@RestController
public class UploadController {

    private String filePath="D:/Desktop/file";

    @PostMapping("/upload")
    public JsonResult upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        //截取名称后缀留下
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //生成新的文件名
        String newFileName = UUID.randomUUID() + suffix;
        //保存文件
        File dirFile = new File(filePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        file.transferTo(new File(dirFile + fileName));

        return  JsonResult.ok();
    }
}
