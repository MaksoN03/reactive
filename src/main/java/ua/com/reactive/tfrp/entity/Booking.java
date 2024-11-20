package ua.com.reactive.tfrp.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Booking {
    private Long id;
    private User user;
    private Tour tour;
    private Status status;

    public enum Status {
        NEW,
        IN_PROGRESS,
        COMPLETED
    }
}
