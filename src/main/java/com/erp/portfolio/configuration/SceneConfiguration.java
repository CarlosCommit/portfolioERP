package com.erp.portfolio.configuration;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class SceneConfiguration {
    @Bean()
    public SceneActual scene() throws IOException {
      return new SceneActual();
    }
}
