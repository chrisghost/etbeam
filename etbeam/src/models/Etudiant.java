	package models;

	import java.util.Collection;
	import java.util.Iterator;

	public class Etudiant {

		public Etudiant(String nom, String prenom, String numEtud) {
			super();
			Nom = nom;
			Prenom = prenom;
			this.numEtud = numEtud;
		}

		/*
		 * (non-javadoc)
		 */
		private String Nom;

		/*
		 * (non-javadoc)
		 */
		private String Prenom;

		/*
		 * (non-javadoc)
		 */
		private String numEtud;

		/**
 *
 */
		private Collection<Note> note;

		/**
 *
 */
		private Collection<ECUE> eCUE;

		/**
 *
 */
		private Collection<UE> uE;

		/**
 *
 */
		private Collection<ECUE> eCUE2;

		/*
		 * (non-javadoc)
		 */
		private Fa�ade fa�ade1;

		/**
 *
 */
		private Collection<ECUE> eCUE1;

		/**
		 * Getter of the property <tt>Nom</tt>
		 * 
		 * @return Returns the Nom.
		 * 
		 */

		public String getNom() {
			return Nom;
		}

		/**
		 * Setter of the property <tt>Nom</tt>
		 * 
		 * @param Nom
		 *            The Nom to set.
		 * 
		 */
		public void setNom(String Nom) {
			this.Nom = Nom;
		}

		/**
		 * Getter of the property <tt>Prenom</tt>
		 * 
		 * @return Returns the Prenom.
		 * 
		 */

		public String getPrenom() {
			return Prenom;
		}

		/**
		 * Setter of the property <tt>Prenom</tt>
		 * 
		 * @param Prenom
		 *            The Prenom to set.
		 * 
		 */
		public void setPrenom(String Prenom) {
			this.Prenom = Prenom;
		}

		/**
		 * Getter of the property <tt>numEtud</tt>
		 * 
		 * @return Returns the numEtud.
		 * 
		 */

		public String getNumEtud() {
			return numEtud;
		}

		/**
		 * Setter of the property <tt>numEtud</tt>
		 * 
		 * @param numEtud
		 *            The numEtud to set.
		 * 
		 */
		public void setNumEtud(String numEtud) {
			this.numEtud = numEtud;
		}

		/**
		 * Getter of the property <tt>note</tt>
		 * 
		 * @return Returns the note.
		 * 
		 */

		public Collection<Note> getNote() {
			return note;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<Note> noteIterator() {
			return note.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isNoteEmpty() {
			return note.isEmpty();
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
		public boolean containsNote(Note note) {
			return this.note.contains(note);
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
		public boolean containsAllNote(Collection<Note> note) {
			return this.note.containsAll(note);
		}

		/**
		 * Returns the number of elements in this collection.
		 * 
		 * @return the number of elements in this collection
		 * @see java.util.Collection#size()
		 * 
		 */
		public int noteSize() {
			return note.size();
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		public Note[] noteToArray() {
			return note.toArray(new Note[note.size()]);
		}

		/**
		 * Setter of the property <tt>note</tt>
		 * 
		 * @param note
		 *            the note to set.
		 * 
		 */
		public void setNote(Collection<Note> note) {
			this.note = note;
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
		public boolean addNote(Note note) {
			return this.note.add(note);
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
		public boolean removeNote(Note note) {
			return this.note.remove(note);
		}

		/**
		 * Removes all of the elements from this collection (optional
		 * operation).
		 * 
		 * @see java.util.Collection#clear()
		 * 
		 */
		public void clearNote() {
			this.note.clear();
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
		 * Getter of the property <tt>eCUE1</tt>
		 * 
		 * @return Returns the eCUE1.
		 * 
		 */

		public Collection<ECUE> getECUE1() {
			return eCUE1;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<ECUE> eCUE1Iterator() {
			return eCUE1.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isECUE1Empty() {
			return eCUE1.isEmpty();
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
		public boolean containsECUE1(ECUE eCUE1) {
			return this.eCUE1.contains(eCUE1);
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
		public boolean containsAllECUE1(Collection<ECUE> eCUE1) {
			return this.eCUE1.containsAll(eCUE1);
		}

		/**
		 * Returns the number of elements in this collection.
		 * 
		 * @return the number of elements in this collection
		 * @see java.util.Collection#size()
		 * 
		 */
		public int eCUE1Size() {
			return eCUE1.size();
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		public ECUE[] eCUE1ToArray() {
			return eCUE1.toArray(new ECUE[eCUE1.size()]);
		}

		/**
		 * Setter of the property <tt>eCUE1</tt>
		 * 
		 * @param eCUE1
		 *            the eCUE1 to set.
		 * 
		 */
		public void setECUE1(Collection<ECUE> eCUE1) {
			this.eCUE1 = eCUE1;
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
		public boolean addECUE1(ECUE eCUE1) {
			return this.eCUE1.add(eCUE1);
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
		public boolean removeECUE1(ECUE eCUE1) {
			return this.eCUE1.remove(eCUE1);
		}

		/**
		 * Removes all of the elements from this collection (optional
		 * operation).
		 * 
		 * @see java.util.Collection#clear()
		 * 
		 */
		public void clearECUE1() {
			this.eCUE1.clear();
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
		 * Returns <tt>true</tt> if this collection contains all of the elements
		 * in the specified collection.
		 * 
		 * @param elements
		 *            collection to be checked for containment in this
		 *            collection.
		 * @see java.util.Collection#containsAll(Collection)
		 * 
		 */
		public boolean containsAllUE(Collection<UE> uE) {
			return this.uE.containsAll(uE);
		}

		/**
		 * Returns the number of elements in this collection.
		 * 
		 * @return the number of elements in this collection
		 * @see java.util.Collection#size()
		 * 
		 */
		public int uESize() {
			return uE.size();
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
		 * Ensures that this collection contains the specified element (optional
		 * operation).
		 * 
		 * @param element
		 *            whose presence in this collection is to be ensured.
		 * @see java.util.Collection#add(Object)
		 * 
		 */
		public boolean addUE(UE uE) {
			return this.uE.add(uE);
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
		public boolean removeUE(UE uE) {
			return this.uE.remove(uE);
		}

		/**
		 * Removes all of the elements from this collection (optional
		 * operation).
		 * 
		 * @see java.util.Collection#clear()
		 * 
		 */
		public void clearUE() {
			this.uE.clear();
		}

		/**
		 * Getter of the property <tt>eCUE2</tt>
		 * 
		 * @return Returns the eCUE2.
		 * 
		 */

		public Collection<ECUE> getECUE2() {
			return eCUE2;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<ECUE> eCUE2Iterator() {
			return eCUE2.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isECUE2Empty() {
			return eCUE2.isEmpty();
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
		public boolean containsECUE2(ECUE eCUE2) {
			return this.eCUE2.contains(eCUE2);
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
		public boolean containsAllECUE2(Collection<ECUE> eCUE2) {
			return this.eCUE2.containsAll(eCUE2);
		}

		/**
		 * Returns the number of elements in this collection.
		 * 
		 * @return the number of elements in this collection
		 * @see java.util.Collection#size()
		 * 
		 */
		public int eCUE2Size() {
			return eCUE2.size();
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		public ECUE[] eCUE2ToArray() {
			return eCUE2.toArray(new ECUE[eCUE2.size()]);
		}

		/**
		 * Setter of the property <tt>eCUE2</tt>
		 * 
		 * @param eCUE2
		 *            the eCUE2 to set.
		 * 
		 */
		public void setECUE2(Collection<ECUE> eCUE2) {
			this.eCUE2 = eCUE2;
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
		public boolean addECUE2(ECUE eCUE2) {
			return this.eCUE2.add(eCUE2);
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
		public boolean removeECUE2(ECUE eCUE2) {
			return this.eCUE2.remove(eCUE2);
		}

		/**
		 * Removes all of the elements from this collection (optional
		 * operation).
		 * 
		 * @see java.util.Collection#clear()
		 * 
		 */
		public void clearECUE2() {
			this.eCUE2.clear();
		}

		/**
		 * Getter of the property <tt>fa�ade1</tt>
		 * 
		 * @return Returns the fa�ade1.
		 * 
		 */

		public Fa�ade getFa�ade1() {
			return fa�ade1;
		}

		/**
		 * Setter of the property <tt>fa�ade1</tt>
		 * 
		 * @param fa�ade1
		 *            The fa�ade1 to set.
		 * 
		 */
		public void setFa�ade1(Fa�ade fa�ade1) {
			this.fa�ade1 = fa�ade1;
		}

	}

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
	// * Returns <tt>true</tt> if this collection contains all of the elements
	// * in the specified collection.
	// *
	// * @param elements
	// * collection to be checked for containment in this
	// * collection.
	// * @see java.util.Collection#containsAll(Collection)
	// *
	// */
	// public boolean containsAllUE(Collection<UE> uE) {
	// return this.uE.containsAll(uE);
	// }
	// /**
	// * Returns all elements of this collection in an array.
	// *
	// * @return an array containing all of the elements in this collection
	// * @see java.util.Collection#toArray()
	// *
	// */
	// public UE[] uEToArray() {
	// return uE.toArray(new UE[uE.size()]);
	// }
	// /**
	// * Returns <tt>true</tt> if this collection contains no elements.
	// *
	// * @return <tt>true</tt> if this collection contains no elements
	// * @see java.util.Collection#isEmpty()
	// *
	// */
	// public boolean isUEEmpty() {
	// return uE.isEmpty();
	// }
	// /**
	// * Returns <tt>true</tt> if this collection contains the specified
	// * element.
	// *
	// * @param element
	// * whose presence in this collection is to be tested.
	// * @see java.util.Collection#contains(Object)
	// *
	// */
	// public boolean containsUE(UE uE) {
	// return this.uE.contains(uE);
	// }
	// /**
	// * Returns the number of elements in this collection.
	// *
	// * @return the number of elements in this collection
	// * @see java.util.Collection#size()
	// *
	// */
	// public int uESize() {
	// return uE.size();
	// }
	// /**
	// * Getter of the property <tt>uE</tt>
	// *
	// * @return Returns the uE.
	// *
	// */
	//
	// public Collection<UE> getUE() {
	// return uE;
	// }
	// /**
	// * Ensures that this collection contains the specified element (optional
	// * operation).
	// *
	// * @param element
	// * whose presence in this collection is to be ensured.
	// * @see java.util.Collection#add(Object)
	// *
	// */
	// public boolean addUE(UE uE) {
	// return this.uE.add(uE);
	// }
	// /**
	// * Setter of the property <tt>uE</tt>
	// *
	// * @param uE
	// * the uE to set.
	// *
	// */
	// public void setUE(Collection<UE> uE) {
	// this.uE = uE;
	// }
	// /**
	// * Returns an iterator over the elements in this collection.
	// *
	// * @return an <tt>Iterator</tt> over the elements in this collection
	// * @see java.util.Collection#iterator()
	// *
	// */
	// public Iterator<UE> uEIterator() {
	// return uE.iterator();
	// }
	// /**
	// * Removes all of the elements from this collection (optional
	// * operation).
	// *
	// * @see java.util.Collection#clear()
	// *
	// */
	// public void clearUE() {
	// this.uE.clear();
	// }
	// /**
	// * Removes a single instance of the specified element from this
	// * collection, if it is present (optional operation).
	// *
	// * @param element
	// * to be removed from this collection, if present.
	// * @see java.util.Collection#add(Object)
	// *
	// */
	// public boolean removeUE(UE uE) {
	// return this.uE.remove(uE);
	// }