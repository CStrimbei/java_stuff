package com.example.demo.features.universities.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.QueryParameters;

public class UniversityView extends VerticalLayout implements HasUrlParameter<String> {
    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        var headerLayout = new VerticalLayout();
        headerLayout.setAlignItems(Alignment.CENTER);
        headerLayout.add(new H1("Universitatile Iasiului!"));
        add(headerLayout);
        add(getUAIC());
        add(getUMF());
        add(getASACHI());
        add(getHomeButton(s));
    }

    private VerticalLayout getASACHI() {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        layout.add(new H2("Universitatea Tehnica 'Gheorghe Asachi':"));
        layout.add("Prin reforma învăţământului din anul 1948 se înfiinţează Institutul Politehnic „Gh. Asachi” din Iaşi, care funcţionează până în anul 1993 când, în cadrul reformei învăţământului superior din România, Institutul Politehnic „Gh. Asachi” din Iaşi devine, la 17 Mai 1993, Universitatea Tehnică „Gheorghe Asachi” Iaşi.");
        var infoButton = new Button("Info");
        infoButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(infoButton);
        infoButton.addClickListener(click->{
            UI.getCurrent().getPage().executeJs("window.open(\"https://www.tuiasi.ro/\", \"_self\");");
        });
        return layout;
    }

    private VerticalLayout getUMF() {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        layout.add(new H2("Universitatea de Medicina si Farmacie 'Grigore T. Popa':"));
        layout.add("Unul dintre cele mai vechi asezaminte de invatamant superior din tara noastra, a fost fondat in 1879, ca Facultate de Medicina, fiind ulterior asociat cu alte doua institutii ce completeaza aria pregatirii medicale – Facultatea de Farmacie si Facultatea de Medicina Dentara. In anul 1991, institutului i se confera statutul de Universitate, primind numele celebrului reprezentant al Scolii de Anatomie Functionala Iasi, Grigore T. Popa. Ulterior este inclusa si Facultatea de Bioinginerie Medicala, singura de acest fel din Romania. Universitatea se mandreste astazi cu un valoros corp profesoral precum si cu o baza materiala si tehnica modernizata, adecvata desfasurarii procesului didactic si activitatii de cercetare stiintifica.");
        var infoButton = new Button("Info");
        infoButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(infoButton);
        infoButton.addClickListener(click->{
            UI.getCurrent().getPage().executeJs("window.open(\"https://www.umfiasi.ro/\", \"_self\");");
        });
        return layout;
    }

    private VerticalLayout getUAIC() {
        var layout = new VerticalLayout();
        layout.setAlignItems(Alignment.CENTER);
        layout.add(new H2("Universitatea Alexandru Ioan Cuza:"));
        layout.add("O istorie a Universităţii din Iaşi ne poartă prin lecţiile manualului de istorie a românilor, încă din secolul al XVI-lea. Dacă, în general, existenţa unei universităţi este legată de contextul istoric, în România Universitatea din Iaşi a avut de multe ori rolul de creatoare de istorie. În secolul al XVII-lea, de exemplu, universitatea a fost un adăpost al culturii bizantine; mai târziu a fost unul dintre cei mai importanţi factori ai răspândirii limbii române şi ai culturii autohtone; după înfiinţarea sa ca prima instituţie de învăţământ superior modern a României, universitatea a furnizat statului cei mai importanţi gânditori şi actori în viaţa publică pentru ca, în perioada comunismului, să menţină viu spiritul umanist.");

        var infoButton = new Button("Info");
        infoButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(infoButton);
        infoButton.addClickListener(click->{
            UI.getCurrent().getPage().executeJs("window.open(\"https://www.uaic.ro/\", \"_self\");");
        });
        return layout;
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
}
