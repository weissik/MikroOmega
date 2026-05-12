public class Meteor {

    private double x;
    private double y;
    private double dx;
    private double dy;
    private double speed;

    public Meteor(double x, double y, Player player, double speed){
        this.x = x;
        this.y = y;
        this.speed = speed;

        double mx = player.getX() - x;
        double my = player.getY() - y;

        mx += (Math.random() - 0.5) * 200;
        my += (Math.random() - 0.5) * 200;

        double length = Math.sqrt(mx * mx + my * my);

        mx /= length;
        my /= length;

        dx = mx * speed;
        dy = my * speed;
    }

    public void update(){
        x += dx;
        y += dy;
    }

}
