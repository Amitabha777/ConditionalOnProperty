package com.project.codesnippet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "weather")
public class Weather {
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "cityId")
    private int cId;


    private String cityname;

    private String weather;
}
