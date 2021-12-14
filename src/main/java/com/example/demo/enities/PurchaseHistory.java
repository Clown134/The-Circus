package com.example.demo.enities;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PurchaseHistory {

    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private String cart;
}
