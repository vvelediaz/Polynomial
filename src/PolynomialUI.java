import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolynomialUI extends JFrame implements ActionListener
{
    private JTextField firstPolynomial, secondPolynomial, resultPolynomial;

    public PolynomialUI()
    {
        super("Add Polynomials");
        this.setSize(600,600);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(3,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstPolynomial = new JTextField(10);
        secondPolynomial = new JTextField(10);
        resultPolynomial = new JTextField(10);
        resultPolynomial.setEditable(false);
        JButton addButton = new JButton("Add");
        JButton clearButton = new JButton("Clear");
        addButton.addActionListener(this);
        clearButton.addActionListener(this);


        JPanel top = new JPanel();
        JPanel middle = new JPanel();
        JPanel bottom = new JPanel();

        top.add(new JLabel("1st Polynomial:"));
        top.add(firstPolynomial);
        top.add(new JLabel("2nd Polynomial:"));
        top.add(secondPolynomial);

        middle.add(addButton);
        middle.add(clearButton);

        bottom.add(new JLabel("Result: "));
        bottom.add(resultPolynomial);

        add(top);
        add(middle);
        add(bottom);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Add"))
        {
            Polynomial p1 = new Polynomial(firstPolynomial.getText());
            Polynomial p2 = new Polynomial(secondPolynomial.getText());
            p1.add(p2);

            resultPolynomial.setText(p1.toString());
        }
        if(e.getActionCommand().equals("Clear"))
        {
            firstPolynomial.setText("");
            secondPolynomial.setText("");
            resultPolynomial.setText("");
        }
    }
}
