package Manager;

import CRUD.UserCrud;
import Entities.User;

public class UserManager implements IBaseManager {
	private UserCrud uCrud = new UserCrud();
	@Override
	public void Validation() {
		// TODO Auto-generated method stub
		
	}
	
	public String CreUser(User pUser) throws Exception {
		uCrud.CreUser(pUser);
		return "Registrado Correctamente";
		
	}
	
	public User RetUser(User pUser) throws Exception {
		User user = uCrud.RetUser(pUser);
		if(user == null) {
			throw new Exception("Email o Contraseña incorrectos!");
		}
		return user;
		
	}

}
