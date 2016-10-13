package beeron.ragnar.server.impl.form;

import beeron.ragnar.common.Person;

public class PersonForm implements Person {

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

	public void setActing(int acting) {
		this.acting = acting;
	}

	public void setName(String name) {
		this.name = name;
	}
}