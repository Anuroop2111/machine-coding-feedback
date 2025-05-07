package snakeAndLadder.models;

public class Player {

    public final String name;
    public int pos = 0;
    public Boolean hasWon = Boolean.FALSE;
    public int rank = 0; // Player Rank

    public Player(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {return name;}
    public int getPos() {return pos;}
    public Boolean getHasWon() {return hasWon;}
    public int getRank() {return rank;}

    // Setters
    public void setPos(int pos) {this.pos = pos;}
    public void setHasWon(Boolean hasWon) {this.hasWon = hasWon;}
    public void setRank(int rank) {this.rank = rank;}
}
