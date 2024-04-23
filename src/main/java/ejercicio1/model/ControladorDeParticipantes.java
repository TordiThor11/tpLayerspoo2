package ejercicio1.model;

public class ControladorDeParticipantes {
    private RegistroDeParticipantes registroDeParticipantes;

    public ControladorDeParticipantes(RegistroDeParticipantes registroDeParticipantes) {
        this.registroDeParticipantes = registroDeParticipantes;
    }

    public void registrarParticipante(Participante participante) {
        this.registroDeParticipantes.registrar(participante);
    }
}
