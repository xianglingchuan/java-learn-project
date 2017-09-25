//package com.myspringmvc.proxy.transactiondemo.domain;
//
//import java.util.Date;
//import javax.persistence.*;
//
///**
// * Created by cat on 2017-03-12.
// */
//@Entity
//public class OperationLog {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String content;
//
//    private Date createdAt;
//
//    @PrePersist
//    public void settingTime(){
//        createdAt = new Date();
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//}
