package beeron.ragnar.server.impl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import beeron.ragnar.common.PersistentLocation;

@Entity(name = "LOCATION")
@Table(name = "LOCATION")
public class LocationEntity implements PersistentLocation {

	@Id
	@GeneratedValue(generator = "SEQ_LOCATION", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_LOCATION", sequenceName = "SEQ_LOCATION_ID", allocationSize = 1)
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

	public void setName(String name) {
		this.name = name;
	}

}
