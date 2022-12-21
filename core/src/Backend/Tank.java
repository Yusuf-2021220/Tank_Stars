package Backend;
public class Tank
{
    private final int Category;
    private int Pos_x;
    private int Pos_y;
    private int Angle;
    private int Power;
    private int Fuel;
    private int Health;
    private final int Damage;


    public int getPos_x() {
        return Pos_x;
    }

    private void setPos_x(int pos_x) {
        Pos_x = pos_x;
    }

    public int getPos_y() {
        return Pos_y;
    }

    private void setPos_y(int pos_y) {
        Pos_y = pos_y;
    }

    public int getAngle() {
        return Angle;
    }

    private void setAngle(int Ang, int change) {
        if(this.Angle<100 && change==1)
            this.Angle = Ang+1;
        else if(Angle>0 && change == -1)
            this.Angle = Ang-1;
    }

    public int getPower() {
        return Power;
    }

    private void setPower(int Pow, int change) {
        if(this.Power<100 && change==1)
            Power = Pow+1;
        else if(Power>0 && change == -1)
            Power = Pow-1;
    }

    public int getFuel()
    {
        return Fuel;
    }

    private void setFuel(int fuel) {
        if(Fuel>0)
            Fuel-=1;
    }

    public int getHealth() {
        return Health;
    }

    private void setHealth(int dam) {
        if(Health - dam>0)
            Health -= dam;
        else
            Health = 0;
    }
    private int Find_Damage(int Category)
    {
        if(Category==0)
            return 40;
        else if(Category == 1)
            return 80;
        else if(Category == 2)
            return 20;
        return 0;
    }

    private int Find_Health(int Category)
    {
        if(Category==0)
            return 100;
        else if(Category == 1)
            return 200;
        else if(Category == 2)
            return 50;
        return 0;
    }

    Tank(int Category, int Pos_x, int Pos_y, int Damage, int Health)
    {
        this.Category = Category;
        this.Pos_x = Pos_x;
        this.Pos_y = Pos_y;
        this.Damage = Find_Damage(Category);
        this.Health = Find_Health(Category);
        this.Angle = 60;
        this.Fuel = 100;
    }
}