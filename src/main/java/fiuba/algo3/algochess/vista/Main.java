package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.tablero.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        theStage.setTitle("AlgoChess");
        
        ReproductorMusica reproductor = new ReproductorMusica();
        reproductor.reproducirMusica();

        ManejadorEscenas manejadorEscenas = new ManejadorEscenas(theStage);

        theStage.show();
    }
}
