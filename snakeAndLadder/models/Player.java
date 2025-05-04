package snakeAndLadder.models;

public class Player {

    public String name;
    public Integer pos = 0;
    public Boolean hasWon = Boolean.FALSE;
    public Integer rank = 0; // Player Rank

    public Player(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {return name;}
    public Integer getPos() {return pos;}
    public Boolean getHasWon() {return hasWon;}
    public Integer getRank() {return rank;}

    // Setters
    public void setPos(Integer pos) {this.pos = pos;}
    public void setHasWon(Boolean hasWon) {this.hasWon = hasWon;}
    public void setRank(Integer rank) {this.rank = rank;}
}
