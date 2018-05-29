package Entities;

/**
 * @author SCBrayan
 *
 */
public class User {
	public int ID;
	public String NAME, LASTNAME, SECONDLASNAME, IDENTIFICATION, EMAIL, PASSWORD;
	
	public User() {
		
		
	}
	
	public User(int iD, String nAME, String lASTNAME, String sECONDLASNAME, String iDENTIFICATION, String eMAIL,
			String pASSWORD) {
		super();
		ID = iD;
		NAME = nAME;
		LASTNAME = lASTNAME;
		SECONDLASNAME = sECONDLASNAME;
		IDENTIFICATION = iDENTIFICATION;
		EMAIL = eMAIL;
		PASSWORD = pASSWORD;
	}


	public User(String pUser) throws Exception {
		String[] array = pUser.split(",");
		if(array.length != 6) {
			throw new Exception("Datos de Usuario Incorrectos!");
		}
		this.NAME = array[0];
		this.LASTNAME = array[1];
		this.SECONDLASNAME = array[2];
		this.IDENTIFICATION = array[3];
		this.EMAIL = array[4];
		this.PASSWORD = array[5];
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getLASTNAME() {
		return LASTNAME;
	}
	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}
	public String getSECONDLASNAME() {
		return SECONDLASNAME;
	}
	public void setSECONDLASNAME(String sECONDLASNAME) {
		SECONDLASNAME = sECONDLASNAME;
	}
	public String getIDENTIFICATION() {
		return IDENTIFICATION;
	}
	public void setIDENTIFICATION(String iDENTIFICATION) {
		IDENTIFICATION = iDENTIFICATION;
	}
}
