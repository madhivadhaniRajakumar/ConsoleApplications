 package manager.AdminLogin;

public class AdminLoginController implements AdminLoginControllerCallBack {
	
	AdminLoginViewCallBack viewback;
	AdminLoginModelCallBack modelback;
	public AdminLoginController(AdminLoginViewCallBack adminLoginView) {
		// TODO Auto-generated constructor stub
		viewback = adminLoginView;
		modelback = new AdminLoginModel(this);
	}

	public void encodeCredentials(String name,String password ) {
		 char[] ch = password.toCharArray();
		 String pass= "";
		 for(int i=0;i<ch.length;i++) {
			char a= (char) (ch[i]+1);
			 pass += a;
		 }
		 if(modelback.checkCredentialDB(name, pass)){
			 viewback.success();
		 }
		 else {
			 viewback.fail();
		 }
	}
}
 