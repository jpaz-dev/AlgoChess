package fiuba.algo3.AlgoChess.modelo.unidades;

import fiuba.algo3.AlgoChess.modelo.tablero.Casilla;
import fiuba.algo3.AlgoChess.modelo.tablero.Jugador;
import fiuba.algo3.AlgoChess.modelo.tablero.Turno;

import java.util.ArrayList;
import java.util.List;

public abstract class Unidad extends Observable {
    Casilla casilla;
    private Jugador propietario;
    private Turno turno;

    private int vida;
    private int costo;

    public Unidad(Jugador propietario, int vida, int costo) {
        this.propietario = propietario;
        this.costo = costo;
        this.vida = vida;
    }

    public Unidad(int vida, int costo) {
        this.costo = costo;
        this.vida = vida;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    /*********************************************************/
    public int getX() { return casilla.getPosicion().getX(); }
    public int getY() { return casilla.getPosicion().getY(); }
    /*********************************************************/

    public int getVida() {
        return vida;
    }

    public int getCosto() {
        return costo;
    }

    public void aumentarVida(int vida) {
        this.vida += vida;
        notifyObservers();
    }

    public void disminuirVida(int vida) {
        this.vida -= vida;
        notifyObservers();
    }

    private boolean perteneceA(Jugador jugador) {
        return jugador.equals(propietario);
    }

    public boolean soyAliadoDe(Unidad unidad) {
        return unidad.perteneceA(propietario);
    }

    public boolean soyEnemigoDe(Unidad unidad) {
        return !unidad.perteneceA(propietario);
    }

    public boolean esMiPropietario(Jugador jugador) {
        return jugador.equals(propietario);
    }

    public abstract void usarHabilidad(Unidad objetivo);

    public List<Unidad> unidadesAdyacentes() {
        return casilla.getUnidadesAdyacentes();
    }

    public List<Unidad> unidadesCerca() {
        return casilla.getUnidadesADistanciaCorta();
    }

    private List<Unidad> aliadosCerca() {
        List<Unidad> unidadesCerca = unidadesCerca();
        List<Unidad> aliadosCerca = new ArrayList<>();
        for (Unidad unidad : unidadesCerca) {
            if (unidad.soyAliadoDe(this)) {
                aliadosCerca.add(unidad);
            }
        }
        return aliadosCerca;
    }

    public List<Unidad> enemigosCerca() {
        List<Unidad> unidadesCerca = unidadesCerca();
        List<Unidad> enemigosCerca = new ArrayList<>();
        for (Unidad unidad : unidadesCerca) {
            if (unidad.soyEnemigoDe(this)) {
                enemigosCerca.add(unidad);
            }
        }
        return enemigosCerca;
    }

    public boolean tieneAliadosCerca() {
        return this.aliadosCerca().size() > 0;
    }

    public boolean noTieneAliadosCerca() {
        return !this.tieneAliadosCerca();
    }

    public boolean tieneEnemigosCerca() {
        return enemigosCerca().size() > 0;
    }

    public boolean noTieneEnemigosCerca() {
        return !tieneEnemigosCerca();
    }

    protected void enlistarse(Batallon batallon) {
        // Por defecto no hace nada.
    }

    private int distanciaACasilla(Casilla casilla) {
        return casilla.distanciaACasilla(this.casilla);
    }

    public boolean estaACortaDistancia(Unidad unidad) {
        int distancia = unidad.distanciaACasilla(casilla);
        return casilla.valorEnRangoCorto(distancia);
    }

    public boolean estaAMediaDistancia(Unidad unidad) {
        int distancia = unidad.distanciaACasilla(casilla);
        return casilla.valorEnRangoMedio(distancia);
    }

    public boolean estaALargaDistancia(Unidad unidad) {
        int distancia = unidad.distanciaACasilla(casilla);
        return casilla.valorEnRangoLargo(distancia);
    }

    public void moverHaciaAdelante() {
        casilla.moverUnidadHaciaAdelante();
        notifyObservers();
    }

    public void moverALaDerecha() {
        casilla.moverUnidadALaDerecha();
        notifyObservers();
    }

    public void moverHaciaAtras() {
        casilla.moverUnidadHaciaAtras();
        notifyObservers();
    }

    public void moverALaIzquierda() {
        casilla.moverUnidadALaIzquierda();
        notifyObservers();
    }

    protected void moverEnBatallonHaciaAdelante() {
    }

    protected void moverEnBatallonALaDerecha() {
    }

    protected void moverEnBatallonHaciaAtras() {
    }

    protected void moverEnBatallonALaIzquierda() {
    }

    public void setTurno(Turno nuevoTurno){
        this.turno = nuevoTurno;
    }

    public void cambiarTurno(){
        turno = turno.cambiarTurno();
    }

    public void moverHaciaAdelanteConTurno(){
        turno.moverHaciaAdelanteConTurno(this);
    }

    public void avisarlesALasUnidadesQueCambienElturno(){
        propietario.cambiarTurnoParaLasUnidades();
    }
}