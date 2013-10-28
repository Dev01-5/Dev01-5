package newRemoteControl.concretes.Tv;

import newRemoteControl.interfaces.ITv;

public class TvTypeOne implements ITv {

	private String state;
	private int channel = 0;
	private boolean power = false;
	
	@Override
	public void On() {
		power = true;
	}

	@Override
	public void Off() {
		power = false;
	}

	@Override
	public void changeChannel(String type) {
		if (power){
			if (type.equals("+"))
				this.channel++;
			else{
				if (channel != 0)
					this.channel--;
			}
		}
			
				
		state = "Tv Type One is on channel: " + this.channel;
	}

	@Override
	public String getState() {
		return state;
	}
}
