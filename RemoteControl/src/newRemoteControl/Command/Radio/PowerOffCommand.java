package newRemoteControl.Command.Radio;

import newRemoteControl.interfaces.Command;

public class PowerOffCommand implements Command {

	Power power;

	public PowerOffCommand(Power power) {
		this.power = power;
	}

	public void execute() {
		power.off();
	}

}
