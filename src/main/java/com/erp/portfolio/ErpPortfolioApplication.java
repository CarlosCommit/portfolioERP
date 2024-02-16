package com.erp.portfolio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ErpPortfolioApplication extends Application {

	public ConfigurableApplicationContext context;
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {

		context = SpringApplication.run(ErpPortfolioApplication.class);
		FXMLLoader fmxl = new FXMLLoader(getClass().getResource("/login/Login.fxml"));
		//fmxl.setControllerFactory(context::getBean);

		Scene scene = new Scene(fmxl.load());
		stage.setTitle("Management Portfolio - Login");
		stage.setScene(scene);
		stage.show();
	}
}
