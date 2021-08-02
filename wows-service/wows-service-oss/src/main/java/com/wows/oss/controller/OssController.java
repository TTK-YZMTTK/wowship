package com.wows.oss.controller;


import com.wows.commonutils.Ret;
import com.wows.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/wowsservice/fileoss")
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping
    public Ret uploadOssFile(MultipartFile file){
        String url  = ossService.uploadShipDescription(file);
        return Ret.ok().data("url",url);
    }



}
