package entities;

public class Smurf
{
    private int age;
    private int health;
    private int posX;
    private int posY;

    public Smurf(int age, int health, int posX, int posY){
        this.age = age;
        this.health = health;
        this.posX = posX;
        this.posY = posY;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
