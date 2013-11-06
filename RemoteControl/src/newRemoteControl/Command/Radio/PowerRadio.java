package newRemoteControl.Command.Radio;

import newRemoteControl.interfaces.IRadio;

public class PowerRadio {

	String state;
	IRadio iRadio;
	
	public PowerRadio(IRadio iRadio) {
		this.iRadio = iRadio;
	}
	
	public void on(){
		state = "Apparaat staat aan!!";
		iRadio.On();
	}
	
	public void off(){
		state = "Apparaat staat uit!!";
		iRadio.Off();
	}
	
	public String getState() {
		return state;
	}
}
