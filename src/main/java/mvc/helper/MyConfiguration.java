package mvc.helper;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"mvc"})
public class MyConfiguration 
{
@Bean
public EntityManager getEm()
{
 return	Persistence.createEntityManagerFactory("dev").createEntityManager();
}
}
