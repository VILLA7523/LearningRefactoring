# PRÁCTICA 7: REFACTORING - MECANISMOS

Aplicar al menos 2 mecanismos de Refactoring al siguiente ejemplo de código.

```javascript
class Persona {
  String nombre;
  String dni;
  String codArea;
  String numTelefono;

  String getNombre() {
   return nombre;
  }
  String getDni() {
    return dni;
  }
  String getNumeroTelefono() {
    return codArea + numTelefono;
  }
}

class Empresa {
  String nombre;
  String ruc;
  String codArea;
  String numTelefono;

  String getNombre() {
    return nombre;
  }
  String getRuc() {
    return ruc;
  }
  String getNumeroTelefono() {
    return codArea + numTelefono;
  }
}
```

## Mecanismo 1 - Técnica extract class

### Descripción

Extract class, o extraer clase, es una de las técnicas usadas para refactorizar el código de un proyecto de programación. Consiste en crear una clase nueva con parte de los elementos de otra.

Una vez generada, esta clase nueva forma parte de los elementos de la clase de la cual se han extraído los componentes para producirla.

### Beneficios

- La técnica extract class permite mejorar la organización del código, haciendo más sencillas las tareas de búsqueda y limpieza del mismo.
- Sirve para mantener nuestros programas más entendibles, puesto que contribuye a que cada fragmento esté orientado a darle solución a un aspecto puntual del proyecto.
- Para agregar más funciones al proyecto, desde la nueva clase que se está extrayendo.

### Como refactorizar

1. Revisar el código para determinar si hay una clase que necesita aplicar esta técnica de refactorización.
2. Verificar cuáles son los elementos de esa clase que se quiere mover a una nueva clase. Luego, se puede generar la nueva clase y darle un nombre que identifique de manera clara lo que esta hace.
3. Ahora es el momento de mover cada uno de los elementos necesarios a esa nueva clase.
   Con la clase ya construida, se establece una conexión entre la clase origen y esta que se acaba de estructurar.
4. Finalmente, se realizan las pruebas necesarias para determinar si el cambio no afecta la funcionalidad del proyecto y si todo está trabajando de manera eficiente.

### Fragmento de código

Siguiendo los pasos mencionados anteriormente , tenemos:

1. En el código se puede observar que tanto la clase **Persona** como la clase **Empresa** estan haciendo uso de la función de obtener teléfono , por lo que estas clases estan haciendo un trabajo que debe ser hecho por otra clase más.
2. Los elementos identificados son _codArea_ y _numTelefono_ , estos se mueven a la nueva clase que la definiremos como **Telefono**
3. Una vez ya creada se hace la conexión con las otras dos clases , con la clase **Persona** y la clase **Empresa** por medio del método _getTelefono_ , además declaramos la instancia de esta clase en las otras dos.

**El resultado se puede observar en la siguiente fracción de código.**

```javascript
class Telefono {
  String codArea;
  String numTelefono;

  String getTelefono() {
    return codArea + numTelefono;
  }
}

class Persona {
  String nombre;
  String dni;
  Telefono telefono = new Telefono();

  String getNombre() {
    return nombre;
  }
  String getDni() {
    return dni;
  }
  String getTelefono() {
    return telefono.getTelefono();
  }
}

class Empresa
{
  String nombre;
  String ruc;
  Telefono telefono = new Telefono();

  String getNombre() {
    return nombre;
  }
  String getRuc() {
    return ruc;
  }
  String getTelefono() {
    return telefono.getTelefono();
  }
}
```

## Mecanismo 2 - Técnica Encapsulate Field

### Descripción

La Técnica de Encapsulate Field permite ocultar sus datos y crear los accesores necesarios.

Es una buena idea ocultar los datos de una clase y acceder a ellos a través de una interfaz externa basada en métodos de acceso. Posteriormente, se puede cambiar los datos internos, conservando la compatibilidad total con el código basado en la clase y sus métodos disponibles.

### Beneficios

- El acceso indirecto a los campos es cuando se actúa sobre un campo a través de métodos de acceso (getters y setters). Este enfoque es mucho más flexible que el acceso directo a los campos .
- En primer lugar, puede realizar operaciones complejas cuando se configuran o reciben datos en el campo. La inicialización diferida y la validación de valores de campo se implementan fácilmente dentro de captadores y definidores de campos.
- En segundo lugar y más importante, puede redefinir getters y setters en subclases.
- Tiene la opción de no implementar un setter para un campo en absoluto. El valor del campo se especificará solo en el constructor, lo que hará que el campo no se pueda modificar durante toda la vida útil del objeto.

### Como refactorizar

1. Crear un getter (y un setter opcional) para el campo. Deben ser public.
2. Encuentre todas las invocaciones directas del campo y reemplácelas con llamadas getter y setter.

### Fragmento de código

Siguiendo los pasos mencionados anteriormente , tenemos:

1. Creamos getter y setter para las clases definidas , como métodos y atributos public , la única clase que no dispone como private es la instancia de la clase **Telefono** que se hacen en la clase Empresa y Clase Persona , sin embargo los métodos y atributos de la clase Telefono si son de tipo private
2. En la clase Persona como en la clase Empresa creamos el metodo _setDataTelefono_ para poder guardar los datos que son de tipo privado en la clase telefono.

**El resultado se puede observar en la siguiente fracción de código.**

```javascript
class Telefono {
  private String codArea;
  private String numTelefono;

  void setCodArea(String _codArea) {
    this.codArea = _codArea;
  }
  void setNumTelefono(String _numTelefono) {
    this.numTelefono = _numTelefono;
  }
  String getCodeArea() {
    return this.codArea;
  }
  String getNumTelefono() {
    return this.numTelefono;
  }
  String getTelefono() {
    return this.codArea + this.numTelefono;
  }
}

class Persona {
  private String nombre;
  private String dni;
  public Telefono telefono = new Telefono();

  void setNombre(String _nombre) {
    this.nombre = _nombre;
  }
  void setDni(String _dni) {
    this.dni = _dni;
  }
  void setDataTelefono(String _codeArea, String _numTelefono) {
    telefono.setCodArea(_codeArea);
    telefono.setNumTelefono(_numTelefono);
  }
  String getNombre() {
    return nombre;
  }
  String getDni() {
    return dni;
  }
  String getTelefono() {
    return telefono.getTelefono();
  }
}

class Empresa
{
  String nombre;
  String ruc;
  Telefono telefono = new Telefono();

  void setNombre(String _nombre) {
    this.nombre = _nombre;
  }
  void setDni(String _ruc) {
    this.ruc = _ruc;
  }
  void setDataTelefono(String _codeArea, String _numTelefono) {
    telefono.setCodArea(_codeArea);
    telefono.setNumTelefono(_numTelefono);
  }
  String getNombre() {
    return nombre;
  }
  String getRuc() {
    return ruc;
  }
  String getTelefono() {
    return telefono.getTelefono();
  }
}

```
