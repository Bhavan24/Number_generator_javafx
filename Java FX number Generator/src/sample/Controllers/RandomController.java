package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class RandomController {
    @FXML
    private Label lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9;

    int buttonCount = 0;
    Label [] labels = new Label[9];
    int [] randomNumbers = new int[9];

    public void initialize(){
        labels[0] = lbl1;
        labels[1] = lbl2;
        labels[2] = lbl3;
        labels[3] = lbl4;
        labels[4] = lbl5;
        labels[5] = lbl6;
        labels[6] = lbl7;
        labels[7] = lbl8;
        labels[8] = lbl9;
    }


    @FXML
    public void printNumber() {

        buttonCount += 1;
        int countNum = buttonCount - 1;
        boolean isGenerated;
        int randomNum;
        if (buttonCount < 10) {
            do {
                isGenerated = false;
                randomNum = getNumber();

                if (randomNumbers.length != 0) {
                    if (buttonCount > 1) {
                        for (int i = 0; i < buttonCount; i++) {
                            if (randomNumbers[i] == randomNum) {
                                isGenerated = true;
                                break;
                            }
                        }
                    }
                    if (isGenerated == false) {
                        randomNumbers[countNum] = randomNum;
                    }
                }

            } while (isGenerated == true);

            labels[countNum].setText(String.valueOf(randomNum));
        }
        else{
            new Alert(Alert.AlertType.INFORMATION,"All numbers are generated").showAndWait();
        }

    }


    public int getNumber() {
        int max = 9;
        int min = 1;
        int range = max - min + 1;
        int random = 0;
        for (int i = 0; i < 10; i++) {
            random = (int) (Math.random() * range) + min;
        }
        return random;
    }


}


