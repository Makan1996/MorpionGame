
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MorpionGame extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private boolean player1Turn = true;  // True = Player 1's turn (Cross), False = Player 2's turn (Circle)
    private JLabel messageLabel;
    private int turnCount = 0;

    public MorpionGame() {
        // Configurer la fenêtre principale
        setTitle("Jeu de Morpion");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centre la fenêtre sur l'écran
        setLayout(new BorderLayout());

        // Créer un label de message (victoire)
        messageLabel = new JLabel("C'est au tour du Joueur 1 (X)", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(messageLabel, BorderLayout.NORTH);

        // Créer la grille 3x3
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 3)); // 3 lignes et 3 colonnes

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                gridPanel.add(buttons[i][j]);
            }
        }

        add(gridPanel, BorderLayout.CENTER);

        // Créer un bouton pour recommencer une nouvelle partie
        JButton restartButton = new JButton("Nouvelle Partie");
        restartButton.addActionListener(new RestartButtonListener());
        add(restartButton, BorderLayout.SOUTH);
    }

    // Gère les actions des boutons de la grille
    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().equals("") && !isGameOver()) {
                if (player1Turn) {
                    buttons[row][col].setText("X");
                    messageLabel.setText("C'est au tour du Joueur 2 (O)");
                } else {
                    buttons[row][col].setText("O");
                    messageLabel.setText("C'est au tour du Joueur 1 (X)");
                }
                turnCount++;
                player1Turn = !player1Turn;

                // Vérifier la victoire
                checkWinner();
            }
        }
    }

    // Vérifie si un joueur a gagné
    private void checkWinner() {
        // Vérifier les lignes
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                !buttons[i][0].getText().equals("")) {
                declareWinner(buttons[i][0].getText());
                return;
            }
        }

        // Vérifier les colonnes
        for (int j = 0; j < 3; j++) {
            if (buttons[0][j].getText().equals(buttons[1][j].getText()) &&
                buttons[1][j].getText().equals(buttons[2][j].getText()) &&
                !buttons[0][j].getText().equals("")) {
                declareWinner(buttons[0][j].getText());
                return;
            }
        }

        // Vérifier les diagonales
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][2].getText()) &&
            !buttons[0][0].getText().equals("")) {
            declareWinner(buttons[0][0].getText());
            return;
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][0].getText()) &&
            !buttons[0][2].getText().equals("")) {
            declareWinner(buttons[0][2].getText());
            return;
        }

        // Vérifier si la partie est terminée (match nul)
        if (turnCount == 9) {
            messageLabel.setText("Match nul !");
        }
    }

    // Affiche le gagnant
    private void declareWinner(String player) {
        if (player.equals("X")) {
            messageLabel.setText("Le Joueur 1 (X) a gagné !");
        } else {
            messageLabel.setText("Le Joueur 2 (O) a gagné !");
        }
    }

    // Vérifie si le jeu est terminé
    private boolean isGameOver() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    // Réinitialiser la partie
    private class RestartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Réinitialiser la grille
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText("");
                }
            }
            turnCount = 0;
            player1Turn = true;
            messageLabel.setText("C'est au tour du Joueur 1 (X)");
        }
    }

    public static void main(String[] args) {
        // Créer et afficher la fenêtre de jeu
        MorpionGame game = new MorpionGame();
        game.setVisible(true);
    }
}

