package com.example.asynctaskloader;


import com.google.gson.annotations.SerializedName;

public class DogsResult {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private DogImage image;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DogImage getImage() {
        return image;
    }

    public static class DogImage {
        @SerializedName("id")
        private String id;

        @SerializedName("url")
        private String url;

        public String getId() {
            return id;
        }

        public String getUrl() {
            return url;
        }
    }
}
