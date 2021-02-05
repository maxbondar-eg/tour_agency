package com.epam.tour_agency.entity;

import javax.persistence.*;

@Entity
@Table(name = "tour_order")
public class TourOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private User user;
    private Tour tour;
    private Byte ticketsQuantity;
    @Enumerated
    private Status status;
}
