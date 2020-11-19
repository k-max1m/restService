package project.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resource")
public class DBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    private String word;
    private Date date;

    public DBEntity() {
    }

    public DBEntity(String url, String word, Date date) {
        this.url = url;
        this.word = word;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
