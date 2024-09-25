public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
    	//make a new string that includes just the last charecter of rotorValues 
	String out=""+rotorValues.charAt(rotorValues.length()-1);
	//add all but the last charecter of rotorValues to the new string
    	out+=rotorValues.substring(0,rotorValues.length()-1);
    	rotorValues=out;
	return(rotorValues.charAt(0)==startChar);
    }
    

    public int indexOf(char c){
        //return the string index at a given character
	return(rotorValues.indexOf(c));
    }

    public char charAt(int idx){
	//return the string character at a given index
    	return(rotorValues.charAt(idx));
    }
}
    
