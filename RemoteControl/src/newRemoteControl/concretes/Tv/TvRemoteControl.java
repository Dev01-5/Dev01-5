package newRemoteControl.concretes.Tv;

import newRemoteControl.abstracts.ATvRemoteControl;
import newRemoteControl.interfaces.Command;
import newRemoteControl.interfaces.ITv;

public class TvRemoteControl extends ATvRemoteControl{

	Command slot;
	Command slot2;
	
	public TvRemoteControl(ITv iTv) {
		super(iTv);
	}

	public void setChannelByButton(String type) {
		setChannel(type);
	}
	
	public void setPowerOn(){
		On();
	}
	
	public void setPowerOff(){
		Off();
	}
	
	public void setCommandPowerOn(Command command) {
		slot = command;
	}

	public void powerOnWasPressed() {
		slot.execute();
	}
	
	public void setCommandPowerOff(Command command) {
		slot2 = command;
	}

	public void powerOffWasPressed() {
		slot2.execute();
	}	
}