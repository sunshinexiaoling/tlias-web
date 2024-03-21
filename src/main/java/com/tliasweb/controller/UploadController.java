package com.tliasweb.controller;

import com.tliasweb.pojo.Result;
import com.tliasweb.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ling
 * @desc:
 * @date 2024/3/16 20:14
 */
@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(MultipartFile image) throws Exception {
        log.info("上传,参数:{}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("上传成功,返回:{}",url);
        return Result.success(url);
    }
}
