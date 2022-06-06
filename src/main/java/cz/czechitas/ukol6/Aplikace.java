package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;

    private JTextField husyField;
    private JTextField kraliciField;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;

    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setLabelFor(husyField);
        husyLabel.setDisplayedMnemonic('H');
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        add(husyLabel);
        add(husyField);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Kralici");
        kraliciLabel.setLabelFor(kraliciField);
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        add(kraliciLabel);
        add(kraliciField);

        vypocitatButton = new JButton("Vypocitat");
        vypocitatButton.setMnemonic('V');
        add(vypocitatButton, "center, span");

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Pocet hlav");
        pocetHlavField.setEditable(false);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Pocet nohou");
        pocetNohouField.setEditable(false);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouLabel.setLabelFor(pocetNohouField);
        add(pocetNohouLabel);
        add(pocetNohouField);

        getRootPane().setDefaultButton(vypocitatButton);

        vypocitatButton.addActionListener(this::handleVypocitat);

        pack();
    }

    private void handleVypocitat(ActionEvent actionEvent) {
        int husy = Integer.parseInt(husyField.getText());
        int kralici = Integer.parseInt(kraliciField.getText());

        pocetHlavField.setText(Integer.toString(husy + kralici));
        pocetNohouField.setText(Integer.toString(2*husy + 4*kralici));


        System.out.println("Stav na farme:");
        System.out.printf("Pocet husi: %s", husyField.getText()).println();
        System.out.printf("Pocet kraliku: %s", kraliciField.getText()).println();
        System.out.printf("Pocet hlav na farme: %s", pocetHlavField.getText()).println();
        System.out.printf("Pocet nohou na farme: %s", pocetNohouField.getText()).println();
    }

}
