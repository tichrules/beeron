package beeron.ragnar.server.impl.entity;

import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import beeron.ragnar.common.Location;
import beeron.ragnar.common.PersistentPerson;

@Entity(name = "PERSON")
@Table(name = "PERSON")
public class PersonEntity implements PersistentPerson {

	@Id
	@GeneratedValue(generator = "SEQ_PERSON", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PERSON", sequenceName = "SEQ_PERSON_ID", allocationSize = 1)
	private Integer id;
	private String name;
	private int acting;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "PERSON_WAS_IN_LOCATION", joinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "LOCATION_ID", referencedColumnName = "ID"))
	@Fetch(FetchMode.SUBSELECT)
	private Set<LocationEntity> locations;

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
	public Set<? extends Location> getLocations() {
		return Collections.unmodifiableSet(locations);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setActing(int acting) {
		this.acting = acting;
	}
}
