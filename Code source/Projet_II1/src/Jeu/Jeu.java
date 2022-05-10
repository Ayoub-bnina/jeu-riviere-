package Jeu;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




enum Rive { droite , gauche} /* type enumeration qui donne 
                     la rive actuelle des éléments du jeu*/

//classe Jeu
public class Jeu extends JFrame{
         Chevre chevre; 
		 Loup loup;   
		 Chou chou;     
		 Fermier fermier;   
		 Barque barque;     
		 JPanel jpg,jpd,jpc,jpb;  
		 JButton echv,ec,el,dchv,dc,dl,dirig;
		 
	    
	 public Jeu() {
			 
			 setVisible(true);
		     setSize(1000, 800);
		     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     setTitle("Simulation de l'ènigme de passage de rivière");
		     setResizable(true);
		     setLocationRelativeTo(null);
		     
		     
		     jpg= new JPanel();
		     jpc= new JPanel();
		     jpd= new JPanel();
		     jpb= new JPanel();
		     jpg.setBackground(Color.cyan);
		     jpc.setBackground(Color.lightGray);
		     jpd.setBackground(Color.cyan);
		     jpb.setBackground(Color.white);
		     jpg.setPreferredSize(new Dimension(300,300));
			 jpc.setPreferredSize(new Dimension(100,100));
			 jpd.setPreferredSize(new Dimension(300,300));
			 jpb.setPreferredSize(new Dimension(300,300));
			 getContentPane().setLayout(new BorderLayout());
			 jpg.setLayout(new BoxLayout(jpg,BoxLayout.PAGE_AXIS));
			 jpc.setLayout(new BoxLayout(jpc,BoxLayout.PAGE_AXIS));
			 jpd.setLayout(new BoxLayout(jpd,BoxLayout.PAGE_AXIS));
			 jpb.setLayout(new BoxLayout(jpb,BoxLayout.PAGE_AXIS));
			 
		    
		     
		    
		  // initialement tout le monde se trouvent sur la rive gauche
			 chevre = new Chevre(Rive.gauche);
			 chou = new Chou(Rive.gauche);
			 loup = new Loup(Rive.gauche);
			 barque = new Barque(Rive.gauche);
			 fermier = new Fermier(Rive.gauche);
			 
			
			 
			 JLabel label= new JLabel("Bienvenue à notre jeu: Simulation de l'ènigme de passage de rivière");
				jpc.add(label);
				
				// les bouttons du jeu
			    echv= new JButton("embarquer la chèvre");
			    ec= new JButton("embarquer le chou");
			    el= new JButton("embarquer le loup");
			    dirig=new JButton("déplacer la barque");
			    dchv= new JButton("débarquer la chèvre");
			    dc= new JButton("débarquer le chou");
			    dl= new JButton("débarquer le loup");
			    jpc.add(echv);
			    jpc.add(dchv);
			    jpc.add(ec);
			    jpc.add(dc);
			    jpc.add(el);
			    jpc.add(dl);
			    jpc.add(dirig);
			    
			    
			    // l'affichage  de la description et les regles du jeu
			    jpb.add(new JLabel("  LA DESCRIPTION DU JEU:  "));
			    jpb.add(new JLabel("  Pour rentrer à sa ferme,un fermier accompagné de sa chèvre,de son loup,et d'un chou doit traverser une riviére. "));
			    jpb.add(new JLabel("  Cependant, il ne possède qu'un minuscule barque lui permettant de transporter qu'un seul des ses compagnons à la fois."));
			    jpb.add(new JLabel("  Comment va-t-il alors s'y prendre pour les faire traverser tous,sans qu'aucun ne se fasse manger par son prèdateur pendant qu'ils ne seront pas surveillés."));
			    
			    jpb.add(new JLabel("  LES REGLES DU JEU:  "));
			    jpb.add(new JLabel("  -La barque à 2 places;"));
			    jpb.add(new JLabel("  -Les éléments du jeu (chèvre,chou,loup,fermier,barque) se trouve initialement sur la rive gauche;"));
			    jpb.add(new JLabel("  -Le fermier doit faire passer les éléments du jeu sur la rive droite;"));
			    jpb.add(new JLabel("  -Seul le fermier peut diriger la barque;"));
			    jpb.add(new JLabel("  -Le fermier ne peut transporter qu'un seul compagnon à la fois;"));
			    jpb.add(new JLabel("  -En absence du fermier, la chévre mange le chou et le loup mange la chèvre."));
		        jpb.add(new JLabel("  **************************************************************************************"));
			    jpb.add(new JLabel("  ECOLE NATIONALE DES SCIENCES DE L'INFORMATIQUE"));
			    jpb.add(new JLabel("  Stage d'été II1  2021"));
			    jpb.add(new JLabel("  Application developpée par: Mohamed Mahmoud Djeba & Ayoub Bnina"));
			   
			  // afficher la situation initiale
			    afficher();
			    
			    
			    echv.addActionListener(new ActionListener() {
				       public void actionPerformed(ActionEvent e) {
				    	   barque.embarquer_chevre(chevre,fermier); 
				           afficher();
				           
				    }
				    });
				ec.addActionListener(new ActionListener() {
					       public void actionPerformed(ActionEvent e) {
					    		
					    	   barque.embarquer_chou(chou,fermier); 
					    	   afficher();
					    }
					    });
					   
				el.addActionListener(new ActionListener() {
					       public void actionPerformed(ActionEvent e) {
					    	   barque.embarquer_loup(loup,fermier);
					    	   afficher();
					    }
					    });
				    
				
				dirig.addActionListener(new ActionListener() {
					       public void actionPerformed(ActionEvent e) {
					    	   diriger_barque();
					           afficher();
					    }
					    });
				    
				   
				dchv.addActionListener(new ActionListener() {
				       public void actionPerformed(ActionEvent e) {
				    	   barque.debarquer_chevre(chevre,fermier); 
				           afficher();
				    }
				    });
				dc.addActionListener(new ActionListener() {
					       public void actionPerformed(ActionEvent e) {
					    	   barque.debarquer_chou(chou,fermier); 
					    	   afficher();
					    }
					    });
					   
				dl.addActionListener(new ActionListener() {
					       public void actionPerformed(ActionEvent e) {
					    	   barque.debarquer_loup(loup,fermier);
					    	   afficher();
					    }
					    });
				
				
				   
			 getContentPane().add(jpd,BorderLayout.EAST );
			 getContentPane().add(jpc,BorderLayout.CENTER);
	   		 getContentPane().add(jpg,BorderLayout.WEST);
	   		 getContentPane().add(jpb,BorderLayout.SOUTH);
				    
			  }
	 
	 
	 // une méthode qui appelle la methode Fermier.diriger(Jeu);
	 public void diriger_barque() {
		 fermier.diriger(this);
	 }
	 
	 
		// methode pour l'affichage des éléments du jeu en utilisant leur images
		 public void afficher() {
			 // pour effacer les affichages precédentes dans l'interface graphique
			 jpg.removeAll();
			 jpd.removeAll();
			 // l'ajout des titres des rives
			 jpg.add(new JLabel(" RIVE GAUCHE  "));
			 jpd.add(new JLabel(" RIVE DROITE  "));
			 //l'affichage des éléments qui se trouvent à l éxterieur de la barque
			 JLabel ch,c,l,f;
			 if(!(barque.passagers.contains("chevre"))) {
			 if(chevre.rive==Rive.gauche) { 
			     
				 ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("chevre.gif"));
				 ch=new JLabel(img);
				 jpg.add(ch);
			     
			 }
			 else {   
				 ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("chevre.gif"));
				
				 ch=new JLabel(img);
				 
				 jpd.add(ch);
				 
				
				 
			 }
			 }
			 if(!(barque.passagers.contains("chou"))) {
			 if(chou.rive==Rive.gauche) {
				 ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("chou.jpg"));
				 c=new JLabel(img);
				 
				 jpg.add(c);
				
				 
			 }
			 else { 
				 ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("chou.jpg"));
				 c=new JLabel(img);
				 jpd.add(c);
				
			 }
			 }
			 if(!(barque.passagers.contains("loup"))) {
			 if(loup.rive==Rive.gauche) { 
				 ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("loup.gif"));
				 l=new JLabel(img);
				jpg.add(l);
				
			 }
			 else { 
				 ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("loup.gif"));
				 l=new JLabel(img);
					jpd.add(l);
				
			 }
			 }
			 if(!(barque.passagers.contains("fermier"))) {
			 if(fermier.rive==Rive.gauche) {  
				 ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("fermier.jpg"));
				 f=new JLabel(img);
				 jpg.add(f);
			
			 }
			 else { 
				 ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("fermier.jpg"));
				 f=new JLabel(img);
				 jpd.add(f);
			
			 }
			 }
			 // l'affichege de la barque et sa contenue
			 barque.afficher_contenue(this);
			 setContentPane(getContentPane());
			
			// les differents cas d'échec
			   if(((chevre.rive==loup.rive)&&(chevre.rive!=fermier.rive))||((chou.rive==chevre.rive)&&(chou.rive!=fermier.rive))) {
				     echv.setEnabled(false);
				     ec.setEnabled(false);
				     el.setEnabled(false);
				     dirig.setEnabled(false);
				     dchv.setEnabled(false);
				     dc.setEnabled(false);
				     dl.setEnabled(false);				   
					 
				   
				   jpc.add(new JLabel(" le jeu est terminé avec échec"));
					
					JButton ok= new JButton("OK");
					jpc.add(ok);
					ok.addActionListener(new ActionListener() {
					       public void actionPerformed(ActionEvent e) {
					    		
					    	   System.exit(0);
					    }
					    });
					setContentPane(getContentPane());
				
				 }
			
				 
			 // en cas de succès
			 
			 if((chevre.rive==Rive.droite)&&(chou.rive==Rive.droite)&&(loup.rive==Rive.droite)&&(fermier.rive==Rive.droite)&&(barque.rive==Rive.droite)){
				 echv.setEnabled(false);
			     ec.setEnabled(false);
			     el.setEnabled(false);
			     dirig.setEnabled(false);
			     dchv.setEnabled(false);
			     dc.setEnabled(false);
			     dl.setEnabled(false);
				 jpc.add(new JLabel(" les éléments du jeu se trouvent sur la rive droite, le jeu est terminé avec succès, Bravo vous avez gagné!")) ;
					
					JButton ok= new JButton("OK");
					jpc.add(ok);
					ok.addActionListener(new ActionListener() {
					       public void actionPerformed(ActionEvent e) {
					    		
					    	   System.exit(0);
					    }
					    });
					setContentPane(getContentPane());
				
				 
			 }
			
	  } 
			
		 
		// la méthode "main" pour l'éxecution du jeu
		 public static void main(String[] args) {
			 EventQueue.invokeLater(new Runnable() {
					public void run() {
						
						Jeu jeu = new Jeu();
						
			
				
				}
				});
		 }
			
    }
		 


				
				
				

				
				
				
				
				
				
				
				
				
				

				
				
		 
			


	
