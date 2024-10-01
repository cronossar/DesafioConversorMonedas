package PracticaInterfazGraf;

import com.aluracurso.arregloAPI.TasaCambioAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMonedaAppGUI extends JFrame {
    private JComboBox<String> comboBoxMonedaBase;
    private JComboBox<String> comboBoxMonedaDestino;
    private JTextField textFieldCantidad;
    private JButton buttonConvertir;
    private JLabel labelResultado;

    public ConversorMonedaAppGUI() {
        setTitle("Conversor de Moneda - Desafío Alura");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //Aca se monta la ventana, el título, tamaño y comportamiento de cierre

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        //Aca crea un panel para la ventana con formato de cuadrícula que tendrá 5 filas y 2 columnas

        // Componentes
        panel.add(new JLabel("Moneda Base:"));
        comboBoxMonedaBase = new JComboBox<>(new String[] {"ARS", "USD", "BRL", "PYG"});
        panel.add(comboBoxMonedaBase);

        panel.add(new JLabel("Moneda Destino:"));
        comboBoxMonedaDestino = new JComboBox<>(new String[] {"USD", "ARS", "BRL", "PYG"});
        panel.add(comboBoxMonedaDestino);

        panel.add(new JLabel("Cantidad:"));
        textFieldCantidad = new JTextField();
        panel.add(textFieldCantidad);

        buttonConvertir = new JButton("Convertir");
        panel.add(buttonConvertir);

        labelResultado = new JLabel("Resultado: ");
        panel.add(labelResultado);
        //Componentes usados en la pantalla:
        // JComboBox<String para seleccionar la moneda base y la moneda destino.
        //JTextField para ingresar la cantidad a convertir.
        //JButton para iniciar la conversión.
        //JLabel para mostrar el resultado.

        // Añadir el panel a la ventana
        add(panel);

        // Acción del botón
        buttonConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirMoneda();
            }
        });
    }

    private void convertirMoneda() {
        String monedaBase = (String) comboBoxMonedaBase.getSelectedItem();
        String monedaDestino = (String) comboBoxMonedaDestino.getSelectedItem();
        double cantidad;

        try {
            cantidad = Double.parseDouble(textFieldCantidad.getText());

            double tasaCambio = obtenerTasaCambio(monedaBase, monedaDestino);
            double resultado = convertir(cantidad, tasaCambio);

            labelResultado.setText(String.format("Resultado: %.2f %s", resultado, monedaDestino));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida.");
        }
    }

    private double obtenerTasaCambio(String monedaBase, String monedaDestino) {
        // Llama a la clase TasaCambioAPI para obtener la tasa
        try {
            return TasaCambioAPI.obtenerTasaCambio(monedaBase, monedaDestino);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al obtener la tasa de cambio: " + e.getMessage());
            return 1; // Valor por defecto en caso de error
        }
    }

    private double convertir(double cantidad, double tasaCambio) {
        return cantidad * tasaCambio;
    }

    //Aca el main llama a la libreria Swing y se crea una instancia para poder verla
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConversorMonedaAppGUI app = new ConversorMonedaAppGUI();
            app.setVisible(true);
        });
    }
}
