package beeron.ragnar.server.impl.form;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import beeron.ragnar.common.Location;
import beeron.ragnar.common.Person;

@RunWith(Arquillian.class)
public class RagnarFormTest {

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addClass(PersonForm.class).addClass(Person.class).addClass(Location.class).addAsManifestResource(EmptyAsset.INSTANCE,
				"beans.xml");
		System.out.println(jar.toString(true));
		return jar;
	}

	@Inject
	PersonForm personForm;

	@Test
	public void testName() {
		personForm.setName("cheese");
		Assert.assertEquals(personForm.getName(), "cheese");
	}
}
