package openjpa.example.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SAMPLE_TABLE database table.
 * 
 */
@Entity
@Table(name="SAMPLE_TABLE")
@NamedQuery(name="SampleTable.findAll", query="SELECT s FROM SampleTable s")
public class SampleTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String column1;

	public SampleTable() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getColumn1() {
		return this.column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

}