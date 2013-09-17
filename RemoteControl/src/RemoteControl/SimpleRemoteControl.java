package RemoteControl;

public class SimpleRemoteControl {
	Command slot;
	Command slot2;

	public SimpleRemoteControl() {
	}

	public void setCommand(Command command) {
		slot = command;
	}

	public void buttonWasPressed() {
		slot.execute();
	}
	
	public void setCommandOff(Command command) {
		slot2 = command;
	}

	public void buttonWasPressedOff() {
		slot2.execute();
	}
}
