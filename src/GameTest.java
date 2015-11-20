import iitc.game.Scene;
import iitc.game.SceneEntity2d;
import iitc.physics.Cartesian2d;
import iitc.physics.Dimension2d;
import iitc.physics.Vector2d;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

/**
 * GameTest
 *
 * @author Ian
 * @version 1.0
 */
public class GameTest {
    public static void main(String[] args) throws IOException {
        final Scene scene = new Scene(0, 0, 900, 900);
        scene.setBackground(Color.BLACK);
        SceneEntity2d paddle = new SceneEntity2d(0, new Dimension2d(200, 20), ImageIO.read(new URL("http://swingame.com/wiki/images/7/7c/Paddle.png")));
        paddle.getMotion().setPosition(new Cartesian2d(50, 50));
        paddle.getMotion().setVelocity(new Vector2d(100, 100));
        scene.add(paddle);
        final JFrame frame = new JFrame("Game Test");
        final ImageIcon icon = new ImageIcon(scene.render());
        frame.setContentPane(new JLabel(icon));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new Timer(6, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scene.update();
                icon.setImage(scene.render());
                frame.repaint();
            }
        }).start();
    }
}
