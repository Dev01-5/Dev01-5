package newRemoteControl.abstracts;

import newRemoteControl.interfaces.IRadio;


public abstract class ARadioRemoteControl extends ARemoteControl{
	
	protected IRadio iRadio;
	
	public ARadioRemoteControl(IRadio iRadio) {
		this.iRadio = iRadio;
	}
	
	// Tv en Radio Bridge Pattern
	public void On() {
		this.iRadio.On();
	}
	
	public void Off() {
		this.iRadio.Off();
	}
	
	public void setChannel(String c) {
		this.iRadio.changeChannel(c);
	}
	
	public String getState() {
		return this.iRadio.getState();
	}
}
