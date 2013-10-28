package newRemoteControl.Command.Lamp;

import newRemoteControl.interfaces.Command;

public class LightTwoOffCommand implements Command {

	LightTwo light;

	public LightTwoOffCommand(LightTwo light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}

}
