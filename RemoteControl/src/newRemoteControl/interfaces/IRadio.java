package newRemoteControl.interfaces;

public interface IRadio {
	
	public void On();
	public void Off();
	public void changeChannel(String type);
	
	public String getState();
}
