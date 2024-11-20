package ua.com.reactive.tfrp.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.tfrp.entity.User;
import ua.com.reactive.tfrp.entity.Greeting;

@Component

public class GreetingHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring")));
    }

    public Mono<ServerResponse> home(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Main page!"));
    }

    public Mono<ServerResponse> getUsers(ServerRequest request) {

        String start = request
                .queryParam("start")
                .orElse("0");


        Flux<User> users = Flux.just(
                        new User(1L, "John", "Mansell", "johnmansell@gmail.com", true),
                        new User(2L, "Charlie", "Wilson", "charliewilson@gmail.com", false),
                        new User(3L,"Mary", "Adams", "maryadams@gmail.com", false)
                )
                .skip(Long.valueOf(start))
                .take(3);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(users, User.class);
    }

}
