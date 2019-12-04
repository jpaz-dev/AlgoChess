package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.modelo.excepciones.NoSePuedePosicionarEnTerrenoEnemigo;
import fiuba.algo3.algochess.modelo.tablero.Posicion;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Curandero;
import fiuba.algo3.algochess.modelo.unidades.Jinete;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.algochess.vista.*;
import fiuba.algo3.algochess.vista.unidadview.*;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class PosicionarUnidadEvent implements EventHandler<MouseEvent> {
    private Unidad unidad;
    private Tablero tablero;
    private TableroView tableroView;

    public PosicionarUnidadEvent(Unidad unidad, Tablero tablero, TableroView tableroView) {
        this.unidad = unidad;
        this.tablero = tablero;
        this.tableroView = tableroView;
    }

    public void handle(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();
        int x = (int) mouseX / tableroView.getTileWidth();
        int y = (int) mouseY / tableroView.getTileHeigth();

        System.out.println("Pane position: (" + x + "," + y + ")");

        try {
            if (unidad != null) {
                tablero.posicionarUnidad(unidad, new Posicion(x, y));
                ViewFactory.getInstance(unidad, tableroView);
                AdministradorDeTurnos.getInstancia().administrarCompras();
                unidad = null;
            }
        } catch (NoSePuedePosicionarEnTerrenoEnemigo e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Casilla invalida");
            alert.setHeaderText("Ese lado del mapa no te pertenece para posicionar unidades");
            alert.showAndWait();
        } catch (CasillaOcupadaException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Casilla ocupada");
            alert.setHeaderText("Esa casilla ya esta ocupada por otra unidad");
            alert.showAndWait();
        }
    }
}
