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
@Table(name = "tour_order")
public class TourOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private User user;
    private String tour;
    private Byte ticketsQuantity;
    @Enumerated
    private Status status;
}
