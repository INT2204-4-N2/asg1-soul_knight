package sample;

import dictionary.DictionaryCommandline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;


public class Controller {
    @FXML
    public TextField Input;
    @FXML
    public ListView<String> listView;
    @FXML
    public ObservableList<String> list = FXCollections.observableArrayList();
    @FXML
    public WebView webViewExplain;
    @FXML
    public  WebView webViewExplainSearch;
    @FXML
    DictionaryCommandline dictionaryCommandline= new DictionaryCommandline();

    @FXML
    public void handleClickListView(MouseEvent event) {
        String value = listView.getSelectionModel().getSelectedItem();
        //DictionaryManagement dictionaryManagement = new DictionaryManagement();
        webViewExplain.getEngine().loadContent(dictionaryCommandline.dictionaryLookup(value), "text/html");
    }
    @FXML
    public void handleClickListViewBinarySearcher(MouseEvent event) {
        String value = listView.getSelectionModel().getSelectedItem();
        //DictionaryManagement dictionaryManagement = new DictionaryManagement();
        webViewExplain.getEngine().loadContent(dictionaryCommandline.dictionaryLookup(value), "text/html");
    }

    @FXML
    public void handleClickListViewSearch(MouseEvent event){
        String input = Input.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String value ;
        value = dictionaryCommandline.dictionarySearcher(input).get(0);

        webViewExplain.getEngine().loadContent(dictionaryCommandline.dictionaryLookup(value), "text/html");

    }
    public  void update(KeyEvent event){
        listView.getItems().setAll(dictionaryCommandline.dictionarySearcher(Input.getText()));

    }



}