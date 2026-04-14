package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class PrimaryController {

    // ==================== COMPONENTES EXISTENTES ====================
    @FXML private Tab tap_sitio;
    @FXML private AnchorPane acp_sitio;
    @FXML private TextField txt_tam1;
    @FXML private TextField txt_duende;
    @FXML private TextField txt_cogu;
    @FXML private Button btn_salvar1;
    @FXML private Button btn_excluir1;
    @FXML private TableView<Sitio> Table_sítio;
    @FXML private TableColumn<Sitio, Integer> col_sitio_id;
    @FXML private TableColumn<Sitio, String> col_sitio_tamanho;
    @FXML private TableColumn<Sitio, String> col_sitio_duende;
    @FXML private TableColumn<Sitio, String> col_sitio_cogumelo;

    @FXML private Tab tap_planta;
    @FXML private AnchorPane acp_planta;
    @FXML private TextField txt_tam2;
    @FXML private TextField txt_cor1;
    @FXML private TextField txt_espe;
    @FXML private Button btn_salvar2;
    @FXML private Button btn_excluir2;
    @FXML private TableView<Planta> table_planta_tabela;
    @FXML private TableColumn<Planta, Integer> col_planta_id;
    @FXML private TableColumn<Planta, String> col_planta_tamanho;
    @FXML private TableColumn<Planta, String> col_planta_cor;
    @FXML private TableColumn<Planta, String> col_planta_especie;

    @FXML private Tab tap_planta1;
    @FXML private AnchorPane acp_dog;
    @FXML private TextField txt_nome;
    @FXML private TextField txt_cor3;
    @FXML private TextField txt_idioma;
    @FXML private Button btn_salvar3;
    @FXML private Button btn_excluir3;
    @FXML private TableView<Dog> table_dog_tabela;
    @FXML private TableColumn<Dog, Integer> col_dog_id;
    @FXML private TableColumn<Dog, String> col_dog_nome;
    @FXML private TableColumn<Dog, String> col_dog_cor;
    @FXML private TableColumn<Dog, String> col_dog_idioma;

    // ==================== VARIÁVEIS ====================
    private DogDAO dogDAO = new DogDAO();
    private PlantaDAO plantaDAO = new PlantaDAO();
    private SitioDAO sitioDAO = new SitioDAO();

    private ObservableList<Dog> dogsList = FXCollections.observableArrayList();
    private ObservableList<Planta> plantasList = FXCollections.observableArrayList();
    private ObservableList<Sitio> sitiosList = FXCollections.observableArrayList();

    // Variáveis para armazenar seleção
    private Sitio sitioSelecionado;
    private Planta plantaSelecionada;
    private Dog dogSelecionado;

    @FXML
    public void initialize() {
        configurarTabelas();
        carregarDados();
        configurarSelecoes();
    }

    private void configurarTabelas() {
        // Configurar tabela Sítio
        col_sitio_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_sitio_tamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        col_sitio_duende.setCellValueFactory(new PropertyValueFactory<>("duende"));
        col_sitio_cogumelo.setCellValueFactory(new PropertyValueFactory<>("cogumelo"));
        Table_sítio.setItems(sitiosList);

        // Configurar tabela Plantas
        col_planta_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_planta_tamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        col_planta_cor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        col_planta_especie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        table_planta_tabela.setItems(plantasList);

        // Configurar tabela Dogs
        col_dog_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_dog_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        col_dog_cor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        col_dog_idioma.setCellValueFactory(new PropertyValueFactory<>("idioma"));
        table_dog_tabela.setItems(dogsList);
    }

    private void configurarSelecoes() {
        // Seleção na tabela Sítio
        Table_sítio.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    sitioSelecionado = newSelection;
                    btn_excluir1.setDisable(newSelection == null);
                    if (newSelection != null) {
                        preencherCamposSitio(newSelection);
                    }
                }
        );

        // Seleção na tabela Planta
        table_planta_tabela.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    plantaSelecionada = newSelection;
                    btn_excluir2.setDisable(newSelection == null);
                    if (newSelection != null) {
                        preencherCamposPlanta(newSelection);
                    }
                }
        );

        // Seleção na tabela Dog
        table_dog_tabela.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    dogSelecionado = newSelection;
                    btn_excluir3.setDisable(newSelection == null);
                    if (newSelection != null) {
                        preencherCamposDog(newSelection);
                    }
                }
        );

        // Inicialmente desabilitar botões de excluir
        btn_excluir1.setDisable(true);
        btn_excluir2.setDisable(true);
        btn_excluir3.setDisable(true);
    }

    // ==================== MÉTODOS SALVAR ====================

    @FXML
    private void salvarDados1() {
        salvarSitio();
    }

    @FXML
    private void salvarDados2() {
        salvarPlanta();
    }

    @FXML
    private void salvarDados3() {
        salvarDog();
    }

    private void salvarSitio() {
        if (validarCamposSitio()) {
            Sitio sitio = new Sitio(
                    txt_tam1.getText(),
                    txt_duende.getText(),
                    txt_cogu.getText()
            );

            sitioDAO.inserirSitio(sitio);
            carregarSitios();
            limparCamposSitio();
            mostrarAlerta("Sucesso", "Sítio salvo com sucesso!", Alert.AlertType.INFORMATION);
        }
    }

    private void salvarPlanta() {
        if (validarCamposPlanta()) {
            Planta planta = new Planta(
                    txt_tam2.getText(),
                    txt_cor1.getText(),
                    txt_espe.getText()
            );

            plantaDAO.inserirPlanta(planta);
            carregarPlantas();
            limparCamposPlanta();
            mostrarAlerta("Sucesso", "Planta salva com sucesso!", Alert.AlertType.INFORMATION);
        }
    }

    private void salvarDog() {
        if (validarCamposDog()) {
            Dog dog = new Dog(
                    txt_nome.getText(),
                    txt_cor3.getText(),
                    txt_idioma.getText()
            );

            dogDAO.inserirDog(dog);
            carregarDogs();
            limparCamposDog();
            mostrarAlerta("Sucesso", "Cachorro salvo com sucesso!", Alert.AlertType.INFORMATION);
        }
    }

    // ==================== MÉTODOS EXCLUIR ====================

    @FXML
    private void excluirDados1() {
        excluirSitio();
    }

    @FXML
    private void excluirDados2() {
        excluirPlanta();
    }

    @FXML
    private void excluirDados3() {
        excluirDog();
    }

    private void excluirSitio() {
        if (sitioSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText("Excluir Sítio");
            confirmacao.setContentText("Tem certeza que deseja excluir este sítio?");

            if (confirmacao.showAndWait().get() == ButtonType.OK) {
                sitioDAO.excluirSitio(sitioSelecionado.getTamanho());
                carregarSitios();
                limparCamposSitio();
                mostrarAlerta("Sucesso", "Sítio excluído com sucesso!", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarAlerta("Aviso", "Selecione um sítio para excluir!", Alert.AlertType.WARNING);
        }
    }

    private void excluirPlanta() {
        if (plantaSelecionada != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText("Excluir Planta");
            confirmacao.setContentText("Tem certeza que deseja excluir esta planta?");

            if (confirmacao.showAndWait().get() == ButtonType.OK) {
                plantaDAO.excluirPlanta(plantaSelecionada.getEspecie());
                carregarPlantas();
                limparCamposPlanta();
                mostrarAlerta("Sucesso", "Planta excluída com sucesso!", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarAlerta("Aviso", "Selecione uma planta para excluir!", Alert.AlertType.WARNING);
        }
    }

    private void excluirDog() {
        if (dogSelecionado != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmação");
            confirmacao.setHeaderText("Excluir Cachorro");
            confirmacao.setContentText("Tem certeza que deseja excluir " + dogSelecionado.getNome() + "?");

            if (confirmacao.showAndWait().get() == ButtonType.OK) {
                dogDAO.excluirDog(dogSelecionado.getNome());
                carregarDogs();
                limparCamposDog();
                mostrarAlerta("Sucesso", "Cachorro excluído com sucesso!", Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarAlerta("Aviso", "Selecione um cachorro para excluir!", Alert.AlertType.WARNING);
        }
    }

    // ==================== MÉTODOS VALIDAÇÃO ====================

    private boolean validarCamposSitio() {
        if (txt_tam1.getText().isEmpty() || txt_duende.getText().isEmpty() || txt_cogu.getText().isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos do sítio!", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    private boolean validarCamposPlanta() {
        if (txt_tam2.getText().isEmpty() || txt_cor1.getText().isEmpty() || txt_espe.getText().isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos da planta!", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    private boolean validarCamposDog() {
        if (txt_nome.getText().isEmpty() || txt_cor3.getText().isEmpty() || txt_idioma.getText().isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos do cachorro!", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    // ==================== MÉTODOS LIMPAR CAMPOS ====================

    private void limparCamposSitio() {
        txt_tam1.clear();
        txt_duende.clear();
        txt_cogu.clear();
        sitioSelecionado = null;
        Table_sítio.getSelectionModel().clearSelection();
        btn_excluir1.setDisable(true);
    }

    private void limparCamposPlanta() {
        txt_tam2.clear();
        txt_cor1.clear();
        txt_espe.clear();
        plantaSelecionada = null;
        table_planta_tabela.getSelectionModel().clearSelection();
        btn_excluir2.setDisable(true);
    }

    private void limparCamposDog() {
        txt_nome.clear();
        txt_cor3.clear();
        txt_idioma.clear();
        dogSelecionado = null;
        table_dog_tabela.getSelectionModel().clearSelection();
        btn_excluir3.setDisable(true);
    }

    // ==================== MÉTODOS PARA PREENCHER CAMPOS ====================

    private void preencherCamposSitio(Sitio sitio) {
        txt_tam1.setText(sitio.getTamanho());
        txt_duende.setText(sitio.getDuende());
        txt_cogu.setText(sitio.getCogumelo());
    }

    private void preencherCamposPlanta(Planta planta) {
        txt_tam2.setText(planta.getTamanho());
        txt_cor1.setText(planta.getCor());
        txt_espe.setText(planta.getEspecie());
    }

    private void preencherCamposDog(Dog dog) {
        txt_nome.setText(dog.getNome());
        txt_cor3.setText(dog.getCor());
        txt_idioma.setText(dog.getIdioma());
    }

    // ==================== MÉTODOS CARREGAR DADOS ====================

    private void carregarDados() {
        carregarSitios();
        carregarPlantas();
        carregarDogs();
    }

    private void carregarSitios() {
        sitiosList.clear();
        List<Sitio> sitios = sitioDAO.listarSitios();
        sitiosList.addAll(sitios);
    }

    private void carregarPlantas() {
        plantasList.clear();
        List<Planta> plantas = plantaDAO.listarPlantas();
        plantasList.addAll(plantas);
    }

    private void carregarDogs() {
        dogsList.clear();
        List<Dog> dogs = dogDAO.listarDogs();
        dogsList.addAll(dogs);
    }

    // ==================== MÉTODO UTILITÁRIO ====================

    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    // ==================== MÉTODOS NOVOS (BOTÕES LIMPAR) ====================

    @FXML
    private void limparDados1() {
        limparCamposSitio();
    }

    @FXML
    private void limparDados2() {
        limparCamposPlanta();
    }

    @FXML
    private void limparDados3() {
        limparCamposDog();
    }
}