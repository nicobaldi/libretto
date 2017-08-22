package esercitazioni.polito.libretto;
	
import esercitazioni.polito.libretto.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			 * il main generato automaticamente utilizza un metodo statico che non lascia tracciaù
			 * dell'oggetto. quindi una volta che ho creato il loader il programma se ne dimentica 
			 * immadiatamente. per tenere traccia del loader devo crearlo espicitamente spezzando 
			 * in due il comando statico
			 */
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Libretto.fxml"));
			BorderPane root = (BorderPane)loader.load();
			//fxmlloader deve dirmi chi è il controller
			
			/*
			 * lemodifiche chefacciamo sono douvute al fatto che il main auto generato
			 * non è pensato per avere un modello separato
			 */
			LibrettoController controller = loader.getController();
			Model model = new Model();
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
