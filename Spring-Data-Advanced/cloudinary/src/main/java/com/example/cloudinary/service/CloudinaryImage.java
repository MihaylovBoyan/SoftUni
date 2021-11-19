package com.example.cloudinary.service;

public class CloudinaryImage {

    private String url;
    private String publicId;


    public String getPublicId() {
        return publicId;
    }

    public String getUrl() {
        return url;
    }

    public CloudinaryImage setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    public CloudinaryImage setUrl(String url) {
        this.url = url;
        return this;
    }
}
