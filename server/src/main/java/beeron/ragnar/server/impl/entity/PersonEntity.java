package beeron.ragnar.server.impl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

	public void setName(String name) {
		this.name = name;
	}

	public void setActing(int acting) {
		this.acting = acting;
	}
}
