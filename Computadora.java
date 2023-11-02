public class Computadora implements DispositivoElectronico{
    private String marca;
    private boolean estado = true;
    
    public Computadora(String marca, boolean estado) {
        this.marca = marca;
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
    public String toString() {
        return super.toString();
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
}
