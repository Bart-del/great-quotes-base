package pl.bartdel.quotesbasespring.dao.entity;

import javax.persistence.*;

@Entity
public class Quote {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private String author;

    public Quote() {
    }

    public Quote(Long index, String body, String author) {
        this.id = index;
        this.body = body;
        this.author = author;
    }

    public Long getIndex() {
        return id;
    }

    public void setIndex(Long index) {
        this.id = index;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "index=" + id +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
