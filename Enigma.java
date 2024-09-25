public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){
	//this is the preprovided code that selects three rotors out of the list of options
	//theoretically this should be randomized but you can select any of the three of your choosing.
	//there is no check that the indices provided are within the range, so this code could throw errors if bad values are given.
        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
    	String out="";
	for(int i=0;i<message.length();i++){
		//set index after going outer->middle
		int index=rotors[2].indexOf(message.charAt(i));
		//set index after going outer->middle-outer->inner
		index=rotors[2].indexOf(rotors[1].charAt(index));
		out+=rotors[0].charAt(index);
		this.rotate();
	}
	return(out);
    }


    
    public String encrypt(String message){
    	String out="";
	for(int i=0;i<message.length();i++){
		//set index after going inner->outer
		int index=rotors[0].indexOf(message.charAt(i));
		//set index after going inner->outer->middle->outer 
		index=rotors[1].indexOf(rotors[2].charAt(index));
		out+=rotors[2].charAt(index);
		this.rotate();
	}
	return(out);
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
