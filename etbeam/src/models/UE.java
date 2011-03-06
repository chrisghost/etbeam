	package models;

	import java.awt.List;
	import java.util.Collection;
	import java.util.Iterator;

	public class UE {

		/*
		 * (non-javadoc)
		 */
		private int nbECTS;

		/*
		 * (non-javadoc)
		 */
		private String codeUE;

		/*
		 * (non-javadoc)
		 */
		private String libelle;

		/*
		 * (non-javadoc)
		 */
<<<<<<< .mine
		private Facade fa�ade;
=======
		private Fa�ade fa�ade;
>>>>>>> .r6

		/**
 *
 */
		private Collection<ECUE> eCUE = null;

		/*
		 * (non-javadoc)
		 */
		private Semestre semestre = null;

		/**
 *
 */
		private Collection<Etudiant> etudiant;

		/**
 *
 */
		private Collection<User> user;

		/**
		 * Getter of the property <tt>user</tt>
		 * 
		 * @return Returns the user.
		 * 
		 */

		public Collection<User> getUser() {
			return user;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<User> userIterator() {
			return user.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isUserEmpty() {
			return user.isEmpty();
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
		public boolean containsUser(User user) {
			return this.user.contains(user);
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
		public boolean containsAllUser(Collection<User> user) {
			return this.user.containsAll(user);
		}

		/**
		 * Returns the number of elements in this collection.
		 * 
		 * @return the number of elements in this collection
		 * @see java.util.Collection#size()
		 * 
		 */
		public int userSize() {
			return user.size();
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		public User[] userToArray() {
			return user.toArray(new User[user.size()]);
		}

		/**
		 * Setter of the property <tt>user</tt>
		 * 
		 * @param user
		 *            the user to set.
		 * 
		 */
		public void setUser(Collection<User> user) {
			this.user = user;
		}

		/**
		 * Ensures that this collection contains the specified element (optional
		 * operation).
		 * 
		 * @param element
		 *            whose presence in this collection is to be ensured.
		 * @see java.util.Collection#add(Object)
		 * 
		 */
		public boolean addUser(User user) {
			return this.user.add(user);
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
		public boolean removeUser(User user) {
			return this.user.remove(user);
		}

		/**
		 * Removes all of the elements from this collection (optional
		 * operation).
		 * 
		 * @see java.util.Collection#clear()
		 * 
		 */
		public void clearUser() {
			this.user.clear();
		}

		/**
		 * Getter of the property <tt>fa�ade</tt>
		 * 
		 * @return Returns the fa�ade.
		 * 
		 */

<<<<<<< .mine
		public Facade getFa�ade() {
			return fa�ade;
=======
		public Fa�ade getFa�ade() {
			return fa�ade;
>>>>>>> .r6
		}

		/**
		 * Setter of the property <tt>fa�ade</tt>
		 * 
		 * @param fa�ade
		 *            The fa�ade to set.
		 * 
		 */
<<<<<<< .mine
		public void setFa�ade(Facade fa�ade) {
			this.fa�ade = fa�ade;
=======
		public void setFa�ade(Fa�ade fa�ade) {
			this.fa�ade = fa�ade;
>>>>>>> .r6
		}

		public boolean getValidation(Etudiant etudiant) {

			return false;

		}

		public float getMoyenne(Etudiant etudiant) {

			return 0;

		}

		/**
		 * Getter of the property <tt>nbECTS</tt>
		 * 
		 * @return Returns the nbECTS.
		 * 
		 */

		public int getNbECTS() {
			return nbECTS;
		}

		/**
		 * Setter of the property <tt>nbECTS</tt>
		 * 
		 * @param nbECTS
		 *            The nbECTS to set.
		 * 
		 */
		public void setNbECTS(int nbECTS) {
			this.nbECTS = nbECTS;
		}

		/**
		 * Getter of the property <tt>codeUE</tt>
		 * 
		 * @return Returns the codeUE.
		 * 
		 */

		public String getCodeUE() {
			return codeUE;
		}

		/**
		 * Setter of the property <tt>codeUE</tt>
		 * 
		 * @param codeUE
		 *            The codeUE to set.
		 * 
		 */
		public void setCodeUE(String codeUE) {
			this.codeUE = codeUE;
		}

		/**
		 * Getter of the property <tt>libelle</tt>
		 * 
		 * @return Returns the libelle.
		 * 
		 */

		public String getLibelle() {
			return libelle;
		}

		/**
		 * Setter of the property <tt>libelle</tt>
		 * 
		 * @param libelle
		 *            The libelle to set.
		 * 
		 */
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		/**
		 * Getter of the property <tt>eCUE</tt>
		 * 
		 * @return Returns the eCUE.
		 * 
		 */

		public Collection<ECUE> getECUE() {
			return eCUE;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<ECUE> eCUEIterator() {
			return eCUE.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isECUEEmpty() {
			return eCUE.isEmpty();
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
		public boolean containsECUE(ECUE eCUE) {
			return this.eCUE.contains(eCUE);
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
		public boolean containsAllECUE(Collection<ECUE> eCUE) {
			return this.eCUE.containsAll(eCUE);
		}

		/**
		 * Returns the number of elements in this collection.
		 * 
		 * @return the number of elements in this collection
		 * @see java.util.Collection#size()
		 * 
		 */
		public int eCUESize() {
			return eCUE.size();
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		public ECUE[] eCUEToArray() {
			return eCUE.toArray(new ECUE[eCUE.size()]);
		}

		/**
		 * Setter of the property <tt>eCUE</tt>
		 * 
		 * @param eCUE
		 *            the eCUE to set.
		 * 
		 */
		public void setECUE(Collection<ECUE> eCUE) {
			this.eCUE = eCUE;
		}

		/**
		 * Ensures that this collection contains the specified element (optional
		 * operation).
		 * 
		 * @param element
		 *            whose presence in this collection is to be ensured.
		 * @see java.util.Collection#add(Object)
		 * 
		 */
		public boolean addECUE(ECUE eCUE) {
			return this.eCUE.add(eCUE);
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
		public boolean removeECUE(ECUE eCUE) {
			return this.eCUE.remove(eCUE);
		}

		/**
		 * Removes all of the elements from this collection (optional
		 * operation).
		 * 
		 * @see java.util.Collection#clear()
		 * 
		 */
		public void clearECUE() {
			this.eCUE.clear();
		}

		/**
		 * Getter of the property <tt>semestre</tt>
		 * 
		 * @return Returns the semestre.
		 * 
		 */

		public Semestre getSemestre() {
			return semestre;
		}

		/**
		 * Setter of the property <tt>semestre</tt>
		 * 
		 * @param semestre
		 *            The semestre to set.
		 * 
		 */
		public void setSemestre(Semestre semestre) {
			this.semestre = semestre;
		}

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
		 * Returns <tt>true</tt> if this collection contains all of the elements
		 * in the specified collection.
		 * 
		 * @param elements
		 *            collection to be checked for containment in this
		 *            collection.
		 * @see java.util.Collection#containsAll(Collection)
		 * 
		 */
		public boolean containsAllEtudiant(Collection<Etudiant> etudiant) {
			return this.etudiant.containsAll(etudiant);
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
		 * Ensures that this collection contains the specified element (optional
		 * operation).
		 * 
		 * @param element
		 *            whose presence in this collection is to be ensured.
		 * @see java.util.Collection#add(Object)
		 * 
		 */
		public boolean addEtudiant(Etudiant etudiant) {
			return this.etudiant.add(etudiant);
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
		 * Removes all of the elements from this collection (optional
		 * operation).
		 * 
		 * @see java.util.Collection#clear()
		 * 
		 */
		public void clearEtudiant() {
			this.etudiant.clear();
		}

	}

	// /**
	// * Getter of the property <tt>fa�ade</tt>
	// *
	// * @return Returns the fa�ade.
	// *
	// */
	//
	// public Fa�ade getFa�ade() {
	// return fa�ade;
	// }
	// /**
	// * Setter of the property <tt>fa�ade</tt>
	// *
	// * @param fa�ade
	// * The fa�ade to set.
	// *
	// */
	// public void setFa�ade(Fa�ade fa�ade) {
	// this.fa�ade = fa�ade;
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
	// * Getter of the property <tt>user</tt>
	// *
	// * @return Returns the user.
	// *
	// */
	//
	// public User getUser() {
	// return user;
	// }
	// /**
	// * Setter of the property <tt>user</tt>
	// *
	// * @param user
	// * The user to set.
	// *
	// */
	// public void setUser(User user) {
	// this.user = user;
	// }
///**
//		 * Removes a single instance of the specified element from this
//		 * collection, if it is present (optional operation).
//		 * 
//		 * @param element
//		 *            to be removed from this collection, if present.
//		 * @see java.util.Collection#add(Object)
//		 * 
//		 */
//		public boolean removeFa�ade1(Fa�ade fa�ade1) {
//			return this.fa�ade1.remove(fa�ade1);
//		}
///**
//		 * Returns <tt>true</tt> if this collection contains the specified
//		 * element.
//		 * 
//		 * @param element
//		 *            whose presence in this collection is to be tested.
//		 * @see java.util.Collection#contains(Object)
//		 * 
//		 */
//		public boolean containsFa�ade1(Fa�ade fa�ade1) {
//			return this.fa�ade1.contains(fa�ade1);
//		}
///**
//		 * Returns <tt>true</tt> if this collection contains all of the elements
//		 * in the specified collection.
//		 * 
//		 * @param elements
//		 *            collection to be checked for containment in this
//		 *            collection.
//		 * @see java.util.Collection#containsAll(Collection)
//		 * 
//		 */
//		public boolean containsAllFa�ade1(Collection<Fa�ade> fa�ade1) {
//			return this.fa�ade1.containsAll(fa�ade1);
//		}
///**
//		 * Getter of the property <tt>fa�ade1</tt>
//		 * 
//		 * @return Returns the fa�ade1.
//		 * 
//		 */
//
//		public Collection<Fa�ade> getFa�ade1() {
//			return fa�ade1;
//		}
///**
//		 * Returns all elements of this collection in an array.
//		 * 
//		 * @return an array containing all of the elements in this collection
//		 * @see java.util.Collection#toArray()
//		 * 
//		 */
//		public Fa�ade[] fa�ade1ToArray() {
//			return fa�ade1.toArray(new Fa�ade[fa�ade1.size()]);
//		}
///**
//		 * Ensures that this collection contains the specified element (optional
//		 * operation).
//		 * 
//		 * @param element
//		 *            whose presence in this collection is to be ensured.
//		 * @see java.util.Collection#add(Object)
//		 * 
//		 */
//		public boolean addFa�ade1(Fa�ade fa�ade1) {
//			return this.fa�ade1.add(fa�ade1);
//		}
///**
//		 * Setter of the property <tt>fa�ade1</tt>
//		 * 
//		 * @param fa�ade1
//		 *            the fa�ade1 to set.
//		 * 
//		 */
//		public void setFa�ade1(Collection<Fa�ade> fa�ade1) {
//			this.fa�ade1 = fa�ade1;
//		}
///**
//		 * Returns an iterator over the elements in this collection.
//		 * 
//		 * @return an <tt>Iterator</tt> over the elements in this collection
//		 * @see java.util.Collection#iterator()
//		 * 
//		 */
//		public Iterator<Fa�ade> fa�ade1Iterator() {
//			return fa�ade1.iterator();
//		}
///**
//		 * Removes all of the elements from this collection (optional
//		 * operation).
//		 * 
//		 * @see java.util.Collection#clear()
//		 * 
//		 */
//		public void clearFa�ade1() {
//			this.fa�ade1.clear();
//		}
///**
//		 * Returns the number of elements in this collection.
//		 * 
//		 * @return the number of elements in this collection
//		 * @see java.util.Collection#size()
//		 * 
//		 */
//		public int fa�ade1Size() {
//			return fa�ade1.size();
//		}
///**
//		 * Returns <tt>true</tt> if this collection contains no elements.
//		 * 
//		 * @return <tt>true</tt> if this collection contains no elements
//		 * @see java.util.Collection#isEmpty()
//		 * 
//		 */
//		public boolean isFa�ade1Empty() {
//			return fa�ade1.isEmpty();
//		}