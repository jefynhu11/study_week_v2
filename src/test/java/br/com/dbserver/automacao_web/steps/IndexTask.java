package br.com.dbserver.automacao_web.steps;

import br.com.dbserver.automacao_web.pageobjects.IndexAppObjects;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IndexTask {

    private final IndexAppObjects indexAppObjects;
    private final Faker faker;

    public IndexTask(WebDriver driver) {
        indexAppObjects = new IndexAppObjects(driver);
        faker = new Faker();
    }

    public IndexTask pesquisarProduto(String produto) {
        indexAppObjects.searchTextField().sendKeys(produto);
        indexAppObjects.submitSearchButton().click();
        indexAppObjects.firstResultProductButton().click();
        return this;
    }

    public IndexTask adicionarProdutoAoCarrinho() {
        Assert.assertEquals(indexAppObjects.productPriceLabel().getText(), "$27.00");
        indexAppObjects.addToCartButton().click();
        return this;
    }

    public IndexTask resumoDaCompra() {
        indexAppObjects.layerToCartButton().click();
        Assert.assertEquals(indexAppObjects.totalPriceLabel().getText(), "$29.00");
        indexAppObjects.proceedToCheckoutButton().click();
        return this;
    }

    public IndexTask realizarCadastrar() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        indexAppObjects.createAnAccountTextField().sendKeys(faker.internet().safeEmailAddress());
        indexAppObjects.createAnAccountButton().click();
        indexAppObjects.genderCheckBox().click();
        indexAppObjects.customerFirstNameTextField().sendKeys(firstName);
        indexAppObjects.customerLastNameTextField().sendKeys(lastName);
        indexAppObjects.passwordTextField().sendKeys(faker.internet().password());
        indexAppObjects.firstNameTextField().sendKeys(firstName);
        indexAppObjects.lastNameTextField().sendKeys(lastName);
        indexAppObjects.addressTextField().sendKeys(faker.address().streetAddress());
        indexAppObjects.cityTextField().sendKeys(faker.address().city());
        indexAppObjects.stateComboBox().selectByIndex(6);
        indexAppObjects.postalCodeTextField().sendKeys(faker.number().digits(5));
        indexAppObjects.phoneMobileTextField().sendKeys(faker.phoneNumber().cellPhone());
        indexAppObjects.registerButton().click();
        return this;
    }

    public IndexTask confirmarEndereco() {
        indexAppObjects.processAddressButton().click();
        return this;
    }

    public IndexTask definirRemessa() {
        indexAppObjects.termsOfServiceCheckBox().click();
        indexAppObjects.processCarrierButton().click();
        return this;
    }

    public IndexTask realizarPagamento() {
        indexAppObjects.payByBankWireButton().click();
        indexAppObjects.iConfirmMyOrderButton().click();
        Assert.assertEquals(indexAppObjects.orderConfirmationLabel().getText(), "Your order on My Store is complete.");
        return this;
    }

    public IndexTask desconectar() {
        indexAppObjects.signOutButton().click();
        Assert.assertEquals(indexAppObjects.authenticationLabel().getText(), "AUTHENTICATION");
        return this;
    }

}

