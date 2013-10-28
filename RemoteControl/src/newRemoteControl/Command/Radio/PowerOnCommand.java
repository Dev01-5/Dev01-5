package newRemoteControl.Command.Radio;

import newRemoteControl.interfaces.Command;

public class PowerOnCommand implements Command {

	Power power;

	public PowerOnCommand(Power power) {
		this.power = power;
	}

	public void execute() {
		power.on();
	}

}
