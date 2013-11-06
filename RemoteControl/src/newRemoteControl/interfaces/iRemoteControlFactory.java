package newRemoteControl.interfaces;

import newRemoteControl.abstracts.ARemoteControl;
import newRemoteControl.View.FrameView;

public interface iRemoteControlFactory {
	
	public FrameView createRemoteControl(); 
	public ARemoteControl getRemoteControl();
}
