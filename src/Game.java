import java.util.ArrayList;

public class Game {

    private Player player;
    private ArrayList<Bullet> bullets;

    public Game(){
        player = new Player(400,300,5);
        bullets = new ArrayList<>();
    }

    public void update(KeyInput keyInput, MouseInput mouseInput){

        if (keyInput.up) player.moveForward();
        if (keyInput.down) player.moveBackwards();
        if (keyInput.left || keyInput.right) player.moveStrafe();

        if (mouseInput.clicked) shoot();

        for (Bullet bullet : bullets){
            bullet.update();
        }

    }

    public void shoot(){
        Bullet bullet = new Bullet(player.getX(), player.getY(), player.getAngel(), 10);
        bullets.add(bullet);
    }



}
