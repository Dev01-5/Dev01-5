package newRemoteControl.concretes.Lamp;

import newRemoteControl.abstracts.ARemoteControl;
import newRemoteControl.interfaces.Command;

public class LampRemoteControl extends ARemoteControl{

	Command slot;
	Command slot2;
	Command slot3;
	Command slot4;

	public void setCommandOneOn(Command command) {
		slot = command;
	}

	public void lampOneOnWasPressed() {
		slot.execute();
	}
	
	public void setCommandOneOff(Command command) {
		slot2 = command;
	}

	public void lampOneOffWasPressed() {
		slot2.execute();
	}
	
	//------------------------------------------------------------------
	
	public void setCommandTwoOn(Command command) {
		slot3 = command;
	}

	public void lampTwoOnWasPressed() {
		slot3.execute();
	}
	
	public void setCommandTwoOff(Command command) {
		slot4 = command;
	}

	public void lampTwoOffWasPressed() {
		slot4.execute();
	}
	
}
