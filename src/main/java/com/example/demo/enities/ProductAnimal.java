package com.example.demo.enities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class ProductAnimal {

    @Id
    @GeneratedValue
    private Long id;
    private String modal;
    private String picture;
    private String description;
    private String name;
}
