package com.cc.tips.JsonDto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class JsonDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "json")
    private String json;
}
