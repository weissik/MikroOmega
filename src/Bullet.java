public class Bullet {

    private double x;
    private double y;
    private double dx;
    private double dy;
    private double speed;

    public Bullet(double x, double y, double angle, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        dx = Math.cos(angle) *  speed;
        dy = Math.sin(angle) * speed;
    }

    public void update() {
        x += dx;
        y += dy;
    }

}
