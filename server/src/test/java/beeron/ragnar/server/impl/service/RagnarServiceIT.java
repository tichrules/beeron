package beeron.ragnar.server.impl.service;

import java.util.Set;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringConfiguration;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

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
	public void testInsert() {
		Person person = new Person() {

			@Override
			public String getName() {
				return "cheese cock1";
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
		int id = ragnarService.insertPerson(person);
		ragnarService.deletePerson(id);
	}
}
