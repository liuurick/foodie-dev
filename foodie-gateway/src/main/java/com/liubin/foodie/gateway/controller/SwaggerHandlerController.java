package com.liubin.foodie.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@RestController
public class SwaggerHandlerController {

    private final SwaggerResourcesProvider swaggerResources;

    public SwaggerHandlerController(SwaggerResourcesProvider swaggerResources) {
        this.swaggerResources = swaggerResources;
    }

    @GetMapping("/swagger-resources")
    public Mono<ResponseEntity<?>> swaggerResources() {
        return Mono.just((new ResponseEntity<>(swaggerResources.get(), HttpStatus.OK)));
    }

}
