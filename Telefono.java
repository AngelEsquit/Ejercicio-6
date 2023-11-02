public class Telefono implements DispositivoElectronico{
    private String modelo;
    private boolean estado = true;

    public Telefono(String modelo, boolean estado) {
        this.modelo = modelo;
        this.estado = estado;
    }

    @Override
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean getEstado() {
        return this.estado;
    }
    
    @Override
    public String validarEstado() {
        if (estado == true) {
            return "Está encendido";
        }

        else {
            return "Está apagado";
        }
    }
    
    @Override
    public String toString() {
        return super.toString();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
