package com.example.antiepidemic.domain;

import java.util.Date;

/**
 * @author hqb
 */
public class Carousel {

    private Long id;

    private String name;

    private Long image;

    private Long inputer;

    private Boolean isDelete;

    private Date gmtCreate;

    private Date gmtUpdate;

    public Carousel(Long id, String name, Long image, Long inputer, Boolean isDelete, Date gmtCreate, Date gmtUpdate) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.inputer = inputer;
        this.isDelete = isDelete;
        this.gmtCreate = gmtCreate;
        this.gmtUpdate = gmtUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getImage() {
        return image;
    }

    public void setImage(Long image) {
        this.image = image;
    }

    public Long getInputer() {
        return inputer;
    }

    public void setInputer(Long inputer) {
        this.inputer = inputer;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + image +
                ", inputer=" + inputer +
                ", isDelete=" + isDelete +
                ", gmtCreate=" + gmtCreate +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }
}
