package com.webflux.learntowebflux.handler;

import com.webflux.learntowebflux.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Component
public class MainHandler {

  private final MainService service;

  public MainHandler(MainService service) {
    this.service = service;
  }

  public Mono<ServerResponse> hello(ServerRequest request) {

    log.info("Inside MainHandler::hello - Executing in Thread :: {}",
        Thread.currentThread().getName());

    // create a new Mono in order to put it on a different thread
    Mono.defer(service::delayer).subscribeOn(Schedulers.single()).subscribe();

    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
  }
}
