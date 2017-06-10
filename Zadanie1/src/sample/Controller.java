package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private TextField input, output;
    @FXML
    private ToggleGroup inputToggleGroup, outputToggleGroup;
    @FXML
    private Label warningLabel;

    private int convType;
    private String inScale;
    private String outScale;

    @FXML
    private void scaleChange() {
        RadioButton inputScale = (RadioButton) inputToggleGroup.getSelectedToggle();
        inScale = inputScale.getText();
        RadioButton outputScale = (RadioButton) outputToggleGroup.getSelectedToggle();
        outScale = outputScale.getText();
        convType = chooseScale(inScale, outScale);
        convert(convType, input.getText());
    }

    @FXML
    private void textChanged() {
        String valueTxt = input.getText();
        if (valueTxt.isEmpty()){
            warningLabel.setText("Input can not be empty");
            return;
        }
        if ( valueTxt.matches("[-+]?[0-9]*\\.?[0-9]+"))
        {
            warningLabel.setText("");
            scaleChange();
        } else {
            warningLabel.setText("Input must be a number");
        }
    }

    protected int chooseScale(String in, String out) {
        int convertKind = 1;
        switch (in) {
              case "Celcius":
                  if (out.equals("Fahrenheit")) {
                      convertKind = 2;
                  } else if (out.equals("Kelvin")) {
                      convertKind = 3;
                  }
                  break;
              case "Fahrenheit":
                  if (out.equals("Celcius")) {
                      convertKind = 4;
                  } else if (out.equals("Kelvin")) {
                      convertKind = 5;
                  }
                  break;
              case "Kelvin":
                  if (out.equals("Celcius")) {
                      convertKind = 6;
                  } else if (out.equals("Fahrenheit")) {
                      convertKind = 7;
                  }
                  break;
              default:
                  convertKind = 1;
                  break;
          }
        return convertKind;
    }

    protected void convert(int kindOfConvertion, String value) {
        double valueToConvert = Double.parseDouble(value);
        switch (kindOfConvertion) {
            case 1:
                output.setText(value);
                break;
            case 2:
                double output1 = valueToConvert * 9/5 + 32;
                this.output.setText(String.valueOf(output1));
                break;
            case 3:
                double output2 = valueToConvert + 273.15;
                this.output.setText(String.valueOf(output2));
                break;
            case 4:
                double output3 = valueToConvert * 5/9 - 32;
                this.output.setText(String.valueOf(output3));
                break;
            case 5:
                double output4 = (valueToConvert + 459.67) * 5/9;
                this.output.setText(String.valueOf(output4));
                break;
            case 6:
                double output5 = valueToConvert - 273.15;
                this.output.setText(String.valueOf(output5));
                break;
            case 7:
                double output6 = valueToConvert * 9/5 - 459.67;
                this.output.setText(String.valueOf(output6));
                break;
        }
    }
}
