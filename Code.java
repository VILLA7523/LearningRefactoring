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
