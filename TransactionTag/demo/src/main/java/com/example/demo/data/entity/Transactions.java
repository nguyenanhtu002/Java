package com.example.demo.data.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
@Entity
@Data
@Getter
@Setter
@Table(name ="Transactions")
public class Transactions implements Serializable{
    @Column(name = "createdAt")
    private String createdAt;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private double amount;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tagId")
    private int tagId;

    public Transactions(String createAt, String title, String description, int amount, int tagId, TagFinance tagFinance) {
    }

    public Transactions(String createdAt, String title, String description, double amount, int tagId) {
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagId = tagId;
    }
}