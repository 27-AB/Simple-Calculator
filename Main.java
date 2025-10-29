import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TrigCalculator extends JFrame implements ActionListener {
    private JTextField inputField1, inputField2;
    private JLabel resultLabel;
    private JButton addBtn, subBtn, mulBtn, divBtn, sinBtn, cosBtn, clearBtn;

    public TrigCalculator() {
        setTitle("Trig Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        inputField1 = new JTextField();
        inputField2 = new JTextField();
        resultLabel = new JLabel("Result: ");

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        sinBtn = new JButton("sin");
        cosBtn = new JButton("cos");
        clearBtn = new JButton("Clear");

        add(new JLabel("Input 1:"));
        add(inputField1);
        add(new JLabel("Input 2 (optional):"));
        add(inputField2);
        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);
        add(sinBtn);
        add(cosBtn);
        add(clearBtn);
        add(resultLabel);

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);
        sinBtn.addActionListener(this);
        cosBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(inputField1.getText());
            double result = 0;

            if (e.getSource() == sinBtn) {
                result = Math.sin(Math.toRadians(num1));
            } else if (e.getSource() == cosBtn) {
                result = Math.cos(Math.toRadians(num1));
            } else {
                double num2 = Double.parseDouble(inputField2.getText());
                if (e.getSource() == addBtn) {
                    result = num1 + num2;
                } else if (e.getSource() == subBtn) {
                    result = num1 - num2;
                } else if (e.getSource() == mulBtn) {
                    result = num1 * num2;
                } else if (e.getSource() == divBtn) {
                    if (num2 == 0) {
                        resultLabel.setText("Error: Division by zero");
                        return;
                    }
                    result = num1 / num2;
                }
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }

        if (e.getSource() == clearBtn) {
            inputField1.setText("");
            inputField2.setText("");
            resultLabel.setText("Result: ");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrigCalculator());
    }
}