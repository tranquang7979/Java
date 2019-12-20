package strutstutorials;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HelloAction extends Action {
	//tu go @Override
	@Override
	public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		//xu ly trong action/controller
		HelloForm hello = (HelloForm)form;
		hello.setMessage("Hello world");
		
		//tim trang view (jsp) khi execute chay xong
		return mapping.findForward("success");
	}

}
