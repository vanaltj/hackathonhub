package com.hackathonhub.server;

import com.hackathonhub.client.ProjectRegistrationService;
import com.hackathonhub.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ProjectRegistrationServiceImpl extends RemoteServiceServlet implements
		ProjectRegistrationService {

	public String registerProject(String input, String url) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Project name must be of length greater than zero.");
		}
		if (!FieldVerifier.isValidName(url)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Project link must be a valid URL.");
		}


		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		url = escapeHtml(url);

		return "Thanks for showing interest in associating your project, " + input + "with hackathonhub.<br>" +
		        "Unfortunately we are not yet operational.  Please join us at the hackathonhub google group to participate in getting this up and running.";
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
