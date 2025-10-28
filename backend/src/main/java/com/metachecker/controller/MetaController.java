package com.metachecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.metachecker.model.MetaDataResponce;
import com.metachecker.model.UrlRequest;
import com.metachecker.service.*;

@RestController
@RequestMapping("/api/meta")
public class MetaController{
    
    @Autowired
    private MetaService metaservice;
    
    @PostMapping("/analyze/file")
    public MetaDataResponce analyzFile(@RequestParam("file") MultipartFile file){
        return metaservice.extractFileMeta(file);
    }

    @PostMapping("/analyze/url")
    public MetaDataResponce analyzUrl(@RequestBody UrlRequest url){
        return metaservice.extractUrlMeta(url.getUrl());
    }
}