//classe Chou
		class Chou  {
			Rive rive;
			  public Chou(Rive r) {
						   rive =r;
						  
					   }
			  // la méthode du déplacement du chou 
			  public void deplacer(Barque b) {
				  if((b.passagers.contains("chou"))) {
					 if (rive==Rive.droite) {
			            rive=Rive.gauche;} 

					 else { 
						 rive=Rive.droite;} 
				    }
				
			  }
		}
		
			 
	   
	   
		//classe Chevre
	   class Chevre  {
		   Rive rive;
			public Chevre(Rive r) {
					  rive=r;
					 
					  }
			// la méthode du déplacement de la chevre
			public void deplacer(Barque b) {
				if((b.passagers.contains("chevre"))) { 
				 if (rive==Rive.droite) {
		            rive=Rive.gauche;} 

				 else {
					 rive=Rive.droite;}
			    }
				
			}
		
	   }
		 
		 
				
  
  //classe Loup
  class Loup {
	  Rive rive;
	   public Loup(Rive r) {
		  rive=r;
		  
	   }
	   // la méthode du déplacement du loup
	   public void deplacer(Barque b) {
		   if((b.passagers.contains("loup"))) {
			 if (rive==Rive.droite) {
	            rive=Rive.gauche;} 
			
			 else {
				 rive=Rive.droite;}
		    }
		
	   }
	
     }
	   
	
  
