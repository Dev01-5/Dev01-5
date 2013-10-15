package newRemoteControl.States.Lamp;

public class AllOnState implements State{

	@Override
	public void turnAllOn(StateContext context) {
		System.out.println("Lampen staan al aan. Kan niet nogmaals aan zetten");
	}

	@Override
	public void turnAllOff(StateContext context) {
		System.out.println("lampen staan uit");
		context.setState(new AllOffState());		
	}

	@Override
	public void turnLightOneOn(StateContext context) {
		System.out.println("Lamp 1 staat al aan. Kan niet nogmaals aan zetten");
	}

	@Override
	public void turnLightTwoOn(StateContext context) {
		System.out.println("Lamp 2 staat al aan. Kan niet nogmaals aan zetten");
	}

	@Override
	public void turnLightOneOff(StateContext context) {
		System.out.println("Lamp 1 is uit.");
		//context.setState(new OneOffTwoOnState());
	}

	@Override
	public void turnLightTwoOff(StateContext context) {
		System.out.println("Lamp 2 is uit.");
		//context.setState(new OneOnTwoOffState());
	}

}
