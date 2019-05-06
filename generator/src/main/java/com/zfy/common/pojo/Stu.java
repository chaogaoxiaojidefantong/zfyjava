package com.zfy.common.pojo;

import java.util.Date;

/**
 * 资源实体类
 */
public class Stu {
    private Long stuId;

    private String stuName;//资源名

    private Integer typeId;//资源类型id

    private Date createdTime;//资源的上传时间

    private Boolean stuMember;//此资源是否需要会员

    private String stuUrl;//资源的url地址

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean getStuMember() {
        return stuMember;
    }

    public void setStuMember(Boolean stuMember) {
        this.stuMember = stuMember;
    }

    public String getStuUrl() {
        return stuUrl;
    }

    public void setStuUrl(String stuUrl) {
        this.stuUrl = stuUrl == null ? null : stuUrl.trim();
    }
}