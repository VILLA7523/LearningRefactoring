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

### Fragmento de código

```javascript

```
