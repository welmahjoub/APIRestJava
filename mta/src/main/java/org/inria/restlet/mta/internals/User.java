package org.inria.restlet.mta.internals;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * User
 *
 * @author ctedeschi
 * @author msimonin
 *
 */
public class User
{

    /** Internal id of the user.*/
    private int id_;

    /** Name of the user.*/
    private String name_;

    /** Age of the user.*/
    private int age_;
    
    private List<Tweet> listeOfPublication;
    

    /** To be added: collection of tweets of the user. */

    public User(String name, int age)
    {
        name_ = name;
        age_ = age;
        listeOfPublication=new ArrayList<Tweet>();
    }

    public String getName()
    {
        return name_;
    }

    public void setName(String name)
    {
        name_ = name;
    }

    public int getAge()
    {
        return age_;
    }

    public void setAge(int age)
    {
        age_ = age;
    }

    public int getId()
    {
        return id_;
    }

    public void setId(int id)
    {
        id_ = id;
    }

	public List<Tweet> getListeOfPublication() {
		return listeOfPublication;
	}

	public void addPublication(Tweet tweet) {
		this.listeOfPublication.add(tweet);
	}

}
