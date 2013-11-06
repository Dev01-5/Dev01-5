package newRemoteControl.Command.Radio;

import newRemoteControl.interfaces.Command;

public class PowerTvOffCommand implements Command {

	PowerTv power;

	public PowerTvOffCommand(PowerTv power) {
		this.power = power;
	}

	public void execute() {
		power.off();
	}

}
