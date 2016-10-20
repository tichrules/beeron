package beeron.ragnar.common;

import java.util.Set;

public interface Person {

	String getName();

	int getActing();

	Set<? extends Location> getLocations();
}
