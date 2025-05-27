package mission_intermediate.i03_reserse;

public class Reverse implements Interface{
	
	String result = "";
	String ori_str = "";
	
	Reverse(){
	}
	
	public String getOri_str() {
		return ori_str;
	}

	public void setOri_str(String ori_str) {
		this.ori_str = ori_str;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	

	public void reverse() {
		//for ��
		for(int i=this.ori_str.length()-1;i>=0 ;i--) {
			this.result += (isUpChk(this.ori_str.charAt(i))) ? toLower(this.ori_str.charAt(i)) :
					  (isLowChk(this.ori_str.charAt(i))) ? toUpper(this.ori_str.charAt(i)) : this.ori_str.charAt(i);

		}
	   this.result = this.result;
	}

	//�빮��üũ
	boolean isUpChk(char str){
		boolean chk = false;
		if(Character.isUpperCase(str)) chk = true;
		return  chk;
	}

	//�ҹ��� üũ
	boolean isLowChk(char str){
		boolean chk = false;
		if(Character.isLowerCase(str)) chk = true;
		return  chk;
	}
	
	char toUpper(char str){
		return Character.toUpperCase(str);
	}

	char toLower(char str){
		return Character.toLowerCase(str);
		
	}
	
	
	
	
}
