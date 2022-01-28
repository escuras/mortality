package com.mortality.model;

import com.mortality.domain.SexEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mortalities")
public class Mortality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    private long mortality;

    private int year;

    @ManyToOne
    private Country country;
}
