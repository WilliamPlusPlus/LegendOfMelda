package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

    public InputHandler (Game game)

    {
        game.addKeyListener(this);
    }



    public class Key {
        private int numTimesPressed = 0;
        public boolean pressed = false;

        public boolean isPressed() {
            return pressed;
        }

        public int getNumTimesPressed() {
            return numTimesPressed;
        }

        public void toggle(boolean isPressed) {
            pressed = isPressed;
            if (isPressed) numTimesPressed++;
        }
    }

    public Key forward = new Key();
    public Key backward = new Key();
    public Key right = new Key();
    public Key left = new Key();

    public void keyPressed(KeyEvent e) {
        toggleKey(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggleKey(e.getKeyCode(), false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void toggleKey(int keyCode, boolean isPressed) {
        if (keyCode == KeyEvent.VK_W) { forward.toggle(isPressed); }
        if (keyCode == KeyEvent.VK_S) { backward.toggle( isPressed ); }
        if (keyCode == KeyEvent.VK_A) { left.toggle( isPressed ); }
        if (keyCode == KeyEvent.VK_D) { right.toggle( isPressed ); }
        }
    }
