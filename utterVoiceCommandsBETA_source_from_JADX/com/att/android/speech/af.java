package com.att.android.speech;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.protocol.HttpContext;

final class af implements HttpRequestInterceptor {
    final /* synthetic */ ad f422a;

    af(ad adVar) {
        this.f422a = adVar;
    }

    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        AuthState authState = (AuthState) httpContext.getAttribute("http.auth.target-scope");
        CredentialsProvider credentialsProvider = (CredentialsProvider) httpContext.getAttribute("http.auth.credentials-provider");
        if (authState.getAuthScheme() == null) {
            AuthScope authScope = new AuthScope(this.f422a.f403h.getHost(), this.f422a.f403h.getPort());
            Credentials usernamePasswordCredentials = new UsernamePasswordCredentials(this.f422a.f404i, this.f422a.f405j);
            credentialsProvider.setCredentials(authScope, usernamePasswordCredentials);
            authState.setAuthScheme(new BasicScheme());
            authState.setCredentials(usernamePasswordCredentials);
        }
    }
}
