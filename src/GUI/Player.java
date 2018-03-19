package GUI;

public class Player {
	
public int shotadd;
public  static String transfer1="0";
public  static String transfer2="0";
public static int index1,index2;	
 public void exchange_striker() throws InterruptedException{
		
			//System.out.println("Entered update");
			
			Thread t2 = new Thread(new Runnable(){
				public void run(){
					try{
						update_striker();
					}
					catch(InterruptedException ie){
					ie.printStackTrace();
					}
				}
			});
			t2.start();
			t2.join();
			
		//System.out.println("T2 Complete");
		
 if(play_brain1.check_if_strike_change){
	// System.out.println("Striker changing : ");
			play_brain1.Striker = play_brain1.Striker + play_brain1.NonStriker;
			play_brain1.NonStriker = play_brain1.Striker.substring(0, (play_brain1.Striker.length() - play_brain1.NonStriker.length()));
			play_brain1.Striker = play_brain1.Striker.substring(play_brain1.NonStriker.length());
 		}
	//System.out.println("Striker : "+play_brain1.Striker);
	//System.out.println("Non-Striker : "+play_brain1.NonStriker);	
	
	
		
 }
 public void update_striker() throws InterruptedException{
		
	int strikerscore;
			//System.out.println("Entered exchange");
		if(!play_brain1.check_if_wicket){
				if(toss_brain.userselect.equals("bat")){
					shotadd=play_su.usershot;
				for(int x=0;x<4;x++){
					if(play_brain1.Striker.equals(play_su.playerscores1[x][0])){
						index1=x;
						strikerscore=Integer.parseInt(play_su.playerscores1[x][1])+shotadd;
						play_su.playerscores1[x][1]=""+strikerscore;
						transfer1=play_su.playerscores1[x][1];
					}
					if(play_brain1.NonStriker.equals(play_su.playerscores1[x][0])){
						transfer2=play_su.playerscores1[x][1];
						index2=x;
					}
				}
				
				}
				else{
						shotadd=play_su.compshot;
						for(int x=0;x<4;x++){
							if(play_brain1.Striker.equals(play_su.playerscores2[x][0])){
								index1=x;
								strikerscore=Integer.parseInt(play_su.playerscores2[x][1])+shotadd;
								play_su.playerscores2[x][1]=""+strikerscore;
								transfer1=play_su.playerscores2[x][1];
								}
							if(play_brain1.NonStriker.equals(play_su.playerscores2[x][0])){
							index2=x;
							transfer2=play_su.playerscores2[x][1];
							}
						}
					}
			}
		else{
			int tempwick=0;
				if(play_brain1.wicket_1==2){
					tempwick=3;
				}
				if(tempwick!=3){
					transfer1="0";
					
					if(toss_brain.userselect.equals("bat")){
					for(int x=0;x<4;x++){
						if(play_brain1.NonStriker.equals(play_su.playerscores1[x][0])){
							transfer2=play_su.playerscores1[x][1];
						}
					}
					}
					else{
							
							for(int x=0;x<4;x++){
								if(play_brain1.NonStriker.equals(play_su.playerscores2[x][0])){
								transfer2=play_su.playerscores2[x][1];}
												}
						}
					
					

				}
		}
		
	}
 
}
