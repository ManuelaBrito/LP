package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class telacaixaController {

    // -----------------------------
    // Componentes Caixa
    // -----------------------------
    @FXML
    private TextField txt_tam1;

    @FXML
    private TextField txt_cor1;

    @FXML
    private TextField txt_dono;

    @FXML
    private Button btn_salvar1;

    // -----------------------------
    // Componentes Homem
    // -----------------------------
    @FXML
    private TextField txt_altura;

    @FXML
    private TextField txt_cor2;

    @FXML
    private TextField txt_persona;

    @FXML
    private Button btn_salvar2;

    // -----------------------------
    // Componentes Casa
    // -----------------------------
    @FXML
    private TextField txt_loc;

    @FXML
    private TextField txt_cor3;

    @FXML
    private TextField txt_tam3;

    @FXML
    private Button btn_salvar;

    // -----------------------------
    // Ações dos botões
    // -----------------------------

    // Caixa
    @FXML
    public void enviarDados(ActionEvent event) {
        // Cria objeto Caixa com os dados do formulário
        Caixa caixa = new Caixa(
                txt_tam1.getText(),
                txt_cor1.getText(),
                txt_dono.getText()
        );

        // Salva em CSV
        caixa.salvar();

        // Limpa campos de texto
        txt_tam1.clear();
        txt_cor1.clear();
        txt_dono.clear();

        System.out.println("Dados da Caixa salvos com sucesso!");
    }

    // Homem
    @FXML
    public void enviarDados2(ActionEvent event) {
        double altura = 0;
        try {
            altura = Double.parseDouble(txt_altura.getText());
        } catch (NumberFormatException e) {
            System.out.println("Altura inválida!");
        }

        Homem homem = new Homem(
                altura,
                txt_cor2.getText(),
                txt_persona.getText()
        );

        homem.salvar();

        txt_altura.clear();
        txt_cor2.clear();
        txt_persona.clear();

        System.out.println("Dados do Homem salvos com sucesso!");
    }

    // Casa
    @FXML
    public void enviarDados3(ActionEvent event) {
        Casa casa = new Casa(
                txt_loc.getText(),
                txt_cor3.getText(),
                txt_tam3.getText()
        );

        casa.salvar();

        txt_loc.clear();
        txt_cor3.clear();
        txt_tam3.clear();

        System.out.println("Dados da Casa salvos com sucesso!");
    }
}
