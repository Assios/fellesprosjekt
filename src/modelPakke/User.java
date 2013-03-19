package modelPakke;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**package modelPakke;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 * The <code>Person</code> class stores information about a single person.
 * 
 * @author Thomas &Oslash;sterlie
 *
 * @version $Revision: 1.5 $ - $Date: 2005/02/20 14:52:29 $
 */
public class User {
	
	private String fornavn;
	private String etternavn;
	private String brukernavn;
	private String epost;
	private Date dateOfbirth;
	private String passord;
	
	/**
	 * This member variable provides functionality for notifying of changes to
	 * the <code>Group</code> class.
	 */
	private transient PropertyChangeSupport propChangeSupp;
	
	/**
	 * Constant used when calling 
	 * {@link java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)}
	 * on {@linkplain #addPropertyChangeListener(java.beans.PropertyChangeListener) registered
	 * <code>PropertyChangeListener<code> objecs} when the person's name is changed.
	 * 
	 * @see #setName(String) the setName(String) method
	 */
	public final static String NAME_PROPERTY_NAME = "name";

	/**
	 * Constant used when calling 
	 * {@link java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)}
	 * on {@linkplain #addPropertyChangeListener(java.beans.PropertyChangeListener) registered
	 * <code>PropertyChangeListener<code> objecs} when the person's email address is changed.
	 * 
	 * @see #setEmail(String) the setEmail(String) method
	 */
	public final static String EMAIL_PROPERTY_NAME = "email";
	
	/**
	 * Constant used when calling 
	 * {@link java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)}
	 * on {@linkplain #addPropertyChangeListener(java.beans.PropertyChangeListener) registered
	 * <code>PropertyChangeListener<code> objecs} when the person's date of birth is changed.
	 * 
	 * @see #setEmail(String) the setDateOfBirth(java.util.Date) method
	 */
	public final static String DATEOFBIRTH_PROPERTY_NAME = "dateOfBirth";
	
	/**
	 * Default constructor. Must be called to initialise the object's member variables.
	 * The constructor sets the name and email of this person to empty
	 * {@link java.lang.String}, while the date of birth is given today's date. The 
	 * {@linkplain #getId() id field} is set to current time when the object is created.
	 */
	public User() {
		fornavn = "";
		etternavn = "";
		brukernavn = "";
		epost = "";
		dateOfbirth = new Date();
		passord = "";
		propChangeSupp = new PropertyChangeSupport(this);
	}
	
	/**
	 * Constructs a new <code>Person</code> object with specified name, email, and date
	 * of birth.
	 * 
	 * @param name The name of the person.
	 * @param email The person's e-mail address
	 * @param dateOfBirth The person's date of birth.
	 */
	public User(String uN,String fornavn, String etternavn, String epost, Date dateOfbirth) {
		this();
		this.brukernavn = uN;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.epost = epost;
		this.dateOfbirth = dateOfbirth;
	}
	
	/**
	 * Assigns a new name to the person.<P>
	 * 
	 * Calling this method will invoke the 
	 * <code>propertyChange(java.beans.PropertyChangeEvent)</code> method on 
	 * all {@linkplain
	 * #addPropertyChangeListener(java.beans.PropertyChangeListener) registered
	 * <code>PropertyChangeListener<code> objecs}.  The {@link java.beans.PropertyChangeEvent}
	 * passed with the {@link java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)}
	 * method has the following characteristics:
	 * 
	 * <ul>
	 * <li>the <code>getNewValue()</code> method returns a {@link java.lang.String} 
	 * with the newly assigned name</li>
	 * <li>the <code>getOldValue()</code> method returns a {@link java.lang.String} 
	 * with the person's old name</li>
	 * <li>the <code>getPropertyName()</code> method returns a {@link java.lang.String} 
	 * with the value {@link #NAME_PROPERTY_NAME}.</li>
	 * <li>the <code>getSource()</code> method returns this {@link Person} object
	 * </ul>
	 * 
	 * @param name The person's new name.
	 *
	 * @see java.beans.PropertyChangeListener <a href="http://java.sun.com/j2se/1.4.2/docs/api/java/beans/PropertyChangeListener.html">java.beans.PropertyChangeListener</a>
	 * @see java.beans.PropertyChangeEvent <a href="http://java.sun.com/j2se/1.4.2/docs/api/java/beans/PropertyChangeEvent.html">java.beans.PropertyChangeEvent</a>
	 */
	public void setName(String fornavn, String etternavn) {
		String oldFornavn = this.fornavn;
		String oldEtternavn = this.etternavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		PropertyChangeEvent event = new PropertyChangeEvent(this, NAME_PROPERTY_NAME, oldFornavn, fornavn);
		PropertyChangeEvent event2 = new PropertyChangeEvent(this, NAME_PROPERTY_NAME, oldEtternavn, etternavn);
		propChangeSupp.firePropertyChange(event);
		propChangeSupp.firePropertyChange(event2);
	}
	
