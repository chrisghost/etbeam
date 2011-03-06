	package gestionUE;

	import java.util.Collection;
	import java.util.Iterator;

	public class Note {

		/**
 *
 */
		private Collection<Etudiant> etudiant;

		/**
 *
 */
		private Collection<ECUE> eCUE;

		/*
		 * (non-javadoc)
		 */
		private float session1;

		/*
		 * (non-javadoc)
		 */
		private float session2;

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

		/**
		 * Getter of the property <tt>session1</tt>
		 * 
		 * @return Returns the session1.
		 * 
		 */

		public float getSession1() {
			return session1;
		}

		/**
		 * Setter of the property <tt>session1</tt>
		 * 
		 * @param session1
		 *            The session1 to set.
		 * 
		 */
		public void setSession1(float session1) {
			this.session1 = session1;
		}

		/**
		 * Getter of the property <tt>session2</tt>
		 * 
		 * @return Returns the session2.
		 * 
		 */

		public float getSession2() {
			return session2;
		}

		/**
		 * Setter of the property <tt>session2</tt>
		 * 
		 * @param session2
		 *            The session2 to set.
		 * 
		 */
		public void setSession2(float session2) {
			this.session2 = session2;
		}

	}

	// /**
	// * Returns <tt>true</tt> if this collection contains the specified
	// * element.
	// *
	// * @param element
	// * whose presence in this collection is to be tested.
	// * @see java.util.Collection#contains(Object)
	// *
	// */
	// public boolean containsECUE(ECUE eCUE) {
	// return this.eCUE.contains(eCUE);
	// }
	// /**
	// * Setter of the property <tt>eCUE</tt>
	// *
	// * @param eCUE
	// * the eCUE to set.
	// *
	// */
	// public void setECUE(Collection<ECUE> eCUE) {
	// this.eCUE = eCUE;
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
	// public boolean containsAllECUE(Collection<ECUE> eCUE) {
	// return this.eCUE.containsAll(eCUE);
	// }
	// /**
	// * Getter of the property <tt>eCUE</tt>
	// *
	// * @return Returns the eCUE.
	// *
	// */
	//
	// public Collection<ECUE> getECUE() {
	// return eCUE;
	// }
	// /**
	// * Returns an iterator over the elements in this collection.
	// *
	// * @return an <tt>Iterator</tt> over the elements in this collection
	// * @see java.util.Collection#iterator()
	// *
	// */
	// public Iterator<ECUE> eCUEIterator() {
	// return eCUE.iterator();
	// }
	// /**
	// * Returns <tt>true</tt> if this collection contains no elements.
	// *
	// * @return <tt>true</tt> if this collection contains no elements
	// * @see java.util.Collection#isEmpty()
	// *
	// */
	// public boolean isECUEEmpty() {
	// return eCUE.isEmpty();
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
	// public boolean removeECUE(ECUE eCUE) {
	// return this.eCUE.remove(eCUE);
	// }
	// /**
	// * Returns the number of elements in this collection.
	// *
	// * @return the number of elements in this collection
	// * @see java.util.Collection#size()
	// *
	// */
	// public int eCUESize() {
	// return eCUE.size();
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
	// public boolean addECUE(ECUE eCUE) {
	// return this.eCUE.add(eCUE);
	// }
	// /**
	// * Returns all elements of this collection in an array.
	// *
	// * @return an array containing all of the elements in this collection
	// * @see java.util.Collection#toArray()
	// *
	// */
	// public ECUE[] eCUEToArray() {
	// return eCUE.toArray(new ECUE[eCUE.size()]);
	// }
	// /**
	// * Removes all of the elements from this collection (optional
	// * operation).
	// *
	// * @see java.util.Collection#clear()
	// *
	// */
	// public void clearECUE() {
	// this.eCUE.clear();
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
	// public boolean containsECUE(ECUE eCUE) {
	// return this.eCUE.contains(eCUE);
	// }
	// /**
	// * Setter of the property <tt>eCUE</tt>
	// *
	// * @param eCUE
	// * the eCUE to set.
	// *
	// */
	// public void setECUE(Collection<ECUE> eCUE) {
	// this.eCUE = eCUE;
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
	// public boolean containsAllECUE(Collection<ECUE> eCUE) {
	// return this.eCUE.containsAll(eCUE);
	// }
	// /**
	// * Getter of the property <tt>eCUE</tt>
	// *
	// * @return Returns the eCUE.
	// *
	// */
	//
	// public Collection<ECUE> getECUE() {
	// return eCUE;
	// }
	// /**
	// * Returns an iterator over the elements in this collection.
	// *
	// * @return an <tt>Iterator</tt> over the elements in this collection
	// * @see java.util.Collection#iterator()
	// *
	// */
	// public Iterator<ECUE> eCUEIterator() {
	// return eCUE.iterator();
	// }
	// /**
	// * Returns <tt>true</tt> if this collection contains no elements.
	// *
	// * @return <tt>true</tt> if this collection contains no elements
	// * @see java.util.Collection#isEmpty()
	// *
	// */
	// public boolean isECUEEmpty() {
	// return eCUE.isEmpty();
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
	// public boolean removeECUE(ECUE eCUE) {
	// return this.eCUE.remove(eCUE);
	// }
	// /**
	// * Returns the number of elements in this collection.
	// *
	// * @return the number of elements in this collection
	// * @see java.util.Collection#size()
	// *
	// */
	// public int eCUESize() {
	// return eCUE.size();
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
	// public boolean addECUE(ECUE eCUE) {
	// return this.eCUE.add(eCUE);
	// }
	// /**
	// * Returns all elements of this collection in an array.
	// *
	// * @return an array containing all of the elements in this collection
	// * @see java.util.Collection#toArray()
	// *
	// */
	// public ECUE[] eCUEToArray() {
	// return eCUE.toArray(new ECUE[eCUE.size()]);
	// }
	// /**
	// * Removes all of the elements from this collection (optional
	// * operation).
	// *
	// * @see java.util.Collection#clear()
	// *
	// */
	// public void clearECUE() {
	// this.eCUE.clear();
	// }