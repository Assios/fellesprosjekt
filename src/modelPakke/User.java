package modelPakke;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;

/**
 * The <code>Person</code> class stores information about a single person.
 * 
 * @author Thomas &Oslash;sterlie
 *
 * @version $Revision: 1.5 $ - $Date: 2005/02/20 14:52:29 $
 */
public class User {
	
	//List of meetings
	
	private ArrayList<Meeting> meetings;
	

	/**
	 * This member variable holds the person's name.
	 */
	private String name;
	
	/**
	 * This member variable holds the person's email address.
	 */
	private String email;
	
	/**
	 * This member variable holds the person's date of birth.
	 */
	private String password;
	/*
	 * Holds password
	 */
	
	private Date dateOfBirth;
	
	/**
	 * This member variable holds a unique identifier for this object.
	 */
	private long id;
	
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
	public final static String PASSWORD_PROPERTY_NAME = "password";
	/**
	 * Constant used when calling 
	 * {@link java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)}
	 * on {@linkplain #addPropertyChangeListener(java.beans.PropertyChangeListener) registered
	 * <code>PropertyChangeListener<code> objecs} when the person's password is changed.
	 * 
	 * @see #setPassword(String) the setPassword(String) method
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
		name = "";
		email = "";
		password = "";
		dateOfBirth = new Date();
		id = System.currentTimeMillis();
		this.meetings = new ArrayList<Meeting>();
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
	public User(String name, String email, String password, Date dateOfBirth) {
		this();
		this.name = name;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.meetings = new ArrayList<Meeting>();
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
	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		PropertyChangeEvent event = new PropertyChangeEvent(this, NAME_PROPERTY_NAME, oldName, name);
		propChangeSupp.firePropertyChange(event);
	}
	
	/*
	 * Same as for setName, only for password
	 */
	public void setPassword(String password) {
		String oldPassword = this.password;
		this.password = password;
		PropertyChangeEvent event = new PropertyChangeEvent(this, PASSWORD_PROPERTY_NAME, oldPassword, password);
		propChangeSupp.firePropertyChange(event);
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
		String oldEmail = this.email;
		this.email = email;
		PropertyChangeEvent event = new PropertyChangeEvent(this, EMAIL_PROPERTY_NAME, oldEmail, this.email);
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
		Date oldDateOfBirth = this.dateOfBirth;
		this.dateOfBirth = dateOfBirth;
		this.dateOfBirth.setYear(dateOfBirth.getYear()-1900);
		PropertyChangeEvent event = new PropertyChangeEvent(this, DATEOFBIRTH_PROPERTY_NAME, oldDateOfBirth, this.dateOfBirth);
		propChangeSupp.firePropertyChange(event);
	}
	
	/**
	 * Returns the person's name.
	 * 
	 * @return The person's name.
	 */
	public String getName() {
		return name;
	}
	
	public String getPassword(){
		return password;
	}

	/**
	 * Returns the person's email address.
	 * 
	 * @return The person's email address.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Returns the person's date of birth.
	 * 
	 * @return The person's date of birth.
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Returns this object's unique identification.
	 * 
	 * @return The person's unique identification.
	 */
	public long getId() {
		return id;
	}
	
	public ArrayList<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(ArrayList<Meeting> meetings) {
		this.meetings = meetings;
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
		if (aPerson.getPassword().compareTo(getPassword()) != 0) 
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
		s += "Password: " + getPassword() + "; ";
		s += "Email: " + getEmail() + "; ";
		s += "Date of birth: " + getDateOfBirth().toString();
		return s;
	}
	
	
}