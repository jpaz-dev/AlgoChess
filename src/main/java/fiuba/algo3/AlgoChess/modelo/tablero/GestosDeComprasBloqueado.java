package fiuba.algo3.AlgoChess.modelo.tablero;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

public class GestosDeComprasBloqueado extends GestorDeCompras {

    GestosDeComprasBloqueado(Jugador propietario) {
        super(propietario);
    }

    @Override
    public void comprarUnidad(Unidad unidad, Billetera billetera) {
        throw new RuntimeException();
    }

    @Override
    public boolean puedeComprar() {
        return false;
    }
}