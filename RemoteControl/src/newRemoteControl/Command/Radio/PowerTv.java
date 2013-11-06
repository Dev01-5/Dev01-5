package newRemoteControl.Command.Radio;

import newRemoteControl.interfaces.ITv;

public class PowerTv {

	String state;
	ITv iTv;
	
	public PowerTv(ITv iTv) {
		this.iTv = iTv;
	}
	
	public void on(){
		state = "Apparaat staat aan!!";
		iTv.On();
	}
	
	public void off(){
		state = "Apparaat staat uit!!";
		iTv.Off();
	}
	
	public String getState() {
		return state;
	}
}
