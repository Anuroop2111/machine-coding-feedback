package snakeAndLadder.util;

public class RollDice {

    private RollDice() {
        throw new AssertionError("Cannot create an instance of RandomGenerator");
    }

    /**
     * @param count             how many 6 sided dices to roll in a single turn
     * @param maxConsecutiveSix how many consecutive 6 can come, at which point all the rolls are voided
     * @return total number of movements
     */
    public static Integer roll(int count, int maxConsecutiveSix) {
        int sixCount = 0;
        int totalDiceValue = 0;
        while (sixCount < maxConsecutiveSix) {
            boolean isSixRolled = false;
            for (int i = 0; i < count; i++) {
                int diceValue = RandomsUtil.getRandomValueBetweenAAndBInclusive(1, 6);
                totalDiceValue += diceValue;
                if (diceValue == 6) {
                    isSixRolled = true;
                }
            }
            if (isSixRolled) {
                sixCount += 1;
            } else {
                break;
            }
        }
        if (sixCount == maxConsecutiveSix) {
            return 0;
        }
        return totalDiceValue;
    }

}
