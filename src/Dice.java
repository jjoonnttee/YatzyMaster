import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * This is the class where I store all dices.
 */
class Dice {

    static Dice myDices = new Dice();
    static String[] yatzy = { "Y", "A", "T", "Z", "Y" };
    static JButton rollDices = new JButton("Roll dices");
    static int nrOfDices = 5;
    private ArrayList<JButton> dices = new ArrayList<>();
    static ArrayList<Integer> diceClickedOrNot = new ArrayList();
    static int[] valueOfDice = new int[5];

    /**
     * Used to reach the ArrayList where the dicec is stored.
     * @return Returns the ArrayList (dices).
     */
    public ArrayList<JButton> getDices() {
        return dices;
    }

    /**
     * This is the class where I creates all dices and adding them to JFrame.
     */
     static void CreatingDices(){

        int possition = 100;
        int i = 0;

        while (i < nrOfDices) {

            myDices.getDices().add(new JButton());
            myDices.getDices().get(i).setText(yatzy[i]);
            myDices.getDices().get(i).setBounds(possition, 30, 195, 192); // (PlaceringX, PlaceringY, StorlekX, StorlekY)
            myDices.getDices().get(i).setFont(new Font("", Font.BOLD, 120));
            myDices.getDices().get(i).setBackground(new Color(22, 103, 0));
            myDices.getDices().get(i).setBorder(null);
            myDices.getDices().get(i).setFocusPainted(false);
            myDices.getDices().get(i).addActionListener(Layout.buttonListener);
            Layout.mainPanel.add(myDices.getDices().get(i));

            i++;
            possition = possition + 250;
        }

        i = 0;

        while (i < nrOfDices) {
            diceClickedOrNot.add(0);
            i++;
        }
    }

}

/**
 * Class is used to get a random number to the dices.
 */
class GetRandomNumber {

    static ImageIcon icon = new ImageIcon();

    /**
     * Method gets a random number and set the number to a source
     * of a png image for the dice.
     *
     * @param index Brings a specific dice to handle.
     */
    public static void RandomNumber(int index) {

        Random rand = new Random();
         int random = rand.nextInt(6) + 1;
         icon = new ImageIcon("D://Desctop//Dice//"+random+".png");
         Dice.myDices.getDices().get(index).setText("");
         Dice.myDices.getDices().get(index).setIcon(icon);
         Dice.valueOfDice[index] = random;


    }
}
