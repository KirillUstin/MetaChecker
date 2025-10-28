package com.metachecker.util;

import com.metachecker.model.MetaDataResponce;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Map;

public class LinkMetaExtractor {

    public static MetaDataResponce extract(String url) {
        Map<String, Object> metadata = new HashMap<>();
        
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .get();

            Element title = doc.selectFirst("title");
            if (title != null) metadata.put("title", title.text());

            Element description = doc.selectFirst("meta[name=description]");
            if (description != null) metadata.put("description", description.attr("content"));

            Element keywords = doc.selectFirst("meta[name=keywords]");
            if (keywords != null) metadata.put("keywords", keywords.attr("content"));

            Element ogTitle = doc.selectFirst("meta[property=og:title]");
            if (ogTitle != null) metadata.put("og:title", ogTitle.attr("content"));

            Element ogImage = doc.selectFirst("meta[property=og:image]");
            if (ogImage != null) metadata.put("og:image", ogImage.attr("content"));

            Element ogType = doc.selectFirst("meta[property=og:type]");
            if (ogType != null) metadata.put("og:type", ogType.attr("content"));

            Element ogUrl = doc.selectFirst("meta[property=og:url]");
            if (ogUrl != null) metadata.put("og:url", ogUrl.attr("content"));

            Element ogDescription = doc.selectFirst("meta[property=og:description]");
            if (ogDescription != null) metadata.put("og:description", ogDescription.attr("content"));

        } catch (Exception e) {
            metadata.put("error", e.getMessage());
        }

        return new MetaDataResponce("link", metadata);
    }
}
