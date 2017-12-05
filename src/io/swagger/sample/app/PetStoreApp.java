package io.swagger.sample.app;

import java.util.HashSet;
import java.util.Set;

import io.swagger.oas.annotations.ExternalDocumentation;
import io.swagger.oas.annotations.OpenAPIDefinition;
import io.swagger.oas.annotations.info.Contact;
import io.swagger.oas.annotations.info.Info;
import io.swagger.oas.annotations.tags.Tag;
import io.swagger.oas.annotations.info.License;
import io.swagger.sample.resource.PetResource;
import io.swagger.sample.resource.PetStoreResource;
import io.swagger.sample.resource.UserResource;

import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

@Path("/")
@OpenAPIDefinition(
		info = @Info(
				title="Pet Store App", 
				version = "2.0", 
				contact=@Contact(
						email="support@petstoreapp.com", 
						name = "PetStore App Support"), 
				license=@License(
						name = "Apache 2.0", 
						url="http://www.apache.org/licenses/LICENSE-2.0.html")
				),
		externalDocs = @ExternalDocumentation(
				description = "More information about the pet store app",
				url = "http://examplepetstoreapp.com/info"
				),
		tags = {
			@Tag(name="pet", description="Everything about your Pets"),
			@Tag(name="store", description="Access to PetStore orders"),
			@Tag(name="user", description="Operations about user")
		}
)
public class PetStoreApp extends Application {
	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>();
		singletons.add(new PetResource());
		singletons.add(new PetStoreResource());
		singletons.add(new UserResource());
		return singletons;
	}

}
