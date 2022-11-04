package ru.yandex.incoming34.VaadinTrial.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//@Component
@Route
public class MainView extends VerticalLayout {

    @Autowired
    FrenchLettersUtils frenchLettersUtils;

    List<FrenchLettersUtils.letters> lettersList;



    Button button = new Button("Hello!");



   // Button accentButton = new Button(frenchLettersUtils.getSymbol(FrenchLettersUtils.letters.A_ACCENT_GRAVE));

    List<Button> buttonList = new ArrayList<>();
    TextField nameField = new TextField();
    HorizontalLayout layout = new HorizontalLayout();

    @PostConstruct
    private void initialize(){
        lettersList = frenchLettersUtils.getAllLetters().stream().collect(Collectors.toList());

        lettersList.forEach(letter -> {
           Button nextButton =  new Button(frenchLettersUtils.getSymbol(letter));
           nextButton.addClickListener(clickEvent ->
                   nameField.setValue(nameField.getValue() + frenchLettersUtils.getSymbol(letter)));
           layout.add(nextButton);
        });

        layout.add(nameField);
    }


    public MainView() {

/*
        button.addClickListener(clickEvent ->
                add(new Text("Hello, " + nameField.getValue() + "! "))
        );

        //buttonList.forEach(element -> layout.add(element));


 */

        layout.setVisible(true);
        add(layout);
        setSizeFull();

    }

}


