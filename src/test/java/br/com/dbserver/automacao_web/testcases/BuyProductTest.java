package br.com.dbserver.automacao_web.testcases;


import br.com.dbserver.automacao_web.steps.IndexTask;
import br.com.dbserver.utils.BaseTest;
import br.com.dbserver.utils.Property;
import br.com.dbserver.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BuyProductTest extends BaseTest {

    @Test(
            description = "Adicionar produto ao carrinho, cadastro e compra",
            priority = 1
    )
    public void test() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(Property.get("url"));

        IndexTask indexTask = new IndexTask(driver);
        indexTask.pesquisarProduto("Blouse")
                .adicionarProdutoAoCarrinho()
                .resumoDaCompra()
                .realizarCadastrar()
                .confirmarEndereco()
                .definirRemessa()
                .realizarPagamento()
                .desconectar();
    }

}
