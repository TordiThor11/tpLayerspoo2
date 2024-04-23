package ejercicio1.model;

public class Participante {
    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono, String region) throws Exception {
        if (!esValidoElTelefono(telefono)) {
            throw new Exception("Telefono invalido");
        }
        if (!esRegionValida(region)) {
            throw new Exception("region invalido");
        }
        if (!esValido(nombre, telefono, region)) {
            throw new Exception("Campos vacios");
        }
        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    private boolean esValido(String nombre, String telefono, String region) {
        return !nombre.trim().isEmpty() || telefono.trim().isEmpty() || region.trim().isEmpty();
    }

    private boolean esRegionValida(String region) {
        return region.equals("China") || region.equals("US") || region.equals("Europa");
    }

    private boolean esValidoElTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRegion() {
        return region;
    }

}
