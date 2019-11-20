package org.inria.restlet.mta.resources;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.Tweet;
import org.inria.restlet.mta.internals.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class AllTweetsResource extends ServerResource{

	/** Backend.*/
    private Backend backend_;


	public AllTweetsResource() {
		super();
		backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
		
	}
	
    
	@Get("json")
    public Representation getAllTweets() throws JSONException
    {
		//Recuperation de tous les tweets
		List<Tweet> listTweet = new ArrayList<Tweet>();
		for (User user : backend_.getDatabase().getUsers()) {
			listTweet.addAll(user.getListeOfPublication());
		}
		
      //Representation Json des Tweets
       Collection<JSONObject> jsonTweets = new ArrayList<JSONObject>();

        for (Tweet tweet: listTweet )
        {
            JSONObject current = new JSONObject();
            current.put("Tweet", tweet.getContenu());
            current.put("Date Tweet", tweet.getDatePublication().toString());
            jsonTweets.add(current);
        }
        
        JSONArray jsonArray = new JSONArray(jsonTweets);
        return new JsonRepresentation(jsonArray);
    }
    
}
