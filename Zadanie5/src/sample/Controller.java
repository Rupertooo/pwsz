package sample;

import javafx.fxml.FXML;
import javafx.scene.web.HTMLEditor;

public class Controller {

    @FXML
    HTMLEditor Editor;

    @FXML
    public void initialize(){

        String tmp = "<html><body onLoad='document.body.focus();'>\n" +
                "Ook. Ook? Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook.\n" +
                "Ook. Ook. Ook. Ook. Ook! Ook? Ook? Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook.\n" +
                "Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook! Ook? Ook? Ook. Ook. Ook.\n" +
                "Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook.\n" +
                "Ook. Ook? Ook! Ook! Ook? Ook! Ook? Ook. Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook.\n" +
                "Ook? Ook. Ook? Ook. Ook? Ook. Ook? Ook. Ook! Ook. Ook. Ook. Ook. Ook. Ook. Ook.\n" +
                "Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook? Ook! Ook! Ook? Ook! Ook? Ook.\n" +
                "Ook! Ook. Ook. Ook? Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook.\n" +
                "Ook. Ook. Ook! Ook? Ook? Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook. Ook?\n" +
                "Ook! Ook! Ook? Ook! Ook? Ook. Ook. Ook. Ook! Ook. Ook. Ook. Ook. Ook. Ook. Ook.\n" +
                "Ook! Ook. Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook.\n" +
                "Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook! Ook!\n" +
                "Ook! Ook. Ook. Ook? Ook. Ook? Ook. Ook. Ook! Ook. "
                + "rem.</body></html>";
        tmp = tmp.replaceAll("<\\/{0,1}font.*?>","");;
        tmp = tmp.replaceAll("(?<=^|\\s)Ook[.]{1}(?=\\s|$)","<font color=\"red\">Ook.</font>");
        tmp = tmp.replaceAll("(?<=^|\\s)Ook[?]{1}(?=\\s|$)","<font color=\"yellow\">Ook?</font>");
        tmp = tmp.replaceAll("(?<=^|\\s)Ook[!]{1}(?=\\s|$)","<font color=\"blue\">Ook!</font>");
        Editor.setHtmlText(tmp);
    }
    @FXML
    public void event(){

        String tmp = Editor.getHtmlText();

        tmp = tmp.replaceAll("<\\/{0,1}font.*?>","");;
        tmp = tmp.replaceAll("(?<=^|\\s)Ook[.]{1}(?=\\s|$)","<font color=\"red\">Ook.</font>");
        tmp = tmp.replaceAll("(?<=^|\\s)Ook[?]{1}(?=\\s|$)","<font color=\"yellow\">Ook?</font>");
        tmp = tmp.replaceAll("(?<=^|\\s)Ook[!]{1}(?=\\s|$)","<font color=\"blue\">Ook!</font>");
        Editor.setHtmlText(tmp);

    }
}
