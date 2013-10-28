package newRemoteControl.Command.Lamp;

import newRemoteControl.interfaces.Command;

public class LightOneOffCommand implements Command {

	LightOne light;

	public LightOneOffCommand(LightOne light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}

}
