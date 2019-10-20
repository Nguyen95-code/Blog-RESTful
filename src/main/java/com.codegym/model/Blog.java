package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String content;
    private String dateCreate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    public Blog() {
    }

    public Blog(String title, String description, String content, String dateCreate, Category category) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.dateCreate = dateCreate;
        this.category = category;
    }
    @Override
    public String toString() {
        return String.format("Blog[id=%d, title='%s', description='%s', content='%s', dateCreate='%s', category='%s']", id, title, description, content, dateCreate, category.getName());
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
