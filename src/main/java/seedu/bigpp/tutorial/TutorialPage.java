package seedu.bigpp.tutorial;

public class TutorialPage {
    private String[] pageContents;

    public TutorialPage(String[] pageContents) {
        this.pageContents = pageContents;
    }

    public String[] getPageContents() {
        return this.pageContents;
    }

    //change to use out
    public void printPageContents() {
        for (String pageContent : pageContents) {
            System.out.println(pageContent);
        }
    }

}
