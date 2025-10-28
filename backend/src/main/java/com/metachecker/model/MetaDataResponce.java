package com.metachecker.model;

import java.util.Map;

public class MetaDataResponce{
    private String type;
    private Map<String, Object> metadata;

    public MetaDataResponce(String t, Map<String, Object> md){
        this.type = t;
        this.metadata = md;
    }

    public String getType(){
        return type;
    }

    public Map<String, Object> getMetadata(){
        return metadata;
    }

    public void setType(String t){
        this.type = t;
    }

    public void setMetadata(Map<String, Object> md){
        this.metadata = md;
    }
}