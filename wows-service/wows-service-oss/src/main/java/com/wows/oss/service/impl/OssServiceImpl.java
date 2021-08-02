package com.wows.oss.service.impl;



import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.wows.oss.service.OssService;
import com.wows.oss.util.ConstantPropertiesUtils;
import org.springframework.stereotype.Service;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {


    @Override
    public String uploadShipDescription(MultipartFile file) {

        String endpoint = ConstantPropertiesUtils.END_POIND;
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            InputStream inputStream = file.getInputStream();
            String fileName = file.getName();
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            fileName = uuid + fileName;
            String datePath = new DateTime().toString("yyyy/MM/dd");
            fileName = datePath +"/"+ fileName;
            ossClient.putObject(bucketName,fileName,inputStream);
            ossClient.shutdown();
            String url = "https://"+bucketName+"."+endpoint+"/"+fileName;
            return url;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


}
