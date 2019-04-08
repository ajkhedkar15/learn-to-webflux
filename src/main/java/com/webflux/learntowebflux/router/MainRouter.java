package com.webflux.learntowebflux.router;

import com.webflux.learntowebflux.handler.MainHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MainRouter {

  private final MainHandler handler;

  public MainRouter(MainHandler handler) {
    this.handler = handler;
  }

  @Bean
  public RouterFunction<ServerResponse> initRoutes() {

    return RouterFunctions.route()
        .GET("/hello", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::hello).build();
  }
}