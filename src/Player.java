public class Player {

    private double x;
    private double y;
    private double angel;
    private double speed;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngel() {
        return angel;
    }

    public Player(double x, double y, double speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void moveForward(){
        x += Math.cos(angel) * speed;
        y += Math.sin(angel) * speed;
    }

    public void moveBackwards(){
        x -= Math.cos(angel) * speed;
        y -= Math.sin(angel) * speed;
    }

    public void moveStrafeLeft(){
        x += -Math.sin(angel) * speed;
        y += Math.cos(angel) * speed;
    }

    public void moveStrafeRight(){
        x -= -Math.cos(angel) * speed;
        y -= Math.sin(angel) * speed;
    }

    public void rotateTo(double mouseX, double mouseY){
        double dx = mouseX - x;
        double dy = mouseY - y;
        angel = Math.atan2(dy, dx);
    }

}
