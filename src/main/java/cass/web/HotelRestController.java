package cass.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HotelRestController {

    @RequestMapping("/")
    public Mono<String> getStatus(){
        return Mono.just("App is Running");
    }
}
