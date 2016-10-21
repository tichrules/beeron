package beeron.ragnar.client.bo;

import beeron.ragnar.common.PersistentLocation;

public class LocationBO implements PersistentLocation {

	private Integer id;
	private String name;

	/**
	 * 
	 * @see beeron.ragnar.common.PersistentLocation#getId()
	 */
	@Override
	public int getId() {
		return id == null ? -1 : id;
	}

	/**
	 * 
	 * @see beeron.ragnar.common.Location#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
