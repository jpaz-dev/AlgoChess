package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.Manejador;
import fiuba.algo3.algochess.vista.TableroView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class JineteController implements EventHandler<MouseEvent> {
    private Unidad unidad;
    private TableroView tableroView;

    public JineteController(Unidad unidad, TableroView tableroView) {
        this.unidad = unidad;
        this.tableroView = tableroView;
    }

    public void handle(MouseEvent mouseEvent) {
        if(AdministradorDeTurnos.getInstancia().turnoDe(unidad.propietario())) {
            if (!Manejador.getInstancia().tieneAutor()) {
                ArrayList<Pane> panes = tableroView.getPanesAdyacentes(unidad);
                panes.add(tableroView.paneActual(unidad));

                Manejador.getInstancia().agregarUnidad(unidad, panes);
            } else {
                Manejador.getInstancia().agregarUnidad(unidad);
            }
        }
    }
}
