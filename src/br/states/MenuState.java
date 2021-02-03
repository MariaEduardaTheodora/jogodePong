package br.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import br.Game;

public class MenuState implements State {

private String[]options= {"START","HELP","EXIT"};	
private Font font1;
private Font font2;
private int choice=0;
private int x=0,y=0, movex=1,movey=1;
	@Override
	public void init() {
	font1=new Font("Dialog",Font.PLAIN,48);
	font2=new Font("Dialog",Font.PLAIN,24);

	}

	@Override
	public void update() {
	x+=movex;
	y+=movey;
	
	limits();
    
	}
    	
	private void limits() {
	if(x+15>Game.width) 
	movex=-1;
	if(y+15>Game.height) 
	movey=-1;
	if(x<0)
	movex=1;
	if(y<0)
	movey=1;	
		
	}

	@Override
	public void render(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, Game.width,Game.height);
	g.setColor(Color.RED);
	g.setFont(font1);
	g.drawString("PONG",Game.width/2-g.getFontMetrics().stringWidth("PONG")/2,Game.height*1/4);
	g.setFont(font2);
	for(int i=0;i<options.length;i++) {
	g.setColor(Color.RED);	
	if(i==choice)
	g.setColor(Color.YELLOW);
	g.drawString(options[i],Game.width/2-g.getFontMetrics().stringWidth(options[i])/2,Game.height*3/4+g.getFontMetrics(font2).getHeight()*i);
	}
    g.setColor(Color.YELLOW);
    g.fillRect(x, y, 15, 15);
	}
	@Override
	public void KeyPressed(int cod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void KeyRelesed(int cod) {
	if(cod==KeyEvent.VK_W) {
		choice--;
	if(choice<0)
		choice=options.length-1;
	}
	
	if(cod==KeyEvent.VK_S) {
		choice++;
	if(choice>options.length-1)
		choice=0;
	}
	
	if(cod==KeyEvent.VK_ENTER) {
	select();
	}	
		
		
		
	}

	private void select() {
	switch(choice) {
	case 0:
	StateManager.setState(StateManager.LEVEL1);
	break;
	case 1:
	break;
	case 2:
	System.exit(0);	
	break;
	default:
	break;
	
	}
		
	}
}
