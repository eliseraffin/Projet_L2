import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import javax.swing.ImageIcon;

public class Modele extends Observable{

	public Objet[][] objets_inventaire;
	public Recette[] recettes;
	public Objet[][] crafting;
	public Recette r;
	public Objet objt_select;
	public int ind=10;
	public int ind_recipe=16;
	public int ind_invt=15;
	public Objet a_stocker;
	public String affichage;
	public boolean possible;
	public ImageIcon ic;
	public String categorie;

	public Modele() {

		this.affichage = "";
		Objet baton = new Objet("baton",6,"Matière première");
		Objet bois = new Objet("bois",6,"Matière première");
		Objet canne_sucre = new Objet("Canne_sucre",6,"Matière première");
		Objet fil = new Objet("fil",6,"Matière première");
		Objet lingot_fer = new Objet("lingot_fer",6,"Matière première");
		Objet pierre = new Objet("pierre",6,"Matière première");
		Objet plume = new Objet("plume",6,"Matière première");
		Objet redstone = new Objet("redstone",6,"Matière première");
		Objet silex = new Objet("silex",6,"Matière première");
		Objet arc = new Objet("arc",1,"Combat");
		Objet boussole = new Objet("boussole",1, "Outil");
		Objet planche = new Objet("planche",9,"Matière première");
		Objet papier = new Objet("papier",9,"Matière première");
		Objet nul = new Objet(null,0,null);

		Objet canne_a_peche = new Objet("canne_peche",1,"Outil");
		Objet hache_objet = new Objet("hache",1,"Outil");
		Objet pioche_objet = new Objet("pioche",1,"Outil");
		Objet four_objet = new Objet("four",1,"Outil");
		Objet distributeur_objet = new Objet("distrib",1,"Maison");
		Objet cisaille_objet = new Objet("cisaille",1,"Outil");
		Objet carte_objet = new Objet("carte",1,"Outil");
		Objet bateau_objet = new Objet("bateau",1,"Véhicule");
		Objet bol_objet = new Objet("bol", 1,"Maison");
		Objet barriere_objet = new Objet("barriere", 1,"Outil");
		Objet briquet_objet = new Objet("briquet",1,"Outil");
		Objet fleche_objet = new Objet("fleche",1,"Combat");

		this.categorie = null;
		
		this.a_stocker=nul;

		this.possible = false;

		this.r=new Recette(null,new Objet[3][3], nul, new HashMap<String, Integer>(),false);

		this.objets_inventaire = new Objet[5][3];
		Objet[][] obj = {{baton,bois,canne_sucre},{fil,lingot_fer,pierre},{plume,redstone,silex},{nul,nul,nul},{nul,nul,nul}};
		this.objets_inventaire = obj;


		final Objet[][] canne_p = {{nul,nul,baton}, {nul,baton,fil},{baton,nul,fil}};
		final HashMap<String,Integer> cp = new HashMap<String, Integer>();
		cp.put("baton", 3);
		cp.put("fil", 3);
		Recette canne_peche = new Recette("canne_peche",canne_p,canne_a_peche, cp,true);

		final Objet[][] hacheob = {{lingot_fer,lingot_fer,nul}, {lingot_fer,baton,nul},{nul,baton,nul}};
		final HashMap<String, Integer> h = new HashMap<String, Integer>();
		h.put("lingot_fer", 3);
		h.put("baton",2);
		Recette hache = new Recette("hache",hacheob,hache_objet,h,true);

		final Objet[][] piocheob = {{lingot_fer,lingot_fer,lingot_fer}, {nul,baton,nul},{nul,baton,nul}};
		final HashMap<String, Integer> p = new HashMap<String, Integer>();
		p.put("lingot_fer", 3);
		p.put("baton", 2);
		Recette pioche = new Recette("pioche",piocheob,pioche_objet,p,true);

		final Objet[][] arcob = {{fil,baton,nul}, {fil,nul,baton},{fil,baton,nul}};
		final HashMap<String, Integer> a = new HashMap<String, Integer>();
		a.put("fil", 3);
		a.put("baton", 3);
		Recette arc_recipe = new Recette("arc",arcob,arc,a,true);

		final Objet[][] fourob = {{pierre,pierre,pierre}, {pierre,nul,pierre},{pierre,pierre,pierre}};
		final HashMap<String, Integer> f = new HashMap<String,Integer>();
		f.put("pierre", 8);
		Recette four = new Recette("four2",fourob,four_objet,f,false);

		final Objet[][] distri = {{pierre,pierre,pierre}, {pierre,arc,pierre},{pierre,redstone,pierre}};
		final HashMap<String, Integer> d = new HashMap<String, Integer>();
		d.put("pierre", 7);
		d.put("arc", 1);
		d.put("redstone",1);
		Recette distributeur = new Recette("distributeur",distri,distributeur_objet,d,false);

		final Objet[][] boussoleob = {{nul,lingot_fer,nul}, {lingot_fer,redstone,lingot_fer},{nul,lingot_fer,nul}};
		final HashMap<String, Integer> b = new HashMap<String, Integer>();
		b.put("lingot_fer", 4);
		b.put("redstone", 1);
		Recette boussole_recipe = new Recette("boussole",boussoleob,boussole,b,true);

		final Objet[][] cisailleob = {{nul,nul,nul}, {nul,lingot_fer,nul},{lingot_fer,nul,nul}};
		final HashMap<String, Integer> c = new HashMap<String, Integer>();
		c.put("lingot_fer", 2);
		Recette cisaille = new Recette("cisaille",cisailleob,cisaille_objet,c,true);

		final Objet[][] carteob = {{papier,papier,papier}, {papier,boussole,papier},{papier,papier,papier}};
		final HashMap<String, Integer> card = new HashMap<String, Integer>();
		card.put("papier", 8);
		card.put("boussole", 1);
		Recette carte = new Recette("carte",carteob,carte_objet,card,false);

		final Objet[][] plancheob = {{nul,nul,nul}, {nul,bois,nul},{nul,nul,nul}};
		final HashMap<String, Integer> pl = new HashMap<String, Integer>();
		pl.put("bois", 1);
		Recette planche_recipe = new Recette("planche",plancheob,planche,pl,true);

		final Objet[][] bateauob = {{nul,nul,nul}, {bois,nul,bois},{bois,bois,bois}};
		final HashMap<String, Integer> boat = new HashMap<String, Integer>();
		boat.put("bois", 5);
		Recette bateau = new Recette("bateau",bateauob,bateau_objet,boat,true);

		final Objet[][] bolob = {{nul,nul,nul}, {planche,nul,planche},{nul,planche,nul}};
		final HashMap<String, Integer> bo = new HashMap<String, Integer>();
		bo.put("planche", 3);
		Recette bol = new Recette("bol",bolob,bol_objet,bo,false);

		final Objet[][] papierob = {{nul,nul,nul}, {nul,nul,nul},{canne_sucre,canne_sucre,canne_sucre}};
		final HashMap<String, Integer> paper = new HashMap<String, Integer>();
		paper.put("canne_sucre", 3);
		Recette papier_recipe = new Recette("papier",papierob,papier,paper,true);

		final Objet[][] barriereob = {{nul,nul,nul},{planche,baton,planche},{planche,baton,planche}};
		final HashMap<String, Integer> barr = new HashMap<String, Integer>();
		barr.put("planche", 4);
		barr.put("baton", 2);
		Recette barriere = new Recette("barriere",barriereob,barriere_objet,barr,false);

		final Objet[][] briquetob = {{nul,nul,nul},{lingot_fer,nul,nul},{nul,silex,nul}};
		final HashMap<String, Integer> br = new HashMap<String, Integer>();
		br.put("lingot_fer", 1);
		br.put("silex", 1);
		Recette briquet = new Recette("briquet",briquetob,briquet_objet,br,true);

		final Objet[][] flecheob = {{nul,silex,nul},{nul,baton,nul},{nul,plume,nul}};
		final HashMap<String, Integer> fl = new HashMap<String, Integer>();
		fl.put("silex", 1);
		fl.put("baton", 1);
		fl.put("plume", 1);
		Recette fleche = new Recette("fleche", flecheob,fleche_objet,fl,true);

		final Objet[][] nulliste = {{nul,nul,nul},{nul,nul,nul},{nul,nul,nul}};
		final HashMap<String, Integer> nullle = new HashMap<String, Integer>();
		Recette nulle = new Recette(null,nulliste,nul,nullle,false);

		this.recettes = new Recette[16];
		Recette[] recipes = {canne_peche,hache,pioche,arc_recipe,four,distributeur,boussole_recipe,cisaille,carte,planche_recipe,bateau,bol,papier_recipe,barriere,briquet,fleche,nulle};
		this.recettes = recipes;

		this.crafting = new Objet[3][3];
		Objet[][] crafting_nul = {{nul,nul,nul},{nul,nul,nul},{nul,nul,nul}};
		this.crafting = crafting_nul;



	}
	
