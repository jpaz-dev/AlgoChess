package fiuba.algo3.AlgoChess;

public class Jinete extends Unidad {
    private int danioMelee;
    private int danioADistancia;

    public Jinete() {
        vida = 100;
        danioMelee = 5;
        danioADistancia = 15;
    }

    public void atacarAMelee(Unidad objetivo) {
        objetivo.recibirDanio(danioMelee);
    }

    public void atacarADistancia(Unidad objetivo) {
        objetivo.recibirDanio(danioADistancia);
    }

}