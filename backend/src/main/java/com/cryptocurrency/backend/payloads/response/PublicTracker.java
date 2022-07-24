package com.cryptocurrency.backend.payloads.response;



import com.cryptocurrency.backend.entities.Tracker;
import com.cryptocurrency.backend.entities.User;

public class PublicTracker {
    private Long id;
    private String name;
    private User user;
    
    
	public PublicTracker(Long id, String name, User user) {
		this.id = id;
		this.name = name;
		this.user = user;
	}
	
	public static PublicTracker build(Tracker tracker) {
		return new PublicTracker(
									tracker.getId(),
									tracker.getName(),
									tracker.getUser()
									);
	}
    

//    public PublicDeveloper(Long id, String name, Integer cohort, Set<Language> languages, Avatar avatar) {
//        this.id = id;
//        this.name = name;
//        this.cohort = cohort;
//        this.languages = languages;
//        this.avatar = avatar;
//    }
//
    
//    static public PublicDeveloper build(Developer developer) {
//        return new PublicDeveloper(
//                developer.getId(),
//                developer.getName(),
//                developer.getCohort(),
//                developer.getLanguages(),
//                developer.getAvatar()
//        );
//    }


    }
