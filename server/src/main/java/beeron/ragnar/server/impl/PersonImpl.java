package beeron.ragnar.server.impl;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import beeron.ragnar.common.Person;

@Entity(name = "PERSON")
@Table(name = "PERSON")
public class PersonImpl implements Person {

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

}
