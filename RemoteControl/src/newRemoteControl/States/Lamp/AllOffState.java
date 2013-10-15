package newRemoteControl.States.Lamp;

public class AllOffState implements State{

	@Override
	public void turnAllOn(StateContext context) {
		System.out.println("lampen staan aan");
		context.setState(new AllOnState());
	}

	@Override
	public void turnAllOff(StateContext context) {
		System.out.println("Lampen staan al uit. Kan niet nogmaals uit zetten");
	}

	@Override
	public void turnLightOneOn(StateContext context) {
		System.out.println("Lamp 1 is aan.");
		//context.setState(new OneOnTwoOffState());
	}

	@Override
	public void turnLightTwoOn(StateContext context) {
		System.out.println("Lamp 2 is aan.");
		//context.setState(new TwoOnOneOffState());
	}

	@Override
	public void turnLightOneOff(StateContext context) {
		System.out.println("Lamp 1 is al uit. Kan niet nogmaals uit zetten");
	}

	@Override
	public void turnLightTwoOff(StateContext context) {
		System.out.println("Lamp 2 is al uit. Kan niet nogmaals uit zetten");
	}
}
