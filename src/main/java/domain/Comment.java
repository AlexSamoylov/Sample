package domain;

/**
 * Created by Alexey Samoylov on 14.01.2015.
 */

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Table(name = "NEW_TABLE")
public class Comment implements Serializable{
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME", unique = true, length = 10)
    private String name;

    @Column(name = "TEXT", length = 45)
    private String text;

    @Column(name = "NUMBER")
    private Integer number;

    public  Comment() {}

    public  Comment(Integer id,String name,String text,Integer email) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.number = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer email) {
        this.number = email;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", number=" + number +
                '}';
    }
}
