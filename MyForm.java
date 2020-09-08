/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Feb 2020
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class MyForm extends Application {
    //private static ArrayList<UserInput> myInput = new ArrayList<>();
    private TextField weekTextField,activityBox,pointsBox;
    private DatePicker datePicker;
    private Label week, message, date, activity, points, total;
    private GridPane buttonsPane, buttonsBottomPane, grid, textFieldPad,tabsPane;
    private Button btnAdd, btnRemove, btnList, btnSummary, btnLoad, btnSave, btnExit;
    private HBox hbBtnAdd, hbBtnRem, hbBtnList, hbBtnSummary, hbBtnLoad, hbBtnSave, hbBtnExit,hTabPane;
    private ListView listView;
    private VBox vBox;
   // private ReadFile rd;
    private ComboBox comboBox;
    private TabPane tabPane = new TabPane();
    private Tab tabMang;
    private Results res=new Results();
    //private IntroTab intro;

    public static void main(String[] args) {
        launch(args);
    }
    ArrayList<Activity> actList=new ArrayList <>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Carbon awareness app");

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ padding added ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        var spacer = new Region();
        var spacer2=new Region();
        spacer.setPrefWidth(40);
        spacer2.setPrefWidth(460);
        VBox.setVgrow(spacer, Priority.ALWAYS);
        VBox.setVgrow(spacer2, Priority.ALWAYS);

        buttonsPane=new GridPane();
        buttonsPane.setHgap(10);
        buttonsPane.setPadding(new Insets(0,0,2,5));

        buttonsBottomPane=new GridPane();
        buttonsBottomPane.setHgap(2);
        buttonsBottomPane.setPadding(new Insets(0,5,2,0));

        grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(5);
        grid.setPadding(new Insets(5, 5, 0, 5));

        textFieldPad=new GridPane();
        //textFieldPad.setAlignment(Pos.CENTER);
        textFieldPad.setHgap(5);
        textFieldPad.setPadding(new Insets(5,5,5,5));

        tabsPane=new GridPane();
        //tabsPane.setHgap(9);
        tabsPane.setPadding(new Insets(5,5,0,5));

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ tabs▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        //tabIntro = new Tab();
        tabMang = new Tab("Activity management");
        //tabRes = new Tab(new Results());
        //tabRes=new Results();
        //tabRes.setClosable(false);
        tabMang.setClosable(false);

        tabPane.getTabs().add(new IntroTab());
        tabPane.getTabs().add(tabMang);
        tabPane.getTabs().add(res);

        String style = "-fx-background-color: rgba(157, 63, 191, 0.6);";

        tabPane.widthProperty().addListener((observable, oldValue, newValue) ->
        {
            tabPane.setTabMinWidth(tabPane.getWidth() / 4);
            tabPane.setTabMaxWidth(tabPane.getWidth() / 4);
        });

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ the top labels in the application▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

        week = new Label("Week ");
        grid.add(week, 0, 1);
        weekTextField = new TextField();
        grid.add(weekTextField, 1, 1);

        grid.add(spacer,2,1);
        message=new Label();
        grid.add(message,3,1);

        date = new Label("Date ");
        grid.add(date, 0, 2);
        datePicker = new DatePicker();
        grid.add(datePicker,1,2);

        activity = new Label("Activity ");
        grid.add(activity, 0, 3);
//        activityBox = new TextField();
//       grid.add(activityBox, 1, 3);

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Walking to work",
                        "Eating a 8oz steak",
                        "Cycling to shop",
                        "Driving to work",
                        "Vegetarian for a day",
                        "Cycling to work",
                        "Using the bus"
                );
        comboBox = new ComboBox(options);

