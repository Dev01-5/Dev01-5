package newRemoteControl.abstracts;

import newRemoteControl.interfaces.iRemoteControlFactory;
import newRemoteControl.View.FrameView;

public abstract class aRemoteControlFactory implements iRemoteControlFactory{
	
	protected ARemoteControl remoteControl;
	
	public abstract FrameView createRemoteControl(); 	

	public ARemoteControl getRemoteControl() {
		return remoteControl;
	}
	
} 
