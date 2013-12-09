package model;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.AccessType.FIELD;


/**
 * The persistent class for the COLLEAGUES database table.
 * 
 */
@Entity
@Table(name="COLLEAGUES", schema = "APP")
@Access(FIELD)
public class Colleague implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name="SUR_NAME")
	private String surName;

	public Colleague() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return this.surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

}