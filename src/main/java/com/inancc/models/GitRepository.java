package com.inancc.models;


import com.fasterxml.jackson.annotation.*;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat
public class GitRepository implements IRepository{

    private int stars;
    private String cloneUrl;
    private String fullName;
    private String description;
    private Date createdAt;

    // using JSonGetter and JSonSetter instead of JSonPropery
    // because from git api we are getting as stargazers_count and we want to
    // return from our service as stars
    @JsonGetter("stars")
    public int getStars() {
        return stars;
    }

    @JsonSetter("stargazers_count")
    public void setStars(int stars) {
        this.stars = stars;
    }



    @JsonGetter("cloneUrl")
    public String getCloneUrl() {
        return cloneUrl;
    }

    @JsonSetter("clone_url")
    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }



    @JsonSetter("full_name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonGetter("fullName")
    public String getFullName() {
        return fullName;
    }



    @JsonGetter("createdAt")
    public Date getCreatedAt() {
        return createdAt;
    }

    @JsonSetter("created_at")
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(75);

        return sb.append("Repository{ fullName=").append(this.fullName).append("\',")
               .append( "description=").append(this.description).append("\',")
                .append( "cloneUrl=").append(this.cloneUrl).append("\',")
                .append( "stars=").append(this.stars).append("\',")
                .append( "createdAt=").append(this.createdAt).append("\'")
                .append("}").toString();

    }

}
