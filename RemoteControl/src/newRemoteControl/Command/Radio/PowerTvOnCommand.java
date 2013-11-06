package newRemoteControl.Command.Radio;

import newRemoteControl.interfaces.Command;

public class PowerTvOnCommand implements Command {

	PowerTv power;

	public PowerTvOnCommand(PowerTv power) {
		this.power = power;
	}

	public void execute() {
		power.on();
	}

}
