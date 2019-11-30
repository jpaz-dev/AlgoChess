package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.controlador.CatapultaController;
import fiuba.algo3.AlgoChess.modelo.unidades.Observer;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CatapultaView extends Button implements Observer {
    private TableroView tableroView;
    private Unidad unidad;
    private ImageView unitImage;

    public CatapultaView(TableroView tableroView, Unidad unidad) {
        this.tableroView = tableroView;
        this.unidad = unidad;

        unidad.addObserver(this);

        unitImage = new ImageView();
        unitImage.setScaleX(1);
        unitImage.setScaleY(1);
        unitImage.setFitHeight(32);
        unitImage.setFitWidth(32);

        unitImage.setImage(getImage());
        tableroView.addViewOnMap(unitImage, unidad.getX(), unidad.getY());

        unitImage.setOnMouseClicked(new CatapultaController(unidad, tableroView));
    }

    public Image getImage() {
        // Extraigo el sprite que me interesa del spritesheet usando la clase BufferedImage
        try {
            BufferedImage bf = ImageIO.read(new File("src/main/resources/catapulta.png"));
            BufferedImage subimage = bf.getSubimage(4 * 32, 0, 32, 32);
            Image image = SwingFXUtils.toFXImage(subimage, null) ;
            return image;
        } catch(IOException e) {
            System.out.println("Error cargando imagen");
        }

        return new Image("catapulta.png");
    }

    @Override
    public void change() {}
}
