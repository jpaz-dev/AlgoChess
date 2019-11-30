package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.tablero.Jugador;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
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
        theStage.setTitle("Prueba AlgoChess");
               
        Tablero tablero = new Tablero();
        TableroView tableroView = new TableroView();
        
        ReproductorMusica reproductor = new ReproductorMusica();
        reproductor.reproducirMusica();
        /*
        Unidad unidadInfanteriaA = new UnidadDeInfanteria();
        jugadorA.comprarUnidad(unidadInfanteriaA);
        tablero.posicionarUnidad(unidadInfanteriaA, new Posicion(2,2));
        new UnidadViewInfanteria(tableroView, unidadInfanteriaA);

        Unidad unidadInfanteriaB = new UnidadDeInfanteria();
        jugadorA.comprarUnidad(unidadInfanteriaB);
        tablero.posicionarUnidad(unidadInfanteriaB, new Posicion(2,3));
        new UnidadViewInfanteria(tableroView, unidadInfanteriaB);

        Unidad unidadInfanteriaC = new UnidadDeInfanteria();
        jugadorA.comprarUnidad(unidadInfanteriaC);
        tablero.posicionarUnidad(unidadInfanteriaC, new Posicion(2,4));
        new UnidadViewInfanteria(tableroView, unidadInfanteriaC);

        Unidad unidadInfanteriaD = new UnidadDeInfanteria();
        jugadorB.comprarUnidad(unidadInfanteriaD);
        tablero.posicionarUnidad(unidadInfanteriaD, new Posicion(10,10));
        new UnidadViewInfanteria(tableroView, unidadInfanteriaD);

        Unidad jinete = new Jinete();
        jugadorA.comprarUnidad(jinete);
        tablero.posicionarUnidad(jinete, new Posicion(5,5));
        new JineteView(tableroView, jinete);

        Unidad catapulta = new Catapulta();
        jugadorA.comprarUnidad(catapulta);
        tablero.posicionarUnidad(catapulta, new Posicion(0,0));
        new CatapultaView(tableroView, catapulta);

        Unidad curandero = new Curandero();
        jugadorA.comprarUnidad(curandero);
        tablero.posicionarUnidad(curandero, new Posicion(7,7));
        new CuranderoView(tableroView, curandero);
        */
        VBox vb = new VBox(tableroView);

        Shop sh = new Shop();
        sh.addViewOnMap(new ButtonComprarUnidadInfanteria(tablero, tableroView), 0);
        sh.addViewOnMap(new ButtonComprarJinete(tablero, tableroView), 1);
        sh.addViewOnMap(new ButtonComprarCurandero(tablero, tableroView), 2);
        sh.addViewOnMap(new ButtonComprarCatapulta(tablero, tableroView), 3);

        VBox vb2 = new VBox(sh);

        HBox hb = new HBox(vb, vb2);

        Scene theScene = new Scene(hb);
        theStage.setScene(theScene);
        theStage.show();
    }
}
