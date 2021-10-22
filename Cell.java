import jdk.internal.jshell.tool.resources.version;

public class Cell {
    boolean unclicked;
    boolean flagged;
    int surroundingMines; // 0-8 = number of surrounding mines, 9 = MINE!!
    int location[];

    public void cell(int[] location, int surroundingMines) {
        this.surroundingMines = surroundingMines;
        this.unclicked = true;
        this.flagged = false;
        this.location = location;
    }

    public void clicked() {
        checkIfUnclicked();
        checkForFlag();
        revealContents();
    }

    public void checkForFlag() {

    }

    public void checkIfUnclicked() {

    }

    public String reavealContents() {
        if 

    }
}
