package com.metachecker.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.metachecker.model.MetaDataResponce;
import com.metachecker.util.*;

@Service
public class MetaService{

    public MetaDataResponce extractFileMeta(MultipartFile file) {
        String type = file.getContentType();

        if(type.startsWith("image/")){
            return PhotoMetaExtractor.extract(file);
        } else if(type.startsWith("video/")){ //в будущем добавить извлечение метаданных из видео
            return new MetaDataResponce("unknown", null); 
        }

        return new MetaDataResponce("unknown", null);
    }

    public MetaDataResponce extractUrlMeta(String url){
        return LinkMetaExtractor.extract(url);
    }

}