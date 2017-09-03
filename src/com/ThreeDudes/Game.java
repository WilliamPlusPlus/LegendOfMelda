package com.ThreeDudes;

import java.awt.*;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

    public static long serialVersionUID = 1L;

    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 3;
    public static final String NAME = "Legend of Zelda";

    private JFrame frame;

    public boolean running;

    public Game() {
        setMinimumSize( new Dimension( WIDTH* SCALE, HEIGHT*SCALE));
        setMaximumSize( new Dimension( WIDTH*SCALE, HEIGHT*SCALE));
        setPreferredSize( new Dimension( WIDTH*SCALE, HEIGHT*SCALE ) );

        frame = new JFrame( NAME );

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setLayout( new BorderLayout() );

        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        frame.setResizable( true );
        frame.setLocationRelativeTo( null );

        frame.setVisible(true);
    }



    private synchronized void start() {
        new Thread(this).start();
        running = true;
    }

    private synchronized void stop() {
        running = false;
    }

    public void render() {

    }
    public void tick() {

    }

    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D/60D;

        int frames = 0;
        int ticks = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0;


        while (running) {

            long now = System.nanoTime();
            delta +=(now - lastTime)/ nsPerTick;
            lastTime = now;

            boolean shouldRender = false;


            while (delta >= 1) {
                ticks++;
                tick();
                delta -= 1;
                shouldRender = true;
            }

            frames++;
            render();

            if (System.currentTimeMillis() - lastTimer > 1000) {
                lastTimer += 1000;
                System.out.println(frames + ", " + ticks);
                frames  = 0;
                ticks = 0;
            }

        }
    }

    public static void main(String[] args) {
        new Game().start();
    }

}
