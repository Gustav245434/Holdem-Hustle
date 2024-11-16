public class PokerSpieler {

    private String name;
    private double bankroll;

    public PokerSpieler(String name) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException("Name is null or empty");
        this.name = name;
        this.bankroll = 0;
    }

    public PokerSpieler() {

    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if(name == null || name.isBlank()) return false;
        this.name = name;
        return true;
    }

    public double getBankroll() {
        return bankroll;
    }

    public void setBankroll(int bankroll) {
        this.bankroll = bankroll;
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getBankroll() + "€";
    }
}
