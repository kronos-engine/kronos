package com.domino.kronos.config.audit;

import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class AuditorAwareImpl implements ReactiveAuditorAware<String> {
    @Override
    public Mono<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional
                .ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(UserDetails.class::cast)
                .map(UserDetails::getUsername)
                .map(Mono::just)
                .orElse(Mono.just("none"));
    }
}
