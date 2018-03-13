package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Play_su2 extends JPanel{
	public static int usershot2;
	public static int compshot2;
	public static JLabel reference2;
	Random ra =new Random();
	public static void main(String s[]){
		
		SwingUtilities.invokeLater(new Runnable(){
		public void run(){
		new Play_su2();}
	});
		
	}
	
	public static Font fsc=new Font("Comic Sans MS",Font.BOLD,100);
	public static Font fre=new Font("Comic Sans MS",Font.BOLD,50);
	public static  JLabel play_base2;
	public static JLabel update_score2;
	public static JLabel update_runrate2;
	public static JLabel update_overs2;
	public static int[] hardshots2={1,2,3};
	String temp[] = null;
	public static  JButton viewscore2;
	public Play_su2(){
		//Button for viewscorecard
	/*	viewscore1=new JButton("View Scorecard>>>");	
		viewscore1.setBounds((int) (Single_player.screenSize.width/(1.275)), (int) (Single_player.screenSize.height/(2.5)), Single_player.screenSize.width/4, Single_player.screenSize.height/15);
		viewscore1.setBorderPainted(true);
		viewscore1.setFont(Single_player.fbutton);
		viewscore1.setFocusable(false);
		viewscore1.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseEntered(java.awt.event.MouseEvent evt) {
				 viewscore1.setBackground(Color.GREEN);
			    	
			    }
			 public void mouseExited(java.awt.event.MouseEvent evt) {
				 viewscore1.setBackground(UIManager.getColor("control"));
			    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
	    		final ViewScore1 vs= new ViewScore1();
	    		Single_player.parent.add(vs,"5");
		    	Single_player.c1.show(Single_player.parent, "5");
		    }
		});
		*/
		
		//System.out.print(team_select.mysquadsel);
		play_base2 = new JLabel();
		play_base2.setSize(Single_player.screenSize.width, Single_player.screenSize.height);
		play_base2.setIcon(Single_player.imageIcon); 
		this.add(play_base2);
		reference2=play_base2;
		
		//Team Display
		
		
				//My Team
				final JButton my_team=new JButton(Single_player.myteam);
				
				my_team.setBounds(0, Single_player.screenSize.height/60, Single_player.screenSize.width/3, Single_player.screenSize.height/10);
				my_team.setBorderPainted(true);
				my_team.setFont(Single_player.fbutton);
				my_team.setFocusable(false);
				play_base2.add(my_team);

				//Opposition Team
				final JButton opp_team=new JButton(Single_player.oppteam);
				opp_team.setBounds((int) (Single_player.screenSize.width/(1.46)), Single_player.screenSize.height/60, Single_player.screenSize.width/3, Single_player.screenSize.height/10);
				opp_team.setBorderPainted(true);
				opp_team.setFont(Single_player.fbutton);
				opp_team.setFocusable(false);
				play_base2.add(opp_team);
				
				
			//Batting Bowling
				//Myteam  Panel
				JLabel myteam_what=new JLabel(toss_brain.compselect.toUpperCase(),SwingConstants.CENTER);
				myteam_what.setFont(Single_player.fhead);
				myteam_what.setForeground(Color.WHITE);
				myteam_what.setBounds(0, (int) (Single_player.screenSize.height/(8.7)), Single_player.screenSize.width/4, (int) (Single_player.screenSize.height/(15)));
				javax.swing.border.Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
				myteam_what.setBorder(border);
				play_base2.add(myteam_what);
				
				//Opp Panel
				JLabel oppteam_what=new JLabel(toss_brain.userselect.toUpperCase(),SwingConstants.CENTER);
				oppteam_what.setFont(Single_player.fhead);
				oppteam_what.setForeground(Color.WHITE);
				oppteam_what.setBounds((int) (Single_player.screenSize.width/(1.30)), (int) (Single_player.screenSize.height/(8.7)), Single_player.screenSize.width/4, (int) (Single_player.screenSize.height/(15)));
				oppteam_what.setBorder(border);
				play_base2.add(oppteam_what);
		//Scorecard
				JLabel score_head=new JLabel("SCORE",SwingConstants.CENTER);
				score_head.setFont(Single_player.fbutton);
				score_head.setForeground(Color.WHITE);
				score_head.setBounds((int) (Single_player.screenSize.width/(2.8)), (int) (Single_player.screenSize.height/(59)), Single_player.screenSize.width/5, Single_player.screenSize.height/20);
				score_head.setBorder(border);
				play_base2.add(score_head);
				
				//Numeric score1
				JLabel score=new JLabel("0/0",SwingConstants.CENTER);
				update_score2=score;
				score.setFont(fsc);
				score.setForeground(Color.WHITE);
				score.setBounds((int) (Single_player.screenSize.width/(2.8)), (int) (Single_player.screenSize.height/(15)), Single_player.screenSize.width/5, Single_player.screenSize.height/15);
				score.setBorder(border);
				play_base2.add(score);
				
				//Overs
				JLabel overs=new JLabel("<html>Overs : 0.0 ("+Single_player.overs+")</html>",SwingConstants.CENTER);
				update_overs2=overs;
				overs.setFont(Single_player.fbutton);
				overs.setForeground(Color.WHITE);
				overs.setBounds((int) (Single_player.screenSize.width/(2.8)), (int) (Single_player.screenSize.height/(7.5)), Single_player.screenSize.width/5, Single_player.screenSize.height/20);
				overs.setBorder(border);
				play_base2.add(overs);
				
				//needed
				JLabel runrate=new JLabel("<html>NEED<br>"+(play_brain1.team_score_1+1)+"<br>OFF<br>"+(Integer.parseInt(Single_player.overs)*6)+" <br>BALLS</html>",SwingConstants.CENTER);
				update_runrate2=runrate;
				runrate.setFont(fre);
				runrate.setForeground(Color.WHITE);
				runrate.setBounds((int) (Single_player.screenSize.width/(2.8)+Single_player.screenSize.width/5), (int) (Single_player.screenSize.height/(59)), Single_player.screenSize.width/10, Single_player.screenSize.height/6);
				runrate.setBorder(border);
				play_base2.add(runrate);
				
		//Playing buttons
				
				//Buttons defiinition
				 final JButton one=new JButton("1");
				final JButton two=new JButton("2");	
				final JButton three=new JButton("3");
				final JButton four=new JButton("4");
				final JButton six=new JButton("6");
				
				//1 Button
				one.setActionCommand("1");
				one.setBounds((int) (Single_player.screenSize.width/(2.8)), Single_player.screenSize.height/50+(int) (Single_player.screenSize.height/(1.55)), Single_player.screenSize.width/15, Single_player.screenSize.height/10);
				one.setBorderPainted(true);
				one.setFont(Single_player.fbutton);
				one.setFocusable(false);
				play_base2.add(one);
				one.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	one.setBackground(Color.green);
				    	
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	one.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(play_brain1.if_first_inning_over)){
				    	usershot2=Integer.parseInt(one.getActionCommand());
				    	if(team_select.difficulty.equals("easy")){
				    	compshot2=toss_su.randnumbers[ra.nextInt(5)];}
				    	else
				    	{	
				    		if(toss_brain.userselect.equals("bat"))
				    		compshot2=hardshots2[ra.nextInt(3)];
				    		else
				    			compshot2=toss_su.randnumbers[ra.nextInt(5)];
				    	}				    	
				    	play_brain1 pb =new play_brain1(update_score2,update_overs2, update_runrate2,reference2);
				    	try {
							pb.main(temp);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						}
					    	repaint();
					    	pb=null;
				    	
				    	}
					    	//Disabling if inning over
				    	else{
					    		one.setEnabled(false);
					    		two.setEnabled(false);
					    		three.setEnabled(false);
					    		four.setEnabled(false);
					    		six.setEnabled(false);
					    	}
			
				    }
				});
				
				//2 Button1
				two.setActionCommand("2");
				two.setBounds((int) (Single_player.screenSize.width/(2.07)), Single_player.screenSize.height/50+(int) (Single_player.screenSize.height/(1.55)), Single_player.screenSize.width/15, Single_player.screenSize.height/10);
				two.setBorderPainted(true);
				two.setFont(Single_player.fbutton);
				two.setFocusable(false);
				play_base2.add(two);
				two.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	two.setBackground(Color.green);
				    	
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	two.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	
				    	if(!(play_brain1.if_first_inning_over)){
				    	usershot2=Integer.parseInt(two.getActionCommand());
				    	if(team_select.difficulty.equals("easy")){
					    	compshot2=toss_su.randnumbers[ra.nextInt(5)];}
				    	else
				    	{	
				    		if(toss_brain.userselect.equals("bat"))
				    		compshot2=hardshots2[ra.nextInt(3)];
				    		else
				    			compshot2=toss_su.randnumbers[ra.nextInt(5)];
				    	}
				    	play_brain1 pb =new play_brain1(update_score2,update_overs2, update_runrate2,reference2);
				    	try {
							pb.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb=null;
				    	}
				    	else{
				    		one.setEnabled(false);
				    		two.setEnabled(false);
				    		three.setEnabled(false);
				    		four.setEnabled(false);
				    		six.setEnabled(false);
				    	}
			
				    }
				});				
				
				//3 Button
				three.setActionCommand("3");
				three.setBounds((int) (Single_player.screenSize.width/(1.65)), Single_player.screenSize.height/50+(int) (Single_player.screenSize.height/(1.55)), Single_player.screenSize.width/15, Single_player.screenSize.height/10);
				three.setBorderPainted(true);
				three.setFont(Single_player.fbutton);
				three.setFocusable(false);
				play_base2.add(three);
				three.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	three.setBackground(Color.green);
				    	
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	three.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(play_brain1.if_first_inning_over)){
				    	usershot2=Integer.parseInt(three.getActionCommand());
				    	if(team_select.difficulty.equals("easy")){
					    	compshot2=toss_su.randnumbers[ra.nextInt(5)];}
				    	else
				    	{	
				    		if(toss_brain.userselect.equals("bat"))
				    		compshot2=hardshots2[ra.nextInt(3)];
				    		else
				    			compshot2=toss_su.randnumbers[ra.nextInt(5)];
				    	}
				    	play_brain1 pb =new play_brain1(update_score2,update_overs2, update_runrate2,reference2);
				    	try {
							pb.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb=null;}
				    	else{
				    		one.setEnabled(false);
				    		two.setEnabled(false);
				    		three.setEnabled(false);
				    		four.setEnabled(false);
				    		six.setEnabled(false);
				    	}
			
				    }
				});				
				
				//4 Button
				four.setActionCommand("4");
				four.setBounds((int) (Single_player.screenSize.width/(2.38)), Single_player.screenSize.height/50+(int) (Single_player.screenSize.height/(1.25)), Single_player.screenSize.width/15, Single_player.screenSize.height/10);
				four.setBorderPainted(true);
				four.setFont(Single_player.fbutton);
				four.setFocusable(false);
				play_base2.add(four);
				four.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	four.setBackground(Color.green);
				    	
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	four.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(play_brain1.if_first_inning_over)){
				    	usershot2=Integer.parseInt(four.getActionCommand());
				    	if(team_select.difficulty.equals("easy")){
					    	compshot2=toss_su.randnumbers[ra.nextInt(5)];}
				    	else
				    	{	
				    		if(toss_brain.userselect.equals("bat"))
				    		compshot2=hardshots2[ra.nextInt(3)];
				    		else
				    			compshot2=toss_su.randnumbers[ra.nextInt(5)];
				    	}
				    	
				    	play_brain1 pb =new play_brain1(update_score2,update_overs2, update_runrate2,reference2);
				    	try {
							pb.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb=null;
				    	}
				    	else{
				    		one.setEnabled(false);
				    		two.setEnabled(false);
				    		three.setEnabled(false);
				    		four.setEnabled(false);
				    		six.setEnabled(false);
				    	}
			
				    }
				});
				//6 Button
				six.setActionCommand("6");
				six.setBounds((int) (Single_player.screenSize.width/(1.83)), Single_player.screenSize.height/50+(int) (Single_player.screenSize.height/(1.25)), Single_player.screenSize.width/15, Single_player.screenSize.height/10);
				six.setBorderPainted(true);
				six.setFont(Single_player.fbutton);
				six.setFocusable(false);
				play_base2.add(six);
				six.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	six.setBackground(Color.green);
				    }

				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	six.setBackground(UIManager.getColor("control"));
				    }
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	if(!(play_brain1.if_first_inning_over)){
				    	usershot2=Integer.parseInt(six.getActionCommand());
				    	if(team_select.difficulty.equals("easy") ){
					    	compshot2=toss_su.randnumbers[ra.nextInt(5)];}
					    	else
					    	{	
					    		if(toss_brain.userselect.equals("bat"))
					    		compshot2=hardshots2[ra.nextInt(3)];
					    		else
					    			compshot2=toss_su.randnumbers[ra.nextInt(5)];
					    	}
				    	play_brain1 pb =new play_brain1(update_score2,update_overs2, update_runrate2,reference2);
				    	
				    	try {
							pb.main(temp);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				    	repaint();
				    	pb=null;
				    	}
				    	else{
				    		one.setEnabled(false);
				    		two.setEnabled(false);
				    		three.setEnabled(false);
				    		four.setEnabled(false);
				    		six.setEnabled(false);
				    	}
				    }
				});		
	}
	@Override
	protected void paintChildren(Graphics g) {
		 super.paintChildren(g);
		  if(!(usershot2==0))
		  {
			  try {
				final BufferedImage image1 = ImageIO.read(new File(usershot2+".jpg"));
				Image dimg1 = image1.getScaledInstance(Single_player.screenSize.width/10,Single_player.screenSize.height/(4),
				        Image.SCALE_SMOOTH);
				  g.drawImage(dimg1, (int) (Single_player.screenSize.width/(3.75)), (int) (Single_player.screenSize.height/(3.25)), null);
				  //hsjhaiskh 
				 
				  
				  final BufferedImage image2 = ImageIO.read(new File(compshot2+".jpg"));
					Image dimg2 = image2.getScaledInstance(Single_player.screenSize.width/10,Single_player.screenSize.height/(4),
					        Image.SCALE_SMOOTH);
					  g.drawImage(dimg2, (int) (Single_player.screenSize.width/(1.52)), (int) (Single_player.screenSize.height/(3.25)), null);
					  
					if(play_brain1.check_if_wicket){
						final BufferedImage image3 = ImageIO.read(new File("out.jpg"));
						Image dimg3 = image3.getScaledInstance(Single_player.screenSize.width/6,Single_player.screenSize.height/(3),
						        Image.SCALE_SMOOTH);
						  g.drawImage(dimg3, (int) (Single_player.screenSize.width/(1.2)), (int) (Single_player.screenSize.height/(1.6)), null);
						
					}
					if((!(play_brain1.check_if_wicket)) && (play_brain1.tempshot==4)){
						final BufferedImage image4 = ImageIO.read(new File("four.jpeg"));
						Image dimg4 = image4.getScaledInstance(Single_player.screenSize.width/6,Single_player.screenSize.height/(3),
						        Image.SCALE_SMOOTH);
						  g.drawImage(dimg4, (int) (Single_player.screenSize.width/(1.2)), (int) (Single_player.screenSize.height/(1.6)), null);
						
					}
					if((!(play_brain1.check_if_wicket)) && ( play_brain1.tempshot==6)){
						final BufferedImage image5 = ImageIO.read(new File("six.jpg"));
						Image dimg5 = image5.getScaledInstance(Single_player.screenSize.width/6,Single_player.screenSize.height/(3),
						        Image.SCALE_SMOOTH);
						  g.drawImage(dimg5, (int) (Single_player.screenSize.width/(1.2)), (int) (Single_player.screenSize.height/(1.6)), null);
						
					}
					
					  
					  
					  
			} catch (IOException e) {
				e.printStackTrace();
			} 
			  
			  

		  }
		  else
		  {
			  try {
					final BufferedImage image1 = ImageIO.read(new File("0.jpg"));
					Image dimg1 = image1.getScaledInstance(Single_player.screenSize.width/10,Single_player.screenSize.height/(4),
					        Image.SCALE_SMOOTH);
					  g.drawImage(dimg1, (int) (Single_player.screenSize.width/(3.75)), (int) (Single_player.screenSize.height/(3.25)), null);
					  //hsjhaiskh 
					 
					  
					  final BufferedImage image2 = ImageIO.read(new File("0.jpg"));
						Image dimg2 = image2.getScaledInstance(Single_player.screenSize.width/10,Single_player.screenSize.height/(4),
						        Image.SCALE_SMOOTH);
						  g.drawImage(dimg2, (int) (Single_player.screenSize.width/(1.5)), (int) (Single_player.screenSize.height/(3.25)), null);
						  
						  
				} catch (IOException e) {
					e.printStackTrace();
				}   
		  }
	
	}
}

