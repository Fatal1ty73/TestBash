package ru.dz.testbash.domain;


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
    private int id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users users;



    @Column(name="TEXT")
    private String text;


    @Column(name="dateaddmess")
    private Date dateAddMess;

    public Messages() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() { return users; }
    public void setUsers(Users users) { this.users = users; }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Date getdateAddMess() {
        return dateAddMess;
    }
    public void setdateAddMess(Date dateAddMess) {
        this.dateAddMess = dateAddMess;
    }
}