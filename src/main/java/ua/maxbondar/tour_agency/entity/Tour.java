package ua.maxbondar.tour_agency.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank(message = "Please fill tour name")
    private String name;
    @NotBlank(message = "Please fill tour descpription")
    private String description;
    @NotNull(message = "Please fill tour price")
    private Integer price;
    @Enumerated(EnumType.STRING)
    private TourType tourType;
    @NotNull(message = "Please fill people amount")
    private Integer peopleAmount;
    @NotNull(message = "Please fill hotel stars")
    private Integer stars;
    private boolean isHot;
    private String img;
}
