import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerSpiel {

    private LocalDateTime datum;
    private Map<PokerSpieler, Double[]> spielerBuyInsBuyOuts;

    public PokerSpiel(LocalDateTime datum, List<PokerSpieler> spieler) {
        if(datum == null) throw new IllegalArgumentException("Datum is NULL!");
        this.datum = datum;
        this.spielerBuyInsBuyOuts = new HashMap<>();
        if(spieler == null || spieler.size() <= 1) throw new IllegalArgumentException("Spieler is NULL or smaller than 2!");
        for (PokerSpieler pokerSpieler : spieler) {
            if(pokerSpieler == null) throw new IllegalArgumentException("Spieler in List is NULL!");
            this.spielerBuyInsBuyOuts.put(pokerSpieler, new Double[2]);
        }
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public boolean setDatum(LocalDateTime datum) {
        if(datum == null) return false;
        this.datum = datum;
        return true;
    }

    public boolean addPlayer(PokerSpieler spieler) {
        if(spieler == null || this.spielerBuyInsBuyOuts.containsKey(spieler)) return false;
        this.spielerBuyInsBuyOuts.put(spieler, new Double[2]);
        return true;
    }

    public boolean removePlayer(PokerSpieler spieler) {
        if(spieler == null) return false;
        this.spielerBuyInsBuyOuts.remove(spieler);
        return true;
    }
}
