package steps.user1Step;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;


import static io.restassured.RestAssured.get;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.not;

public class user1Step {
    @Dado("que o usuario queira verificar o primeiro usuario")
    public void que_o_usuario_queira_verificar_o_primeiro_usuario() {

    }

    @Quando("o usuario entrou na pagina")
    public void o_usuario_entrou_na_pagina() {
        RestAssured.baseURI = "http://restapi.wcaquino.me/users";
    }

    @Entao("validou as informacoes e o statuscode")
    public void validou_as_informacoes_e_o_statuscode() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/1");
        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println("resposta do id" + jsonPathEvaluator.get("id"));
        System.out.println("resposta do name" + jsonPathEvaluator.get("name"));
        System.out.println("resposta do age" + jsonPathEvaluator.get("age"));
        System.out.println("resposta do salary" + jsonPathEvaluator.get("salary"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(jsonPathEvaluator.get("id"),1);
        Assert.assertEquals(jsonPathEvaluator.get("name"), "João da Silva");
        Assert.assertEquals(jsonPathEvaluator.get("age"),30);
        Assert.assertEquals(jsonPathEvaluator.get("salary"),1234.5677f);
        Assert.assertEquals(statusCode,200,"status code correto retornado");
        System.out.println("Resposta da pagina e => " +  + statusCode);


    }

}
