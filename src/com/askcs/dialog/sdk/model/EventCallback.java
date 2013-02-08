package com.askcs.dialog.sdk.model;

import com.askcs.dialog.sdk.model.impl.*;
import com.askcs.dialog.sdk.model.intf.EventCallbackIntf;

public class EventCallback implements EventCallbackIntf {
	private static final long serialVersionUID = -2431456288188062707L;

	public static final String EVENT_TYPE_TIMEOUT = "timeout";
	public static final String EVENT_TYPE_EXCEPTION = "exception";
	public static final String EVENT_TYPE_HANGUP = "hangup";
	
	EventCallbackIntf eventCallback;
	
	public EventCallback() {
		this.eventCallback = new E_fields();
	}
	public EventCallback(String event, String callback) {
		this.eventCallback = new E_fields();
		this.eventCallback.setEvent(event);
		this.eventCallback.setCallback(callback);
	}
	@Override
	public String getEvent_id() { return eventCallback.getEvent_id(); }
	@Override
	public String getEvent() { return eventCallback.getEvent(); }
	@Override
	public String getCallback() { return eventCallback.getCallback(); }
	@Override
	public void setEvent_id(String event_id) { eventCallback.setEvent_id(event_id); }
	@Override
	public void setEvent(String event_type) { eventCallback.setEvent(event_type); }
	@Override
	public void setCallback(String callback) { eventCallback.setCallback(callback); }
}
