package com.epam.tour_agency.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    @Enumerated(EnumType.STRING)
    private TourType tourType;
    private int peopleAmount;
    private Byte stars;
    private boolean isHot;
}
