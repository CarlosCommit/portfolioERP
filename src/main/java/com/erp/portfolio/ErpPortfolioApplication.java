package com.erp.portfolio;

import com.erp.portfolio.configuration.SceneActual;
import com.erp.portfolio.controller.ProjectController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ErpPortfolioApplication extends Application {

	public ConfigurableApplicationContext context;
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {

		context = SpringApplication.run(ErpPortfolioApplication.class);
		this.prepareSceneLogin(stage);

	}

	public void prepareSceneLogin(Stage stage) throws IOException {
		//FXMLLoader fmxl = new FXMLLoader(getClass().getResource("/login/Login.fxml"));
		FXMLLoader fmxl = new FXMLLoader(getClass().getResource("/content/PanelProject.fxml"));

		fmxl.setControllerFactory(context::getBean);

		Scene scene = new Scene(fmxl.load());

		SceneActual sceneActual = context.getBean(SceneActual.class);
		sceneActual.setSceneActual(scene);


		ProjectController projectController = context.getBean(ProjectController.class);
		projectController.addListenerOutClickTable();

		stage.setTitle("Management Portfolio - Login");
		stage.setScene(scene);

		stage.show();



	}
}
