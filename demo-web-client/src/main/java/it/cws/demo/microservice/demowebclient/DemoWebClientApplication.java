package it.cws.demo.microservice.demowebclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringBootApplication
public class DemoWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebClientApplication.class, args);
	}
	
    @Theme("valo")
    @SpringUI(path = "")
    public static class VaadinUI extends UI {

        @Override
        protected void init(VaadinRequest request) {
        	VerticalLayout vl = new VerticalLayout();
        	setContent(vl);
        	Button b = new Button("chiama rest");
        	vl.addComponent(b);
        	Label l = new Label();
        	vl.addComponent(l);
        
        	b.addClickListener(e-> {
        		 RestTemplate restTemplate = new RestTemplate();
        	        Value quote = restTemplate.getForObject("http://localhost:8080/string", Value.class);
        	     l.setValue(quote.getValue());
        	});
        }

    }
}
