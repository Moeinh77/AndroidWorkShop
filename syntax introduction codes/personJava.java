public class personJava {

   private String Name;
   private int Age;
   private String Job;

   public personJava(String Name,int Age) {
       this.Age = Age;
       this.Name = Name;
       this.Job = null;
   }

   public personJava(String Name, int Age, String Job) {
       this.Age = Age;
       this.Name = Name;
       this.Job = Job;
   }

   public int getValue() {
       return Age;
   }

   public String getSuit() {
       return Name;
   }

   public String isFaceUp() {
       return Job;
   }

   public void setFaceUp(String faceUp) {
       this.Job = faceUp;
   }

	@Override
	public boolean equals(Object object) {
 	  if (object instanceof personJava) {
          personJava p = (personJava) object;
   	  	  return this.Age == p.Age
    	           && this.Name.equals(p.Name)
  	             && this.Job == p.Job;
 	  } else {
 	      return false;
	   }
	}

	@Override
	public String toString() {
 	  return "personJava(Age="+Age+", Name="+Name+",Job="+Job+")";
	}

}
