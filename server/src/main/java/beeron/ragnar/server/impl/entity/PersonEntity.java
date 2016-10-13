package beeron.ragnar.server.impl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import beeron.ragnar.common.Person;

@Entity(name = "PERSON")
@Table(name = "PERSON")
public class PersonEntity implements Person {

	@Id
	private String name;
	private int acting;

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
