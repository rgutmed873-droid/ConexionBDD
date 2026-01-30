package View;

import javax.swing.*;

public class Driverview extends JFrame {

    public JButton bntBuscar;
    public JTextField txtNumDriver;
    public JLabel etiquetaDriver;

    public Driverview(){
//        super("Vista Conductor");
        setTitle("Vista Conductor");
        setBounds(600,600,400,400);

        bntBuscar = new JButton("Buscar");
        bntBuscar.setSize(100,50);
        txtNumDriver = new JTextField(10);
        etiquetaDriver = new JLabel("Introduzca el conductor");

        JPanel panelConductor = new JPanel();

        this.add(etiquetaDriver);
        this.add(bntBuscar);
        this.add(txtNumDriver);



        setVisible(true);

    }

}
