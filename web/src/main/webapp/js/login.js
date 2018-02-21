var loginBtn = $('#loginBtn'), email = $('#email'), password = $('#password'), saveEmail = $('#saveEmail');
		loginBtn.click(function() {
			console.log(email.val(), password.val(), saveEmail.is(':checked'));
			$.post('../json/auth/login', {
				email : email.val(),
				password : password.val(),
				saveEmail : saveEmail.is(':checked')
			}, function(result) {
				if (result.status == "success") {
					console.log(result);
					 $('#loginbtn').html('Mypage');
					 $('#loginbtn').attr("href", "../apply/apply.html");
					 $('#logoutbtn').show();
					 $('#msgMenu').show();
					 location.href = "../apply/apply.html"
				} else {
					$('#loginbtn').html('Login');
			    	 $('#loginbtn').attr("href", "../auth/login.html");
			    	 $('#logoutbtn').hide();
			    	 $('#msgMenu').hide();
					swal("Login Fail", "이메일이나 암호가 일치하는 사용자를 찾을 수 없습니다.", "error");
				}
			}, 'json');

		});
		
		$.getJSON('../json/auth/loginUser', function(result) {
		    if (result.status == 'fail') {
		    	$('#logoutbtn').hide();
		    	$('#msgMenu').hide();
		    	$('#loginbtn').html('Login');
		    	 $('#loginbtn').attr("href", "../auth/login.html");
		        return;
		    }
		    
		    $('#loginbtn').html('Mypage');
		    $('#loginbtn').attr("href", "../apply/apply.html");
		    $('#logoutbtn').show();
		    $('#msgMenu').show();
		});

		$('#logoutbtn').click(() => {
			console.log('logout!');
		    $.getJSON('../json/auth/logout', (result) => {
			    console.log(result);	
			    $('#loginbtn').html('Login');
		    	 $('#loginbtn').attr("href", "../auth/login.html");
		    	 $('#logoutbtn').hide();
		    	 $('#msgMenu').hide();
			    location.href = '../auth/login.html';
		    });
		})