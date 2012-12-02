package com.hackathonhub.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface ProjectRegistrationServiceAsync {
	void registerProject(String input, String url, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
