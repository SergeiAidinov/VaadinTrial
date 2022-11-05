package ru.yandex.incoming34.VaadinTrial.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Route
public class MainView extends VerticalLayout {

    private static final String RESPOND = "Répondre";
    private static final String INVITATION = "Conjuguons le verbe: ";

    @Autowired
    FrenchLettersUtils frenchLettersUtils;

    TextField answerField = createAnswerField();
    TextField inviteField = createInviteField();
    Button respondButton = createRespondButton();
    VerticalLayout verticalLayout = createVerticalLayout();
    private final String WIDTH = "250px";
    private final String LAYOUT_WIDTH = "300px";

    @PostConstruct
    private void initialize() {

        List<FrenchLettersUtils.letters> lettersList = frenchLettersUtils.getAllLetters().stream().collect(Collectors.toList());
        Iterator<FrenchLettersUtils.letters> iterator = lettersList.iterator();

        while (iterator.hasNext()) {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            horizontalLayout.setWidth(LAYOUT_WIDTH);
            for (int i = 0; i < 3; i++) {
                if (iterator.hasNext()) {
                    FrenchLettersUtils.letters letter = iterator.next();
                    Button nextButton = new Button(frenchLettersUtils.getSymbol(letter));
                    nextButton.addClickListener(clickEvent ->
                            answerField.setValue(answerField.getValue() + frenchLettersUtils.getSymbol(letter)));
                    horizontalLayout.add(nextButton);
                }
            }
            verticalLayout.add(horizontalLayout);
        }

        verticalLayout.add(respondButton);
        verticalLayout.setVisible(true);
        add(verticalLayout);

    }

    private TextField createAnswerField() {
        TextField answerField = new TextField();
        answerField.setWidth(WIDTH);
        return answerField;
    }

    private TextField createInviteField() {

        TextField inviteField = new TextField();
        inviteField.setWidth(WIDTH);
        inviteField.setValue(INVITATION);
        inviteField.setReadOnly(true);
        inviteField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
        return inviteField;
    }

    private Button createRespondButton() {
        Button respondButton = new Button(RESPOND);
        respondButton.setWidth(WIDTH);
        respondButton.addClickListener(clickEvent -> {
            String answer = answerField.getValue();
            inviteField.setValue(answer);

        });
        return respondButton;
    }

    private VerticalLayout createVerticalLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setWidth(LAYOUT_WIDTH);
        verticalLayout.add(inviteField);
        verticalLayout.add(answerField);
        return verticalLayout;
    }


}


