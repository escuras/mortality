package com.mortality.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(name = "country_acronym")
    private String countryAcronym;

    private int population;

    @OneToMany(mappedBy="country")
    @JsonIgnore
    List<Mortality> mortalities = new ArrayList<>();
}
