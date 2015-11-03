package IHM.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by QKFD7244 on 02/11/2015.
 */
public class AccueilPanel extends javax.swing.JPanel{
    /*Constructeur*/
    public AccueilPanel() {
        initAccueil();
    }

    /*Attributs...*/
    private JPanel panAccueil;

    /*Méthode*/
    private void initAccueil() {
        panAccueil = new JPanel();

        panAccueil.setBackground(Color.red);
        panAccueil.setLayout(new GridLayout(3, 1));

        //mise en forme

        JLabel nom = new JLabel("      Velo Malin");
        nom.setFont(new Font("Arial", Font.PLAIN, 50));
        nom.setForeground(Color.white);
        nom.setSize(500, 300);
        nom.setHorizontalTextPosition(JLabel.CENTER);
        nom.setVerticalTextPosition(JLabel.TOP);

        panAccueil.add(nom);

        ImageIcon icon5 = new ImageIcon("src/main/resources/img/image_velovs.jpg");
        JLabel label_image = new JLabel(icon5);
        label_image.setSize(200, 200);
        label_image.setVerticalTextPosition(JLabel.CENTER);
        label_image.setHorizontalTextPosition(JLabel.CENTER);

        panAccueil.add(label_image);


    }
}
