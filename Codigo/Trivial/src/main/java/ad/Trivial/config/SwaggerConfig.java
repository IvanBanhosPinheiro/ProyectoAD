package ad.Trivial.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestion de Productos")
                        .version("1.0")
                        .description("Documentacion Gestion Actividades")
                        .contact(new Contact()
                                .name("Iván")
                                .email("Ivan.banos@iessanmamede.com")
                                .url("www.google.es")));
    }
}
