package beeron.ragnar.server.impl.service;

import java.util.Collections;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringConfiguration;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import beeron.ragnar.common.Location;
import beeron.ragnar.common.PersistentLocation;
import beeron.ragnar.common.PersistentPerson;
import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarDao;
import beeron.ragnar.common.RagnarService;
import beeron.ragnar.server.impl.dao.RagnarDaoImpl;
import beeron.ragnar.server.impl.entity.LocationEntity;
import beeron.ragnar.server.impl.entity.PersonEntity;

@RunWith(Arquillian.class)
@SpringConfiguration("test.xml")
public class RagnarServiceIT {

	private static final String TEST_LOC = "Test Location";
	private static final String TEST_PERSON_NAME = "Test Person";
	private static final int TEST_PERSON_ACTING = 5;

	private PersonEntity testPerson;
	private LocationEntity testLocation;

	@Before
	public void setup() {
		testLocation = new LocationEntity();
		testLocation.setName(TEST_LOC);
		testPerson = new PersonEntity();
		testPerson.setName(TEST_PERSON_NAME);
		testPerson.setActing(TEST_PERSON_ACTING);
		testPerson.setLocations(Collections.singleton(testLocation));

	}

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addClass(RagnarDao.class).addClass(RagnarService.class).addClass(RagnarServiceImpl.class)
				.addClass(RagnarDaoImpl.class).addClass(Location.class).addClass(Person.class).addClass(PersistentLocation.class).addClass(PersistentPerson.class)
				.addClass(LocationEntity.class).addClass(PersonEntity.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml").addAsResource("META-INF/persistence.xml")
				.addAsResource("test.xml");
		System.out.println(jar.toString(true));
		return jar;
	}

	@Autowired
	private RagnarService ragnarService;

	@Test
	public void testGetInsertDelete() {
		int countBefore = ragnarService.getPeople().size();
		int id = ragnarService.insertPerson(testPerson);
		int countAfter = ragnarService.getPeople().size();
		Assert.assertEquals(countAfter, countBefore + 1);
		Person person = ragnarService.getPerson(id);
		Assert.assertNotNull(person);
		Assert.assertEquals(person.getName(), TEST_PERSON_NAME);
		Assert.assertEquals(person.getActing(), TEST_PERSON_ACTING);
		Assert.assertEquals(person.getLocations().size(), 1);
		Location location = person.getLocations().iterator().next();
		Assert.assertEquals(location.getName(), TEST_LOC);
		ragnarService.deletePerson(id);
		countAfter = ragnarService.getPeople().size();
		Assert.assertEquals(countAfter, countBefore);
		person = ragnarService.getPerson(id);
		Assert.assertNull(person);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testInsertDuplicate() {
		Integer id = null;
		try {
			id = ragnarService.insertPerson(testPerson);
			ragnarService.insertPerson(testPerson);
		} finally {
			if (id != null) {
				ragnarService.deletePerson(id);
			}
		}
	}
}
