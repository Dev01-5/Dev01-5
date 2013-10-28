package newRemoteControl.Command.Radio;

public class Power {

	String state;
	
	public void on(){
		state = "Apparaat staat aan!!";
	}
	
	public void off(){
		state = "Apparaat staat uit!!";
	}
	
	public String getState() {
		return state;
	}
}
