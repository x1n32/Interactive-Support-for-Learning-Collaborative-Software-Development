package github.x1n32.Task3DesignPatterns.Decorator;
/**
 * Extended from the decorator class
 * So when a media player is created, they can wrap it in this class to inherit the assemble method
 */
public class MP4Player extends MediaPlayerDecorator {
	public MP4Player(MediaPlayer mediaPlayer) {
		super(mediaPlayer);
	}
 
	@Override
	public void assemble() {
		super.assemble();   //Do what assemble does in the parent class
		System.out.println("Adding functionality to run MP4 files.");	 // and add this line to it	
	}
}