package com.example.servicedemo.config;

import com.example.servicedemo.domain.User;
import com.example.servicedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;
@Configuration
public class RouterFunctionConfiguration {

    /**
     * person/find/all
     * @param userRepository
     * @return
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
      return   RouterFunctions.route(RequestPredicates.GET("/person/find/all"), request -> {
            Collection<User> users=userRepository.findAll();
            Flux<User> userFlux=Flux.fromIterable(users);
           return ServerResponse.ok().body(userFlux,User.class);

        });

    }
}
