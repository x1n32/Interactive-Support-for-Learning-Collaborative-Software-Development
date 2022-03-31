package github.x1n32.Task3DesignPatterns.Decorator;
public class DecoratorPatternTest {
	public static void main(String args[]){
		
		//How to use:
		//MediaPlayer mediaPlayerName = new BasicMedialayer();
		//mediaPlayerName = new VLCPlayer(mediaPlayerName);
		//  OR

		//interface class + object name = new decorator class(new base class):
		//(basic)Media player created - wrapped in a VLC Player, so it inherits the VLC functionality
		MediaPlayer vLCPlayer = new VLCPlayer(new BasicMedialayer());
		vLCPlayer.assemble();
		System.out.println();
 
		//Media player created - wrapped in BOTH MP4 and VLC, inheriting both their functionality
		MediaPlayer decoratedVLCPlayer = new VLCPlayer(new MP4Player(new BasicMedialayer()));
		decoratedVLCPlayer.assemble();
	}
}