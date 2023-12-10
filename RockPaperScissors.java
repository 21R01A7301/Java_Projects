import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends JFrame implements ActionListener {
    private JLabel resultLabel;

    public RockPaperScissors() {
        super("Rock Paper Scissors Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");
        JButton quitButton = new JButton("Quit");

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);
        quitButton.addActionListener(this);

        resultLabel = new JLabel("Make your choice!");

        add(rockButton);
        add(paperButton);
        add(scissorsButton);
        add(resultLabel);
        add(quitButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Quit")) {
            JOptionPane.showMessageDialog(this, "Thanks for playing. Goodbye!");
            System.exit(0);
        } else {
            String userChoice = e.getActionCommand().toLowerCase();
            String[] choices = {"rock", "paper", "scissors"};
            int computerIndex = new Random().nextInt(3);
            String computerChoice = choices[computerIndex];

            resultLabel.setText("Your choice: " + userChoice + "   Computer's choice: " + computerChoice);

            if (userChoice.equals(computerChoice)) {
                resultLabel.setText(resultLabel.getText() + "   It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                    (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
                resultLabel.setText(resultLabel.getText() + "   You win!");
            } else {
                resultLabel.setText(resultLabel.getText() + "   Computer wins!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockPaperScissors());
    }
}
