package cr.ac.una.tutoria2.util;

import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Luvara
 */
public class Utilidades {
  
    public static void ajustarAnchorVentana(AnchorPane root) {
        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setLeftAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);
    }
}
