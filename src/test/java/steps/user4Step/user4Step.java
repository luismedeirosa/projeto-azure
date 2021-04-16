package steps.user4Step;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class user4Step {

    @Dado("que o usuario queira verificar o quarto usuario")
    public void que_o_usuario_queira_verificar_o_quarto_usuario() {

    }

    @Quando("o usuario entrou na pagina quatro")
    public void o_usuario_entrou_na_pagina_quatro() {
        RestAssured.baseURI = "http://restapi.wcaquino.me/users";
    }

    @Entao("validou as informacoes e o statuscode da quarta pagina")
    public void validou_as_informacoes_e_o_statuscode_da_quarta_pagina() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/4");
        String responseBody = response.getBody().asString();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,404,"usuario nao existente ");
        Assert.assertEquals(response.getBody().asString(),"{\"error\":\"Usuário inexistente\"}","usuario nao existente ");

        System.out.println("Resposta da pagina e => " + responseBody + statusCode);
    }
}