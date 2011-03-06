	package gestionUE;

	import java.util.Collection;
	import java.util.Iterator;

	public class Semestre {

		/*
		 * (non-javadoc)
		 */
		private String libelleSemestre;

		/*
		 * (non-javadoc)
		 */
		private String codeSemestre;

		/*
		 * (non-javadoc)
		 */
		private int nbUEfacultative;

		/*
		 * (non-javadoc)
		 */
		private Annee annee = null;

		/**
 *
 */
		private Collection<UE> uE = null;

		/*
		 * (non-javadoc)
		 */
		private Façade façade = null;

		/**
		 * Getter of the property <tt>libelleSemestre</tt>
		 * 
		 * @return Returns the libelleSemestre.
		 * 
		 */

		public String getLibelleSemestre() {
			return libelleSemestre;
		}

		/**
		 * Setter of the property <tt>libelleSemestre</tt>
		 * 
		 * @param libelleSemestre
		 *            The libelleSemestre to set.
		 * 
		 */
		public void setLibelleSemestre(String libelleSemestre) {
			this.libelleSemestre = libelleSemestre;
		}

		/**
		 * Getter of the property <tt>codeSemestre</tt>
		 * 
		 * @return Returns the codeSemestre.
		 * 
		 */

		public String getCodeSemestre() {
			return codeSemestre;
		}

		/**
		 * Setter of the property <tt>codeSemestre</tt>
		 * 
		 * @param codeSemestre
		 *            The codeSemestre to set.
		 * 
		 */
		public void setCodeSemestre(String codeSemestre) {
			this.codeSemestre = codeSemestre;
		}

		/**
		 * Getter of the property <tt>nbUEfacultative</tt>
		 * 
		 * @return Returns the nbUEfacultative.
		 * 
		 */

		public int getNbUEfacultative() {
			return nbUEfacultative;
		}

		/**
		 * Setter of the property <tt>nbUEfacultative</tt>
		 * 
		 * @param nbUEfacultative
		 *            The nbUEfacultative to set.
		 * 
		 */
		public void setNbUEfacultative(int nbUEfacultative) {
			this.nbUEfacultative = nbUEfacultative;
		}

		/**
		 * Getter of the property <tt>annee</tt>
		 * 
		 * @return Returns the annee.
		 * 
		 */

		public Annee getAnnee() {
			return annee;
		}

		/**
		 * Setter of the property <tt>annee</tt>
		 * 
		 * @param annee
		 *            The annee to set.
		 * 
		 */
		public void setAnnee(Annee annee) {
			this.annee = annee;
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
		 * Getter of the property <tt>façade</tt>
		 * 
		 * @return Returns the façade.
		 * 
		 */

		public Façade getFaçade() {
			return façade;
		}

		/**
		 * Setter of the property <tt>façade</tt>
		 * 
		 * @param façade
		 *            The façade to set.
		 * 
		 */
		public void setFaçade(Façade façade) {
			this.façade = façade;
		}

	}
