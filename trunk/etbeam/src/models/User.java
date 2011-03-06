	package models;

	import java.util.Collection;
	import java.util.Iterator;

	public class User {

		/*
		 * (non-javadoc)
		 */
		private String login;

		/*
		 * (non-javadoc)
		 */
		private String password;

		/**
 *
 */
		private Collection<ECUE> eCUE;

		/**
 *
 */
		private Collection<UE> uE;

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
		 * Getter of the property <tt>login</tt>
		 * 
		 * @return Returns the login.
		 * 
		 */

		public String getLogin() {
			return login;
		}

		/**
		 * Setter of the property <tt>login</tt>
		 * 
		 * @param login
		 *            The login to set.
		 * 
		 */
		public void setLogin(String login) {
			this.login = login;
		}

		/**
		 * Getter of the property <tt>password</tt>
		 * 
		 * @return Returns the password.
		 * 
		 */

		public String getPassword() {
			return password;
		}

		/**
		 * Setter of the property <tt>password</tt>
		 * 
		 * @param password
		 *            The password to set.
		 * 
		 */
		public void setPassword(String password) {
			this.password = password;
		}

	}

	// /**
	// * Getter of the property <tt>eCUE</tt>
	// *
	// * @return Returns the eCUE.
	// *
	// */
	//
	// public ECUE getECUE() {
	// return eCUE;
	// }
	// /**
	// * Setter of the property <tt>eCUE</tt>
	// *
	// * @param eCUE
	// * The eCUE to set.
	// *
	// */
	// public void setECUE(ECUE eCUE) {
	// this.eCUE = eCUE;
	// }
///**
//		 * Getter of the property <tt>uE</tt>
//		 * 
//		 * @return Returns the uE.
//		 * 
//		 */
//
//		public UE getUE() {
//			return uE;
//		}
///**
//		 * Setter of the property <tt>uE</tt>
//		 * 
//		 * @param uE
//		 *            The uE to set.
//		 * 
//		 */
//		public void setUE(UE uE) {
//			this.uE = uE;
//		}