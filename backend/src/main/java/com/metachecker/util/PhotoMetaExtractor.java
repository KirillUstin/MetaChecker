package com.metachecker.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.Directory;
import com.drew.metadata.Tag;
import org.springframework.web.multipart.MultipartFile;

import com.metachecker.model.MetaDataResponce;

public class PhotoMetaExtractor {
    public static MetaDataResponce extract(MultipartFile file){
        Map<String, Object> metadataMap = new HashMap<>();

        try(InputStream inputStream = file.getInputStream()){
            Metadata metadata = ImageMetadataReader.readMetadata(inputStream);

            for(Directory directory : metadata.getDirectories()){
                for(Tag tag : directory.getTags()){
                    metadataMap.put(tag.getTagName(), tag.getDescription());
                }
            }

        } catch(Exception e){
            metadataMap.put("error", e.getMessage());
        }

        return new MetaDataResponce("image", metadataMap);
    }    
}