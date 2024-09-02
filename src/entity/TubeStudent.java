package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tube_students database table.
 * 
 */
@Entity
@Table(name="tube_student")
@NamedQuery(name="TubeStudent.findAll", query="SELECT t FROM TubeStudent t")
public class TubeStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int list_id;

	@Column(name="student_id")
	private String studentId;

	@Column(name="student_name")
	private String studentName;

	private String tubeID;

	public TubeStudent() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInTube_ID() {
		return this.list_id;
	}

	public void setlist_id(int list_id) {
		this.list_id = list_id;
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getTubeID() {
		return this.tubeID;
	}

	public void setTubeID(String tubeID) {
		this.tubeID = tubeID;
	}

	@Override
	public String toString() {
		return "TubeStudent [id=" + id + ", list_id=" + list_id
				+ ", studentId=" + studentId + ", studentName=" + studentName
				+ ", tubeID=" + tubeID + "]";
	}

}