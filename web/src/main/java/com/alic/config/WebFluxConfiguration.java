package com.alic.config;

import com.alic.domain.User;
import com.alic.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * webflux配置
 *
 * @author suxingzhe
 * @create 2018-06-05 下午2:45
 **/
@Configuration
public class WebFluxConfiguration {
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> routerFunctionUsers(UserRepository userRepository){
        Collection<User> users = userRepository.findAll();
        Flux<User> userFlux = Flux.fromIterable(users);

        return RouterFunctions.route(RequestPredicates.path("/users"),
                request -> ServerResponse.ok().body(userFlux, User.class));
    }
}
