package beeron.ragnar.server.impl.dao;

import java.util.Set;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import beeron.ragnar.common.Location;
import beeron.ragnar.common.PersistentLocation;
import beeron.ragnar.common.PersistentPerson;
import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarDao;
import beeron.ragnar.common.RagnarService;
import beeron.ragnar.server.impl.entity.LocationEntity;
import beeron.ragnar.server.impl.entity.PersonEntity;

@RunWith(Arquillian.class)
public class RagnarDaoTest {

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addClass(RagnarDao.class).addClass(RagnarService.class).addClass(RagnarDaoImpl.class).addClass(Location.class)
				.addClass(Person.class).addClass(PersistentLocation.class).addClass(PersistentPerson.class).addClass(LocationEntity.class).addClass(PersonEntity.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml").addAsManifestResource("persistence.xml");
		System.out.println(jar.toString(true));
		return jar;
	}

	@Inject
	RagnarDao ragnarDao;

	@Test
	public void testInsert() {
		Person person = new Person() {

			@Override
			public String getName() {
				return "bite mefsdaf";
			}

			@Override
			public int getActing() {
				return 0;
			}

			@Override
			public Set<? extends Location> getLocations() {
				return null;
			}
		};
		ragnarDao.insertPerson(person);
	}
}
