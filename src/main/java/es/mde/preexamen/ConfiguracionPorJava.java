package es.mde.preexamen;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;



import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URI;
import java.net.URLDecoder;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositorySearchesResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.context.annotation.PropertySource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.mde.entidades.Camiseta;
import es.mde.entidades.Equipo;
import es.mde.entidades.Jugador;
import es.mde.rest.MixIns;

@Configuration
@PropertySource({ "classpath:config/rest.properties", "classpath:config/jackson.properties" })
@EnableTransactionManagement
@EnableJpaRepositories("${misRepositorios}")
@ComponentScan("es.mde.rest")
public class ConfiguracionPorJava {
  
  @Value("${misEntidades}")
  String entidades;

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env,
          JpaVendorAdapter vendorAdapter) {

      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource);
//    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); // O pedirlo como parametro y que haga el Autowired
      em.setJpaVendorAdapter(vendorAdapter);

      em.setPackagesToScan(entidades); // leer valor de propiedades? pero solo para las entidades anotadas
      em.setMappingResources("jpa/Perro.orm.xml"); //para escanear archivos xml...
      // leerValorDePropiedades?

      Properties jpaProperties = new Properties();
      Arrays.asList("dialect", "show_sql", "hbm2ddl.auto", "enable_lazy_load_no_trans") //  leer valor de para las entidades anotadas 
              .stream().map(s -> "hibernate." + s)
              .map(p -> new AbstractMap.SimpleEntry<String, String>(p, env.getProperty(p)))
              .filter(e -> e.getValue() != null).forEach(e -> jpaProperties.put(e.getKey(), e.getValue()));
      em.setJpaProperties(jpaProperties);

      return em;
  }

  @Bean
  public EntityManager entityManager(EntityManagerFactory emf) {
      System.err.println("--- LAS ENTIDADES MAPEADAS SON ---");
      emf.getMetamodel().getEntities().forEach(System.err::println);
      System.err.println("----------------------------------");

      return emf.createEntityManager();
  }
  
  @Bean
  public ObjectMapper getObjectMapper() {

      ObjectMapper mapper = new ObjectMapper();
      mapper.addMixIn(Jugador.class, MixIns.Jugadores.class);
      mapper.addMixIn(Equipo.class, MixIns.Equipos.class);
      mapper.addMixIn(Camiseta.class, MixIns.Camisetas.class);

      return mapper;
  }

//  @Bean
//  RepresentationModelProcessor<RepositorySearchesResource> addSearchLinks(RepositoryRestConfiguration config) {
//      Map<Class<?>, Class<?>> controllersRegistrados = new HashMap<>();
//      controllersRegistrados.put(Producto.class, ProductoController.class);
//      controllersRegistrados.put(Cliente.class, ClienteController.class);
//
//      return new RepresentationModelProcessor<RepositorySearchesResource>() {
//
//          @Override
//          public RepositorySearchesResource process(RepositorySearchesResource searchResource) {
//              if (controllersRegistrados.containsKey(searchResource.getDomainType())) {
//                  Method[] metodos = controllersRegistrados.get(searchResource.getDomainType()).getDeclaredMethods();
//                  for (Method m : metodos) {
//                      if (!m.isAnnotationPresent(ResponseBody.class)) {
//                          continue;
//                      }
//                      try {
//                          URI uri = linkTo(m).toUri();
//                          String path = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(),
//                                  config.getBasePath() + uri.getPath(), null, null).toString();
//                          path = URLDecoder.decode(path, "UTF-8");
//                          String requestParams = Stream.of(m.getParameters())
//                                  .filter(p -> p.isAnnotationPresent(RequestParam.class)).map(Parameter::getName)
//                                  .collect(Collectors.joining(","));
//                          searchResource.add(Link.of(path + "{?" + requestParams + "}", m.getName()));
//                      } catch (Exception e) {
//                          e.printStackTrace();
//                      }
//                  }
//              }
//
//              return searchResource;
//          }
//
//      };
//  }
}
