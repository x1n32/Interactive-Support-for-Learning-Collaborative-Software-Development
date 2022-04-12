package github.x1n32.Task3DesignPatterns.Decorator;
/**
 * This is the same as MP4 Player; just the extra functionality to assemble() uses a different text
 * Media player objects created can be wrapped in this class and/or the MP4 player.
 */
public class VLCPlayer extends MediaPlayerDecorator {
	public VLCPlayer(MediaPlayer mediaPlayer) {
		super(mediaPlayer);
	}
 
	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding functionality to run VLC files.");		
	}
}