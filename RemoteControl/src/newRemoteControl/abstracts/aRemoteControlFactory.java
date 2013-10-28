package newRemoteControl.abstracts;

import newRemoteControl.interfaces.iRemoteControl;
import newRemoteControl.interfaces.iRemoteControlFactory;

public abstract class aRemoteControlFactory implements iRemoteControlFactory{
	
	protected ARemoteControl remoteControl;
	
	public abstract iRemoteControl createRemoteControl(); 	

} 