//classe Barque
	class Barque {
		   Rive rive;
		   final int nbr_de_places=2; //nombre maximum des places de la barque
		   ArrayList<String> passagers; /* un tableau dynamique de type String contient 
		      les noms des classes des objets embarqués sur la barque */
		   public Barque(Rive r) {
			   rive=r;
			 
			   passagers = new  ArrayList<String>();
			
		   }
		   // la methode du déplacement de la barque
		   public void deplacer() {
			 if (rive==Rive.droite) {
				 rive=Rive.gauche; 
				
	              }
			 
			 else {
				 rive=Rive.droite; 
			
		    }
		   }
		   // une methode qui affiche le contenu de la barque en utilisant leur images
		   public void afficher_contenue(Jeu j) {
			 if(rive==Rive.gauche) {
			   if(passagers.size()==1) {
				   ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("barque_fermier.jpg"));
					 
					 j.jpg.add(new JLabel(img));
				
			   }
			   else if(passagers.size()==2) {
			    if((passagers.contains("chevre"))){
			    	ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("barque_chevre.jpg"));
					 j.jpg.add(new JLabel(img));
			   }
			   if(passagers.contains("chou")){
				   ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("barque_chou.jpg"));
					 j.jpg.add(new JLabel(img));
			
			   }
			   if(passagers.contains("loup")){
				   ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("barque_loup.jpg"));
					 j.jpg.add(new JLabel(img));
				 
			   }
			   }
			   else {
				   ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("barque.jpg"));
					 j.jpg.add(new JLabel(img));
			   }
			   }
			   else {
				   if(passagers.size()==1) {
					   ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("barque_fermier.jpg"));
						 j.jpd.add(new JLabel(img));
					
				   }
				   else if(passagers.size()==2) {
				    if((passagers.contains("chevre"))){
				    	ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("barque_chevre.jpg"));
						 j.jpd.add(new JLabel(img));
					
				   }
				   if(passagers.contains("chou")){
					   ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("barque_chou.jpg"));
						 j.jpd.add(new JLabel(img));
					
				   }
				   if(passagers.contains("loup")){
					   ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("barque_loup.jpg"));
						 j.jpd.add(new JLabel(img));
					  
				   }
				   }
				   else {
					   ImageIcon img=new ImageIcon(getClass().getClassLoader().getResource("barque.jpg"));
						 j.jpd.add(new JLabel(img));
					 
				   } 
			   }
		   }
		   // la méthode de l'embarquement du fermier 
		   public void embarquer_fermier(Fermier f) {
			   
			   if ((passagers.size()<2)&&(!(passagers.contains("fermier")))&&(rive==f.rive)){
			    
			
			      passagers.add("fermier"); 
			     
			      
			      }
		   }
		 
		// la méthode de l'embarquement de la chevre
		   public void embarquer_chevre(Chevre ch,Fermier f) {
			   if(!(passagers.contains("fermier"))) { 
				   embarquer_fermier(f);} 
			
			   if ((passagers.size()<2)&&(!(passagers.contains("chevre")))&&(rive==f.rive)&&(rive==ch.rive))
			     {
				
			  
			      passagers.add("chevre");
			      
			      
			      }
			  
		   }
		  
		// la méthode de l'embarquement du loup
		   public void embarquer_loup(Loup l,Fermier f) {
			   if(!(passagers.contains("fermier"))) { 
				   embarquer_fermier(f); 
			   }
			   
			   if ((passagers.size()<2)&&(!(passagers.contains("loup")))&&(rive==f.rive)&&(rive==l.rive)) {
			     
			      passagers.add("loup"); 
			      
			   }
			      
			  
		   }
		   
		// la méthode de l'embarquement du chou
		   public void embarquer_chou(Chou c,Fermier f) {
			   if(!(passagers.contains("fermier"))) {
				   embarquer_fermier(f);} 
			
			    if ((passagers.size()<2)&&(!(passagers.contains("chou"))&&(rive==f.rive)&&(rive==c.rive))) {
			     
			      passagers.add("chou"); 
			     
			    }
			      
			 
			   }
		   
		// la méthode du débarquement du fermier 
		   public void debarquer_fermier(Fermier f) {
				
			   if((passagers.size()!=0)&&(rive==f.rive)&&(passagers.contains("fermier"))){
				  
				
					   
						   passagers.remove("fermier");  
					
						  
					   
				   
			   }
				
			   
			   }
			   
		   
		// la méthode du débarquement de la chevre
		   public void debarquer_chevre(Chevre ch, Fermier f) {
			 if((passagers.size() !=0)&&(rive==f.rive)&&(rive==ch.rive)&&(passagers.contains("chevre"))) {
				   
				
					 
						   passagers.remove("chevre"); 
						
						   
				   
			   }
				
			   
			   }

		// la méthode du débarquement du chou
		   public void debarquer_chou(Chou c,Fermier f) {
	         if((passagers.size()!=0)&&(rive==f.rive)&&(rive==c.rive)&&(passagers.contains("chou"))) {
				 
				
					   
						   passagers.remove("chou"); 
						
						 
					   
				   
			   }
				
			   }
		   
		// la méthode du débarquement du loup
		   public void debarquer_loup(Loup l,Fermier f) {
			    if((passagers.size()!=0)&&(rive==f.rive)&&(rive==l.rive)&&(passagers.contains("loup"))) {
				    
				  
						   passagers.remove("loup");
			   }
				
	
		  
	}
		
	}	
		
		
		//classe Fermier
		 class Fermier{
			 Rive rive;
			   public Fermier(Rive r) {
				   rive=r;
				
			   }
			   
			// la méthode du déplacement du fermier 
			   public void deplacer(Barque b) {
				  if( b.passagers.contains("fermier")) {
					 if (rive==Rive.droite) {
			            rive=Rive.gauche;}
	
					 else {
						 rive=Rive.droite;}
				    }
			   }
			   
			  // la méthode qui permet au fermier de diriger la barque 
			   public void diriger(Jeu j) {
				   if(!(j.barque.passagers.contains("fermier"))) {//si le fermier n'existe pas sur la barque
					   j.barque.embarquer_fermier(this);} // on embarque le fermier
				   
				   // déplacer la barque et ses passagers  
				   if (j.barque.rive==Rive.droite) { 
			          
			            j.barque.deplacer();
			             j.fermier.deplacer(j.barque);
			             j.chevre.deplacer(j.barque);
			             j.chou.deplacer(j.barque);
			             j.loup.deplacer(j.barque);}
			               
				   else{
				    
				       j.barque.deplacer();
		               j.fermier.deplacer(j.barque);
		               j.chevre.deplacer(j.barque);
		               j.chou.deplacer(j.barque);
		               j.loup.deplacer(j.barque);
				   } 
				   
				  
				  
					 
			   
			   }
			   
		   }
		  
		  

		   
  
	   
	   
 

  
  

