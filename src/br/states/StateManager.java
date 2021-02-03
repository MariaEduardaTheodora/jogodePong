package br.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StateManager implements KeyListener{
public static final int numberStates=3;
public static State[]states=new State[numberStates];
public static int currentState=0;
public static final int FPS=0;
public static final int MENU=1;
public static final int LEVEL1=2;
public static void setState(int state) {
currentState=state;
states[currentState].init();
}

public static State getState() {
return states[currentState];
}

public StateManager() {
states[0]=new FPSState();
states[1]=new MenuState();
states[2]=new Level1State();
}

public void update() {
states[currentState].update();
}

public void render(Graphics g) {
states[currentState].render(g);
}



@Override
public void keyPressed(KeyEvent e) {
states[currentState].KeyPressed(e.getKeyCode());	
	
}


@Override
public void keyReleased(KeyEvent e) {
states[currentState].KeyRelesed(e.getKeyCode());
}


@Override
public void keyTyped(KeyEvent arg0) {


	
}


}

