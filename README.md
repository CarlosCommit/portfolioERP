# ERP para Gestión de Portafolios 💼

Este es un proyecto de ERP (Enterprise Resource Planning) desarrollado con JavaFX integrado con Spring Boot. Está diseñado para gestionar un portafolio, permitiendo a los usuarios subir proyectos, imágenes y realizar diversas acciones relacionadas con la gestión de su portafolio profesional.

Termino siendo bastante interesante el proyecto, al combinar ambas tecnologias pude tener un bean de escena y stage actual que por lo que vi en documentaciones es bastante tedioso y codigo de mala practica tenerlo siempre presente ya que el init de los controladores se ejecutan antes de que la escena se setee completamente y para obtenerlo se requiere una accion desde la interfaz luego del metodo init. Pero con spring se pudo configurar un bean singleton para ir registrando la escena y stage cada vez que cambien la cual necesitaba para capturar clicks en la escena y deshabilitar la seleccion de filas de una tabla, lo cual presento el mismo problema de la ejecucion del metodo init antes de que se cargue correctamente la escena en el bean pero gracias a que los controller tambien son beans se pudo obtener la instancia y ejecutar el metodo que agrega un handle event al scene.

## Características 🚀

- Gestión de proyectos: Permite al usuario crear, editar y eliminar proyectos en su portafolio.
- Subida de imágenes: Permite a los usuarios cargar imágenes relacionadas con sus proyectos.
- Interfaz de usuario intuitiva: Utiliza JavaFX para proporcionar una interfaz gráfica de usuario moderna y fácil de usar.

## Arquitectura 🏛️

El proyecto sigue una arquitectura en capas, con las siguientes capas principales:
- Capa de presentación: Implementada con JavaFX para la interfaz de usuario.
- Capa de lógica de negocio: Implementada con Spring Boot para manejar la lógica de la aplicación.
- Capa de acceso a datos: Utiliza una base de datos asociada para almacenar y recuperar datos de manera eficiente.

## Instalación y Configuración ⚙️

Para ejecutar el proyecto localmente, sigue estos pasos:

1. Clona este repositorio a tu máquina local.
2. Abre el proyecto en tu IDE preferido.
3. Configura la conexión a tu base de datos en el archivo `application.properties`.
4. Ejecuta la aplicación desde tu IDE.

## Uso 🛠️

Una vez que la aplicación esté en funcionamiento, puedes utilizar la interfaz de usuario para gestionar tu portafolio de proyectos. Puedes crear nuevos proyectos, subir imágenes asociadas a ellos y realizar diversas acciones de gestión.

## Frontend para el Portafolio 🌐

Para el frontend del portafolio, necesitarás un servidor backend adicional para consumir los datos gestionados por el ERP. Este servidor backend debe proporcionar métodos GET públicos para acceder a los datos de tus proyectos.

## Contribuciones 🤝

Las contribuciones son bienvenidas. Si deseas contribuir al proyecto, por favor sigue los siguientes pasos:

1. Haz un fork de este repositorio.
2. Crea una rama con el nombre de la característica que deseas agregar o mejorar (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un pull request.

## Licencia 📝

Este proyecto está bajo la licencia [MIT](LICENSE).
