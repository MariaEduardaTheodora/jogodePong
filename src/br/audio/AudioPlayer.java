package br.audio;

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
	private Clip clip;
	
public AudioPlayer(String path) {
try {
AudioInputStream ais=AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path));
	AudioFormat baseFormat=ais.getFormat();
	AudioFormat decodeFormat=new AudioFormat(
	AudioFormat.Encoding.PCM_SIGNED,
	baseFormat.getSampleRate(),
	16,
	baseFormat.getChannels(),
	baseFormat.getChannels()*2,
	baseFormat.getSampleRate(),
	false);
AudioInputStream dais=AudioSystem.getAudioInputStream(decodeFormat,ais);
clip=AudioSystem.getClip();
clip.open(dais);
	
	
} catch (UnsupportedAudioFileException | IOException e) {
	e.printStackTrace();
} catch (LineUnavailableException e) {
	e.printStackTrace();
}
}
public void play() {
if(clip==null)	
return;	
stop();
clip.setFramePosition(0);
clip.start();
}
public void stop() {
if(clip.isRunning())
clip.stop();	
}





}

