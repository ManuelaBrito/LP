package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class DogController {

    @FXML private TextField txtNome;
    @FXML private TextField txtCor;
    @FXML private TextField txtIdioma;

    @FXML private TableView<Dog> tableView;
    @FXML private TableColumn<Dog, String> colNome;
    @FXML private TableColumn<Dog, String> colCor;
    @FXML private TableColumn<Dog, String> colIdioma;

    @FXML private Button btnSalvar;
    @FXML private Button btnAtualizar;
    @FXML private Button btnExcluir;
    @FXML private Button btnNovo;
    @FXML private Button btnBuscar;

    private DogDAO dogDAO = new DogDAO();
    private ObservableList<Dog> dogsList = FXCollections.observableArrayList();
    private Dog dogSelecionado = null;

    @FXML
    public void initialize() {
        configurarTabela();
        carregarDogs();
        configurarBotoes();
    }

    private void configurarTabela() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colIdioma.setCellValueFactory(new PropertyValueFactory<>("idioma"));

        tableView.setItems(dogsList);

        // Quando selecionar um dog na tabela
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarDog(newValue)
        );
    }

    private void carregarDogs() {
        dogsList.clear();
        List<Dog> dogs = dogDAO.listarDogs();
        dogsList.addAll(dogs);
    }

    private void configurarBotoes() {
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
    }

    private void selecionarDog(Dog dog) {
        if (dog != null) {
            dogSelecionado = dog;
            txtNome.setText(dog.getNome());
            txtCor.setText(dog.getCor());
            txtIdioma.setText(dog.getIdioma());

            btnSalvar.setDisable(true);
            btnAtualizar.setDisable(false);
            btnExcluir.setDisable(false);
        }
    }

    @FXML
    private void salvarDog() {
        if (validarCampos()) {
            Dog dog = new Dog(
                    txtNome.getText(),
                    txtCor.getText(),
                    txtIdioma.getText()
            );

            dogDAO.inserirDog(dog);
            carregarDogs();
            limparCampos();
            mostrarAlerta("Sucesso", "Cachorro salvo com sucesso!", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    private void atualizarDog() {
        if (dogSelecionado != null && validarCampos()) {
            Dog dogAtualizado = new Dog(
                    txtNome.getText(),
                    txtCor.getText(),
                    txtIdioma.getText()
            );

            dogDAO.atualizarDog(dogSelecionado.getNome(), dogAtualizado);
            carregarDogs();
            limparCampos();
            mostrarAlerta("Sucesso", "Cachorro atualizado com sucesso!", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    private void excluirDog() {
        if (dogSelecionado != null) {
            // Confirmação antes de excluir
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText("Excluir Cachorro");
            confirmacao.setContentText("Tem certeza que deseja excluir " + dogSelecionado.getNome() + "?");

            if (confirmacao.showAndWait().get() == ButtonType.OK) {
                dogDAO.excluirDog(dogSelecionado.getNome());
                carregarDogs();
                limparCampos();
                mostrarAlerta("Sucesso", "Cachorro excluído com sucesso!", Alert.AlertType.INFORMATION);
            }
        }
    }

    @FXML
    private void novoDog() {
        limparCampos();
        dogSelecionado = null;
        tableView.getSelectionModel().clearSelection();
        btnSalvar.setDisable(false);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
    }

    @FXML
    private void buscarDog() {
        String nome = txtNome.getText();
        if (!nome.isEmpty()) {
            Dog dog = dogDAO.buscarPorNome(nome);
            if (dog != null) {
                dogsList.clear();
                dogsList.add(dog);
            } else {
                mostrarAlerta("Busca", "Cachorro não encontrado!", Alert.AlertType.WARNING);
            }
        } else {
            carregarDogs(); // Se campo vazio, mostra todos
        }
    }

    private void limparCampos() {
        txtNome.clear();
        txtCor.clear();
        txtIdioma.clear();
    }

    private boolean validarCampos() {
        if (txtNome.getText().isEmpty() || txtCor.getText().isEmpty() || txtIdioma.getText().isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}