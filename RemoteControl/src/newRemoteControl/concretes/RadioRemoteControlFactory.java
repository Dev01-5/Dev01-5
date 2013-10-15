package newRemoteControl.concretes;

import java.awt.Color;

import newRemoteControl.abstracts.aRemoteControlFactory;

public class RadioRemoteControlFactory extends aRemoteControlFactory{

	@Override
	public RemoteControl createRemoteControl() {
		RemoteControl remoteControl = new RemoteControl();
		
		remoteControl.setWindowTitle("Radio Remote");
		remoteControl.setWindowSize(400, 400);
		remoteControl.setWindowPosition(800, 250);
		remoteControl.setWindowBackground(Color.GREEN);
		
		remoteControl.setRemoteWindow();
		
		return remoteControl;
	}
}
