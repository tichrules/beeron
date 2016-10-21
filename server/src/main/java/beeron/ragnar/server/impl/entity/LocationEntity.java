package beeron.ragnar.server.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import beeron.ragnar.common.PersistentLocation;

@Entity(name = "LOCATION")
@Table(name = "LOCATION")
@NamedQueries({ @NamedQuery(name = "Location.findByName", query = "SELECT L FROM LOCATION L WHERE L.name=:NAME") })
@NamedNativeQueries({
		@NamedNativeQuery(name = "Location.findMostPopular", query = "SELECT DISTINCT L.* FROM LOCATION L, PERSON_WAS_IN_LOCATION P1 WHERE P1.LOCATION_ID=L.ID AND NOT EXISTS(SELECT * FROM PERSON_WAS_IN_LOCATION P2 WHERE (SELECT COUNT(*) FROM PERSON_WAS_IN_LOCATION WHERE LOCATION_ID=P2.LOCATION_ID)>(SELECT COUNT(*) FROM PERSON_WAS_IN_LOCATION WHERE LOCATION_ID=P1.LOCATION_ID))", resultClass = LocationEntity.class) })
public class LocationEntity implements PersistentLocation {

	@Id
	@GeneratedValue(generator = "SEQ_LOCATION", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_LOCATION", sequenceName = "SEQ_LOCATION_ID", allocationSize = 1)
	private Integer id;
	@NaturalId
	@Column(nullable = false)
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
