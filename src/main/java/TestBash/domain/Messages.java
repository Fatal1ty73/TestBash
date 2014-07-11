package TestBash.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Эмиль on 09.07.2014.
 */

@Entity
@Table(name = "messages")
public class Messages
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="userid", length=11)
    private int userid;

    @Column(name="text")
    private String text;


    @Column(name="date", nullable=true)
    private Date date;

    public Messages() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }
    public void setUserid(int Userid) {
        this.userid = Userid;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}