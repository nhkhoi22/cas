package org.apereo.cas.support.oauth.web.response.accesstoken.ext;

import org.apereo.cas.CentralAuthenticationService;
import org.apereo.cas.audit.AuditableExecution;
import org.apereo.cas.configuration.model.support.oauth.OAuthProperties;
import org.apereo.cas.services.ServicesManager;
import org.apereo.cas.support.oauth.OAuth20GrantTypes;
import org.apereo.cas.support.oauth.authenticator.OAuth20CasAuthenticationBuilder;
import org.apereo.cas.ticket.registry.TicketRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is {@link AccessTokenClientCredentialsGrantRequestExtractor}.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
public class AccessTokenClientCredentialsGrantRequestExtractor extends AccessTokenPasswordGrantRequestExtractor {

	static Logger LOGGER = LoggerFactory.getLogger(OAuth20CasAuthenticationBuilder.class);
	
    public AccessTokenClientCredentialsGrantRequestExtractor(final ServicesManager servicesManager,
                                                             final TicketRegistry ticketRegistry,
                                                             final OAuth20CasAuthenticationBuilder authenticationBuilder,
                                                             final CentralAuthenticationService centralAuthenticationService,
                                                             final OAuthProperties oAuthProperties,
                                                             final AuditableExecution registeredServiceAccessStrategyEnforcer) {
        super(servicesManager, ticketRegistry, authenticationBuilder,
            centralAuthenticationService, oAuthProperties, registeredServiceAccessStrategyEnforcer);
    }

    @Override
    public OAuth20GrantTypes getGrantType() {
        return OAuth20GrantTypes.CLIENT_CREDENTIALS;
    }
}
