package com.example.demo.features.muzee.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.QueryParameters;

@PageTitle("Muzee si Istorie")
public class MuzeeView extends VerticalLayout implements HasUrlParameter<String> {
    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Istoria Orasului:"));
        add(headerLayout);
        add(getCityHistory());
        add(getMuseumNature());
        add(getPalatulCulturii());
        add(getHomeButton(s));
    }

    private VerticalLayout getHomeButton(String s) {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var homeButton = new Button("Home");
        homeButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        layout.add(homeButton);
        homeButton.addClickListener(click->{
            UI.getCurrent().navigate("logged/" + s, QueryParameters.fromString(s));
        });
        return layout;
    }

    private VerticalLayout getPalatulCulturii() {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var infoButton = new Button("Info");
        infoButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(new H2("Palatul Culturii:"));
        layout.add("Palatul din centrul Iaşilor, conceput în spiritul palatelor comunale din Europa de Vest, este o îmbinare fericită a mai multor stiluri arhitecturale: neogotic, romantic și neobaroc. Marcând puternic arhitectura vechii capitale a Moldovei, Palatul s-a impus ca o adevarată efigie încă de la apariţia ei în peisajul urbei.");
        layout.add(infoButton);
        infoButton.addClickListener(click->{
            UI.getCurrent().getPage().executeJs("window.open(\"https://palatulculturii.ro/\", \"_self\");");
        });
        return layout;
    }

    private VerticalLayout getMuseumNature() {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        var infoButton = new Button("Info");
        infoButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(new H2("Muzeul de Istorie Naturală Iasi:"));
        layout.add("Muzeul de Istorie Naturală Iași este o instituție culturală, cu valenţe educative, aflată în administrarea Universităţii „Alexandru Ioan Cuza” Iaşi. Obiectivul muzeului îl constituie colectarea, identificarea, conservarea şi valorificarea bunurilor din patrimoniul biodiversităţii naturale, în paralel cu activitatea de educare a publicului în spiritul cunoaşterii si conservării naturii.");
        layout.add(infoButton);
        infoButton.addClickListener(click->{
            UI.getCurrent().getPage().executeJs("window.open(\"https://www.uaic.ro/muzeul-de-istorie-naturala-iasi/\", \"_self\");");
        });
        return layout;
    }

    private VerticalLayout getCityHistory() {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        layout.add("Orașul Iași este cunoscut în documente ca Târgul Ieșilor, Iașii sau Jassy (mai ales în documentele străine). Numele orașului este legat de tribul iazigilor, un popor antic documentat în sec. I-V d.Hr., care făcea parte din familia sarmaților (de origine iraniană) alături de alani și roxolani. Urmașii acestor triburi sunt „iașii”, care apar menționați în sec. XIV în zona Moldovei și a Ungariei și se crede că numele lor ar deriva de la vechii iazigi, unde yazg sau yash înseamnă „faimă bună” în sanscrită. În limba maghiară, Municipiul Iași este denumit „Jászvásár”, iar în estul Ungariei există comitatul Jász.");
        return layout;
    }
}
