	package models;

	import java.util.Collection;
	import java.util.Iterator;

	public class Annee {

		/*
		 * (non-javadoc)
		 */
		private String VersionEtape;

		/**
 *
 */
		private Collection<Semestre> semestre = null;

		/*
		 * (non-javadoc)
		 */
		private Fa�ade fa�ade = null;

		/**
		 * Getter of the property <tt>VersionEtape</tt>
		 * 
		 * @return Returns the VersionEtape.
		 * 
		 */

		public String getVersionEtape() {
			return VersionEtape;
		}

		/**
		 * Setter of the property <tt>VersionEtape</tt>
		 * 
		 * @param VersionEtape
		 *            The VersionEtape to set.
		 * 
		 */
		public void setVersionEtape(String VersionEtape) {
			this.VersionEtape = VersionEtape;
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
		 * Returns the number of elements in this collection.
		 * 
		 * @return the number of elements in this collection
		 * @see java.util.Collection#size()
		 * 
		 */
		public int semestreSize() {
			return semestre.size();
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

		/**
		 * Setter of the property <tt>semestre</tt>
		 * 
		 * @param semestre
		 *            the semestre to set.
		 * 
		 */
		public void setSemestre(Collection<Semestre> semestre) {
			this.semestre = semestre;
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
		public boolean addSemestre(Semestre semestre) {
			return this.semestre.add(semestre);
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
		public boolean removeSemestre(Semestre semestre) {
			return this.semestre.remove(semestre);
		}

		/**
		 * Removes all of the elements from this collection (optional
		 * operation).
		 * 
		 * @see java.util.Collection#clear()
		 * 
		 */
		public void clearSemestre() {
			this.semestre.clear();
		}

		/**
		 * Getter of the property <tt>fa�ade</tt>
		 * 
		 * @return Returns the fa�ade.
		 * 
		 */

		public Fa�ade getFa�ade() {
			return fa�ade;
		}

		/**
		 * Setter of the property <tt>fa�ade</tt>
		 * 
		 * @param fa�ade
		 *            The fa�ade to set.
		 * 
		 */
		public void setFa�ade(Fa�ade fa�ade) {
			this.fa�ade = fa�ade;
		}

	}
