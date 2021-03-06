package org.apereo.cas.support.oauth.web.endpoints;

import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.authentication.principal.ServiceFactory;
import org.apereo.cas.authentication.principal.WebApplicationService;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.services.ServicesManager;
import org.apereo.cas.support.oauth.authenticator.OAuth20CasAuthenticationBuilder;
import org.apereo.cas.support.oauth.profile.OAuth20ProfileScopeToAttributesFilter;
import org.apereo.cas.ticket.accesstoken.AccessTokenFactory;
import org.apereo.cas.ticket.registry.TicketRegistry;
import org.apereo.cas.web.support.CookieRetrievingCookieGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * This controller is the base controller for wrapping OAuth protocol in CAS.
 *
 * @author Jerome Leleu
 * @since 3.5.0
 */
@Controller
public abstract class BaseOAuth20Controller {

	static Logger LOGGER = LoggerFactory.getLogger(OAuth20CasAuthenticationBuilder.class);
	
    /**
     * Services manager.
     */
    protected final ServicesManager servicesManager;

    /**
     * The Ticket registry.
     */
    protected final TicketRegistry ticketRegistry;

    /**
     * The Access token factory.
     */
    protected final AccessTokenFactory accessTokenFactory;

    /**
     * The Principal factory.
     */
    protected final PrincipalFactory principalFactory;

    /**
     * The Web application service service factory.
     */
    protected final ServiceFactory<WebApplicationService> webApplicationServiceServiceFactory;

    /**
     * Convert profile scopes to attributes.
     */
    protected final OAuth20ProfileScopeToAttributesFilter scopeToAttributesFilter;

    /**
     * Collection of CAS settings.
     */
    protected final CasConfigurationProperties casProperties;
    
    /**
     * Cookie retriever.
     */
    protected final CookieRetrievingCookieGenerator ticketGrantingTicketCookieGenerator;

	public BaseOAuth20Controller(ServicesManager servicesManager, TicketRegistry ticketRegistry,
			AccessTokenFactory accessTokenFactory, PrincipalFactory principalFactory,
			ServiceFactory<WebApplicationService> webApplicationServiceServiceFactory,
			OAuth20ProfileScopeToAttributesFilter scopeToAttributesFilter, CasConfigurationProperties casProperties,
			CookieRetrievingCookieGenerator ticketGrantingTicketCookieGenerator) {
		super();
		this.servicesManager = servicesManager;
		this.ticketRegistry = ticketRegistry;
		this.accessTokenFactory = accessTokenFactory;
		this.principalFactory = principalFactory;
		this.webApplicationServiceServiceFactory = webApplicationServiceServiceFactory;
		this.scopeToAttributesFilter = scopeToAttributesFilter;
		this.casProperties = casProperties;
		this.ticketGrantingTicketCookieGenerator = ticketGrantingTicketCookieGenerator;
	}

}
