package br.states;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import br.Game;
import br.audio.AudioPlayer;
import br.input.KeyManager;
public class Level1State implements State {
private Rectangle ball=new Rectangle(Game.width/2-5,Game.height/2-5,10,10);
private Rectangle p1=new Rectangle(0,0,10,50);
private Rectangle p2=new Rectangle(Game.width-10,0,10,50);
private int  movex=1,movey=1;
private int score1=0, score2=0;
private AudioPlayer pong,music;

public Level1State() {
pong=new AudioPlayer("/audio/pong.mp3");
music=new AudioPlayer("/audio/theblackframe.mp3");
	
}
	@Override
	public void init() {
	start();
	music.play();

	}
	
public void start() {
	ball.x=Game.width/2-5;
	ball.y=Game.width/2-5;
	
 Random r=new Random();
 movex=(r.nextInt(2)==0)? 2 :-2;
 movey=(r.nextInt(2)==0)? 2 :-2;
}
	@Override
	public void update() {
	ball.x+=movex;
	ball.y+=movey;
	
	LimitsBall();
	
	if(KeyManager.w)
		p1.y-=8;	
		
		if(KeyManager.s)
			p1.y+=8;	
		
		if(KeyManager.up)
			p2.y-=8;	
			
		if(KeyManager.down)
			p2.y+=8;	
	
		LimitsPlayers();
	}	
	  
	private void LimitsBall() {
	if(ball.x+15>Game.width) {
	score1++;	
	start();
	}
	if(ball.y+15>Game.height) {
	movey=-2;
	//////////OBSSSSS
	}
	if(ball.x<0) {
	score2++;
	start();
	}
	if(ball.y<0) {
	movey=2;
	pong.play();
	}
	if(p1.intersects(ball)||p2.intersects(ball)) {
	movex*=-1;
	pong.play();
	}
	}
	
	private void LimitsPlayers() {
	if(p1.y<0)
	p1.y=0;
	if(p1.y>Game.height-p1.height)
	p1.y=Game.height-p1.height;
	
	if(p2.y<0)
	p2.y=0;
	if(p2.y>Game.height-p2.height)
	p2.y=Game.height-p2.height;
			
	}

	
	
	
	

	@Override
	public void render(Graphics g) {
	g.setColor(Color.BLUE);
    g.fillRect(0, 0, Game.width, Game.height);
    g.setColor(Color.YELLOW);
    
    Font fonte= new Font("Dialog",Font.BOLD,12);
    g.setFont(fonte);
    g.drawString("1° Player : " + score1,Game.width*1/4-g.getFontMetrics().stringWidth("1° Player : " + score1)/2,g.getFontMetrics(fonte).getHeight());
    g.drawString("2° Player : " + score2,Game.width*3/4-g.getFontMetrics().stringWidth("2° Player : " + score2)/2,g.getFontMetrics(fonte).getHeight());
    g.fillRect(ball.x, ball.y, ball.width, ball.height);
    g.fillRect(p1.x, p1.y, p1.width, p1.height);
    g.fillRect(p2.x, p2.y, p2.width, p2.height);
    g.fillRect(Game.width/2-3, 0, 6, Game.height);
	}

	@Override
	public void KeyPressed(int cod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void KeyRelesed(int cod) {
		// TODO Auto-generated method stub

	}

}
