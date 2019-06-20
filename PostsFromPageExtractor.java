import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class PostsFromPageExtractor {

public static void main(String[] args) throws FacebookException {

 // Generate facebook instance.
Facebook facebook = new FacebookFactory().getInstance();
// Use default values for oauth app id.
facebook.setOAuthAppId("477885336290806", "a7a809f007eebec08072386cade54876");
// Get an access token from: 
// https://developers.facebook.com/tools/explorer
// Copy and paste it below.
String accessTokenString = "EAAGyolm2hfYBAJlP2RwLPit7fOZCacsCCBA1yZCd5OBIhihukcXY26KuNV8yXUehIycu8ZBhZBtvup2ZBWuDiFUIu2N3FK0QzHFcRiSDJAX0tlwTUmxk5ZCjixWm49Sy65cLdZBZCBghrpPuX7OE1UxBq0j0lDtT6er1YZAqCvfaeDxIGPlZAOCW5GSuPRYnvlDUJFcZASZB4dPRYwZDZD";
AccessToken at = new AccessToken(accessTokenString);
// Set access token.
facebook.setOAuthAccessToken(at);

 // We're done.
// Access group feeds.
// You can get the group ID from:
// https://developers.facebook.com/tools/explorer

 // Set limit to 25 feeds.

ResponseList< Post > feeds  = facebook.getFeed("2370242596631705",
new Reading().limit(25));

 // For all 25 feeds...
for (int i = 0; i < feeds.size(); i++) {
// Get post.
Post post = feeds.get(i);
// Get (string) message.
String message = post.getMessage();
// Print out the message.
System.out.println(message);
PagableList comments = post.getComments();
String date = post.getCreatedTime().toString();
// String name = post.getFrom().getName();
String id = post.getId();
System.out.println(date);
System.out.println(id);
}
 }	
}