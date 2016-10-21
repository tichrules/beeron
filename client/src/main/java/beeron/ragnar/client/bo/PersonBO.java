package beeron.ragnar.client.bo;

import java.util.HashSet;
import java.util.Set;

import beeron.ragnar.common.Location;
import beeron.ragnar.common.PersistentPerson;

public class PersonBO implements PersistentPerson {

	private Integer id;
	private String name;
	private int acting;
	private Set<LocationBO> locations;

	public PersonBO() {
		locations = new HashSet<LocationBO>();
	}

	/**
	 * @see beeron.ragnar.common.PersistentPerson#getId()
	 */
	@Override
	public int getId() {
		return id == null ? -1 : id;
	}

	/**
	 * @see beeron.ragnar.common.Person#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @see beeron.ragnar.common.Person#getActing()
	 */
	@Override
	public int getActing() {
		return acting;
	}

	/**
	 * @see beeron.ragnar.common.Person#getLocations()
	 */
	@Override
	public Set<Location> getLocations() {
		Set<Location> result = new HashSet<Location>();
		result.addAll(locations);
		return result;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setActing(int acting) {
		this.acting = acting;
	}
}
