package com.example.registrationform;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Rejestracja extends Application {
    @Override
    public void start(Stage stage) {
        Text nameLabel = new Text("Imię");
        TextField nameText = new TextField();
        Text dobLabel = new Text("Data urodzenia");
        DatePicker datePicker = new DatePicker();
        Text genderLabel = new Text("Płeć");
        ToggleGroup groupGender = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Mężczyzna");
        maleRadio.setToggleGroup(groupGender);
        RadioButton femaleRadio = new RadioButton("Kobieta");
        femaleRadio.setToggleGroup(groupGender);
        Text reservationLabel = new Text("Rezerwacja");
        ToggleGroup groupReservation = new ToggleGroup();
        ToggleButton yes = new ToggleButton("Tak");
        yes.setToggleGroup(groupReservation);
        ToggleButton no = new ToggleButton("Nie");
        no.setToggleGroup(groupReservation);
        Text technologiesLabel = new Text("Znane technologie");
        CheckBox javaCheckBox = new CheckBox("Java");
        CheckBox dotnetCheckBox = new CheckBox("DotNet");
        Text educationLabel = new Text("Wykształcenie");
        ObservableList<String> names = FXCollections.observableArrayList(
                "Inżynieria", "MCA", "MBA", "Studia licencjackie", "MTECH", "MPhil", "Doktorat");
        ListView<String> educationListView = new ListView<>(names);
        Text locationLabel = new Text("Lokalizacja");
        ChoiceBox<String> locationChoiceBox = new ChoiceBox<>();
        locationChoiceBox.getItems().addAll("Hyderabad", "Chennai", "Delhi", "Mumbai", "Vishakhapatnam");
        Button buttonRegister = new Button("Zarejestruj się");
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500, 500);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameText, 1, 0);
        gridPane.add(dobLabel, 0, 1);
        gridPane.add(datePicker, 1, 1);
        gridPane.add(genderLabel, 0, 2);
        gridPane.add(maleRadio, 1, 2);
        gridPane.add(femaleRadio, 2, 2);
        gridPane.add(reservationLabel, 0, 3);
        gridPane.add(yes, 1, 3);
        gridPane.add(no, 2, 3);
        gridPane.add(technologiesLabel, 0, 4);
        gridPane.add(javaCheckBox, 1, 4);
        gridPane.add(dotnetCheckBox, 2, 4);
        gridPane.add(educationLabel, 0, 5);
        gridPane.add(educationListView, 1, 5);
        gridPane.add(locationLabel, 0, 6);
        gridPane.add(locationChoiceBox, 1, 6);
        gridPane.add(buttonRegister, 2, 8);
        buttonRegister.setStyle("-fx-background-color: darkslateblue; -fx-textfill: white;");
        nameLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        dobLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        genderLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        reservationLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        technologiesLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        educationLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        locationLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
        gridPane.setStyle("-fx-background-color: BEIGE;");
        Scene scene = new Scene(gridPane);
        stage.setTitle("Formularz rejestracyjny");
        stage.setScene(scene);
        stage.show();

        buttonRegister.setOnAction(e -> {
            String name = nameText.getText();
            String dob = datePicker.getValue() != null ? datePicker.getValue().toString() : "Nie podano";
            String gender = maleRadio.isSelected() ? "Mężczyzna" : femaleRadio.isSelected() ? "Kobieta" : "Nie podano";
            String reservation = yes.isSelected() ? "Tak" : no.isSelected() ? "Nie" : "Nie podano";
            String technologies = (javaCheckBox.isSelected() ? "Java " : "") + (dotnetCheckBox.isSelected() ? "DotNet" : "");
            String education = educationListView.getSelectionModel().getSelectedItem();
            String location = locationChoiceBox.getValue();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Potwierdzenie");
            alert.setHeaderText("Czy jesteś pewien?");
            alert.setContentText("Imię: " + name + "\nData urodzenia: " + dob + "\nPłeć: " + gender +
                    "\nRezerwacja: " + reservation + "\nTechnologie: " + technologies +
                    "\nWykształcenie: " + education + "\nLokalizacja: " + location);
            alert.showAndWait();
        });
    }

    public static void main(String args[]){
        launch(args);
    }
}
