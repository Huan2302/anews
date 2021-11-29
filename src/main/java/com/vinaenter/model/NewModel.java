package com.vinaenter.model;

import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

public class NewModel {
    private int id;
    @NotEmpty(message = "Không được để truống")
    private String name;
    @NotEmpty(message = "Không được để trống")
    private String sortdescriptor;
    private String photo;
    @NotEmpty(message = "Không được để trống")
    private String title;
    private Timestamp createDate;
    private CategoryModel cat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortdescriptor() {
        return sortdescriptor;
    }

    public void setSortdescriptor(String sortdescriptor) {
        this.sortdescriptor = sortdescriptor;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public CategoryModel getCat() {
        return cat;
    }

    public void setCat(CategoryModel cat) {
        this.cat = cat;
    }
}
