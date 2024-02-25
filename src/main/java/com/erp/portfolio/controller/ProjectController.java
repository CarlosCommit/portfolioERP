package com.erp.portfolio.controller;

import com.erp.portfolio.configuration.SceneActual;
import com.erp.portfolio.entity.Project;
import com.erp.portfolio.service.ProjectService;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controlador, contiene por defecto la lista de los proyectos y botones para elegir un proyecto para editarlo o eliminarlo
 * tambien contiene un boton para crear un nuevo proyecto
 */
@Component
public class ProjectController implements Initializable {

    private final ProjectService projectService;

    private final SceneActual scene;


    public ProjectController(ProjectService projectService,SceneActual scene) {
        this.projectService = projectService;
        this.scene = scene;
    }

    @FXML
    private TableView projectsTable;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnNew;

    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("Inicializado");
        loadProjectsTable();
        disableButtons();


        // Obtener la escena actual desde el nodo raíz
    }

    public void addListenerOutClickTable()
    {
        // Ahora puedes trabajar con la escena
        // Por ejemplo, agregar un event handler
       if(scene.getSceneActual()!=null)
       {

           scene.getSceneActual().setOnMouseClicked(event -> {
               if (!projectsTable.getBoundsInParent().contains(event.getX(), event.getY())) {
                   projectsTable.getSelectionModel().clearSelection();
                   this.disableButtons();
               }
           });


       }




    }

    private void loadProjectsTable()
    {
        List<Project> projects  = (List<Project>) projectService.getProjectsAll().getPayload();
        ObservableList<Project> projectsObservable = FXCollections.observableArrayList(projects);
        projectsTable.setItems(projectsObservable);


    }

    private void disableButtons(){
        this.btnUpdate.setDisable(true);
        this.btnDelete.setDisable(true);
    }

    public void activeButtons()
    {
        this.btnUpdate.setDisable(false);
        this.btnDelete.setDisable(false);
    }




}
