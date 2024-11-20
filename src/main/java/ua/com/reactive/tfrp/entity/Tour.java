package ua.com.reactive.tfrp.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Tour {
    private int id;
    private String title;
    private String type;
    private double price;
    private boolean isHot;
}
