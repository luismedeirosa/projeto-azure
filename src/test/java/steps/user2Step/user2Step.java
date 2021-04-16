package steps.user2Step;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class user2Step {
    @Dado("que o usuario queira verificar o segundo usuario")
    public void que_o_usuario_queira_verificar_o_segundo_usuario() {

    }

    @Quando("o usuario entrou na pagina dois")
    public void o_usuario_entrou_na_pagina_dois() {
        RestAssured.baseURI = "http://restapi.wcaquino.me/users";
    }

    @Entao("validou as informacoes e o statuscode da segunda pagina")
    public void validou_as_informacoes_e_o_statuscode_da_segunda_pagina() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/2");
        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println("resposta do id" + jsonPathEvaluator.get("id"));
        System.out.println("resposta do name" + jsonPathEvaluator.get("name"));
        System.out.println("resposta do age" + jsonPathEvaluator.get("age"));
        System.out.println("resposta do endereco" + jsonPathEvaluator.get("endereco"));
        System.out.println("resposta do salary" + jsonPathEvaluator.get("salary"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "status code correto retornado");
        Assert.assertEquals(jsonPathEvaluator.get("id"),2);
        Assert.assertEquals(jsonPathEvaluator.get("name"), "Maria Joaquina");
        Assert.assertEquals(jsonPathEvaluator.get("age"),25);
        Assert.assertEquals(jsonPathEvaluator.get("salary"), 2500);
        Assert.assertEquals(jsonPathEvaluator.get("endereco.rua"),"Rua dos bobos");
        Assert.assertEquals(jsonPathEvaluator.get("endereco.numero"),0);
        System.out.println("Resposta da pagina e => " + +statusCode);
    }
}
