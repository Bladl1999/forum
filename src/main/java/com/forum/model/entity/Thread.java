package com.forum.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "threads")
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "thread_name")
    private String thread_name;

    @Column(name = "first_text")
    private String first_text;

    public Thread(){

    }

    public Thread(UUID id, Users user, String thread_name, String first_text){
        this.id = id;
        this.user = user;
        this.thread_name = thread_name;
        this.first_text = first_text;
    }

}
