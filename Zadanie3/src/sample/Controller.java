package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.*;

public class Controller {

    @FXML
    private TextField text1,text2;
    @FXML
    private Label labelWarn;
    @FXML
    private TableView tabela;
    @FXML
    private TableColumn ImieTab,NumerTab;

    private ObservableList<Person> data;
    private int selectionIndex;

    @FXML
    public void initialize()
    {
        data = FXCollections.observableArrayList();
        LoadPerson();

        ImieTab.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        NumerTab.setCellValueFactory(new PropertyValueFactory<Person, String>("numer"));
        tabela.setItems(data);

    }

    @FXML
    private void Button1Click(ActionEvent event)
    {


        if(Validate()){
            Person tmp = new Person(text1.getText(), text2.getText());
            data.add(tmp);
            text1.setText("");
            text2.setText("");
            labelWarn.setText("");
        }

        SavePerson();
    }
    @FXML
    private void Button2Click(ActionEvent event)
    {
        if(Validate()) {
            Person tmp = new Person(text1.getText(), text2.getText());
            data.set(selectionIndex, tmp);
            labelWarn.setText("");
        }

        SavePerson();
    }
    @FXML
    private void Button3Click(ActionEvent event)
    {
        data.remove(tabela.getSelectionModel().getSelectedItem());
        tabela.getSelectionModel().selectLast();
        SavePerson();
    }
    @FXML
    private void TableSele(MouseEvent event)
    {

        if(tabela.getSelectionModel().getSelectedIndex()!= -1){
            selectionIndex = tabela.getSelectionModel().getSelectedIndex();
            UpdateTextBoxs();
        }
    }


    private void SavePerson()
    {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("objects.bin"))) {
            for (Person person: data) {
                outputStream.writeObject(person);
            }
            outputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void LoadPerson()
    {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("objects.bin"))) {
            while(true)
            {
                data.add((Person) inputStream.readObject());
            }
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void UpdateTextBoxs()
    {
        text1.setText(data.get(selectionIndex).getName());
        text2.setText(data.get(selectionIndex).getNumer());
    }

    private boolean Validate()
    {
        if(!text1.getText().isEmpty() && !text2.getText().isEmpty())
        {
         if (text1.getText().length()> 25){
             labelWarn.setText("Imie i Nazwisko za długie");
             return false;
         }
         if (text2.getText().length() != 8)
         {
            labelWarn.setText("Numer za długi/krótki, prawidłowy XXX-XXXX");
            return false;
         }
         if (text2.getText().charAt(3) != '-')
         {
             labelWarn.setText("Zły format numeru, prawidłowy XXX-XXXX");
             return false;
         }
         return true;
        }
        else return false;
    }

}
