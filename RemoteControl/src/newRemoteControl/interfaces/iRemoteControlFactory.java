package newRemoteControl.interfaces;

import newRemoteControl.abstracts.ARemoteControl;

public interface iRemoteControlFactory {
	
	public iRemoteControl createRemoteControl(); 
	public ARemoteControl getRemoteControl();
}
