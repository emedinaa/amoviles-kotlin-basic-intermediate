# Lesson 6 - Saturday, December 15

Curso de Aplicaciones Android con Kotlin (Básico - Intermedio) - Academia Móviles

# Slides

Lesson7-StoragOptions 

# Lesson

Lesson6 https://github.com/emedinaa/amoviles-kotlin-basic-intermediate/archive/Lesson7-StorageOptions.zip

- SharedPreferences

Te permite almacenar información del tipo <key, value>, donde la única forma de que se pierda es borrando la cache de la app o eliminando la aplicación.

Para instanciar el SP , realizamos lo siguiente 

```java
   sharedPreferences=getSharedPreferences("com.amoviles.sharedpref", Context.MODE_PRIVATE);
```
Donde el primer parámetro es el nombre que vamos a usar para este SP y luego , el segundo , es para definir el nivel de privacidad :

```java
  Context.MODE_PRIVATE //Privado y solo se puede acceder desde la app
  Context.MODE_APPEND //Compartido para el resto de apps
```
Para poder almacenar valores en el SP, primero debemos tener una instancia del SharedPreferences.Editor

```java
  private SharedPreferences.Editor sharedPreferencesEditor;
  sharedPreferencesEditor= sharedPreferences.edit();
```
Luego, si queremos guadar un valor usamos el método "putString(key, value)" para almacenar un String y con "apply" concluimos la operación. 

```java
  private void saveStringKey(String key, String value){
  
        sharedPreferencesEditor.putString(key, value);
        sharedPreferencesEditor.apply();
        //sharedPreferencesEditor.commit();
        
    }
 ...
 
 saveStringKey("USERNAME","edu");
```
Despúes de guardar , lo siguiente es poder obtener los valores almacenados. Tener presente que requerimos del

```java
 private void retrieveStringValue(String key){
        String value= sharedPreferences.getString(key,"Valor eliminado");
        //log(String.format("retrieve key : %s , value : %s",key,value));
    }
  ...
  retrieveStringValue("USERNAME");
````

Otra opción que disponemos , es eliminar un elemento del SP o limpiar todo el SP con todos los elementos almacenados.

Si queremos eliminar solo un elemento, necesitamos el Key

```java
  sharedPreferencesEditor.remove(key);
  sharedPreferencesEditor.apply();
```

Pero , si lo que necesitamos es borrar o limpiar todo el SP

```java
 private void clear(){
        
        //sharedPreferencesEditor.remove(key);
        sharedPreferencesEditor.clear();
        sharedPreferencesEditor.apply();
    }
```

- Inicializar SharedPreferences

```java
Context context = getActivity();
SharedPreferences sharedPref = context.getSharedPreferences(
        getString(R.string.preference_file_key), Context.MODE_PRIVATE);
```

- Guardar un valor

```java
SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPref.edit();
editor.putInt(getString(R.string.saved_high_score_key), newHighScore);
editor.commit();
```

- Obtener un valor

```java
SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
int defaultValue = getResources().getInteger(R.integer.saved_high_score_default_key);
int highScore = sharedPref.getInt(getString(R.string.saved_high_score_key), defaultValue);
```

## Samples


## Exercises

## Homework
- xxxx

## Resources 

- Save Key-Value Data with SharedPreferences https://developer.android.com/training/data-storage/shared-preferences.html#java

- Save Data using SQLite https://developer.android.com/training/data-storage/sqlite.html

- Storage Options https://developer.android.com/guide/topics/data/data-storage.html

- Saving Files https://developer.android.com/training/data-storage/files.html

- Data and File Storage Overview https://developer.android.com/guide/topics/data/data-storage.html

- SharedPreferences https://developer.android.com/training/data-storage/shared-preferences.html

- Uplabs https://www.uplabs.com/android

