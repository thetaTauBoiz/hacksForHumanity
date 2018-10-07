package vagabondvalleyspace.com.mobilestage;

import java.util.ArrayList;

public class Database {
    private static ArrayList<DataMember> data;

    private Database() {
        data = new ArrayList<>();

        data.add(new DataMember("3 miles from you", "Venue", "This is a venue", "1234 St St", "Joe Schmoe", "4805323452", "first.last@someone.com", "Music Performance"));
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

    public DataMember(String name, String description, String address, String operatorName, String phoneNumber, String email, String venueType) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.operatorName = operatorName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.venueType = venueType;
    }
}
