package org.wickedsource.pageexit;

public class PageExitWarningEvent {

	private boolean pageExitWarningEnabled = false;

	public PageExitWarningEvent(boolean pageExitWarningEnabled) {
		this.setPageExitWarningEnabled(pageExitWarningEnabled);
	}

	public boolean isPageExitWarningEnabled() {
		return pageExitWarningEnabled;
	}

	public void setPageExitWarningEnabled(boolean pageExitWarningEnabled) {
		this.pageExitWarningEnabled = pageExitWarningEnabled;
	}

}
