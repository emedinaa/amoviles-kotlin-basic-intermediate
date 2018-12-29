## Patrones y Arquitectura de aplicaciones móviles*

- Explicaremos un poco de las diferentes opciones de patrones y arquitecturas para el desarrollo de aplicaciones móviles.

- Usaremos el patrón Model View Presenter (MVP)

 <img src="https://github.com/emedinaa/android-mvp/blob/master/modelviewpresenter.png" height="480">

 - Model : Esta relacionado a las entidades y los cambios que se den estas.

    - Entidad : Entidades de nuesta app, ejemplo UserEntity
    - Cambios en el modelo : Aquí puede estar nuestros proveedores de datos , como sqlite para persistencia local o las peticiones a servicios (conexión remota).

- View : Esta elemento se comparto como un terminal tonto o pasivo,  donde solo tiene declarada acciones de la vista pero no lógica propia de la app. Esta a la espera que un controlador le diga las acciones a realizar.

    - ¿Qué son acciones de una vista?, Las acciones de vista son cosas como : mostrar una ventana de cargando, mostrar un mensaje de error, validar campos de un formulario, cambiar de pantalla.
    - Los fragments y las activities son Views ?, estrictamente hablando no, yo puedo crear un interface que represente lo que va a realizar una vista. La idea es trabajar con la interface y no directamente con el fragment o activity.

- Presenter : Este elemento va tener la lógica , se comunica con el módelo. Recibe los cambios del modelo y actualiza la vista. Se comporta como controlador de las vistas.


## Referencias

 - Principios S.O.L.I.D https://academy.realm.io/posts/learning-path-solid-principles-for-android/

 - Android Architecture Blueprints https://github.com/googlesamples/android-architecture

 - MVP Pattern (Microsoft) https://msdn.microsoft.com/en-us/library/ff649571.aspx

 - GUI Architectures (Martin Fowler) https://martinfowler.com/eaaDev/uiArchs.html

 - MVC, MVP , MVVM (Realm) https://academy.realm.io/posts/eric-maxwell-mvc-mvp-and-mvvm-on-android/

 - Ejemplo MVP
 https://github.com/emedinaa/android-mvp
 
 - Clean Architecture https://docs.google.com/presentation/d/1Eg2V_0j0UO1V3gvYBMYomsMjS9cxD-p-CldPB68ZQxs/edit?usp=sharing
