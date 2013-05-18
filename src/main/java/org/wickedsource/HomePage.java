package org.wickedsource;

import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wickedsource.pageexit.PageExitWarningBehavior;
import org.wickedsource.pageexit.PageExitWarningEvent;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Link<Void>("activateExitWarningLink"){
			@Override
			public void onClick() {
				send(HomePage.this, Broadcast.BREADTH, new PageExitWarningEvent(true));
			}
		});

		add(new Link<Void>("deactivateExitWarningLink"){
			@Override
			public void onClick() {
				send(HomePage.this, Broadcast.BREADTH, new PageExitWarningEvent(false));
			}
		});
		
		add(new PageExitWarningBehavior());

    }
}
