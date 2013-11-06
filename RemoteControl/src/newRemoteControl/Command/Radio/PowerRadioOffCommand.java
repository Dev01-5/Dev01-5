package newRemoteControl.Command.Radio;

import newRemoteControl.interfaces.Command;

public class PowerRadioOffCommand implements Command {

	PowerRadio power;

	public PowerRadioOffCommand(PowerRadio power) {
		this.power = power;
	}

	public void execute() {
		power.off();
	}

}
