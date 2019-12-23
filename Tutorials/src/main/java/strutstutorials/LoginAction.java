package strutstutorials;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {
	//tu go @Override
	@Override
	public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		//xu ly trong action/controller
		
		if(form != null) {
			LoginForm loginForm = (LoginForm)form;
			String username = loginForm.getUserName();
			String password = loginForm.getPassword();
			
			if(username != null && password != null && username.equals("tester") && password.equals("123")) 
				return mapping.findForward("success"); 
		}
		
		return mapping.findForward("error");
		
	}

}
