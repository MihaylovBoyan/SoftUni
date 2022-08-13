package com.example.mobi.model.view;

public class StatsView {

    private final int authRequests;
    private final int anonymousRequests;

    public StatsView(int authRequests, int anonymousRequests) {
        this.authRequests = authRequests;
        this.anonymousRequests = anonymousRequests;
    }

    public int getAuthRequests() {
        return authRequests;
    }

    public int getAnonymousRequests() {
        return anonymousRequests;
    }

    public int getTotalRequests() {
        return authRequests + anonymousRequests;
    }

}
