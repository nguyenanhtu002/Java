package com.example.demo.data.entity;

import com.example.demo.data.dto.Request.TagfinanceRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TagFinance")
public class TagFinance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public TagFinance(TagfinanceRequestDTO tagfinanceRequestDTO) {

    }


}