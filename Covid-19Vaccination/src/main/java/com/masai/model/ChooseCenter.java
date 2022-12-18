package com.masai.model;

public enum ChooseCenter {

	 Aims{		
		@Override
	    public String timeslot() {	    	
	    	return "Aims";
	    }
	},	
	
	Rml{		
		@Override
	    public String timeslot() {	    	
	    	return "Rml";
	    }
	},	
	
	BombayHospital{		
		@Override
	    public String timeslot() {	    	
	    	return "BombayHospital";
	    }
	},
	
	Sanjeevni{		
		@Override
	    public String timeslot() {	    	
	    	return "Sanjeevni";
	    }
};

public String timeslot() {
	// TODO Auto-generated method stub
	return null;
}
	
}
