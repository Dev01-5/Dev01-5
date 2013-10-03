package newRemoteControl.concretes;

import java.awt.Color;

import newRemoteControl.abstracts.aRemoteControlFactory;

public class TvRemoteControlFactory extends aRemoteControlFactory{

	@Override
	public RemoteControl createRemoteControl() {
		RemoteControl remoteControl = new RemoteControl();
		
		remoteControl.setWindowTitle("Tv Remote");
		remoteControl.setWindowSize(300, 300);
		remoteControl.setWindowPosition(500, 250);
		remoteControl.setWindowBackground(Color.ORANGE);
		
		return remoteControl;
	}
}
