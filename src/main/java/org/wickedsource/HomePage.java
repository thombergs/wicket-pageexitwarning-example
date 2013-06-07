package org.wickedsource;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wickedsource.pageexit.PageExitWarningBehavior;

public class HomePage extends WebPage {
	
	private static final long serialVersionUID = 1L;
	
	private String name;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		
		Form<Void> form = new Form<Void>("form");
		add(form);

		TextField<String> nameField = new TextField<String>("name", new PropertyModel(this, "name"));
		nameField.add(new PageExitWarningBehavior());
		form.add(nameField);

    }
}
