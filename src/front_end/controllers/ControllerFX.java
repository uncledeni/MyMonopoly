package front_end.controllers;

import back_end.Controller;
import back_end.Play.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ControllerFX {

    public ImageView id0;
    public ImageView id1;
    public ImageView id2;
    public ImageView id3;
    public ImageView id4;
    public ImageView id5;
    public ImageView id6;
    public ImageView id7;
    public ImageView id8;
    public ImageView id9;
    public ImageView id10;
    public ImageView id11;
    public ImageView id12;
    public ImageView id13;
    public ImageView id14;
    public ImageView id15;
    public ImageView id16;
    public ImageView id17;
    public ImageView id18;
    public ImageView id19;
    public ImageView id20;
    public ImageView id21;
    public ImageView id22;
    public ImageView id23;
    public ImageView id24;
    public ImageView id25;
    public ImageView id26;
    public ImageView id27;
    public ImageView id28;
    public ImageView id29;
    public ImageView id30;
    public ImageView id31;
    public ImageView id32;
    public ImageView id33;
    public ImageView id34;
    public ImageView id35;
    public ImageView id36;
    public ImageView id37;
    public ImageView id38;
    public ImageView id39;

    @FXML
    public Label playerNum;

    @FXML
    public Label moneyField;

    @FXML
    public Label turnField;

    @FXML
    public Button buyButton;

    @FXML
    public Button upgradeButton;

    @FXML
    public Button throwButton;

    @FXML
    public Button turnButton;

    @FXML
    public TextArea textArea;

    @FXML
    public TextArea aboutCellArea;

    private int countPlayer = 1;
    private ObservableList<ImageView> cells = FXCollections.observableArrayList();
    private Controller controller = new Controller();

    public void initialize() throws IOException {
        cells.add(id0);
        cells.add(id1);
        cells.add(id2);
        cells.add(id3);
        cells.add(id4);
        cells.add(id5);
        cells.add(id6);
        cells.add(id7);
        cells.add(id8);
        cells.add(id9);
        cells.add(id10);
        cells.add(id11);
        cells.add(id12);
        cells.add(id13);
        cells.add(id14);
        cells.add(id15);
        cells.add(id16);
        cells.add(id17);
        cells.add(id18);
        cells.add(id19);
        cells.add(id20);
        cells.add(id21);
        cells.add(id22);
        cells.add(id23);
        cells.add(id24);
        cells.add(id25);
        cells.add(id26);
        cells.add(id27);
        cells.add(id28);
        cells.add(id29);
        cells.add(id30);
        cells.add(id31);
        cells.add(id32);
        cells.add(id33);
        cells.add(id34);
        cells.add(id35);
        cells.add(id36);
        cells.add(id37);
        cells.add(id38);
        cells.add(id39);
    }

    @FXML
    public void addPlayer(ActionEvent actionEvent) throws IOException {
        if (countPlayer < 3) {
            Controller.addPlayer(Integer.toString(countPlayer));
            if (countPlayer == 3) Controller.setFlagTeam();

            textArea.appendText("Игрок " + countPlayer + " был добавлен.\n");
            countPlayer++;
        } else
            textArea.appendText("Нет свободных мест!\n");
        updateWindow();
    }

    public void endTurn(ActionEvent actionEvent) throws IOException {
        controller.exit();
        textArea.setText(controller.win());
        updateWindow();
    }

    public void buy(ActionEvent actionEvent) throws IOException {
        controller.returnPlace();
        updateWindow();
    }

    public void upgrade(ActionEvent actionEvent) throws IOException {
        controller.createHouse();
        updateWindow();
    }

    public void movement(ActionEvent actionEvent) throws IOException {
        controller.movement();
        textArea.setText("");
        textArea.setText(controller.getInfo());
        aboutCellArea.appendText(controller.getPlayer().getMyColection());
        updateWindow();
    }

    private int getPlayerNumber(String playerName) {
        if (playerName.contains("1"))
            return 1;
        else if (playerName.contains("2"))
            return 2;
        else
            return -1;
    }

    private String generateURL(int x, int numberPlayer) { // numberPlayer=1(Player0),2(Player1),3(Player0 and Player1),4(Empty cell)
        String url = "front_end/resources/";

        if (numberPlayer != 4)
            url += Integer.toString(numberPlayer);

        switch (controller.getType(x)) {
            case "Communite Chest":
                url += "plus.jpg";
                break;
            case "Chance":
                url += "question.jpg";
                break;
            case "PayMoney":
                url += "minus.jpg";
                break;
            case "K":
                url += "K.jpg";
                break;
            case "T":
                url += "T.jpg";
                break;
            default:
                url += "empty.jpg";
                break;
        }

        return url;
    }

    @FXML
    private void updateWindow() throws IOException {
        //id0.setImage(new Image(String.valueOf("front_end/resources/1empty.jpg")));

        ArrayList<Player> players = Controller.getPlayers();

        for (int i = 0; i < cells.size(); i++) {
            int num = 4;
            for (Player player : players) {
                if (num == 4 && player.getX() == i)
                    num = getPlayerNumber(player.getName());
                else if (num != 4 && player.getX() == i)
                    num = 3;
            }

            cells.get(i).setImage(new Image(String.valueOf(generateURL(i, num))));
        }

        playerLoad();
    }

    private void playerLoad() {
        playerNum.setText(Integer.toString(getPlayerNumber(controller.getPlayer().getName())));
        moneyField.setText(Integer.toString(controller.getPlayer().getMoney()));
        turnField.setText(Integer.toString(Controller.getCourse()));
        aboutCellArea.setText(controller.getPlayer().getMyColection());
    }
}
