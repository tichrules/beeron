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
import beeron.ragnar.common.RagnarService;
import beeron.ragnar.server.RagnarDao;
import beeron.ragnar.server.impl.dao.RagnarDaoImpl;
import beeron.ragnar.server.impl.entity.LocationEntity;
import beeron.ragnar.server.impl.entity.PersonEntity;

@RunWith(Arquillian.class)
@SpringConfiguration("test.xml")
public class RagnarServiceIT {

	private static final String LOCATION_NAME = "Test Location";
	private static final String PERSON_NAME = "Test Person";
	private static final int PERSON_ACTING = 5;

	private PersonEntity testPerson;
	private LocationEntity testLocation;

	@Before
	public void setup() {
		testLocation = new LocationEntity();
		testLocation.setName(LOCATION_NAME);
		testPerson = new PersonEntity();
		testPerson.setName(PERSON_NAME);
		testPerson.setActing(PERSON_ACTING);
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
		try {
			int countBefore = ragnarService.getPeople().size();
			int id = ragnarService.insertPerson(testPerson);
			int countAfter = ragnarService.getPeople().size();
			Assert.assertEquals(countAfter, countBefore + 1);
			Person person = ragnarService.getPerson(id);
			Assert.assertNotNull(person);
			Assert.assertEquals(person.getName(), PERSON_NAME);
			Assert.assertEquals(person.getActing(), PERSON_ACTING);
			Assert.assertEquals(person.getLocations().size(), 1);
			Location location = person.getLocations().iterator().next();
			Assert.assertEquals(location.getName(), LOCATION_NAME);
			ragnarService.deletePerson(id);
			countAfter = ragnarService.getPeople().size();
			Assert.assertEquals(countAfter, countBefore);
			person = ragnarService.getPerson(id);
			Assert.assertNull(person);
		} finally {
			ragnarService.deletePerson(PERSON_NAME);
			ragnarService.deleteLocation(LOCATION_NAME);
		}
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testInsertDuplicate() {
		try {
			ragnarService.insertPerson(testPerson);
			ragnarService.insertPerson(testPerson);
		} finally {
			ragnarService.deletePerson(PERSON_NAME);
			ragnarService.deleteLocation(LOCATION_NAME);
		}
	}

	@Test
	public void testMostPopularLocation() {
		Location location = ragnarService.getMostPopularLocation();
		Assert.assertNotNull(location);
	}
}
