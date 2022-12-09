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

## Mecanismos 1 - Técnica extract class

### Descripción

Extract class, o extraer clase, es una de las técnicas usadas para refactorizar el código de un proyecto de programación. Consiste en crear una clase nueva con parte de los elementos de otra.

Una vez generada, esta clase nueva forma parte de los elementos de la clase de la cual se han extraído los componentes para producirla.

### Ventajas

- La técnica extract class permite mejorar la organización del código, haciendo más sencillas las tareas de búsqueda y limpieza del mismo.
- Sirve para mantener nuestros programas más entendibles, puesto que contribuye a que cada fragmento esté orientado a darle solución a un aspecto puntual del proyecto.
- Para agregar más funciones al proyecto, desde la nueva clase que se está extrayendo.

### Como utilizarla

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
