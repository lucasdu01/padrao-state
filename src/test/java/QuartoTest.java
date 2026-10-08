import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuartoTest {

    Quarto quarto;

    @BeforeEach
    public void setUp() {
        quarto = new Quarto();
    }

    // ===================== Estado inicial =====================

    @Test
    public void deveIniciarLiberado() {
        assertEquals(QuartoEstadoLiberado.getInstance(), quarto.getEstado());
    }

    // ===================== Liberado =====================

    @Test
    public void deveReservarQuartoLiberado() {
        quarto.setEstado(QuartoEstadoLiberado.getInstance());
        assertTrue(quarto.reservar());
        assertEquals(QuartoEstadoReservado.getInstance(), quarto.getEstado());
    }

    @Test
    public void deveFazerCheckInQuartoLiberado() {
        quarto.setEstado(QuartoEstadoLiberado.getInstance());
        assertTrue(quarto.fazerCheckIn());
        assertEquals(QuartoEstadoOcupado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveFazerCheckOutQuartoLiberado() {
        quarto.setEstado(QuartoEstadoLiberado.getInstance());
        assertFalse(quarto.fazerCheckOut());
        assertEquals(QuartoEstadoLiberado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveCancelarReservaQuartoLiberado() {
        quarto.setEstado(QuartoEstadoLiberado.getInstance());
        assertFalse(quarto.cancelarReserva());
        assertEquals(QuartoEstadoLiberado.getInstance(), quarto.getEstado());
    }

    @Test
    public void deveBloquearQuartoLiberado() {
        quarto.setEstado(QuartoEstadoLiberado.getInstance());
        assertTrue(quarto.bloquear());
        assertEquals(QuartoEstadoEmManutencao.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveConcluirLimpezaQuartoLiberado() {
        quarto.setEstado(QuartoEstadoLiberado.getInstance());
        assertFalse(quarto.concluirLimpeza());
        assertEquals(QuartoEstadoLiberado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveConcluirManutencaoQuartoLiberado() {
        quarto.setEstado(QuartoEstadoLiberado.getInstance());
        assertFalse(quarto.concluirManutencao());
        assertEquals(QuartoEstadoLiberado.getInstance(), quarto.getEstado());
    }

    @Test
    public void deveDesativarQuartoLiberado() {
        quarto.setEstado(QuartoEstadoLiberado.getInstance());
        assertTrue(quarto.desativar());
        assertEquals(QuartoEstadoDesativado.getInstance(), quarto.getEstado());
    }

    // ===================== Reservado =====================

    @Test
    public void naoDeveReservarQuartoReservado() {
        quarto.setEstado(QuartoEstadoReservado.getInstance());
        assertFalse(quarto.reservar());
        assertEquals(QuartoEstadoReservado.getInstance(), quarto.getEstado());
    }

    @Test
    public void deveFazerCheckInQuartoReservado() {
        quarto.setEstado(QuartoEstadoReservado.getInstance());
        assertTrue(quarto.fazerCheckIn());
        assertEquals(QuartoEstadoOcupado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveFazerCheckOutQuartoReservado() {
        quarto.setEstado(QuartoEstadoReservado.getInstance());
        assertFalse(quarto.fazerCheckOut());
        assertEquals(QuartoEstadoReservado.getInstance(), quarto.getEstado());
    }

    @Test
    public void deveCancelarReservaQuartoReservado() {
        quarto.setEstado(QuartoEstadoReservado.getInstance());
        assertTrue(quarto.cancelarReserva());
        assertEquals(QuartoEstadoLiberado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveBloquearQuartoReservado() {
        quarto.setEstado(QuartoEstadoReservado.getInstance());
        assertFalse(quarto.bloquear());
        assertEquals(QuartoEstadoReservado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveConcluirLimpezaQuartoReservado() {
        quarto.setEstado(QuartoEstadoReservado.getInstance());
        assertFalse(quarto.concluirLimpeza());
        assertEquals(QuartoEstadoReservado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveConcluirManutencaoQuartoReservado() {
        quarto.setEstado(QuartoEstadoReservado.getInstance());
        assertFalse(quarto.concluirManutencao());
        assertEquals(QuartoEstadoReservado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveDesativarQuartoReservado() {
        quarto.setEstado(QuartoEstadoReservado.getInstance());
        assertFalse(quarto.desativar());
        assertEquals(QuartoEstadoReservado.getInstance(), quarto.getEstado());
    }

    // ===================== Ocupado =====================

    @Test
    public void naoDeveReservarQuartoOcupado() {
        quarto.setEstado(QuartoEstadoOcupado.getInstance());
        assertFalse(quarto.reservar());
        assertEquals(QuartoEstadoOcupado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveFazerCheckInQuartoOcupado() {
        quarto.setEstado(QuartoEstadoOcupado.getInstance());
        assertFalse(quarto.fazerCheckIn());
        assertEquals(QuartoEstadoOcupado.getInstance(), quarto.getEstado());
    }

    @Test
    public void deveFazerCheckOutQuartoOcupado() {
        quarto.setEstado(QuartoEstadoOcupado.getInstance());
        assertTrue(quarto.fazerCheckOut());
        assertEquals(QuartoEstadoEmLimpeza.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveCancelarReservaQuartoOcupado() {
        quarto.setEstado(QuartoEstadoOcupado.getInstance());
        assertFalse(quarto.cancelarReserva());
        assertEquals(QuartoEstadoOcupado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveBloquearQuartoOcupado() {
        quarto.setEstado(QuartoEstadoOcupado.getInstance());
        assertFalse(quarto.bloquear());
        assertEquals(QuartoEstadoOcupado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveConcluirLimpezaQuartoOcupado() {
        quarto.setEstado(QuartoEstadoOcupado.getInstance());
        assertFalse(quarto.concluirLimpeza());
        assertEquals(QuartoEstadoOcupado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveConcluirManutencaoQuartoOcupado() {
        quarto.setEstado(QuartoEstadoOcupado.getInstance());
        assertFalse(quarto.concluirManutencao());
        assertEquals(QuartoEstadoOcupado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveDesativarQuartoOcupado() {
        quarto.setEstado(QuartoEstadoOcupado.getInstance());
        assertFalse(quarto.desativar());
        assertEquals(QuartoEstadoOcupado.getInstance(), quarto.getEstado());
    }

    // ===================== Em limpeza =====================

    @Test
    public void naoDeveReservarQuartoEmLimpeza() {
        quarto.setEstado(QuartoEstadoEmLimpeza.getInstance());
        assertFalse(quarto.reservar());
        assertEquals(QuartoEstadoEmLimpeza.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveFazerCheckInQuartoEmLimpeza() {
        quarto.setEstado(QuartoEstadoEmLimpeza.getInstance());
        assertFalse(quarto.fazerCheckIn());
        assertEquals(QuartoEstadoEmLimpeza.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveFazerCheckOutQuartoEmLimpeza() {
        quarto.setEstado(QuartoEstadoEmLimpeza.getInstance());
        assertFalse(quarto.fazerCheckOut());
        assertEquals(QuartoEstadoEmLimpeza.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveCancelarReservaQuartoEmLimpeza() {
        quarto.setEstado(QuartoEstadoEmLimpeza.getInstance());
        assertFalse(quarto.cancelarReserva());
        assertEquals(QuartoEstadoEmLimpeza.getInstance(), quarto.getEstado());
    }

    @Test
    public void deveBloquearQuartoEmLimpeza() {
        quarto.setEstado(QuartoEstadoEmLimpeza.getInstance());
        assertTrue(quarto.bloquear());
        assertEquals(QuartoEstadoEmManutencao.getInstance(), quarto.getEstado());
    }

    @Test
    public void deveConcluirLimpezaQuartoEmLimpeza() {
        quarto.setEstado(QuartoEstadoEmLimpeza.getInstance());
        assertTrue(quarto.concluirLimpeza());
        assertEquals(QuartoEstadoLiberado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveConcluirManutencaoQuartoEmLimpeza() {
        quarto.setEstado(QuartoEstadoEmLimpeza.getInstance());
        assertFalse(quarto.concluirManutencao());
        assertEquals(QuartoEstadoEmLimpeza.getInstance(), quarto.getEstado());
    }

    @Test
    public void deveDesativarQuartoEmLimpeza() {
        quarto.setEstado(QuartoEstadoEmLimpeza.getInstance());
        assertTrue(quarto.desativar());
        assertEquals(QuartoEstadoDesativado.getInstance(), quarto.getEstado());
    }

    // ===================== Em manutenção =====================

    @Test
    public void naoDeveReservarQuartoEmManutencao() {
        quarto.setEstado(QuartoEstadoEmManutencao.getInstance());
        assertFalse(quarto.reservar());
        assertEquals(QuartoEstadoEmManutencao.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveFazerCheckInQuartoEmManutencao() {
        quarto.setEstado(QuartoEstadoEmManutencao.getInstance());
        assertFalse(quarto.fazerCheckIn());
        assertEquals(QuartoEstadoEmManutencao.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveFazerCheckOutQuartoEmManutencao() {
        quarto.setEstado(QuartoEstadoEmManutencao.getInstance());
        assertFalse(quarto.fazerCheckOut());
        assertEquals(QuartoEstadoEmManutencao.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveCancelarReservaQuartoEmManutencao() {
        quarto.setEstado(QuartoEstadoEmManutencao.getInstance());
        assertFalse(quarto.cancelarReserva());
        assertEquals(QuartoEstadoEmManutencao.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveBloquearQuartoEmManutencao() {
        quarto.setEstado(QuartoEstadoEmManutencao.getInstance());
        assertFalse(quarto.bloquear());
        assertEquals(QuartoEstadoEmManutencao.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveConcluirLimpezaQuartoEmManutencao() {
        quarto.setEstado(QuartoEstadoEmManutencao.getInstance());
        assertFalse(quarto.concluirLimpeza());
        assertEquals(QuartoEstadoEmManutencao.getInstance(), quarto.getEstado());
    }

    @Test
    public void deveConcluirManutencaoQuartoEmManutencao() {
        quarto.setEstado(QuartoEstadoEmManutencao.getInstance());
        assertTrue(quarto.concluirManutencao());
        assertEquals(QuartoEstadoEmLimpeza.getInstance(), quarto.getEstado());
    }

    @Test
    public void deveDesativarQuartoEmManutencao() {
        quarto.setEstado(QuartoEstadoEmManutencao.getInstance());
        assertTrue(quarto.desativar());
        assertEquals(QuartoEstadoDesativado.getInstance(), quarto.getEstado());
    }

    // ===================== Desativado (estado final) =====================

    @Test
    public void naoDeveReservarQuartoDesativado() {
        quarto.setEstado(QuartoEstadoDesativado.getInstance());
        assertFalse(quarto.reservar());
        assertEquals(QuartoEstadoDesativado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveFazerCheckInQuartoDesativado() {
        quarto.setEstado(QuartoEstadoDesativado.getInstance());
        assertFalse(quarto.fazerCheckIn());
        assertEquals(QuartoEstadoDesativado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveFazerCheckOutQuartoDesativado() {
        quarto.setEstado(QuartoEstadoDesativado.getInstance());
        assertFalse(quarto.fazerCheckOut());
        assertEquals(QuartoEstadoDesativado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveCancelarReservaQuartoDesativado() {
        quarto.setEstado(QuartoEstadoDesativado.getInstance());
        assertFalse(quarto.cancelarReserva());
        assertEquals(QuartoEstadoDesativado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveBloquearQuartoDesativado() {
        quarto.setEstado(QuartoEstadoDesativado.getInstance());
        assertFalse(quarto.bloquear());
        assertEquals(QuartoEstadoDesativado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveConcluirLimpezaQuartoDesativado() {
        quarto.setEstado(QuartoEstadoDesativado.getInstance());
        assertFalse(quarto.concluirLimpeza());
        assertEquals(QuartoEstadoDesativado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveConcluirManutencaoQuartoDesativado() {
        quarto.setEstado(QuartoEstadoDesativado.getInstance());
        assertFalse(quarto.concluirManutencao());
        assertEquals(QuartoEstadoDesativado.getInstance(), quarto.getEstado());
    }

    @Test
    public void naoDeveDesativarQuartoDesativado() {
        quarto.setEstado(QuartoEstadoDesativado.getInstance());
        assertFalse(quarto.desativar());
        assertEquals(QuartoEstadoDesativado.getInstance(), quarto.getEstado());
    }

    // ===================== Nome dos estados =====================

    @Test
    public void deveRetornarNomeDosEstados() {
        assertEquals("Liberado", QuartoEstadoLiberado.getInstance().getEstado());
        assertEquals("Reservado", QuartoEstadoReservado.getInstance().getEstado());
        assertEquals("Ocupado", QuartoEstadoOcupado.getInstance().getEstado());
        assertEquals("Em limpeza", QuartoEstadoEmLimpeza.getInstance().getEstado());
        assertEquals("Em manutencao", QuartoEstadoEmManutencao.getInstance().getEstado());
        assertEquals("Desativado", QuartoEstadoDesativado.getInstance().getEstado());
    }
}
