public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
    	String out=""+rotorValues.charAt(rotorValues.length()-1);
    	out+=rotorValues.substring(0,rotorValues.length()-1);
    	rotorValues=out;
	return(rotorValues.charAt(0)==startChar);
    }
    

    public int indexOf(char c){
        return(rotorValues.indexOf(c));
    }

    public char charAt(int idx){
    	return(rotorValues.charAt(idx));
    }
}
    
