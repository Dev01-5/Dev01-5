package newRemoteControl.Command.Radio;

import newRemoteControl.interfaces.*;

public class PowerRadioOnCommand implements Command {

	PowerRadio power;

	public PowerRadioOnCommand(PowerRadio power) {
		this.power = power;
	}

	public void execute() {
		power.on();
	}

}
