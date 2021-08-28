package preencher.campo.de.cadastro;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.beans.binding.Bindings;
import javafx.scene.chart.PieChart;
import javafx.scene.input.DataFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PreencherCamposDeCadastro {

    WebDriver navegador;

    public String getData(){
        DateFormat dataFormat = new SimpleDateFormat("yy-MM-yy");
        Date date = new Date();
        return dataFormat.format(date);
    }


    @Given("Acessar o navegador")
    public void acessar_o_navegador() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Just\\AppData\\Local\\Temp\\Temp7_chromedriver_win32.zip\\chromedriver.exe");
        navegador = new ChromeDriver();

        //maximizando a tela
        navegador.manage().window().maximize();

        //Acessando o cadastro
        navegador.get("https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Faccounts.google.com%2FManageAccount%3Fnc%3D1&hl=pt-br&flowName=GlifWebSignIn&flowEntry=SignUp");
    }
    @When("Acessar o cadastro e preencher os dados da Tela")
    public void acessar_o_cadastro_e_preencher_os_dados_da_tela() {

        //Campo Nome
        navegador.findElement(By.id("firstName")).sendKeys("Maria");

        //Campo Sobrenome
        navegador.findElement(By.id("lastName")).sendKeys("Miranda");

        //Campo Gmail
        navegador.findElement(By.id("username")).sendKeys("maria.miranda11996");

        //Campo senha
        navegador.findElement(By.name("Passwd")).sendKeys("Mmaria001");

        //Campo Confirmar
        navegador.findElement(By.name("ConfirmPasswd")).sendKeys("Mmaria001");


    }


    @Then("Visulizar a tela preenchida")
    public void visulizar_a_tela_preenchida() throws IOException {


        TakesScreenshot ts=(TakesScreenshot)navegador;
        java.io.File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new java.io.File("automação.cadastr\\Screenshot"+getData()));


    }

}
