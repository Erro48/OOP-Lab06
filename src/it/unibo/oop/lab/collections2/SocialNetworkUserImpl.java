package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
	
	/*
	 * With this implementation:
	 * 
	 * Each user has a group
	 * A user can has no group
	 * A user can be only in one group
	 * */
	private Map<U,String> followedUsers;

    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.followedUsers = new HashMap<U,String>();
    }
    
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
		this(name, surname, user, -1);
	}

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
    	if(!this.followedUsers.containsKey(user)) {    		
    		this.followedUsers.put(user, circle);
    		return true;
    	}
        return false;
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
    	Collection<U> usersInGroup = new ArrayList<>();
    	
    	for(Map.Entry<U, String> e : this.followedUsers.entrySet()) {
    		if(e.getValue().equals(groupName)) {
    			usersInGroup.add(e.getKey());
    		}
    	}
    	
        return usersInGroup;
    }

    @Override
    public List<U> getFollowedUsers() {
    	List<U> followed = new ArrayList<>();
    	
    	for(Map.Entry<U, String> e : this.followedUsers.entrySet()) {
    		followed.add(e.getKey());
    	}
    	
        return followed;
    }

}
