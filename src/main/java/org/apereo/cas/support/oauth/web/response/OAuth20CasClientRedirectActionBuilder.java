package org.apereo.cas.support.oauth.web.response;

import org.apereo.cas.config.IndirectCasClient;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.redirect.RedirectAction;

/**
 * This is {@link OAuth20CasClientRedirectActionBuilder}.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@FunctionalInterface
public interface OAuth20CasClientRedirectActionBuilder {

    /**
     * Build redirect action for the client dynamically
     * and configure the CAS client accordingly based
     * on the properties of the web context.
     *
     * @param IndirectCasClient the cas client config
     * @param context   the context
     * @return the redirect action
     */
    RedirectAction build(IndirectCasClient casClient, WebContext context);

}