//        comboBox.getItems().addAll(
//                "Option 4",
//                "Option 5",
//                "Option 6"
//        );
        grid.add(comboBox, 1, 3);

        points = new Label("Points -10 +10 ");
        grid.add(points, 0, 4);
        pointsBox = new TextField();
        grid.add(pointsBox, 1, 4);
        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ buttons under the app ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 3);

        btnAdd = new Button("Add");
        hbBtnAdd = new HBox(3);
        hbBtnAdd.getChildren().add(btnAdd);
        buttonsPane.add(hbBtnAdd, 0, 5);

        btnRemove = new Button("Remove");
        hbBtnRem = new HBox(3);
        hbBtnRem.getChildren().add(btnRemove);
        buttonsPane.add(hbBtnRem, 1, 5);

        btnList = new Button("List");
        hbBtnList = new HBox(3);
        hbBtnList.getChildren().add(btnList);
        buttonsPane.add(hbBtnList, 2, 5);

        btnSummary = new Button("Summary");
        hbBtnSummary = new HBox(3);
        hbBtnSummary.getChildren().add(btnSummary);
        buttonsPane.add(hbBtnSummary, 3, 5);

        buttonsPane.add(spacer,4,5);
        total=new Label();

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ textfield▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        listView = new ListView();

        listView.setPrefHeight(300);
        listView.setPrefWidth(600);
        listView.getItems().add("Activities to be displayed.");

        textFieldPad.add(listView,0,0);

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ Actions for the top buttons▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        btnList.setOnAction(e->{
            System.out.println(actList.toString());
            //ArrayList<Activity> actList;
            if(actList.size()==0){
                listView.getItems().clear();
                listView.getItems().add("Empty");
            }else{
                listView.getItems().clear();
                for(int i=0;i<actList.size();i++){
                    listView.getItems().add(actList.get(i));
                }
            }

            res=new Results();
            //res.addToResults(actList);
        });

        tabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
            System.err.println("changed");
        });


        btnAdd.setOnAction(e ->{
            addActivity(actList);
            System.out.println(actList);
            message.setText("Added!");
        });


        btnRemove.setOnAction(e->{
            int index = listView.getSelectionModel().getSelectedIndex();
            System.out.println("removed at :"+index);

            actList.remove(index);

            listView.getItems().clear();
            for(int i=0;i<actList.size();i++){
                listView.getItems().add(actList.get(i));
            }
        });

        btnSummary.setOnAction(e->{
            int totalPoints=0;
            for(int i = 0; i < actList.size(); i++) {
                totalPoints+=actList.get(i).getPoints();
            }
            total.setText("Total points: "+ totalPoints);
        });
        buttonsPane.add(total, 5, 5);
        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ rest of the buttons ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        btnLoad = new Button("Load");
        hbBtnLoad = new HBox(3);
        hbBtnLoad.getChildren().add(btnLoad);
        buttonsBottomPane.add(hbBtnLoad, 0, 0);

        btnSave = new Button("Save");
        hbBtnSave = new HBox(3);
        hbBtnSave.getChildren().add(btnSave);
        buttonsBottomPane.add(hbBtnSave, 1, 0);

        buttonsBottomPane.add(spacer2,2,0);

        btnExit = new Button("Exit");
        hbBtnExit = new HBox(3);
        hbBtnExit.getChildren().add(btnExit);
        buttonsBottomPane.add(hbBtnExit,3,0);
        btnExit.setStyle("-fx-background-color: red; -fx-text-fill: white;");

        btnLoad.setOnAction(e->{
            //rd=new ReadFile();
            //rd.readFile("./src/activities.txt",actList);
            message.setText("Loaded!");
            Serialize serial=new Serialize();
            actList=serial.deserialize();
            for (Activity a : actList) {
                System.out.println(a);
            }
            //tabRes=new Results();
            //res.addStuffToTable(actList);
            //userTextField.clear();
            //userTextField.appendText(activityList.printList());
        });

        btnExit.setOnAction(e->{
            primaryStage.close();
        });

        btnSave.setOnAction(e->{
            //printArrayListToFile(actList);
            //Serialize serial=new Serialize();
            Serialize serial=new Serialize();
            serial.serialize(actList);

            message.setText("Saved!");
        });


//▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ scene▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        grid.setGridLinesVisible(false);
        buttonsPane.setGridLinesVisible(false);
        buttonsBottomPane.setGridLinesVisible(false);
        textFieldPad.setGridLinesVisible(false);
        tabsPane.setGridLinesVisible(false);

        vBox = new VBox(5,grid,buttonsPane,textFieldPad,buttonsBottomPane);
        tabsPane.setStyle(style);
        vBox.setStyle(style);

        tabMang.setContent(vBox);
        //tabIntro.setContent(intro);
        //tabPane.getTabs().add (new IntroTab() );

        //tabPane.getTabs().add(tabMang);

        Scene scene = new Scene(tabPane, 600, 550);
        //scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);

        //primaryStage.getStylesheets().add("./src/stylesheet.css");
        primaryStage.show();
    }

    public void addActivity(ArrayList<Activity> actList){
        int points;
        if(pointsBox.getText()==null){
            points=0;
        }else{
            points=Integer.parseInt(pointsBox.getText());
        }

        if( points<-10 || points>10){
            System.out.println("Cant add, incorrect points!");
        } else{
            Activity act=new Activity();
            act.setWeek(weekTextField.getText());
            act.setUserDate(datePicker.getValue());
            act.setActivity(comboBox.getValue().toString());
            act.setPoints(points);

            act.printData();
            actList.add(act);
        }
    }

//    public static void printArrayListToFile(ArrayList<Activity> actList){
//        File fileName= new File("./src/activities.txt");
//
//        try{
//            FileWriter fw= new FileWriter(fileName);
//            BufferedWriter output=new BufferedWriter(fw);
//
//            for(int i = 0; i < actList.size(); i++) {
//                Activity act=actList.get(i);
//                output.write(act.toFile()+"\n");
//            }
//            output.close();
//            fw.close();
//
//        }catch (Exception ex){
//            JOptionPane.showMessageDialog(null, "Cannot create file");
//        }
//    }
}

