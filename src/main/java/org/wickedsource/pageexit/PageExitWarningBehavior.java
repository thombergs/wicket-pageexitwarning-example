package org.wickedsource.pageexit;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;

/**
 * This behavior displays a warning when the user leaves a page.
 * 
 * @author Tom
 * 
 */
public class PageExitWarningBehavior extends Behavior {

	private boolean shouldWarn = false;

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		if (shouldWarn) {
			response.render(new OnDomReadyHeaderItem(
					"window.onbeforeunload = function (e) {"
							+ "var message = 'Your confirmation message goes here.',"
							+ "e = e || window.event;" + "if (e) {"
							+ "e.returnValue = message;" + "}"
							+ "return message;" + "};"));
		}
	}

	@Override
	public void onEvent(Component component, IEvent<?> event) {
		super.onEvent(component, event);
		if (event.getPayload() instanceof PageExitWarningEvent) {
			PageExitWarningEvent exitEvent = (PageExitWarningEvent) event
					.getPayload();
			this.shouldWarn = exitEvent.isPageExitWarningEnabled();
		}
	}
}
