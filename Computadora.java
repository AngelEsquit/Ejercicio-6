public class Computadora implements DispositivoElectronico{
    private boolean estado = true;
    
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
