package ua.com.reactive.tfrp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.com.reactive.tfrp.entity.User;

@RestController

public class MyController {
    @GetMapping("/users")

    public Flux<User> getUsers() {
        Flux<User> users = Flux.just(
                        new User(1L, "John", "Mansell", "johnmansell@gmail.com", true),
                        new User(2L, "Charlie", "Wilson", "charliewilson@gmail.com", false),
                        new User(3L,"Mary", "Adams", "maryadams@gmail.com", false)
                )
                .skip(0)
                .take(2);

        return users;
    }
}
