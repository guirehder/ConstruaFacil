package webTests;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class comprarCursoCS {
    @Dado("^que acesso o site da Iterasys$")
    public void queAcessoOSiteDaIterasys() {
    }

    @Quando("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @E("^clico na lupa$")
    public void clicoNaLupa() {
    }

    @Entao("^vejo a lista de resultados para o curso \"([^\"]*)\"$")
    public void vejoAListaDeResultadosParaOCurso(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Quando("^clico no Matricule-se$")
    public void clicoNoMatriculeSe() {
    }

    @Entao("^confirmo o nome do curso como \"([^\"]*)\" e o preco de \"([^\"]*)\"$")
    public void confirmoONomeDoCursoComoEOPrecoDe(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
