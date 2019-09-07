package cass.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ApplicationRoutes {
    /*static RouterFunction<?> routes(HotelHandler hotelHandler) {
        return nest(path("/hotels"),
                nest(accept(MediaType.APPLICATION_JSON),
                        route(GET("/{id}"), hotelHandler::get)
                                .andRoute(POST("/"), hotelHandler::save)
                                .andRoute(PUT("/"), hotelHandler::update)
                                .andRoute(DELETE("/{id}"), hotelHandler::delete)
                                .andRoute(GET("/startingwith/{letter}"), hotelHandler::findHotelsWithLetter)
                                .andRoute(GET("/fromstate/{state}"), hotelHandler::findHotelsInState)
                ));
    }*/


    @Bean
    public static RouterFunction<ServerResponse> hotelRoute(HotelHandler hotelHandler) {
        return RouterFunctions.
                        route(GET("/hotels/{id}").and(accept(MediaType.APPLICATION_JSON)), hotelHandler::get)
                                .andRoute(POST("/hotels").and(accept(MediaType.APPLICATION_JSON)), hotelHandler::save)
                                .andRoute(PUT("/hotels").and(accept(MediaType.APPLICATION_JSON)), hotelHandler::update)
                                .andRoute(DELETE("/hotels/{id}").and(accept(MediaType.APPLICATION_JSON)), hotelHandler::delete)
                                .andRoute(GET("/hotels/startingwith/{letter}").and(accept(MediaType.APPLICATION_JSON)), hotelHandler::findHotelsWithLetter)
                                .andRoute(GET("/hotels/fromstate/{state}").and(accept(MediaType.APPLICATION_JSON)), hotelHandler::findHotelsInState);
    }
    
}
