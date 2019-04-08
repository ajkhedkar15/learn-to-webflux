package com.webflux.learntowebflux.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class MainService {

  public Mono<Void> delayer() {

    log.info("Inside MainService::delayer - Executing in Thread :: {}",
        Thread.currentThread().getName());

    try {

      // intentionally introduced delay
      Thread.sleep(3000);

    } catch (InterruptedException e) {

      log.error("Error while delaying :: {} - Executing in Thread :: {}", e,
          Thread.currentThread().getName());
    }

    log.info("I was intentionally delayed - Executing in Thread :: {}", Thread.currentThread().getName());

    return Mono.empty();
  }
}
