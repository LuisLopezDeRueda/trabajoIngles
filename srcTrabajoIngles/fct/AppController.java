package fct;

import java.io.IOException;

import fct.app.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController {
	public static final String BIENVENIDA = "/fct/Pantallas/bienvenida.fxml";
	public static final String INICIO = "/fct/Pantallas/inicion.fxml";
	
	private static Stage stage;

	public AppController() {
	}

	public AppController(Stage Loginstage) {
		stage = Loginstage;
	}

	public AppController cambiarVista(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = null;
			scene = new Scene(loader.load());
			stage.setScene(scene);
			return loader.getController();
		} catch (IOException e) {

			System.out.println("Error con la vista nueva \n Vista destino " + fxml);
			e.getStackTrace();
			throw new RuntimeException(e);

		}

	}

	public Parent cargarVista(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			return loader.load();
		} catch (IOException e) {

			System.out.println("Error con la vista nueva \n Vista destino " + fxml);
			e.getStackTrace();
			throw new RuntimeException(e);

		}

	}
}
