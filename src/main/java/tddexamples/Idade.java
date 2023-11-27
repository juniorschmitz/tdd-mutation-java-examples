package tddexamples;

public class Idade {
    public String ehValida(Integer idade) {
        String result;
        if (idade >= 18 && idade <= 65) {
            result = "VALIDA";
        }
        else {
            result = "INVALIDA";
        }
        return result;
    }
}
