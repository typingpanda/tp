package seedu.bigpp.command.tutorialcommand;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import seedu.bigpp.command.Command;
import seedu.bigpp.tutorial.Tutorial;
import seedu.bigpp.tutorial.TutorialPage;

public class TutorialViewCommand extends Command {
    public TutorialViewCommand(String arguments) {
        super.setArguments(arguments);
        ;
    }

    @Override
    public String executeCommand() {
        File tutorialFile = new File("src/main/resources/tutorial/tutorial.txt");

        ArrayList<String> lines = new ArrayList<String>(); 
        

        try {
            Scanner scanner = new Scanner(tutorialFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }

            scanner.close();
        } catch (

        FileNotFoundException e) {
            System.out.println("File not found");
        }

        ArrayList<ArrayList<String>> pages = new ArrayList<ArrayList<String>>();

        //add 100 words in line to an array in pages
        for (String line : lines) {
            String[] words = line.split(" ");
            int wordCount = 0;
            int page = 0;
            pages.add(new ArrayList<String>());
            for (String word : words) {
                if (wordCount == 100) {
                    page++;
                    pages.add(new ArrayList<String>());
                    wordCount = 0;
                }
                pages.get(page).add(word);
                wordCount++;
            }
        }

        

        return "";
    }

}
