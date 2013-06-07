package org.wickedsource.pageexit;

import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;

/**
 * <p>
 * This behavior can be added to form components to activate a javascript page
 * exit warning when the user leaves the page after he changed some values in a
 * form.
 * </p>
 * <p>
 * <strong>NOTE:</strong> any form component this behavior is added to needs to
 * have a model that is not null!
 * </p>
 * 
 * 
 * @author Tom
 * 
 */
public class PageExitWarningBehavior extends AjaxFormComponentUpdatingBehavior {

	private static final long serialVersionUID = 1L;

	private String warningMessage;

	public PageExitWarningBehavior(String warningMessage) {
		super("onkeyup");
		this.warningMessage = warningMessage;
	}

	@Override
	protected void onBind() {
		if (getComponent().getDefaultModel() == null) {
			throw new WicketRuntimeException(
					String.format(
							"A form component needs to be bound to model if you want to use %s!",
							AjaxFormComponentUpdatingBehavior.class.getName()));
		}
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);

		response.render(JavaScriptHeaderItem.forScript(
				"var pageExitWarningActive = false;", "pageExit"));

		response.render(new OnDomReadyHeaderItem(String.format(
				"window.onbeforeunload = function (e) {"
						+ "if(pageExitWarningActive == true){"
						+ "var message = '%s'," + "e = e || window.event;"
						+ "if (e) {" + "e.returnValue = message;" + "}"
						+ "return message;" + "}};", warningMessage)));
	}

	@Override
	protected void onUpdate(AjaxRequestTarget target) {
		target.appendJavaScript("pageExitWarningActive = true;");
	}

}
