package org.inria.restlet.mta.database.api;

import java.util.Collection;

import org.inria.restlet.mta.internals.User;

/**
 *
 * Interface to the database.
 *
 * @author msimonin
 *
 */
public interface Database
{

    /**
     *
     * Create a new user in the database.
     *
     * @param name      The name of the user
     * @param age       The age of the user
     * @return  the new user.
     */
    User createUser(String name, int age);


    /**
     *
     * Returns the list of users.
     *
     * @return the list of users
     */
    Collection<User> getUsers();


    /**
     *  Returns the user with a given id.
     *  @param id id du user
     *  @return the user
     */
    User getUser(int id);
    
    /**
    *
    * Delete a user in the database.
    *
    * @param id id of the user
    * @return  the  user.
    */
   User deleteUser(int id);

}
