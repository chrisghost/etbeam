	package gestionUE;

	import java.util.Collection;
	import java.util.Iterator;

	public class ECUE {

		/*
		 * (non-javadoc)
		 */
		private String libelle;

		/*
		 * (non-javadoc)
		 */
		private UE uE = null;

		/**
 *
 */
		private Collection<Note> note;

		/**
 *
 */
		private Collection<Etudiant> etudiant2;

		/*
		 * (non-javadoc)
		 */
		private User user = null;

		/**
		 * Getter of the property <tt>user</tt>
		 * 
		 * @return Returns the user.
		 * 
		 */

		public User getUser() {
			return user;
		}

		/**
		 * Setter of the property <tt>user</tt>
		 * 
		 * @param user
		 *            The user to set.
		 * 
		 */
		public void setUser(User user) {
			this.user = user;
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

		public int semestre() {

			return 0;

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
		 * Getter of the property <tt>uE</tt>
		 * 
		 * @return Returns the uE.
		 * 
		 */

		public UE getUE() {
			return uE;
		}

		/**
		 * Setter of the property <tt>uE</tt>
		 * 
		 * @param uE
		 *            The uE to set.
		 * 
		 */
		public void setUE(UE uE) {
			this.uE = uE;
		}

		/**
		 * Getter of the property <tt>etudiant2</tt>
		 * 
		 * @return Returns the etudiant2.
		 * 
		 */

		public Collection<Etudiant> getEtudiant2() {
			return etudiant2;
		}

		/**
		 * Returns an iterator over the elements in this collection.
		 * 
		 * @return an <tt>Iterator</tt> over the elements in this collection
		 * @see java.util.Collection#iterator()
		 * 
		 */
		public Iterator<Etudiant> etudiant2Iterator() {
			return etudiant2.iterator();
		}

		/**
		 * Returns <tt>true</tt> if this collection contains no elements.
		 * 
		 * @return <tt>true</tt> if this collection contains no elements
		 * @see java.util.Collection#isEmpty()
		 * 
		 */
		public boolean isEtudiant2Empty() {
			return etudiant2.isEmpty();
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
		public boolean containsEtudiant2(Etudiant etudiant2) {
			return this.etudiant2.contains(etudiant2);
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
		public boolean containsAllEtudiant2(Collection<Etudiant> etudiant2) {
			return this.etudiant2.containsAll(etudiant2);
		}

		/**
		 * Returns the number of elements in this collection.
		 * 
		 * @return the number of elements in this collection
		 * @see java.util.Collection#size()
		 * 
		 */
		public int etudiant2Size() {
			return etudiant2.size();
		}

		/**
		 * Returns all elements of this collection in an array.
		 * 
		 * @return an array containing all of the elements in this collection
		 * @see java.util.Collection#toArray()
		 * 
		 */
		public Etudiant[] etudiant2ToArray() {
			return etudiant2.toArray(new Etudiant[etudiant2.size()]);
		}

		/**
		 * Setter of the property <tt>etudiant2</tt>
		 * 
		 * @param etudiant2
		 *            the etudiant2 to set.
		 * 
		 */
		public void setEtudiant2(Collection<Etudiant> etudiant2) {
			this.etudiant2 = etudiant2;
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
		public boolean addEtudiant2(Etudiant etudiant2) {
			return this.etudiant2.add(etudiant2);
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
		public boolean removeEtudiant2(Etudiant etudiant2) {
			return this.etudiant2.remove(etudiant2);
		}

		/**
		 * Removes all of the elements from this collection (optional
		 * operation).
		 * 
		 * @see java.util.Collection#clear()
		 * 
		 */
		public void clearEtudiant2() {
			this.etudiant2.clear();
		}

	}

	// /**
	// * Setter of the property <tt>note</tt>
	// *
	// * @param note
	// * the note to set.
	// *
	// */
	// public void setNote(Collection<Note> note) {
	// this.note = note;
	// }
	// /**
	// * Returns an iterator over the elements in this collection.
	// *
	// * @return an <tt>Iterator</tt> over the elements in this collection
	// * @see java.util.Collection#iterator()
	// *
	// */
	// public Iterator<Note> noteIterator() {
	// return note.iterator();
	// }
	// /**
	// * Getter of the property <tt>note</tt>
	// *
	// * @return Returns the note.
	// *
	// */
	//
	// public Collection<Note> getNote() {
	// return note;
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
	// public boolean addNote(Note note) {
	// return this.note.add(note);
	// }
	// /**
	// * Returns all elements of this collection in an array.
	// *
	// * @return an array containing all of the elements in this collection
	// * @see java.util.Collection#toArray()
	// *
	// */
	// public Note[] noteToArray() {
	// return note.toArray(new Note[note.size()]);
	// }
	// /**
	// * Removes all of the elements from this collection (optional
	// * operation).
	// *
	// * @see java.util.Collection#clear()
	// *
	// */
	// public void clearNote() {
	// this.note.clear();
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
	// public boolean removeNote(Note note) {
	// return this.note.remove(note);
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
	// public boolean containsNote(Note note) {
	// return this.note.contains(note);
	// }
	// /**
	// * Returns the number of elements in this collection.
	// *
	// * @return the number of elements in this collection
	// * @see java.util.Collection#size()
	// *
	// */
	// public int noteSize() {
	// return note.size();
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
	// public boolean containsAllNote(Collection<Note> note) {
	// return this.note.containsAll(note);
	// }
	// /**
	// * Returns <tt>true</tt> if this collection contains no elements.
	// *
	// * @return <tt>true</tt> if this collection contains no elements
	// * @see java.util.Collection#isEmpty()
	// *
	// */
	// public boolean isNoteEmpty() {
	// return note.isEmpty();
	// }
	// /**
	// * Setter of the property <tt>note</tt>
	// *
	// * @param note
	// * the note to set.
	// *
	// */
	// public void setNote(Collection<Note> note) {
	// this.note = note;
	// }
	// /**
	// * Returns an iterator over the elements in this collection.
	// *
	// * @return an <tt>Iterator</tt> over the elements in this collection
	// * @see java.util.Collection#iterator()
	// *
	// */
	// public Iterator<Note> noteIterator() {
	// return note.iterator();
	// }
	// /**
	// * Getter of the property <tt>note</tt>
	// *
	// * @return Returns the note.
	// *
	// */
	//
	// public Collection<Note> getNote() {
	// return note;
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
	// public boolean addNote(Note note) {
	// return this.note.add(note);
	// }
	// /**
	// * Returns all elements of this collection in an array.
	// *
	// * @return an array containing all of the elements in this collection
	// * @see java.util.Collection#toArray()
	// *
	// */
	// public Note[] noteToArray() {
	// return note.toArray(new Note[note.size()]);
	// }
	// /**
	// * Removes all of the elements from this collection (optional
	// * operation).
	// *
	// * @see java.util.Collection#clear()
	// *
	// */
	// public void clearNote() {
	// this.note.clear();
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
	// public boolean removeNote(Note note) {
	// return this.note.remove(note);
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
	// public boolean containsNote(Note note) {
	// return this.note.contains(note);
	// }
	// /**
	// * Returns the number of elements in this collection.
	// *
	// * @return the number of elements in this collection
	// * @see java.util.Collection#size()
	// *
	// */
	// public int noteSize() {
	// return note.size();
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
	// public boolean containsAllNote(Collection<Note> note) {
	// return this.note.containsAll(note);
	// }
	// /**
	// * Returns <tt>true</tt> if this collection contains no elements.
	// *
	// * @return <tt>true</tt> if this collection contains no elements
	// * @see java.util.Collection#isEmpty()
	// *
	// */
	// public boolean isNoteEmpty() {
	// return note.isEmpty();
	// }
///**
//		 * Setter of the property <tt>user</tt>
//		 * 
//		 * @param user
//		 *            The user to set.
//		 * 
//		 */
//		public void setUser(User user) {
//			this.user = user;
//		}
///**
//		 * Getter of the property <tt>user</tt>
//		 * 
//		 * @return Returns the user.
//		 * 
//		 */
//
//		public User getUser() {
//			return user;
//		}