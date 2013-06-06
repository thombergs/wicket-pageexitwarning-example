package org.wickedsource.pageexit;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;

/**
 * This behavior triggers invalidation of the user's session via AJAX if he
 * leaves the page.
 * 
 * @author Tom
 * 
 */
public class PageExitLogoutBehavior extends AbstractDefaultAjaxBehavior {

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		response.render(new OnDomReadyHeaderItem(String.format(
				"window.onbeforeunload = function(e){ %s };",
				this.getCallbackScript())));
	}

	@Override
	protected void respond(AjaxRequestTarget target) {
		System.out.println("logging out...");
		target.getPage().getSession().invalidate();
	}

}
