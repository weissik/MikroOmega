public class Player {

    private double x;
    private double y;
    private double angel;
    private double speed;

    public Player(double x, double y, double speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void moveTo(){
        x += Math.cos(angel) * speed;
        y += Math.sin(angel) * speed;
    }

    public void rotateTo(double mouseX, double mouseY){
        double dx = mouseX - x;
        double dy = mouseY - y;
        angel = Math.atan2(dy, dx);
    }

}
