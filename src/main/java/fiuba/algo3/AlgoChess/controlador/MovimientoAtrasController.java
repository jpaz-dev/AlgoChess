package fiuba.algo3.AlgoChess.controlador;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import fiuba.algo3.AlgoChess.vista.Manejador;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MovimientoAtrasController implements EventHandler<MouseEvent> {
    private Unidad unidad;

    public MovimientoAtrasController(Unidad unidad) {
        this.unidad = unidad;
    }

    public void handle(MouseEvent mouseEvent) {
        unidad.moverHaciaAtras();

        Manejador.getInstancia().resetPanes();
    }
}
