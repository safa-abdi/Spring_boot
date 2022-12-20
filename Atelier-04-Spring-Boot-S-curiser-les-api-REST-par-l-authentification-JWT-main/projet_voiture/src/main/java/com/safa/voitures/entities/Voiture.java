package com.safa.voitures.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
public class Voiture {
	@ManyToOne
	private Marque marque;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idVoiture;
	@Size (min = 2,max = 30)
	private String designation;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date dateCreation;
	
	
	@NotNull
	private Double prixVoiture;
	
	@Size (min = 3,max = 155)
	private String couleurs;
	private String disponibilite;
	private int garantie;
	private int nbPlaces;
	private int nbPortes;
	private int nbCylindres;
	private String Energie;
	private String Puisssance_fiscale;
	private String boite;
	private int longueur;
	private int largueur;
	private int Hauteur;

	public Voiture() {
	    super(); 
		}
	
	public Voiture(Marque marque, @Size(min = 2, max = 30) String designation, Date dateCreation, Double prixVoiture,
			@Size(min = 3, max = 155) String couleurs, String disponibilite, int garantie, int nbPlaces, int nbPortes,
			int nbCylindres, String energie, String puisssance_fiscale, String boite, int longueur, int largueur,
			int hauteur) {
		super();
		this.setMarque(marque);
		this.designation = designation;
		this.dateCreation = dateCreation;
		this.prixVoiture = prixVoiture;
		this.couleurs = couleurs;
		this.disponibilite = disponibilite;
		this.garantie = garantie;
		this.nbPlaces = nbPlaces;
		this.nbPortes = nbPortes;
		this.nbCylindres = nbCylindres;
		Energie = energie;
		Puisssance_fiscale = puisssance_fiscale;
		this.boite = boite;
		this.longueur = longueur;
		this.largueur = largueur;
		Hauteur = hauteur;
	}

	public String getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}
	public int getGarantie() {
		return garantie;
	}
	public void setGarantie(int garantie) {
		this.garantie = garantie;
	}
	public int getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	public int getNbPortes() {
		return nbPortes;
	}
	public void setNbPortes(int nbPortes) {
		this.nbPortes = nbPortes;
	}
	public int getNbCylindres() {
		return nbCylindres;
	}
	public void setNbCylindres(int nbCylindres) {
		this.nbCylindres = nbCylindres;
	}
	public String getEnergie() {
		return Energie;
	}
	public void setEnergie(String energie) {
		Energie = energie;
	}
	public String getPuisssance_fiscale() {
		return Puisssance_fiscale;
	}
	public void setPuisssance_fiscale(String puisssance_fiscale) {
		Puisssance_fiscale = puisssance_fiscale;
	}
	public String getBoite() {
		return boite;
	}
	public void setBoite(String boite) {
		this.boite = boite;
	}
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	public int getLargueur() {
		return largueur;
	}
	public void setLargueur(int largueur) {
		this.largueur = largueur;
	}
	public int getHauteur() {
		return Hauteur;
	}
	public void setHauteur(int hauteur) {
		Hauteur = hauteur;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getPrixVoiture() {
		return prixVoiture;
	}
	public void setPrixVoiture(Double prixVoiture) {
		this.prixVoiture = prixVoiture;
	}
	public Long getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}
	public String getCouleurs() {
		return couleurs;
	}
	public void setCouleurs(String couleurs) {
		this.couleurs = couleurs;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", idVoiture=" + idVoiture + ", designation=" + designation
				+ ", dateCreation=" + dateCreation + ", prixVoiture=" + prixVoiture + ", couleurs=" + couleurs
				+ ", disponibilite=" + disponibilite + ", garantie=" + garantie + ", nbPlaces=" + nbPlaces
				+ ", nbPortes=" + nbPortes + ", nbCylindres=" + nbCylindres + ", Energie=" + Energie
				+ ", Puisssance_fiscale=" + Puisssance_fiscale + ", boite=" + boite + ", longueur=" + longueur
				+ ", largueur=" + largueur + ", Hauteur=" + Hauteur + "]";
	}


	public Marque getMarque() {
		return marque;
	}


	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	

	
}
