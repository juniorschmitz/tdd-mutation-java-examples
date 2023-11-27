package tddexamples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IdadeTest {

    @Test
    public void devePermitirIdadeValida() {
        Idade idade = new Idade();
        String result = idade.ehValida(22);
        assertEquals("VALIDA", result);
    }

//    @Test
//    public void naoDevePermitirIdadeInvalidaSuperior() {
//        Idade idade = new Idade();
//        String result = idade.ehValida(68);
//        assertEquals("INVALIDA", result);
//    }

    @Test
    public void devePermitirIdadeLimiteSuperior() {
        Idade idade = new Idade();
        String result = idade.ehValida(65);
        assertEquals("VALIDA", result);
    }

    @Test
    public void devePermitirIdadeLimiteInferior() {
        Idade idade = new Idade();
        String result = idade.ehValida(18);
        assertEquals("VALIDA", result);
    }

    @Test
    public void naoDevePermitirIdadeInvalida() {
        Idade idade = new Idade();
        String result = idade.ehValida(17);
        assertEquals("INVALIDA", result);
    }

    @Test
    public void naoDevePermitirIdadeInvalidaSuperior() {
        Idade idade = new Idade();
        String result = idade.ehValida(66);
        assertEquals("INVALIDA", result);
    }
}