	/**
	 * Assigns a new email address to the person.<P>
	 * 
	 * Calling this method will invoke the 
	 * <code>propertyChange(java.beans.PropertyChangeEvent)</code> method on 
	 * all {@linkplain
	 * #addPropertyChangeListener(java.beans.PropertyChangeListener) registered
	 * <code>PropertyChangeListener<code> objecs}.  The {@link java.beans.PropertyChangeEvent}
	 * passed with the {@link java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)}
	 * method has the following characteristics:
	 * 
	 * <ul>
	 * <li>the <code>getNewValue()</code> method returns a {@link java.lang.String} 
	 * with the newly assigned email address</li>
	 * <li>the <code>getOldValue()</code> method returns a {@link java.lang.String} 
	 * with the person's old email address</li>
	 * <li>the <code>getPropertyName()</code> method returns a {@link java.lang.String} 
	 * with the value {@link #EMAIL_PROPERTY_NAME}.</li>
	 * <li>the <code>getSource()</code> method returns this {@link Person} object
	 * </ul>
	 * 
	 * @param email The person's new email address.
	 *
	 * @see java.beans.PropertyChangeListener <a href="http://java.sun.com/j2se/1.4.2/docs/api/java/beans/PropertyChangeListener.html">java.beans.PropertyChangeListener</a>
	 * @see java.beans.PropertyChangeEvent <a href="http://java.sun.com/j2se/1.4.2/docs/api/java/beans/PropertyChangeEvent.html">java.beans.PropertyChangeEvent</a>
	 */
	public void setEmail(String email) {
		String oldEmail = this.epost;
		this.epost = email;
		PropertyChangeEvent event = new PropertyChangeEvent(this, EMAIL_PROPERTY_NAME, oldEmail, this.epost);
		propChangeSupp.firePropertyChange(event);
	}
	
	/**
	 * Assigns a new date of birth to the person.<P>
	 * 
	 * Calling this method will invoke the 
	 * <code>propertyChange(java.beans.PropertyChangeEvent)</code> method on 
	 * all {@linkplain
	 * #addPropertyChangeListener(java.beans.PropertyChangeListener) registered
	 * <code>PropertyChangeListener<code> objecs}.  The {@link java.beans.PropertyChangeEvent}
	 * passed with the {@link java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)}
	 * method has the following characteristics:
	 * 
	 * <ul>
	 * <li>the <code>getNewValue()</code> method returns a {@link java.util.Date} 
	 * with the newly assigned date of birth</li>
	 * <li>the <code>getOldValue()</code> method returns a {@link java.util.Date} 
	 * with the person's old date of birth</li>
	 * <li>the <code>getPropertyName()</code> method returns a {@link java.lang.String} 
	 * with the value {@link #DATEOFBIRTH_PROPERTY_NAME}.</li>
	 * <li>the <code>getSource()</code> method returns this {@link Person} object
	 * </ul>
	 * 
	 * @param dateOfBirth The person's new date of birth.
	 * 
	 * @see java.beans.PropertyChangeListener <a href="http://java.sun.com/j2se/1.4.2/docs/api/java/util/Date.html">java.util.Date</a>
	 * @see java.beans.PropertyChangeListener <a href="http://java.sun.com/j2se/1.4.2/docs/api/java/beans/PropertyChangeListener.html">java.beans.PropertyChangeListener</a>
	 * @see java.beans.PropertyChangeEvent <a href="http://java.sun.com/j2se/1.4.2/docs/api/java/beans/PropertyChangeEvent.html">java.beans.PropertyChangeEvent</a>
	 */	
	public void setDateOfBirth(Date dateOfBirth) {
		Date oldDateOfBirth = this.dateOfbirth;
		this.dateOfbirth = dateOfBirth;
		PropertyChangeEvent event = new PropertyChangeEvent(this, DATEOFBIRTH_PROPERTY_NAME, oldDateOfBirth, this.dateOfbirth);
		propChangeSupp.firePropertyChange(event);
	}
	
	/**
	 * Returns the person's name.
	 * 
	 * @return The person's name.
	 */
	public String getName() {
		return fornavn + " " + etternavn;
	}

	/**
	 * Returns the person's email address.
	 * 
	 * @return The person's email address.
	 */
	public String getEmail() {
		return epost;
	}
	
	/**
	 * Returns the person's date of birth.
	 * 
	 * @return The person's date of birth.
	 */
	public Date getDateOfBirth() {
		return dateOfbirth;
	}
	
	/**
	 * Returns this object's unique identification.
	 * 
	 * @return The person's unique identification.
	 *
	 */
	public String getPassword(){
		return passord;
	}
	 
	 public String getUserName(){
		 return brukernavn;
	 }
	/**
	 * Add a {@link java.beans.PropertyChangeListener} to the listener list.
	 * 
	 * @param listener The {@link java.beans.PropertyChangeListener} to be added.
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propChangeSupp.addPropertyChangeListener(listener);
	}
	
	/**
	 * Remove a {@link java.beans.PropertyChangeListener} from the listener list.
	 * 
	 * @param listener The {@link java.beans.PropertyChangeListener} to be removed.
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propChangeSupp.removePropertyChangeListener(listener);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object obj) {
		if (super.equals(obj))
			return true;
		
		if (obj.getClass() != this.getClass())
			return false;
		
		User aPerson = (User)obj;
		
		if (aPerson.getName().compareTo(getName()) != 0) 
			return false;
		if (aPerson.getEmail().compareTo(getEmail()) != 0)
			return false;
		if (aPerson.getDateOfBirth().compareTo(getDateOfBirth()) != 0)
			return false;
		
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		String s = "Name: " + getName() + "; ";
		s += "Email: " + getEmail() + "; ";
		s += "Date of birth: " + getDateOfBirth().toString();
		return s;
	}
}
