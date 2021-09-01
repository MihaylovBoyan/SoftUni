package barracksWars.models.units;

public class Horseman extends AbstractUnit {

    private static final int HEALTH = 50;
    private static final int ATTACK = 10;

    public Horseman() {
        super(HEALTH, ATTACK);
    }
}
