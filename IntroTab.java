import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Mar 2020
 */
public class IntroTab extends Tab {
    private VBox vBox;
    private GridPane grid;
    //-----------------------------------------------------------------
    //  Sets up this panel with two labels.
    //-----------------------------------------------------------------
    public IntroTab()
    {
        // setBackground (Color.green);
//        String style = "-fx-background-color: rgba(157, 63, 191, 0.6);"+
//                "-fx-background-image: url(\"./images/carbonfoot.jpg\");+" +
//                "-fx-background-size: 600 550;";
        //String style="-fx-background-color: rgba(157, 63, 191, 0.6);";
        setClosable(false);
        //setStyle(style);
        setText("My intro");
        FlowPane pane = new FlowPane();


        Label l1=new Label("People across the world are becoming increasingly concerned\n" +
                              "about climate change: 8-in-10 people see climate change\n" +
                              "as a major threat to their country.");
        Label l2 = new Label ("So, you want to reduce your carbon footprint?");
        Label l3 = new Label ("This application is ideal to keep track of what food \nyou ate  and transportation method you used.");


        vBox = new VBox(5,l1,l2,l3);
        vBox.setPadding(new Insets(40, 40, 0, 40));
        //vBox.setStyle("-fx-font-size: 20; -fx-font-family: Courier New;");
        pane.getChildren().add(vBox);

        pane.setStyle("-fx-font-size: 20; -fx-font-family: Courier New; -fx-background-image: url(\"./images/carbonfoot.jpg\"); -fx-background-repeat: stretch; -fx-opacity:0.8;-fx-background-color: white; -fx-background-size: 600 550;");
        setContent(pane);
    }
}

