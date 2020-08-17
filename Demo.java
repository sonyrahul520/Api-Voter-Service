
import java.util.ArrayList;

import java.io.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("votingservice")
public class Demo {
	
	 ArrayList<Voters> vp = new ArrayList<Voters>();
	 ArrayList<Motion> mp = new ArrayList<Motion>();
	 
	 @GET
	 @Path("createVoter/{voter_id}")
	 
	 @Produces(MediaType.TEXT_PLAIN)
	 public boolean createVoter(@PathParam("voter_id") String v) // method to create voter
	 {
		 Voters vot = new Voters();
		 vot.v_id = v;
		 vp.add(vot);
		// this.saveVoters();
		 try {									// to save the voters data into file.txt

	            
             StringBuilder  stringBuilder = new StringBuilder();
             stringBuilder.append( vot.getv_id()+"\n");
             
             File f1 = new File("file.txt");
            

             if(f1.length() == 0) //checks if file is empty
             {
            	 FileWriter writer = new FileWriter("file.txt") ; //then write data directly
             writer.write(stringBuilder.toString());;
             BufferedWriter out = new BufferedWriter(writer) ;

             out.close();
             }
             else {			//if file not empty then check if v_id already present 
            	 try  
        		 {  
        		  
        		 FileReader fr=new FileReader("file.txt");   //reads the file  
        		 BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
        		 StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
        		 String line; 
        		
        		 while((line=br.readLine())!=null)  
        		 {  
        			
        			 if (line.equals(v))
        			 {
        				 return false;			//if v_id exists return false
        			 }
        			 else			//else write the data
        			 {
        				 FileWriter writer = new FileWriter("file.txt") ;
        	             writer.write(stringBuilder.toString());;
        	             BufferedWriter out = new BufferedWriter(writer) ;

        	             out.close();
        	             return true;
        			
        			 }
        			 
        		 }  
        		 fr.close();    //closes the stream and release the resources  
        		  
        		 }  
        		 catch(IOException e)  
        		 {  
        		 e.printStackTrace();  
        		 }  
             }
             System.out.println("File created successfuly");
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
		 
		 
		 
		 return true;
		 
		 
	 }
	 
	 @GET
	 @Path("getVoter/{v_id}")			//returns voter id
	 @Produces(MediaType.TEXT_PLAIN)
	 public String getVoter(@PathParam("v_id") String v)
	 {
		 
		 try  
		 {  
		  
		 FileReader fr=new FileReader("file.txt");   //reads the file  
		 BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
		 StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
		 String line; 
		
		 while((line=br.readLine())!=null)  
		 {  
			
			 if (line.equals(v))
			 {return "{\"voter_id\":\""+v+"\"}";		//returns the v_id
				 //return "found";
			 }
			 else
			 {
				 
				return "{\"voter_id\":"+""+"}";
			 }
			 
		 }  
		 fr.close();    //closes the stream and release the resources  
		 System.out.println("Contents of File: ");  
		 //System.out.println(sb.toString());   //returns a string that textually represents the object  
		 }  
		 catch(IOException e)  
		 {  
		 e.printStackTrace();  
		 }  
		 return "done";
		 
	 }
	 
	 @GET
	 @Path("createMotion/{motion_id}/{text}")
	 @Produces(MediaType.TEXT_PLAIN)
	 public boolean createMotion(@PathParam("motion_id") String m, @PathParam("text") String t)
	 {
		 Motion mot = new Motion();
		 mot.m_id = m;
		 mot.text = t;
		 mp.add(mot);
		 
		 try {

            
             StringBuilder  stringBuilder = new StringBuilder();
             stringBuilder.append( mot.getmid()+" "+mot.gettext()+"\n");
             //stringBuilder.append( mot.getmid()+" "+mot.gettext()+"\n");
             
             File f1 = new File("file1.txt");
            

             if(f1.length() == 0) //checks if file is empty
             {
            	 FileWriter writer = new FileWriter("file1.txt") ;
             writer.write(stringBuilder.toString());;
             BufferedWriter out = new BufferedWriter(writer) ;

             out.close();
             }
             else {			//if file not empty then check if m_id already present 
            	 try  
        		 {  
        		  
        		 FileReader fr=new FileReader("file1.txt");   //reads the file  
        		 BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
        		 StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
        		 String line; 
        		
        		 while((line=br.readLine())!=null)  
        		 {  
        			
        			 if (line.equals(m))
        			 {
        				 return false;			//if m_id exists return false
        			 }
        			 else			//else write the data
        			 {
        				 FileWriter writer = new FileWriter("file1.txt") ;
        	             writer.write(stringBuilder.toString());;
        	             BufferedWriter out = new BufferedWriter(writer) ;

        	             out.close();
        	             return true;
        			
        			 }
        			 
        		 }  
        		 fr.close();    //closes the stream and release the resources  
        		  
        		 }  
        		 catch(IOException e)  
        		 {  
        		 e.printStackTrace();  
        		 }  
             }
             System.out.println("File created successfuly");
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
		 
		 return true;
		 
		 
	 }
	 
	 @GET
	 @Path("getMotion/{m_id}")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String getMotion(@PathParam("m_id") String m)
	 {
		 
		 try  
		 {  
		  
		 FileReader fr=new FileReader("file1.txt");   //reads the file  
		 BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
		 //StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
		 String line; 
		
		 while((line=br.readLine())!=null)  
		 {  
			 String[] words = line.split(" ");
			 for(String a: words)
				 if(a.equals(m))
			 {return "{\"motion_id\":\""+m+"\"}";
				 
			 }
			 else
			 {
				 
				 return "not found";
			 }
			 
		 }  
		
		 fr.close();    //closes the stream and release the resources  
		 System.out.println("Contents of File: ");  
		 //System.out.println(sb.toString());   //returns a string that textually represents the object  
		 }  
		 catch(IOException e)  
		 {  
		 e.printStackTrace();  
		 }  
		 return "done";
		 
	 }
	 
	 @GET
	 @Path("createVotingRecord/{voter_id}/{motion_id}/{record_id}")
	 @Produces(MediaType.TEXT_PLAIN)
	 public boolean createVoterRecord(@PathParam("voter_id") String v, @PathParam("motion_id") String m, @PathParam("record_id") String r)
	 {
		 Motion mot = new Motion();
		 mot.m_id = m;
		 Voters vot = new Voters();
		 vot.v_id= v;
		 VotingRecord vr = new VotingRecord();
		 vr.vr_id = r;
				 
		 try {

	            
             StringBuilder  stringBuilder = new StringBuilder();
             stringBuilder.append( mot.getmid()+" "+vot.getv_id()+" "+vr.vrid()+"\n");
             
             File f1 = new File("file2.txt");
            

             if(f1.length() == 0) //checks if file is empty
             {
            	 FileWriter writer = new FileWriter("file2.txt") ;
             writer.write(stringBuilder.toString());;
             BufferedWriter out = new BufferedWriter(writer) ;

             out.close();
             }
             else {
               	 try  
            		 {  
            		  
            		 FileReader fr=new FileReader("file2.txt");   //reads the file  
            		 BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            		 StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
            		 String line; 
            		
            		 while((line=br.readLine())!=null)  
            		 {  
            			
            			 if (line.equals(m))
            			 {
            				 return false;			//if m_id exists return false
            			 }
            			 else			//else write the data
            			 {
            				 FileWriter writer = new FileWriter("file2.txt") ;
            	             writer.write(stringBuilder.toString());;
            	             BufferedWriter out = new BufferedWriter(writer) ;

            	             out.close();
            	             return true;
            			
            			 }
            			 
            		 }  
            		 fr.close();    //closes the stream and release the resources  
            		  
            		 }  
            		 catch(IOException e)  
            		 {  
            		 e.printStackTrace();  
            		 } 
            	 
             }
             System.out.println("File created successfuly");
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }

		 return true;
		 
	 }
	 

		 
	 @GET
	 @Path("vote/{voter_id}/{motion_id}/{vote}")
	 @Produces(MediaType.TEXT_PLAIN)
	 public boolean Vote(@PathParam("voter_id") String v, @PathParam("motion_id") String m, @PathParam ("vote") boolean vo){
		 Motion mot = new Motion();
		 mot.m_id = m;
		 Voters vot = new Voters();
		 vot.v_id= v;
		 mot.votes++;
		 if (vo == true)
		 {
			 mot.in_fav++;
			 
		 }
		 VotingRecord vr = new VotingRecord();
		 vr.voted_yes = vo;
		 vr.vote_cast = true;

				 
		 try {

	            
             StringBuilder  stringBuilder = new StringBuilder();
             stringBuilder.append( vr.vote_cast+" "+vo+" " +vot.getv_id()+" "+mot.getmid()+"\n");
             
             File f1 = new File("file3.txt");
            

             if(f1.length() == 0) //checks if file is empty
             {
            	 FileWriter writer = new FileWriter("file3.txt") ;
             writer.write(stringBuilder.toString());;
             BufferedWriter out = new BufferedWriter(writer) ;

             out.close();
             }
             else {
            	 FileWriter writer = new FileWriter("file3.txt",true) ; 
            	 writer.write(stringBuilder.toString());;
                 BufferedWriter out = new BufferedWriter(writer) ;

                 out.close();
            	 
             }
             System.out.println("File created successfuly");
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
		 return true;
		 
		 
	 }
	 @GET
	 @Path("getVotingRecordsForVoter/{voter_id}")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String getVotingRecord(@PathParam("voter_id") String v)
	 {
		 
		 
		 try  
		 {  
		  
		 FileReader fr=new FileReader("file3.txt");   //reads the file  
		 BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
		 //StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
		 String line; 
		
		
		 while((line=br.readLine())!=null)  
		 {  
			 String[] words = line.split(" ");
			 for(String a: words)
			 { if(a.contains(v))
			 {return "{\"voter_id\":\""+v+"\"}"; 
			 }
			 else
			 {
				 return "{\"voter_id\":"+""+"}";
			 }
			 }
			 
		 }  
		
		 fr.close();    //closes the stream and release the resources  
		 System.out.println("Contents of File: ");  
		 //System.out.println(sb.toString());   //returns a string that textually represents the object  
		 }  
		 catch(IOException e)  
		 {  
		 e.printStackTrace();
		 }  
		 return "done";
		 
	 }
		 @GET
		 @Path("clearDatabase")
		 @Produces(MediaType.TEXT_PLAIN)
	 public String cleardatabase() throws IOException {
	        FileWriter fwOb = new FileWriter("file.txt", false); 
	        PrintWriter pwOb = new PrintWriter(fwOb, false);
	        pwOb.flush();
	        pwOb.close();
	        fwOb.close();
	        FileWriter fw1b = new FileWriter("file1.txt", false); 
	        PrintWriter pw1b = new PrintWriter(fw1b, false);
	        pw1b.flush();
	        pw1b.close();
	        fw1b.close();
	        FileWriter fw2b = new FileWriter("file2.txt", false); 
	        PrintWriter pw2b = new PrintWriter(fw1b, false);
	        pw2b.flush();
	        pw2b.close();
	        fw2b.close();
	        FileWriter fw3b = new FileWriter("file3.txt", false); 
	        PrintWriter pw3b = new PrintWriter(fw3b, false);
	        pw3b.flush();
	        pw3b.close();
	        fw3b.close();
	        
	        return "cleared";
	    }	
	 
		 @GET
		 @Path("hello")
		 @Produces(MediaType.TEXT_PLAIN)
		 public String hello()
		 {
			 
			 return "hello world";
		 }
	 
	 }


 class Voters implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String v_id;
	
	public String getv_id() {
		
		return v_id;
		
	}


	
}
 
 class Motion implements Serializable{
	 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String m_id;
	 public String text;
	 public int votes = 0;
	 public int in_fav =0;;

	 public String getmid() {
		 
		 return m_id;
	 }
	 public String gettext() {
		 
		 return text;
	 }
	 
 }
 
 class VotingRecord implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String vr_id;
	 public boolean vote_cast;
	 public boolean voted_yes;
	 
	 public String vrid() {
		 
		 return vr_id;
	 }
	 
 }
 
 


