package com.tutusfunny.Library.entity;

import jakarta.persistence.*;

@Entity
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="author_id",length = 11)
    private int authorId;
    @Column(name = "name",length = 45)
    private String authorName;

    public Author(int authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public Author(int authorId) {
        this.authorId = authorId;
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public Author() {}

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
