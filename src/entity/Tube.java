package entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tube database table.
 * 
 */
@Entity
@NamedQuery(name="Tube.findAll", query="SELECT t FROM Tube t")
public class Tube implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tubeID;

	private String operateTime;

	private String resultTime;

	private String state;

	public Tube() {
	}

	public String getTubeID() {
		return this.tubeID;
	}

	public void setTubeID(String tubeID) {
		this.tubeID = tubeID;
	}

	public String getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getResultTime() {
		return this.resultTime;
	}

	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Tube [tubeID=" + tubeID + ", operateTime=" + operateTime
				+ ", resultTime=" + resultTime + ", state=" + state + "]";
	}

}