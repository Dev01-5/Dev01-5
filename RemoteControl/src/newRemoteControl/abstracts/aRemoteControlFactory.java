package newRemoteControl.abstracts;

import newRemoteControl.concretes.RemoteControl;
import newRemoteControl.interfaces.iRemoteControlFactory;

public abstract class aRemoteControlFactory implements iRemoteControlFactory{
	
	public abstract RemoteControl createRemoteControl(); 	
}
