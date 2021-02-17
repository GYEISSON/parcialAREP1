#  Parcial de Conceptos Técnicos

Se realizó el desarrollo de una API, la cual envia información del clima acerca de una ciudad o lugar. Para el desarrollo de la aplicación se realizo la conexión a API exteno, se creo un cache que permite consultas concurrentes; para evitar consultas innecesarias al API externo y para soportar consultas en paralelo.

  

## Pre-requisitos

*  [MAVEN](https://maven.apache.org/) - Administrador de dependencias.

*  [GIT](https://git-scm.com/) - Control de versiones.

Para estar seguro de las versiónes que posee de maven, git y de java ejecute los siguientes comandos:

```

mvn -version

```

```

git --version

```

```

java -version

```

## Instalación

Para descargar el proyecto desde GitHub ejecute la siguiente linea:

```

git clone https://github.com/GYEISSON/parcialAREP1.git

```


## Ejecutar

Para compilar ejecutamos la siguiente linea:

```

mvn package

```

Para ejecutar el proyecto ejecutamos la siguiente linea:

```

java -cp target/ParcialClima-1.0-SNAPSHOT.jar edu.escuelaing.arep.App

```

Para ejecutar desde Heroku CLI ejecutamos la siguiente linea:

```

heroku local web
  

Para correr las pruebas ejecutamos la siguiente linea:

```

mvn test



  

## Construido con

*  [MAVEN](https://maven.apache.org/) - Administrador de dependencias.

*  [GIT](https://git-scm.com/) - Control de versiones.

*  [JUNIT](https://junit.org/junit5/) - Framework para realizar y automatizar pruebas.

* Java - Lenguaje de programación.

## Despliegue en Heroku 

* [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://powerful-cove-34049.herokuapp.com/clima?lugar=bogota)

## Autor

*  **Yeisson Gualdron** - [GYEISSON](https://github.com/GYEISSON)   

  

## Licencia

Este proyecto está bajo la Licencia GNU(General Public License) - mira el archivo [LICENSE](LICENSE) para detalles.

