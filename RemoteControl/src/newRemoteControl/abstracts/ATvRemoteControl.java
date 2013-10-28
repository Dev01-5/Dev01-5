package newRemoteControl.abstracts;

import newRemoteControl.interfaces.ITv;

public abstract class ATvRemoteControl extends ARemoteControl{
	
	protected ITv iTv;
	
	public ATvRemoteControl(ITv iTv) {
		this.iTv = iTv;
	}
	
	// Tv en Radio Bridge Pattern
	public void On() {
		this.iTv.On();
	}
	
	public void Off() {
		this.iTv.Off();
	}
	
	public void setChannel(String c) {
		this.iTv.changeChannel(c);
	}
	
	public String getState() {
		return this.iTv.getState();
	}
}
