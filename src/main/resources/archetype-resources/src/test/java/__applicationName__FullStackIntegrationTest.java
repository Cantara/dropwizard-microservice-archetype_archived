#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import ${package}.hello.${applicationName}Resource;
import ${package}.hello.api.Planet;
import ${package}.hello.api.Saying;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class ${applicationName}FullStackIntegrationTest {

    @ClassRule
    public static final DropwizardAppRule<${applicationName}DropwizardConfiguration> RULE =
            new DropwizardAppRule<>(${applicationName}Application.class, ResourceHelpers.resourceFilePath("hello-world-test.yml"));

    @Test
    public void get${applicationName}() {
        Client client = JerseyClientBuilder.createClient();

        Response response = client.target(
                String.format("http://localhost:%d" + ${applicationName}Resource.PATH, RULE.getLocalPort()))
                .request()
                .get();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void post${applicationName}() {
        Client client = JerseyClientBuilder.createClient();

        Response response = client.target(
                String.format("http://localhost:%d" + ${applicationName}Resource.PATH, RULE.getLocalPort()))
                .request()
                .post(Entity.json(new Planet("Neptune", "Bad Santa")));

        assertThat(response.getStatus()).isEqualTo(200);
        Saying saying = response.readEntity(Saying.class);
        assertThat(saying.getContent()).isEqualTo("Hello Bad Santa on planet Neptune");
    }

}
