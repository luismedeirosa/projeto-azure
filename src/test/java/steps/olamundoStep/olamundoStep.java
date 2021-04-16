package steps.olamundoStep;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.not;


public class olamundoStep {

    @Dado("que o usuario queria validar a mensagem da pagina")
    public void que_o_usuario_queria_validar_a_mensagem_da_pagina() {

    }

    @Quando("entrou na pagina")
    public void entrou_na_pagina() {
        RestAssured.baseURI = "http://restapi.wcaquino.me/ola";

    }

    @Então("validou a mensagem e o statuscode")
    public void validou_a_mensagem_e_o_statuscode() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"");
        String responseBody = response.getBody().asString();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200,"status code correto retornado");
        Assert.assertEquals(response.getBody().asString(),"Ola Mundo!");
        System.out.println("Resposta da pagina e => " + responseBody + statusCode);
    }


}

