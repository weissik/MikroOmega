import java.util.ArrayList;

public class Game {

    private Player player;
    private ArrayList<Bullet> bullets;
    private KeyInput key;
    private MouseInput mouse;

    public Game(KeyInput key, MouseInput mouse) {
        player = new Player(400,300,5);
        bullets = new ArrayList<>();
        this.key = key;
        this.mouse = mouse;
    }

    public void update(){

        player.rotateTo(mouse.mouseX, mouse.mouseY);

        if (key.up) player.moveForward();
        if (key.down) player.moveBackwards();
        if (key.left) player.moveStrafeLeft();
        if (key.right) player.moveStrafeRight();

        if (mouse.clicked) {
            shoot();
            mouse.clicked = false;
        }

        for (Bullet bullet : bullets){
            bullet.update();
        }

    }

    public void shoot(){
        Bullet bullet = new Bullet(player.getX(), player.getY(), player.getAngel(), 10);
        bullets.add(bullet);
    }



}
