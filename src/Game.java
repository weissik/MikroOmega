import java.util.ArrayList;

public class Game {

    private Player player;
    private ArrayList<Bullet> bullets;
    private ArrayList<Meteor> meteors;
    private KeyInput key;
    private MouseInput mouse;
    private int timer;

    public Game(KeyInput key, MouseInput mouse) {
        player = new Player(400,300,5);
        bullets = new ArrayList<>();
        this.key = key;
        this.mouse = mouse;
        timer = 0;
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

        timer++;
        if (timer > 60){
            spawnMeteor();
            timer = 0;
        }

        for (Meteor meteor : meteors){
            meteor.update();
        }

    }

    public void shoot(){
        bullets.add(new Bullet(player.getX(), player.getY(), player.getAngel(), 10));
    }

    public void spawnMeteor(){

        int side = (int)(Math.random() * 4);
        double x = 0;
        double y = 0;
        double angel = 0;

        switch (side) {
            case 0 -> {
                x = Math.random() * 800;
                y = -20;
                angel = Math.toRadians(90);
            }
            case 1 -> {
                x = Math.random() * 800;
                y = 620;
                angel = Math.toRadians(270);
            }
            case 2 -> {
                x = -20;
                y = Math.random() * 600;
                angel = Math.toRadians(0);
            }
            case 3 -> {
                x = 820;
                y = Math.random() * 600;
                angel = Math.toRadians(180);
            }
        }

        meteors.add(new Meteor(x, y, player, 2));

    }



}
