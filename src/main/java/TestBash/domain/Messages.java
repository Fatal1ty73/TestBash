package TestBash.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Эмиль on 09.07.2014.
 */

@Entity
@Table(name = "MESSAGES")
public class Messages
{
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Integer id;

    @Column(name="USERID")
    private Integer userid;

    @Column(name="TEXT")
    private String text;


    @Column(name="DATE")
    private Date date;

    public Messages() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}