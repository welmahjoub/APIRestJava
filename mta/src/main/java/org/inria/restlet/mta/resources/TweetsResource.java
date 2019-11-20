package org.inria.restlet.mta.resources;
import java.util.ArrayList;
import java.util.Collection;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.Tweet;
import org.inria.restlet.mta.internals.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class TweetsResource extends ServerResource{

	/** Backend.*/
    private Backend backend_;

    /** Utilisateur géré par cette resource.*/
    private User user_;

	public TweetsResource() {
		super();
		backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
		
	}
	
	@Get("json")
    public Representation getTweets() throws JSONException
    {
		String userIdString = (String) getRequest().getAttributes().get("userId");
        int userId = Integer.valueOf(userIdString);
        user_ = backend_.getDatabase().getUser(userId);

      //  User user = backend_.getDatabase().getUsers();
       Collection<JSONObject> jsonTweets = new ArrayList<JSONObject>();

        for (Tweet tweet: user_.getListeOfPublication() )
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
