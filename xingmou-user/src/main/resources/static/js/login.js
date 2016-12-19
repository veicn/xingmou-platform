

function checkform(){
	  var nickName =$("#nickName").val();
	  var password =$("#password").val();
	    
	    if(nickName==""){
			$("#nickName").focus();
	        layer.tips('请输入用户名', '#nickName');
	        return false;
	    } 
	    if(password==""){
			$("#password").focus();
	        layer.tips('请输入密码', '#password');
	        return false;
	    }
	    return true;
 }

 function login(){
	
    checkform();
	 
     //判断是否勾选了自动登录
     var b = new Base64();
     var nickName = b.encode($("#nickName").val());
     var password = b.encode($("#password").val());
     var jsonData={"nickName":nickName,"password":password};
     if (!$("#autoLogin").prop('checked')){
        sendPostRequestByJsonObj(platformUrl.toLogin+"?notAuto=true",jsonData,logincallback);
        return
     }

     sendPostRequestByJsonObj(platformUrl.toLogin,jsonData,logincallback);
		 
		 
  }
 
 
 function logincallback(data){
	 if(data.result.status=="OK"){
		 forwardWithHeader(platformUrl.xmcx);
		return false;
	 }else{
	     $(".log_title").text(data.result.message)
	 }
 }
 function keylogin(){
	 if (event.keyCode == 13)
	  {
	    login();
	  }
 }
 
 function logout(){
		$.ajax({
			url : platformUrl.logout,
			type : "POST",
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			async : false,
			error : function(request) {
				alert("connetion error");
			},
			success : function(data) {
				if(data.result.status=="OK"){
					location.href=platformUrl.toLoginPage;
				}
			}
		}); 
	} 
