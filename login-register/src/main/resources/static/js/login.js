
function login(){
	
	
    var name = $('#name').val()
    var pwd = $('#pwd').val()
    var flag = false
    var checkbox = $('#checkbox').prop("checked")

    if(checkbox)
        flag = true

    var data = {
        username:name,
        password:pwd,
        flag:flag
    };
    if(name == ""){
        alert("请先输入用户名")
    }
    else if(pwd == ""){
        alert("请先输入密码")
    }else{

        $.post(
            "login.l",
            data,
            function(data){

                if(data.code == 0){
                	alert(data.msg);
                    
                }else if(data.code == -1){

                    alert("账号或者密码错误");
                }else{
                	
                	window.location.href="http://localhost/index.html?"+data.code;
                }
            });
    }
}