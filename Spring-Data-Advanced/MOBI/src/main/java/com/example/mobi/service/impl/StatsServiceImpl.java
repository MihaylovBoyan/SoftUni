package com.example.mobi.service.impl;

import com.example.mobi.model.view.StatsView;
import com.example.mobi.service.StatsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    private int anonymousRequest, authRequests;

    @Override
    public void onRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            authRequests++;
        } else {
            anonymousRequest++;
        }
    }

    @Override
    public StatsView getStats() {
        return new StatsView(authRequests, anonymousRequest);
    }
}
