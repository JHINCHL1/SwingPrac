package app;

import tournament.Tournament;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class App {
    private JButton startTournamentButton;
    private JPanel mainPanel;
    private JLabel playersOut;
    private JComboBox tournamentSizeCB;
    private JTextPane playerNames;

    private static Tournament tournament;


    public App() {

        // tournament size selection
        tournamentSizeCB.addItem(8);
        tournamentSizeCB.addItem(16);
        tournamentSizeCB.addItem(32);
        tournamentSizeCB.addItem(64);
        tournamentSizeCB.setSelectedIndex(2);



        startTournamentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO start tournament
                String tSize = "failed";
                if (tournamentSizeCB.getSelectedItem().toString() != null) {
                    tSize = tournamentSizeCB.getSelectedItem().toString();
                    try {
                        tournament = new Tournament(Integer.parseInt(tSize));
                        printPlayers();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    playersOut.setText(tournament.getPlayers());
                }
                else {
                    playersOut.setText(tSize);
                }
            }
        });



    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        frame.pack();
        frame.setSize(1290,720);
        frame.setVisible(true);

    }

    public void printPlayers(){
        for (String fullname: tournament.getPlayersFullNames()) {
            String temp = playerNames.getText();
            playerNames.setText(temp + ", " + fullname);
        }
    }

}
