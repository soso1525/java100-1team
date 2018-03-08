
		var passID = false, passPwd = false, passEmail = false, passBno = false;

		var bno;
		
		var submitBtn = $('#submitBtn'),
			btnCheckBtn = $('#btnCheckInfo'),
			idItem = $('#id'),
			passwordItem = $('#password'),
			nameItem = $('#cName'),
			kindItem = $('#cKind'),
			cTypeItem = $('#cType'),
			emailItem = $('#email'),
			addressItem = $('#address'),
			telItem = $('#tel'),
			bnoItem = $('#businessNo');
		
		submitBtn.click(() => {
		    $.ajax('../json/company/cAdd', {
		        data: {
		        	email: emailItem.val(),
		        	id: idItem.val(),
		        	password: passwordItem.val(),
		        	tel: telItem.val(),
		        	address: addressItem.val(),
		        	cName: nameItem.val(),
		        	cKind: kindItem.val(),
		        	businessNo: bno,
		        	cType: cTypeItem.val(),
		        	type: 2
		        },
		        dataType: 'json',
		        method: 'POST',
		        success: (result) => {
		            location.href = "../auth/login.html";	
		        },
		        error: () => {
		            window.alert('서버 실행 오류!');
		        }
		    });
		});
		
		
		
		function checkID() {
			var ctxpath = '/json';
			var userID = $('#id').val();
			
			$
					.ajax({
						type : 'GET',
						url : ctxpath + '/member/check-memb-id',
						data : {
							id : userID
						},
						success : function(data) {
							var result = JSON.parse(data);
							if (result.success) {
								if(userID.length == 0) {
									passID = false;
									$('#validID').css('color', '#4c9cef');
									$('#validID').html('사용하실 아이디를 입력해주세요');
									return;
								}
								passID = true;
								$('#validID').css('color', '#4CAF50');
								$('#validID').html('사용 가능한 아이디입니다');
								checkPass();
							} else {
								passID = false;
								$('#validID').css('color', '#f7639a');
								$('#validID').html('이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요');
								checkPass();
							}
						}
					});
		}
		function checkEmail() {
			var ctxpath = '/json';
			var userEmail = $('#email').val();
			$
					.ajax({
						type : 'GET',
						url : ctxpath + '/member/check-memb-email',
						data : {
							email : userEmail
						},
						success : function(data) {
							var result = JSON.parse(data);
							if (result.success) {
								if(userEmail.length == 0) {
									passEmail = false;
									$('#validEmail').css('color', '#4c9cef');
									$('#validEmail').html('사용하실 이메일을 입력해주세요');
									checkPass();
									return;
								}
								
								passEmail = true;
								$('#validEmail').css('color', '#4CAF50');
								$('#validEmail').html('사용 가능한 이메일입니다');
								checkPass();
							} else {
								passEmail = false;
								$('#validEmail').css('color', '#f7639a');
								$('#validEmail').html("이미 사용중인 이메일입니다. 다른 이메일을 입력해주세요");
								checkPass();
							}
						}
					});
		}
		
		function checkPwd() {
			var password = $('#password'),
			    repassword = $('#repassword'),
			    checkpassword = $('#validPWD');
				
				if (password.val() == repassword.val()) {
					passPwd = true;
					checkpassword.css('color', '#4CAF50');
					checkpassword.html('비밀번호가 일치합니다');
					checkPass();
				} else {
					passPwd = false;
					
					if(password.val().length == 0 || repassword.val().length == 0) {
						checkpassword.css('color', '#4c9cef');
						checkpassword.html('비밀번호 확인을 위해 다시 입력해주세요');
						checkPass();
						return;
					}
					
					checkpassword.css('color', '#f7639a');
					checkpassword.html('비밀번호가 일치하지않습니다');
					checkPass();
				}
		}

		function checkPass() {
			if (passID && passEmail && passPwd && passBno) {
				$('#submitBtn').prop("disabled", false);
			} else {
				$('#submitBtn').prop("disabled", true);
			}
		}
		
		var modal = document.getElementById('myModal');
		var btn = document.getElementById("btnCheckInfo");
		var span = document.getElementsByClassName("close")[0];

		btnCheckBtn.click(() => {
			console.log("button clicked");
			document.getElementById('myModal').style.display = "block";
		    $('#compName').val(nameItem.val());
		    $('#bno').val(bnoItem.val());
		});

		window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		};
		
		$('#closeBtn').click(() => {
			console.log("close btn clicked");
			$('#myModal').hide();
		});
		
		$('#bnoBtn').click(() => {
			console.log('bnoBtn clicked');
			var ctxpath = '/json';
			var compName = $('#compName').val();
			var compNum = $('#bno').val().replace(/^\s*/,'').replace(/\s*$/,'').substring(0,6);
			$('#validBno').html('');
			var qs = {
				cname : compName,
				cnum : compNum
			};

			$.ajax({
				type : 'GET',
				url : ctxpath + '/company/check-comp-info',
				data : qs,
				success : function(response) {
					var result = JSON.parse(response);
					if (result.success) {
						swal("인증 성공", "인증이 완료되었습니다", "success");
						$('#businessNo').val($('#bno').val().replace(/^\s*/,'').replace(/\s*$/,''));
						bno = $('#bno').val();
						passBno = true;
						checkPass();
					} else {
						swal("인증 실패", "번호를 다시 확인해주세요", "error");
						passBno = false;
						checkPass();
					}
				},
				beforeSend:function() {
					document.getElementById('loading').style.display='block';
					$('#bnoBtn').prop("disabled", true);
					$('#bnoBtn').html('조회중');
				},
				complete:function() {
					document.getElementById('loading').style.display='none';
					$('#bnoBtn').prop("disabled", false);
					$('#bnoBtn').html('조회하기');
					$('#closeBtn').show();
				},
				error:function() {
					
				}
			});
		});
		
		