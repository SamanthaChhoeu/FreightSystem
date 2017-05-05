import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class StateComparator.
 */
public class StateComparator implements Comparator<State> {
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int  compare(State o1, State o2) {
		if(o1.getfx() < o2.getfx()) {
			return -1;
		}
		if(o1.getfx() > o2.getfx()) {
			return 1;
		}
		return 0;
	}

}
