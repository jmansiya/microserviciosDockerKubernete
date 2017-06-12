# microserviciosDockerKubernete
Microservicios dockerizados y configuraciÃ³n despliegue en kubernete. Arquitectura Netflix

En este repositorio tendremos un ejemplo de una arquitectura de microservicios con arquitectura netflix, usando servicios de Eureka y Zuul. Estos microservicios serÃ¡n Dockerizados y se generarÃ¡ el ficher docker-compose para permitir levantar el entorno en local y permitir escalar horizontalmente los servicios que sean necesarios.

Habrá comunicación entre el microservicio Empleados y el microservicios empresa.

07/06/2017
Se añade el fichero docker-composeV2.yml que orquestará el entorno completo de esta prueba.

Para ejecutar y levantar el entorno, primero levantar docker en el sistema, después ejecutar lo siguiente:

docker-compose -f docker-composeV2.yml up -d

Desde el directorio donde se encuentra el fichero docker-composeV2.yml.

