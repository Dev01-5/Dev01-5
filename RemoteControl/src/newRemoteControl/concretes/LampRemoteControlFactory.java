package newRemoteControl.concretes;

import java.awt.Color;

import newRemoteControl.abstracts.aRemoteControlFactory;

public class LampRemoteControlFactory extends aRemoteControlFactory{

	@Override
	public RemoteControl createRemoteControl() {
		RemoteControl remoteControl = new RemoteControl();
		
		remoteControl.setWindowTitle("Lamp Remote");
		remoteControl.setWindowSize(400, 400);
		remoteControl.setWindowPosition(100, 250);
		remoteControl.setWindowBackground(Color.RED);
		
		return remoteControl;
	}
}
