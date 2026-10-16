import javax.swing.*;
import java.awt.*;

public class ProjetoCalculadoraIMC {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame palco = new JFrame("Calculadora IMC");
            palco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            palco.setLayout(new GridLayout(4, 2, 8, 8));

            // Etiquetas
            JLabel etiquetaPeso = new JLabel("Peso (kg)");
            JLabel etiquetaAltura = new JLabel("Altura (m)");

            // Campos de texto
            JTextField campoPeso = new JTextField();
            JTextField campoAltura = new JTextField();

            JButton botaoCalcular = new JButton("Calcular");
            JLabel resultado = new JLabel("");

            botaoCalcular.addActionListener(e -> {
                try {
                    double peso = Double.parseDouble(campoPeso.getText().replace(",", "."));
                    double altura = Double.parseDouble(campoAltura.getText().replace(",", "."));
                    double imc = peso / (altura * altura);

                    String faixa;
                    if (imc < 18.5) faixa = "Abaixo do peso";
                    else if (imc < 25) faixa = "Peso normal";
                    else if (imc < 30) faixa = "Sobrepeso";
                    else faixa = "Obesidade";

                    resultado.setText(String.format("IMC: %.2f - %s", imc, faixa));
                } catch (NumberFormatException ex) {
                    resultado.setText("Digite números válidos");
                }
            });

            palco.add(etiquetaPeso);
            palco.add(campoPeso);
            palco.add(etiquetaAltura);
            palco.add(campoAltura);
            palco.add(botaoCalcular);
            palco.add(resultado);

            palco.setSize(350, 200);
            palco.setLocationRelativeTo(null);
            palco.setVisible(true);
        });
    }
}