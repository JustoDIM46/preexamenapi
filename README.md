1.	Recuerde añadir toda la configuración que necesite a los archivos `build.gradle` y `application.properties` y arrancar H2.

1. **(x puntos)** Se valorará positivamente el uso correcto de estilo, existencia de código sobrante, buenas prácticas, organización correcta del proyecto (paquetes), uso adecuado de clase/s de configuración, uso adecuado de placeholder...
1. **(x puntos)** Implemente el código necesario para persistir la clase `Perro` (JPA Hibernate con ORM. XML).<br>
A tener en cuenta:
    1. (2,5 puntos) La clase `Perro` es **externa** y no puede modificar, añadir, ni omitir nada de ella.
    1. (0,2 puntos) El id debe ser autogenerado.
    1. (0,1 puntos) La tabla debe llamarse `PERRETES`.
    1. (0,1 puntos) La columna _edad_ debe llamarse `VIEJO`.
    1. (0,1 puntos) La columna _nombre_ debe llamarse `ALIAS`.
1. **(x puntos)** Implemente el código necesario para persistir las clases `Jugador` y `Equipo` (JPA Hibernate  @OneToMany).<br>
A tener en cuenta:
    1. (x puntos) Use una **JoinColum**: Es decir, la clave ajena en una columna de la entidad `Jugador` que referencia a la clave primaria de la entidad `Equipo` (como hemos visto en clase).
    1. (x puntos) Los id,s deben ser autogenerados.
    1. (x puntos) No se desea persistir el campo _virgen_.
    1. (x puntos) Recuerde sincronizar la relación.
1. **(x puntos)** Implemente el código necesario para persistir una nueva entidad que se llamará `Camiseta` (JPA Hibernate @OneToMany).<br>
A tener en cuenta:
    1. (x puntos) La clase `Camiseta` deberá tener un campo llamado _lavableEnSeco_ (boolean) y un campo llamado _numero_ (int).
    1. (x puntos) Implemente el código necesario para establecer una relación OneToMany entre `Jugador` y `Camiseta`.
    1. (x puntos) Implemente el código necesario para, persistir adecuadamente la clase `Camiseta`. 
    1. (x puntos) Implemente el código conveniente para que los nombres de las columnas sean adecuados y que la tabla se llame `CAMISETAS_DE_FUTBOL`.
1. **(x puntos)** Implemente el código necesario para añadir la capa REST nivel HATEOAS (Data REST, endpoints HATEOAS).<br>
A tener en cuenta:
    1. (x puntos) No debe exponer los repositorios que no tengan la anotación adecuada y debe añadir el prefijo “api” a sus url,s.
    1. (x punto) Aplique y configure convenientemente la anotación adecuada a sus repositorios para exponerlos.
    1. (x puntos) Implemente todo lo necesario para que sea HATEOAS (autodescubrimiento de URL,s), si es que no lo ha hecho anteriormente.
1. **(x puntos)** Genere e implemente unos **Mixins** que hagan lo siguiente:
    1. Para `Camiseta`:
        1. La respuesta debe mostrar _Dry_ en lugar de _lavableEnSeco_.
    1. Para `Jugador`:
        1. La respuesta debe **ignorar** el campo _altura_.
1. **(x puntos)** Implemente el código necesario para conseguir lo siguiente (**Listener**):<br>
A tener en cuenta:
    1. (x puntos) Despues de crear un `Jugador` en la BBDD se genere un **log** con nivel ERROR con el mensaje: “Se ha creado a ” + “nombre del jugador".
    1. (x puntos) Además de por consola, se desea que estos log,s se guarden en un archivo llamado `**examen.log**` dentro de un directorio llamado _log_, que se encontrará en la carpeta o paquete raíz.
1. **(x puntos)** Aprovechando la potencia que le ofrece JPA, implemente el código necesario para configurar sus métodos y conseguir lo siguiente (Añadir código personalizado):<br>
A tener en cuenta:
    1. (x puntos) Un método que encuentre los jugadores por su altura exacta, y devolviendo una lista con los mismos en caso de alguna coincidencia.  
        1. El parámetro del método se llamará **medida**.
        1. Configure la ruta para que se llegue a él con un **GET** a .....jugadores/search/por-altura?medida=”valor que se desea buscar”. 
     1. (x puntos) Un método que **prohíba borrar** los perros con una llamada REST. Este método no debe exponerse.
1. **(x puntos)** Añadir código personalizado. Uso de **Controladores**:<br>
A tener en cuenta:
    1. (x puntos) Implemente el código necesario para, haciendo uso de un controlador, exponer un método personalizado con la siguiente funcionalidad:
        1. (x punto) Devuelva una lista con los jugadores que llevan el número 10.
		A tener en cuenta:
            1. La lista no debe tener elementos repetidos.
            1. Recuerde que no se trata solo de implementar los métodos, sino de exponerlos convenientemente para ser consumidos como un servicio web y ser autodescubribles (HATEOAS).
            1. Configure las rutas para que se llegue a ellos con un **GET** a ...jugadores/search/diez.