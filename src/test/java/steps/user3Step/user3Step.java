package steps.user3Step;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class user3Step {
    @Dado("que o usuario queira verificar o terceiro usuario")
    public void que_o_usuario_queira_verificar_o_terceiro_usuario() {

    }

    @Quando("o usuario entrou na pagina tres")
    public void o_usuario_entrou_na_pagina_tres() {
        RestAssured.baseURI = "http://restapi.wcaquino.me/users";
    }

    @Entao("validou as informacoes e o statuscode da terceira pagina")
    public void validou_as_informacoes_e_o_statuscode_da_terceira_pagina() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/3");
        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println("resposta do id" + jsonPathEvaluator.get("id"));
        System.out.println("resposta do name" + jsonPathEvaluator.get("name"));
        System.out.println("resposta do age" + jsonPathEvaluator.get("age"));
        System.out.println("resposta do filhos" + jsonPathEvaluator.get("filhos"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "status code correto retornado");
        Assert.assertEquals(jsonPathEvaluator.get("filhos.name[0]"), "Zezinho");
        Assert.assertEquals(jsonPathEvaluator.get("filhos.name[1]"), "Luizinho");
        Assert.assertEquals(jsonPathEvaluator.get("id"),3);
        Assert.assertEquals(jsonPathEvaluator.get("name"), "Ana Júlia");
        Assert.assertEquals(jsonPathEvaluator.get("age"),20);
        System.out.println("Resposta da pagina e => " + +statusCode);
    }
}