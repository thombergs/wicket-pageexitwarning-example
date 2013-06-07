package org.wickedsource.pageexit;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * <p>
 * This behavior can be added to form components to activate a javascript page
 * exit warning when the user leaves the page after he changed some values in a
 * form.
 * </p>
 * 
 * @author Tom
 * 
 */
public class PageExitWarningBehavior extends Behavior {

	private static final long serialVersionUID = 1L;

	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		super.onComponentTag(component, tag);
		tag.put("onkeyup", "PageExitWarningBehavior.activateWarning()");
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		response.render(JavaScriptHeaderItem
				.forReference(new JavaScriptResourceReference(
						PageExitWarningBehavior.class,
						"PageExitWarningBehavior.js")));
	}

}
