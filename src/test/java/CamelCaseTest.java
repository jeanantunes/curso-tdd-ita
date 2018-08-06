import com.jotait.exception.ComecaComDigitoException;
import com.jotait.exception.PossuiCaracterEspecialException;
import com.jotait.utils.Converter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CamelCaseTest {

    @Test
    public void converteComUmaPalavraInicioMinusculo() {
        List<String> resultadoEsperado = Arrays.asList("nome");
        String cadeiaDeCaracteres = "nome";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComUmaPalavraInicioMaiusculo() {
        List<String> resultadoEsperado = Arrays.asList("nome");
        String cadeiaDeCaracteres = "Nome";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComUmaPalavraAcronimo() {
        List<String> resultadoEsperadoCPF = Arrays.asList("CPF");
        String cadeiaDeCaracteresCPF = "CPF";

        List<String> resultadoEsperadoCEP = Arrays.asList("CEP");
        String cadeiaDeCaracteresCEP = "CEP";

        assertEquals(resultadoEsperadoCPF, Converter.converterCamelCase(cadeiaDeCaracteresCPF));
        assertEquals(resultadoEsperadoCEP, Converter.converterCamelCase(cadeiaDeCaracteresCEP));
    }

    @Test
    public void converteComDuasPalavraInicioMinusculo() {
        List<String> resultadoEsperado = Arrays.asList("nome", "Composto");
        String cadeiaDeCaracteres = "nomeComposto";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComDuasPalavraInicioMaiusculo() {
        List<String> resultadoEsperado = Arrays.asList("nome", "Composto");
        String cadeiaDeCaracteres = "NomeComposto";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComDuasPalavraSegundaAcronimo() {
        List<String> resultadoEsperado = Arrays.asList("numero", "CPF");
        String cadeiaDeCaracteres = "numeroCPF";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComDuasPalavraPrimeiraAcronimo() {
        List<String> resultadoEsperado = Arrays.asList("CPF", "Numero");
        String cadeiaDeCaracteres = "CPFNumero";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComDuasPalavraSegundaNumero() {
        List<String> resultadoEsperado = Arrays.asList("CPF", "10");
        String cadeiaDeCaracteres = "CPF10";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComMaisDeDuasPalavraPrimeiraMinuscula() {
        List<String> resultadoEsperado = Arrays.asList("vamos", "Testar", "Agora", "Cara");
        String cadeiaDeCaracteres = "vamosTestarAgoraCara";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComMaisDeDuasPalavraPrimeiraMaiuscula() {
        List<String> resultadoEsperado = Arrays.asList("vamos", "Testar", "Agora", "Cara");
        String cadeiaDeCaracteres = "VamosTestarAgoraCara";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComMaisDeDuasPalavraComAcronimoPrimeiraMinuscula() {
        List<String> resultadoEsperado = Arrays.asList("vamos", "Testar", "CEP", "Agora", "Cara");
        String cadeiaDeCaracteres = "vamosTestarCEPAgoraCara";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComMaisDeDuasPalavraComAcronimoPrimeiraMaiuscula() {
        List<String> resultadoEsperado = Arrays.asList("vamos", "Testar", "CEP", "Agora", "Cara");
        String cadeiaDeCaracteres = "VamosTestarCEPAgoraCara";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComMaisDeDuasPalavraComAcronimoComNumeroPrimeiraMinuscula() {
        List<String> resultadoEsperado = Arrays.asList("vamos", "Testar", "CEP", "10", "Agora", "Cara");
        String cadeiaDeCaracteres = "vamosTestarCEP10AgoraCara";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test
    public void converteComMaisDeDuasPalavraComAcronimoComNumeroPrimeiraMaiuscula() {
        List<String> resultadoEsperado = Arrays.asList("vamos", "Testar", "CEP", "10", "Agora", "Cara");
        String cadeiaDeCaracteres = "vamosTestarCEP10AgoraCara";

        assertEquals(resultadoEsperado, Converter.converterCamelCase(cadeiaDeCaracteres));
    }

    @Test(expected = PossuiCaracterEspecialException.class)
    public void palavraComCaracteresEspeciais() {
        String cadeiaDeCaracteres = "#vamos&TestarCEP10AgoraCara";

        Converter.converterCamelCase(cadeiaDeCaracteres);
    }

    @Test(expected = ComecaComDigitoException.class)
    public void palavraComDigito() {
        String cadeiaDeCaracteres = "1vamosTestarCEP10AgoraCara";

        Converter.converterCamelCase(cadeiaDeCaracteres);
    }

}
