package ui;

import model.Bar;
import model.Graph;
import model.exceptions.NegativeValue;

import java.util.Scanner;
import java.util.Set;

public class BarGrapher {

    private Graph graph;
    private final Scanner input;

    public BarGrapher() {
        this.graph = new Graph();
        this.input = new Scanner(System.in);
        runBarGrapher();
    }

    //EFFECTS: start up the main menu
    public void runBarGrapher() {
        boolean keepGoing = true;
        String command;

        while(keepGoing) {
            displayGraph();
            System.out.println("[1] Add a new bar\n" +
                    "[2] Remove a bar\n" +
                    "[3] Quit");
            command = input.next();

            if (command.equals("3")) {
                keepGoing = false;
            } else {
                processMainMenu(command);
            }
        }

        System.out.println("See you next time!");
    }

    //EFFECTS: call new method based on command
    public void processMainMenu(String command) {
        if (command.equals("1")) {
            displayAddBarMenu();
        } else if (command.equals("2")) {
            displayRemoveBarMenu();
        } else {
            System.out.println("Sorry, that isn't an option");
        }
    }

    //MODIFIES: this
    //EFFECTS: displays the menu to allow the user to add a bar
    public void displayAddBarMenu() {
        String label;
        String valueString;
        double value;
        Bar bar;

        System.out.println("Enter a label for the new bar:\n");
        label = input.next();

        System.out.println("Enter a value for the new bar:\n");
        valueString = input.next();
        value = Double.parseDouble(valueString);

        try {
            bar = new Bar(value);
            this.graph.addBar(label, bar);
        } catch (NegativeValue e) {
            System.out.println("Value must be positive!");
        } catch (Exception e) {
            System.out.println("That value is not a number!");
        }
    }

    //MODIFIES: this
    //EFFECTS: displays the menu to allow the user to remove a bar
    public void displayRemoveBarMenu() {
        String label;

        System.out.println("Enter the label of the bar you wish to remove:\n");
        label = input.next();

        this.graph.removeBar(label);
    }

    //EFFECTS: displays graph sorted by value
    public void displayGraph() {
        Set<String> labels = this.graph.getLabels();
        double maxValue = 0;
        int lengthCounter = 100;

        for (String s : labels) {
            if (this.graph.getBars().get(s).getValue() > maxValue) {
                maxValue = this.graph.getBars().get(s).getValue();
            }
        }

        for (String s : labels) {
            int length = (int) Math.round((this.graph.getBars().get(s).getValue()/maxValue)*100);
            this.graph.getBars().get(s).setLength(length);
        }

        while(lengthCounter > 0) {
            for (String s : labels) {
                if (this.graph.getBars().get(s).getLength() == lengthCounter) {
                    String spaces = "";
                    String ticks = "";
                    for (int i = s.length(); i < 20; i++) {
                        spaces += " ";
                    }
                    for (int i = 0; i < lengthCounter; i++) {
                        ticks += "|";
                    }
                    System.out.println(s + spaces + ticks + "\n");
                }
            }

            lengthCounter--;
        }
    }
}
