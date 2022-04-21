package com.gornostaeva.Router.configuration;

import com.gornostaeva.Router.repository.RouterRepository;
import com.gornostaeva.Router.repository.RouterRepositoryImpl;
import com.gornostaeva.Router.service.RouterService;
import com.gornostaeva.Router.service.RouterServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RouterConfiguration {

    @Bean
    public RouterRepository routerRepository(
            @Value("${routeFilePath}") String filePath
    ) {
        return new RouterRepositoryImpl(filePath);
    }

    @Bean
    public RouterService routerService() {
        return new RouterServiceImpl();
    }
}
