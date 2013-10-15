package newRemoteControl.States.Lamp;

public class StateContext {
    private State myState;
        /**
         * Standard constructor
         */
    public StateContext() {
        setState(new AllOffState());
    }
 
        /**
         * Setter method for the state.
         * Normally only called by classes implementing the State interface.
         * @param newState the new state of this context
         */
    public void setState(final State newState) {
        myState = newState;
    }
}
