package task;

public class BattleUnit {
    private int Strength;
    private int Armor;
    private int Health;
    private int X;
    private int Y;

    public BattleUnit(int Strength, int Armor, int Health, int X, int Y) {
        this.Armor = Armor;
        this.Strength = Strength;
        this.Health = Health;
        this.X = X;
        this.Y = Y;
    }

    public int getArmor() {
        return Armor;
    }

    public int getStrength() {
        return Strength;
    }

    public int getHealth() {
        return Health;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }


    public void attacked(BattleUnit enemy) {
        if ((Armor>=0)&&(enemy.getStrength()-Armor> 0)) Health=Health-(enemy.getStrength()-Armor);
        else if (Armor < 0) Health=Health- enemy.getStrength();
    }
    public void moveUp(){
        Y=Y-1;
    }
    public void moveDown(){
        Y=Y+1;
    }
    public void moveLeft() {
        X=X-1;
    }
    public void moveRight(){
        X=X+1;
    }
    public boolean isAlive() {
        return Health > 0;
    }
}
