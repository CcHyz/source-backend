package com.cc.tips.date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "date_dto")
@ApiModel(description = "DateDto entity for storing various date and time related fields")
public class DateDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ApiModelProperty(notes = "The unique identifier for the date entity", required = true, position = 1)
    private Long id;

    @Column(name = "start_date", nullable = false)
    @ApiModelProperty(notes = "The start date and time", required = true, position = 2)
    private LocalDateTime startDate;

    @Column(name = "name", length = 255)
    @ApiModelProperty(notes = "The name associated with the date", position = 3)
    private String name;

    @Column(name = "date_time")
    @ApiModelProperty(notes = "The date and time", position = 4)
    private LocalDateTime dateTime;

    @Column(name = "date")
    @ApiModelProperty(notes = "The date", position = 5)
    private Date date;

    @Column(name = "year")
    @ApiModelProperty(notes = "The year", position = 6)
    private Year year;

    @Column(name = "time")
    @ApiModelProperty(notes = "The time", position = 7)
    private Date time;
}
