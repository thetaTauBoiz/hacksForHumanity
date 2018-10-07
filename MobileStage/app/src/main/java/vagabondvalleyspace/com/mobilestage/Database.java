package vagabondvalleyspace.com.mobilestage;

import java.util.ArrayList;

public class Database {
    private static ArrayList<DataMember> data;

    public static void setupDatabase() {
        data = new ArrayList<>();

        data.add(new DataMember("18 miles", "Bold Roost Cafe", "Since we’re just a little family shop, our menu/events/decor, etc. have organically evolved based on customer recommendations, random inspiration, and even by lucky accident. We always want to offer great coffee, food, cocktails and fun, but we especially want you to find a comfortable “home away from home” to enjoy. Feel free to request your favorite music, relax on the couches and chat with us about your day. If you want to chill, borrow one of our books or check out the local art on our walls. If you’re feeling like an adventure, join us for karaoke, yoga or painting classes", "1489 S Higley Rd suite 103, Gilbert, AZ 85296", "Brandon Seil", "480-227-7706", "Brandon@boldroost.com", "Send a text to my cell phone with what you want to do. We can go from there. No fee for performing live. 20% fee if art is sold at our place."));
		
		data.add(new DataMember("10.1 miles", "Modified Arts (Art Gallary)", "Modified Arts showcases stimulating and assertive artwork in an accessible and open environment. Our monthly exhibitions feature regional, national, and international artists of all media and seek to provide a fresh perspective for both new and established collectors. Exhibitions include contemporary painting, sculpture, works on paper, photography, multi-media, and installation.", "407 E Roosevelt St, Phoenix, AZ 85004", "Miguel Angel Monzón", "480-258-3657", "miguelangelmonzonart@gmail.com", "Submit a proposal that includes; Artist Statement, Bio, Images of work, and short proposal idea for an exhibition to info@modifiedarts.org; Available Mon-Fri 9am-5pm & Sat-12-4pm, also available by appointment" ));
    }

    public static DataMember queryRadius(String query) {
        for (DataMember b : data) {
            if (query.equals(b.radius)) {
                return b;
            }
        }

        return null;
    }
	
	public static DataMember queryName(String query) {
		for (DataMember b : data) {
			if (query.equals(b.name)) {
				return b;
			}
		}
		
		return null;
	}
}

class DataMember {
	public String radius;
    public String name;
    public String description;
    public String address;
    public String operatorName;
    public String phoneNumber;
    public String email;
    public String venueType;

    public DataMember(String radius, String name, String description, String address, String operatorName, String phoneNumber, String email, String venueType) {
        this.radius = radius;
        this.name = name;
        this.description = description;
        this.address = address;
        this.operatorName = operatorName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.venueType = venueType;
    }
}
