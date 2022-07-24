package com.cryptocurrency.backend.payloads.response;


import com.cryptocurrency.backend.entities.Tracker;

public class SelfTracker {
    private Long id;
    private String name;
    
    public SelfTracker(Long id, String name) {
        this.id = id;
        this.name = name;
        
    }

    static public SelfTracker build(Tracker Tracker) {
     //   Set<Tracker> empty/currency = new HashSet<>();
        return new SelfTracker(
                Tracker.getId(),
                Tracker.getName()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
