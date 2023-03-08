package seedu.bigpp.tutorial;

import java.util.ArrayList;

public class Tutorial {
    
    private int numberOfPages;
    private int currentPage;
    private ArrayList<TutorialPage> tutorialPages;

    public Tutorial(ArrayList<TutorialPage> tutorialPages) {
        this.numberOfPages = tutorialPages.size();
        this.tutorialPages = tutorialPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public ArrayList<TutorialPage> getTutorialPages() {
        return tutorialPages;
    }

    public void showFirstPage() {
        
    }

    public void showNextPage() {

    }

    public void showPreviousPage() {

    }

}
