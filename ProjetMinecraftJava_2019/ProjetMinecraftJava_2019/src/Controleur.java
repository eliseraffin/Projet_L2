import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Controleur implements ActionListener {

	Modele mdl;

	public Controleur(Modele m){
		this.mdl = m;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		String[] source_inv = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14"};
		for (int i = 0; i<source_inv.length; i++) {
			if (((JButton)e.getSource()).getName() == source_inv[i]) {
				for (int j = 0; j<5; j++) {
					for (int k=0; k<3; k++) {
						if (2*j+j+k==i && this.mdl.objets_inventaire[j][k].lib != null) {
							String nom = this.mdl.objets_inventaire[j][k].lib;
							String categorie = this.mdl.objets_inventaire[j][k].categorie;
							if (this.mdl.objets_inventaire[j][k].qte >1) {
								this.mdl.nouvelObjet(nom,1,categorie);
							} if (this.mdl.objets_inventaire[j][k].qte==0) {
								this.mdl.nouvelObjet(null,0,null);
							} if (this.mdl.objets_inventaire[j][k].qte==1) {
								this.mdl.nouvelObjet(nom,1,categorie);
								this.mdl.objets_inventaire[j][k] = new Objet("vide",0,null);	
							} if (this.mdl.a_stocker.lib!=null && this.mdl.a_stocker.lib ==nom) {
								this.mdl.objets_inventaire[j][k] = new Objet(nom,this.mdl.a_stocker.qte+this.mdl.objets_inventaire[j][k].qte, this.mdl.a_stocker.categorie);	
							}
						} if (2*j+j+k==i && (this.mdl.objets_inventaire[j][k].lib == null || this.mdl.objets_inventaire[j][k].lib == "vide")) {
							this.mdl.ind_recipe = Integer.parseInt(source_inv[i]);
							this.mdl.ajouterRecette(this.mdl.a_stocker.lib, this.mdl.ind_recipe,this.mdl.a_stocker.qte, this.mdl.a_stocker.categorie);
							this.mdl.a_stocker = new Objet(null,0,null);
							this.mdl.ind_recipe = 15;
						}
					}
				} 
			} 
		}

		String[] source_craft =  {"0c","1c","2c","3c","4c","5c","6c","7c","8c"};	
		for (int j = 0; j<source_craft.length; j++) {
			if (((JButton)e.getSource()).getName() == source_craft[j]) {
				int indice = Integer.parseInt(((JButton)e.getSource()).getName().substring(0, 1));
				for (int i = 0; i<3; i++) {
					for (int k = 0;k<3; k++) {
						if (2*i+i+k==indice) {
							if (this.mdl.crafting[i][k].lib == null) {
								if (!(this.mdl.est_present_invt(this.mdl.objt_select.lib))) {
									this.mdl.ajouterObjet(this.mdl.objt_select.lib, indice,1,this.mdl.objt_select.categorie);
									this.mdl.objt_select = new Objet(null,0,null);
								} if (this.mdl.objt_select.lib!=null) {
									this.mdl.ajouterObjet(this.mdl.objt_select.lib, indice,1,this.mdl.objt_select.categorie);
								}
								for (int m = 0; m<5; m++) {
									for (int n = 0; n<3; n++) {
										if (this.mdl.objets_inventaire[m][n].lib==this.mdl.objt_select.lib) {
											if (this.mdl.objets_inventaire[m][n].qte>1) {
												this.mdl.objets_inventaire[m][n].qte --;
											}
										} 
										if (this.mdl.objets_inventaire[m][n].lib==this.mdl.objt_select.lib && this.mdl.objets_inventaire[m][n].qte==1) {
											this.mdl.objets_inventaire[m][n].qte=0;
											this.mdl.objets_inventaire[m][n] = new Objet("vide",0,null);	
										} 	
									}
								} 
							} else {
								if (this.mdl.crafting[i][k].lib != null) {

									String o = this.mdl.crafting[i][k].lib;
									String cat = this.mdl.crafting[i][k].categorie;
									this.mdl.ajouterObjet(null, indice,0,null);
									if (this.mdl.est_present_invt(o)) {
										for (int m = 0; m<5; m++) {
											for (int n = 0; n<3; n++) {
												if (this.mdl.objets_inventaire[m][n].lib==o) {
													this.mdl.objets_inventaire[m][n].qte ++;
												} 	
											}
										}  
									} if (!(this.mdl.est_present_invt(o))) {
										this.mdl.remettre_objet_inventaire(o, this.mdl.indice_remettre_objet_inventaire(),cat);

									} 
								}
							}
						}
					}
				}
			}
		} 



		if (((JButton)e.getSource()).getName() == "0r") {
			if ( this.mdl.r.lib!=null) {
				this.mdl.categorie(null);
				this.mdl.a_stocker = this.mdl.r.miniature;
				this.mdl.objt_select = new Objet(null,0,null);
				this.mdl.raz_recette();
				this.mdl.raz_craft();
			}
		}

		String[][] source_acc =  {{"0acc","1acc","2acc","3acc"},{"4acc","5acc","6acc","7acc"},{"8acc","9acc","10acc","11acc"},{"12acc","13acc","14acc","15acc"}}; 
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<4; j++) {
				if (((JButton)e.getSource()).getName()== source_acc[i][j]) {
					this.mdl.conseils(this.mdl.recettes[4*i+j]);
				}
			}
		}
		
		String[] source_tri = {"Outil", "Combat", "Matière première", "Maison", "Véhicule"};
		for (int i = 0; i<5; i++) {
			if (((JButton)e.getSource()).getName() == source_tri[i]) {
				this.mdl.categorie(source_tri[i]);	
			}
		}
		
		if (((JButton)e.getSource()).getName()=="raz") {
			this.mdl.categorie(null);
		}
	}
}
