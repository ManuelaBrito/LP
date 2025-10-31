package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrimaryController {

    // Seus campos FXML
    @FXML private AnchorPane acp_dog;
    @FXML private AnchorPane acp_planta;
    @FXML private AnchorPane acp_sitio;
    @FXML private Button btn_salvar1;
    @FXML private Button btn_salvar2;
    @FXML private Button btn_salvar3;
    @FXML private Tab tap_planta;
    @FXML private Tab tap_planta1;
    @FXML private Tab tap_sitio;
    @FXML private TextField txt_cogu;
    @FXML private TextField txt_cor1;
    @FXML private TextField txt_cor3;
    @FXML private TextField txt_duende;
    @FXML private TextField txt_espe;
    @FXML private TextField txt_idioma;
    @FXML private TextField txt_nome;
    @FXML private TextField txt_tam1;
    @FXML private TextField txt_tam2;

    private CsvLeituraEscrita csvWriter = new CsvLeituraEscrita();

    // Método para trocar de tela
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    // Método para salvar dados do SÍTIO
    @FXML
    private void salvarDados1() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String[] cabecalho = {"Data_Hora", "Tamanho", "Duende", "Cogumelo"};
        String[][] dados = {
                {timestamp, txt_tam1.getText(), txt_duende.getText(), txt_cogu.getText()}
        };

        // Escreve no CSV (apenas cabeçalho na primeira vez)
        boolean arquivoExiste = new java.io.File("sitio.csv").exists();
        csvWriter.escreverCSV("sitio.csv", arquivoExiste ? null : cabecalho, dados);

        mostrarMensagemSucesso("Sítio");
        limparCamposAba1();
    }

    // Método para salvar dados da PLANTA
    @FXML
    private void salvarDados2() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String[] cabecalho = {"Data_Hora", "Cor", "Tamanho", "Especie"};
        String[][] dados = {
                {timestamp, txt_cor1.getText(), txt_tam2.getText(), txt_espe.getText()}
        };

        boolean arquivoExiste = new java.io.File("planta.csv").exists();
        csvWriter.escreverCSV("planta.csv", arquivoExiste ? null : cabecalho, dados);

        mostrarMensagemSucesso("Planta");
        limparCamposAba2();
    }

    // Método para salvar dados do DOG
    @FXML
    private void salvarDados3() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String[] cabecalho = {"Data_Hora", "Nome", "Cor", "Idioma"};
        String[][] dados = {
                {timestamp, txt_nome.getText(), txt_cor3.getText(), txt_idioma.getText()}
        };

        boolean arquivoExiste = new java.io.File("dog.csv").exists();
        csvWriter.escreverCSV("dog.csv", arquivoExiste ? null : cabecalho, dados);

        mostrarMensagemSucesso("Dog");
        limparCamposAba3();
    }

    // Métodos auxiliares
    private void mostrarMensagemSucesso(String aba) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Dados salvos!");
        alert.setContentText("Dados da aba " + aba + " salvos em CSV");
        alert.showAndWait();
    }

    private void limparCamposAba1() {
        txt_tam1.clear();
        txt_duende.clear();
        txt_cogu.clear();
    }

    private void limparCamposAba2() {
        txt_cor1.clear();
        txt_tam2.clear();
        txt_espe.clear();
    }

    private void limparCamposAba3() {
        txt_nome.clear();
        txt_cor3.clear();
        txt_idioma.clear();
    }
}