package beeron.ragnar.server.impl.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import beeron.ragnar.common.Location;
import beeron.ragnar.common.PersistentPerson;

@Entity(name = "PERSON")
@Table(name = "PERSON")
@NamedQueries({ @NamedQuery(name = "Person.findByName", query = "SELECT P FROM PERSON P WHERE P.name=:NAME") })
public class PersonEntity implements PersistentPerson {

	@Id
	@GeneratedValue(generator = "SEQ_PERSON", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PERSON", sequenceName = "SEQ_PERSON_ID", allocationSize = 1)
	private Integer id;
	@NaturalId
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int acting;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinTable(name = "PERSON_WAS_IN_LOCATION", joinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "LOCATION_ID", referencedColumnName = "ID"))
	@Fetch(FetchMode.SUBSELECT)
	private Set<LocationEntity> locations = new HashSet<LocationEntity>();

	/**
	 * 
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
		return Collections.unmodifiableSet(locations);
	}

	public void setLocations(Set<Location> locations) {
		this.locations.clear();
		for (Location location : locations) {
			LocationEntity locationEntity = new LocationEntity();
			locationEntity.setName(location.getName());
			this.locations.add(locationEntity);
		}
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
