public class Quarto {

    private QuartoEstado estado;

    public Quarto() {
        this.estado = QuartoEstadoLiberado.getInstance();
    }

    public QuartoEstado getEstado() {
        return estado;
    }

    public void setEstado(QuartoEstado estado) {
        this.estado = estado;
    }

    public boolean reservar(){
        return estado.reservar(this);
    }

    public boolean fazerCheckIn(){
        return estado.fazerCheckIn(this);
    }

    public boolean fazerCheckOut(){
        return estado.fazerCheckOut(this);
    }

    public boolean cancelarReserva(){
        return estado.cancelarReserva(this);
    }

    public boolean bloquear(){
        return estado.bloquear(this);
    }

    public boolean concluirLimpeza(){
        return estado.concluirLimpeza(this);
    }

    public boolean concluirManutencao(){
        return estado.concluirManutencao(this);
    }

    public boolean desativar() {
        return estado.desativar(this);
    }

}
