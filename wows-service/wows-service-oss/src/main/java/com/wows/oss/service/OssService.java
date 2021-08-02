package com.wows.oss.service;


import org.springframework.web.multipart.MultipartFile;


public interface OssService {

    String uploadShipDescription(MultipartFile file) ;


}
