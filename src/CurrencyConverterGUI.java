// CurrencyConverterGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI extends BaseGUI {
    private final CurrencyAPI api;
    private JTextField amountField;
    private JComboBox<String> fromCurrencyBox;
    private JComboBox<String> toCurrencyBox;
    private JLabel resultLabel;

    public CurrencyConverterGUI(String apiToken) {
        this.api = new CurrencyAPI(apiToken);
    }

    @Override
    protected void createAndShowGUI() {
        JFrame frame = new JFrame("Conversor de Moedas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Add components to the panel
        JLabel amountLabel = new JLabel("Valor:", SwingConstants.RIGHT);
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        amountField = new JTextField();

        JLabel fromCurrencyLabel = new JLabel("De Moeda:", SwingConstants.RIGHT);
        fromCurrencyLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        fromCurrencyBox = new JComboBox<>(getMajorCurrencies());

        JLabel toCurrencyLabel = new JLabel("Para Moeda:", SwingConstants.RIGHT);
        toCurrencyLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        toCurrencyBox = new JComboBox<>(getMajorCurrencies());

        JButton convertButton = new JButton("Converter");
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel = new JLabel("Resultado: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        convertButton.addActionListener(new ConvertActionListener());

        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(fromCurrencyLabel);
        panel.add(fromCurrencyBox);
        panel.add(toCurrencyLabel);
        panel.add(toCurrencyBox);
        panel.add(new JLabel());  // Empty space
        panel.add(convertButton);
        panel.add(new JLabel());  // Empty space
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

    private String[] getMajorCurrencies() {
        return new String[] {"USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "CNY", "SEK", "NZD", "BRL"};
    }

    private class ConvertActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String amountText = amountField.getText();
                double amount = Double.parseDouble(amountText);
                String fromCurrency = (String) fromCurrencyBox.getSelectedItem();
                String toCurrency = (String) toCurrencyBox.getSelectedItem();

                String rateText = api.getExchangeRate(fromCurrency, toCurrency);

                if (rateText != null) {
                    double rate = Double.parseDouble(rateText);
                    double result = amount * rate;
                    resultLabel.setText(String.format("%,.2f %s equivale a %,.2f %s", amount, fromCurrency, result, toCurrency));
                } else {
                    resultLabel.setText("Erro ao obter a taxa de câmbio.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, insira um número.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}