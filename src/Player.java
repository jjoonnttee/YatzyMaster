import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Player is meant to be my object Player.
 */
public class Player {

     Object rowData[][] = new Object[19][1];
     Object columnNames[] = { "Column One" };
     JTable table = new JTable(rowData, columnNames);

}

/**
 * Class is used to create all players.
 */
class CreatePlayer {

    static ArrayList<Player> players = new ArrayList<>();
    static byte i = 0;
    static byte j = 1;
    static int possition = 290;

    /**
     * Method is used to create all players and save the object in a ArrayList (players).
     *
     * @param nrOfPlayers this is a number of how many players should be created.
     */
    static void CreatingPlayers(int nrOfPlayers) {

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        while (i < nrOfPlayers) {

            // skapar en tabell för varje spelare
            players.add(new Player());
            players.get(i).table.setRowHeight(66); // höjd på raderna
            players.get(i).table.setBounds(possition, 360, 164, 1254); // possition och storlek
            players.get(i).table.setFont(new Font("", Font.CENTER_BASELINE, 30)); // font och storlek
            players.get(i).table.setBackground(Color.WHITE); // bakgrund
            players.get(i).table.setEnabled(false); // gör att den inte går att reigera
            players.get(i).table.addMouseListener(Layout.mouseListener);
            players.get(i).table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            players.get(i).table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // centrerar text
            players.get(i).rowData[0][0] = AddPlayerLayout.rowData[i][0].trim();
            Layout.mainPanel.add(players.get(i).table);
            possition = possition + 169;

            j++;
            i++;
        }
        players.get(Rules.turn).table.setBorder(BorderFactory.createLineBorder(Color.RED, 10));

    }
}
