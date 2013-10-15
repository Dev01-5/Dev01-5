package newRemoteControl.abstracts;

import newRemoteControl.interfaces.iRemoteControl;
import newRemoteControl.concretes.*;
import newRemoteControl.interfaces.iRemoteControlFactory;

public abstract class aRemoteControlFactory implements iRemoteControlFactory{
	
	protected RemoteControl remoteControl;
	
	public abstract iRemoteControl createRemoteControl(); 	
}
