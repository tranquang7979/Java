package itviec;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LocaleAction extends Action{

	
	@Override
	public ActionForward execute (ActionMapping maping, ActionForm form, 
			HttpServletRequest request,HttpServletResponse response)   {
		String lang = request.getParameter("language");
		System.out.println(lang);
		if(lang.equals("en")) {
			
			request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
		}else {
			request.getSession().setAttribute(Globals.LOCALE_KEY, new Locale("vi","VN"));
			
			
		}
		
		return maping.findForward("success");
	}
}
