package com.hotelservice.entites;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotels")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hotel {

    @Id
    @Column(name="ID")
    private String id;
    @Column(name="Name")
    private String name;
    @Column(name="LOCATION")
    private String location;
    @Column(name="ABOUT")
    private String about;

}
