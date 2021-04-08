package kz.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String author;
    private Boolean is_issued;
    private String title;

    @Column(name = "user_id")
    private Long myUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    public Book(String author, Boolean is_issued, String title) {
        this.author = author;
        this.is_issued = is_issued;
        this.title = title;
    }

    public Book() {
    }

    public Boolean getIs_issued() {
        return is_issued;
    }

    public void setIs_issued(Boolean is_issued) {
        this.is_issued = is_issued;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(Long myUserId) {
        this.myUserId = myUserId;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
