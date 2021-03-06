package org.apereo.cas.support.oauth.web.response.accesstoken.ext;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apereo.cas.authentication.Authentication;
import org.apereo.cas.authentication.principal.Service;
import org.apereo.cas.support.oauth.OAuth20GrantTypes;
import org.apereo.cas.support.oauth.authenticator.OAuth20CasAuthenticationBuilder;
import org.apereo.cas.support.oauth.services.OAuthRegisteredService;
import org.apereo.cas.ticket.OAuthToken;
import org.apereo.cas.ticket.TicketGrantingTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is {@link AccessTokenRequestDataHolder}.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
public class AccessTokenRequestDataHolder {

	static Logger LOGGER = LoggerFactory.getLogger(OAuth20CasAuthenticationBuilder.class);
	
    private final Service service;

    private final Authentication authentication;

    private final OAuthToken token;

    private final boolean generateRefreshToken;

    private final OAuthRegisteredService registeredService;

    private final TicketGrantingTicket ticketGrantingTicket;

    private final OAuth20GrantTypes grantType;

    private final Set<String> scopes;

    public Service getService() {
		return service;
	}

	public Authentication getAuthentication() {
		return authentication;
	}

	public OAuthToken getToken() {
		return token;
	}

	public boolean isGenerateRefreshToken() {
		return generateRefreshToken;
	}

	public OAuthRegisteredService getRegisteredService() {
		return registeredService;
	}

	public TicketGrantingTicket getTicketGrantingTicket() {
		return ticketGrantingTicket;
	}

	public OAuth20GrantTypes getGrantType() {
		return grantType;
	}

	public Set<String> getScopes() {
		return scopes;
	}

	public AccessTokenRequestDataHolder(final OAuthToken token, final OAuthRegisteredService registeredService, final OAuth20GrantTypes grantType,
                                        final boolean isAllowedToGenerateRefreshToken, final Set<String> scopes) {
        this(token.getService(), token.getAuthentication(), token, registeredService, grantType, isAllowedToGenerateRefreshToken, scopes);
    }

    public AccessTokenRequestDataHolder(final Service service, final Authentication authentication, final OAuthToken token,
                                        final OAuthRegisteredService registeredService, final OAuth20GrantTypes grantType,
                                        final boolean isAllowedToGenerateRefreshToken, final Set<String> scopes) {
        this(service, authentication, registeredService, token, null, grantType, isAllowedToGenerateRefreshToken, scopes);
    }

    public AccessTokenRequestDataHolder(final Service service, final Authentication authentication, final OAuthRegisteredService registeredService,
                                        final TicketGrantingTicket ticketGrantingTicket, final OAuth20GrantTypes grantType, final Set<String> scopes) {
        this(service, authentication, registeredService, null, ticketGrantingTicket, grantType, true, scopes);
    }

    private AccessTokenRequestDataHolder(final Service service, final Authentication authentication, final OAuthRegisteredService registeredService,
                                         final OAuthToken token, final TicketGrantingTicket ticketGrantingTicket, final OAuth20GrantTypes grantType,
                                         final boolean isAllowedToGenerateRefreshToken, final Set<String> scopes) {
        this.service = service;
        this.authentication = authentication;
        this.registeredService = registeredService;
        this.ticketGrantingTicket = token != null ? token.getTicketGrantingTicket() : ticketGrantingTicket;
        this.token = token;
        this.generateRefreshToken = isAllowedToGenerateRefreshToken ? (registeredService != null && registeredService.isGenerateRefreshToken()) : false;
        this.grantType = grantType;
        this.scopes = new LinkedHashSet<>(scopes);
    }

	@Override
	public String toString() {
		return "AccessTokenRequestDataHolder [service=" + service + ", authentication=" + authentication + ", token="
				+ token + ", generateRefreshToken=" + generateRefreshToken + ", registeredService=" + registeredService
				+ ", ticketGrantingTicket=" + ticketGrantingTicket + ", grantType=" + grantType + ", scopes=" + scopes
				+ "]";
	}

}
