package newRemoteControl.States.Lamp;

public interface State {
	void turnAllOn(StateContext context);
	void turnAllOff(StateContext context);
	
	void turnLightOneOn(StateContext context);
	void turnLightTwoOn(StateContext context);
	void turnLightOneOff(StateContext context);
	void turnLightTwoOff(StateContext context);
}
