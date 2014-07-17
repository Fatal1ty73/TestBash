package ru.dz.testbash.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Эмиль on 16.07.2014.
 */


@Entity
@Table(name = "USERS")
public class Users {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private int id;


    @Column(name="NICKNAME")
    private String nickname;

    public Users () {

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @OneToMany(mappedBy="users")
    private Set<Messages> messages;
    public Set<Messages> getMessages() { return messages; }
    public void setMessages(Set<Messages> messagesList) { this.messages = messagesList; }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", messages=" + messages +
                '}';
    }
}
