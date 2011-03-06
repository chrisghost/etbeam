	package gestionUE;

	import java.util.Collection;
	import java.util.Iterator;

	public class Façade {

		/**
 *
 */
		private Collection<UE> uE;

		/**
 *
 */
		private Collection<Etudiant> etudiant;

		/*
		 * (non-javadoc)
		 */
		private Etudiant etudiant1;

		/**
 *
 */
		private Collection<Annee> annee;

		/**
 *
 */
		private Collection<Semestre> semestre;

		/**
		 * Getter of the property <tt>etudiant</tt>
		 * 
		 * @return Returns the etudiant.
		 * 
		 */

		public Collection<Etudiant> getEtudiant() {
			return etudiant;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<Etudiant> etudiantIterator() {
			return etudiant.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isEtudiantEmpty() {
			return etudiant.isEmpty();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains the specified
		 * element.
		 * 
		 * @param element
		 *            whose presence in this collection is to be tested.
		 * @see java.util.Collection#contains(Object)
		 * 
		 */
		public boolean containsEtudiant(Etudiant etudiant) {
			return this.etudiant.contains(etudiant);
		}

		/**
		 * Returns the number of elements in this collection.
		 * 
		 * @return the number of elements in this collection
		 * @see java.util.Collection#size()
		 * 
		 */
		public int etudiantSize() {
			return etudiant.size();
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		public Etudiant[] etudiantToArray() {
			return etudiant.toArray(new Etudiant[etudiant.size()]);
		}

		/**
		 * Setter of the property <tt>etudiant</tt>
		 * 
		 * @param etudiant
		 *            the etudiant to set.
		 * 
		 */
		public void setEtudiant(Collection<Etudiant> etudiant) {
			this.etudiant = etudiant;
		}

		/**
		 * Removes a single instance of the specified element from this
		 * collection, if it is present (optional operation).
		 * 
		 * @param element
		 *            to be removed from this collection, if present.
		 * @see java.util.Collection#add(Object)
		 * 
		 */
		public boolean removeEtudiant(Etudiant etudiant) {
			return this.etudiant.remove(etudiant);
		}

		/**
		 * Getter of the property <tt>uE</tt>
		 * 
		 * @return Returns the uE.
		 * 
		 */

		public Collection<UE> getUE() {
			return uE;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<UE> uEIterator() {
			return uE.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isUEEmpty() {
			return uE.isEmpty();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains the specified
		 * element.
		 * 
		 * @param element
		 *            whose presence in this collection is to be tested.
		 * @see java.util.Collection#contains(Object)
		 * 
		 */
		public boolean containsUE(UE uE) {
			return this.uE.contains(uE);
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		public UE[] uEToArray() {
			return uE.toArray(new UE[uE.size()]);
		}

		/**
		 * Setter of the property <tt>uE</tt>
		 * 
		 * @param uE
		 *            the uE to set.
		 * 
		 */
		public void setUE(Collection<UE> uE) {
			this.uE = uE;
		}

		/**
		 * Getter of the property <tt>etudiant1</tt>
		 * 
		 * @return Returns the etudiant1.
		 * 
		 */

		public Etudiant getEtudiant1() {
			return etudiant1;
		}

		/**
		 * Getter of the property <tt>annee</tt>
		 * 
		 * @return Returns the annee.
		 * 
		 */

		public Collection<Annee> getAnnee() {
			return annee;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<Annee> anneeIterator() {
			return annee.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isAnneeEmpty() {
			return annee.isEmpty();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains the specified
		 * element.
		 * 
		 * @param element
		 *            whose presence in this collection is to be tested.
		 * @see java.util.Collection#contains(Object)
		 * 
		 */
		public boolean containsAnnee(Annee annee) {
			return this.annee.contains(annee);
		}

		/**
		 * Returns <tt>true</tt> if this collection contains all of the elements
		 * in the specified collection.
		 * 
		 * @param elements
		 *            collection to be checked for containment in this
		 *            collection.
		 * @see java.util.Collection#containsAll(Collection)
		 * 
		 */
		public boolean containsAllAnnee(Collection<Annee> annee) {
			return this.annee.containsAll(annee);
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		public Annee[] anneeToArray() {
			return annee.toArray(new Annee[annee.size()]);
		}

		/**
		 * Getter of the property <tt>semestre</tt>
		 * 
		 * @return Returns the semestre.
		 * 
		 */

		public Collection<Semestre> getSemestre() {
			return semestre;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<Semestre> semestreIterator() {
			return semestre.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isSemestreEmpty() {
			return semestre.isEmpty();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains the specified
		 * element.
		 * 
		 * @param element
		 *            whose presence in this collection is to be tested.
		 * @see java.util.Collection#contains(Object)
		 * 
		 */
		public boolean containsSemestre(Semestre semestre) {
			return this.semestre.contains(semestre);
		}

		/**
		 * Returns <tt>true</tt> if this collection contains all of the elements
		 * in the specified collection.
		 * 
		 * @param elements
		 *            collection to be checked for containment in this
		 *            collection.
		 * @see java.util.Collection#containsAll(Collection)
		 * 
		 */
		public boolean containsAllSemestre(Collection<Semestre> semestre) {
			return this.semestre.containsAll(semestre);
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		public Semestre[] semestreToArray() {
			return semestre.toArray(new Semestre[semestre.size()]);
		}

	}

	// /**
	// * Setter of the property <tt>uE</tt>
	// *
	// * @param uE
	// * The uE to set.
	// *
	// */
	// public void setUE(UE uE) {
	// this.uE = uE;
	// }
	// /**
	// * Getter of the property <tt>uE</tt>
	// *
	// * @return Returns the uE.
	// *
	// */
	//
	// public UE getUE() {
	// return uE;
	// }
	// /**
	// * Setter of the property <tt>etudiant</tt>
	// *
	// * @param etudiant
	// * The etudiant to set.
	// *
	// */
	// public void setEtudiant(Etudiant etudiant) {
	// this.etudiant = etudiant;
	// }
	// /**
	// * Getter of the property <tt>etudiant</tt>
	// *
	// * @return Returns the etudiant.
	// *
	// */
	//
	// public Etudiant getEtudiant() {
	// return etudiant;
	// }
	// /**
	// * Setter of the property <tt>uE1</tt>
	// *
	// * @param uE1
	// * The uE1 to set.
	// *
	// */
	// public void setUE1(UE uE1) {
	// this.uE1 = uE1;
	// }
	// /**
	// * Getter of the property <tt>uE1</tt>
	// *
	// * @return Returns the uE1.
	// *
	// */
	//
	// public UE getUE1() {
	// return uE1;
	// }