package github.x1n32.Task3DesignPatterns.Decorator;

/**See MediaPlayer.java first.
 * This is the first implementataion of media player
 * which adds functionality to assemble that all the other versions of media player inherit.
 */
public class BasicMedialayer implements MediaPlayer {
	@Override
	public void assemble() {
		System.out.println("Basic media player");
	}
}