	public void categorie(String cat) {
		this.categorie = cat;
		this.setChanged();
		this.notifyObservers(this.categorie);
	}

	public void ajouterObjet(String obj, int ind,int qte, String cat) {	
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				if (2*i+j+i == ind) {
					this.crafting[i][j] = new Objet(obj,1,cat);
					this.ind = ind;
					this.setChanged();
					this.notifyObservers(this.crafting);
					if (est_recette(this.crafting)<16) {
						this.r = this.recettes[est_recette(this.crafting)];
					} else {
						this.r = this.recettes[16];
					}this.setChanged();
					this.notifyObservers(this.crafting);

				} 


			}
		}
	}





	public void ajouterRecette(String obj, int ind,int qte,String cat) {
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<3; j++) {
				if (2*i+i+j==ind && (this.objets_inventaire[i][j].lib==null || this.objets_inventaire[i][j].lib=="vide")) {
					this.objets_inventaire[i][j] = new Objet(obj,qte, cat);
					this.ind_recipe = ind;
					this.a_stocker = new Objet(null,0,null);
					this.ind_recipe = 15;
					this.setChanged();
					this.notifyObservers(this.objets_inventaire);
					this.notifyObservers(this.a_stocker);
					this.notifyObservers(this.ind_recipe);

				}
			}


		}

	}



	public void raz_recette() {
		this.r=new Recette(null,new Objet[3][3],new Objet(null,1,null), new HashMap<String,Integer>(), false);
		this.setChanged();
		this.notifyObservers(this.r);
	}


	public void nouvelObjet(String lib, int qte, String cat) {
		this.objt_select = new Objet(lib,qte, cat);
		this.ind = 10;
		this.setChanged();
		this.notifyObservers(this.objt_select);
	}

	public boolean identiques(Objet[][] mat1, Objet[][] mat2) {
		boolean flag=true;
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				if (mat1[i][j].lib!=null && mat2[i][j].lib!=null) {
					if (!((mat1[i][j].lib).equals(mat2[i][j].lib))) {
						flag = false;
					}
				}
				if (mat1[i][j].lib!=null && mat2[i][j].lib==null) {
					flag = false;
				}
				if (mat1[i][j].lib==null && mat2[i][j].lib!=null) {
					flag = false;
				}
			}
		} return flag;
	}

	public int est_recette(Objet[][] matrice_crafting) {
		int recette_ind = 16;
		for (int k = 0; k<16; k++) {
			if (identiques(this.recettes[k].matrice, matrice_crafting)){
				recette_ind = k;
			}
		}
		return recette_ind;
	}


	public void raz_craft() {
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				this.crafting[i][j] = new Objet(null,0,null);
				this.ind = 10;
			}
		}

		this.setChanged();
		this.notifyObservers(this.crafting);
	}

	public int indice_remettre_objet_inventaire() {
		int ind=0;
		for (int i = 4; i>=0; i--) {
			for (int j = 2; j>=0; j--) {
				if (this.objets_inventaire[i][j].lib == "vide" || this.objets_inventaire[i][j].lib==null) {
					ind = 2*i+i+j;
				}
			}
		}



		return (ind);
	}

	public void remettre_objet_inventaire (String ob,int ind, String cat) {
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<3; j++) {
				if (2*i+i+j == ind) {
					this.objets_inventaire[i][j] = new Objet(ob,1, cat);
				}
			}
		}

		this.setChanged();
		this.notifyObservers(this.crafting);
	}

	public boolean est_present_invt(String ob) {
		boolean flag = false;
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<3; j++) {
				if (this.objets_inventaire[i][j].lib == ob) {
					flag = true;
				}
			}
		}



		return flag;
	}

	public String cheminObjet(Objet o) {
		return o.lib+".png";
	}

	public String cheminRecette(Recette r) {
		return r.lib+"2.png";
	}

	public String cheminAccompagnement(Recette r) {
		return "acc_"+r.lib+".PNG";
	}



	public void conseils(Recette r) {
		this.affichage = "Il vous faut : \r\n";
		for (Entry <String, Integer> entry : r.liste.entrySet()) {
			String nom = entry.getKey();
			Integer qt = entry.getValue();
			String quantite = qt.toString();
			if (nom!=null) {
				this.affichage += nom + " x " + quantite + "\r\n";
				this.possible = false;
				for (int i = 0; i<5; i++) {
					for (int j=0; j<3; j++) {
						if (this.objets_inventaire[i][j].lib==nom && this.objets_inventaire[i][j].qte>=qt) {
							this.possible = true;
						} 
					}
				} 
				if (this.possible==true) {
					this.ic = new ImageIcon("Accompagnement_images/"+this.cheminAccompagnement(r));
				} else {
					this.ic = new ImageIcon("Accompagnement_images/impossible.png");
				}
			}

		}

		this.setChanged();
		this.notifyObservers(this.ic);
		this.notifyObservers(this.affichage);

		this.affichage = "";
		this.notifyObservers(this.affichage);
	}

}