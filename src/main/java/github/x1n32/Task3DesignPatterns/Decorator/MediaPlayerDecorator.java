package github.x1n32.Task3DesignPatterns.Decorator;

/**
 * This is the decorator class. Implemented from the base media player; not the basic media player.
 * Child classes will inherit the decorator method. 
 */
public class MediaPlayerDecorator implements MediaPlayer {
	protected MediaPlayer mediaPlayer;
 
	public MediaPlayerDecorator(MediaPlayer mediaPlayer){
		this.mediaPlayer=mediaPlayer;
	}
 
	@Override
	public void assemble() {
		this.mediaPlayer.assemble();		
	}
}