
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
								console.log("success");
								passID = true;
								$('#id').removeClass("form-control");
								$('#id').removeClass("form-control is-invalid");
								$('#id').addClass("form-control is-valid");
								$('#validID').removeClass("valid-feedback");
								$('#validID').removeClass("invalid-feedback");
								$('#validID').addClass("valid-feedback");
								document.querySelector('#validID').innerHTML = "사용 가능한 ID입니다";
								checkPass();
							} else {
								passID = false;
								console.log("fail");
								$('#submitBtn').prop("disabled", true);
								$('#id').removeClass("form-control");
								$('#id').removeClass("form-control is-valid");
								$('#id').addClass("form-control is-invalid");
								$('#validID').removeClass("invalid-feedback");
								$('#validID').removeClass("valid-feedback");
								$('#validID').addClass("invalid-feedback");
								document.querySelector('#validID').innerHTML = "사용 불가능한 ID입니다. 다른 ID를 입력해주세요";
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
								console.log("success");
								passEmail = true;
								$('#email').removeClass("form-control");
								$('#email').removeClass(
										"form-control is-invalid");
								$('#email').addClass("form-control is-valid");
								$('#validEmail').removeClass("valid-feedback");
								$('#validEmail')
										.removeClass("invalid-feedback");
								$('#validEmail').addClass("valid-feedback");
								document.querySelector('#validEmail').innerHTML = "사용 가능한 email입니다";
								checkPass();
							} else {
								console.log("fail");
								passEmail = false;
								$('#submitBtn').prop("disabled", true);
								$('#email').removeClass("form-control");
								$('#email')
										.removeClass("form-control is-valid");
								$('#email').addClass("form-control is-invalid");
								$('#validEmail')
										.removeClass("invalid-feedback");
								$('#validEmail').removeClass("valid-feedback");
								$('#validEmail').addClass("invalid-feedback");
								document.querySelector('#validEmail').innerHTML = "이미 사용중인 email입니다. 다른 Email을 입력해주세요";
								checkPass();
							}
						}
					});
		}

		function checkPwd() {
			var password = document.querySelector('#password')
			var repassword = document.querySelector('#repassword')
			var checkpassword = document.querySelector('#validPWD')
			repassword.addEventListener('keyup', function() {
				if (password.value == repassword.value) {
					passPwd = true;
					$('#repassword').removeClass("form-control");
					$('#repassword').removeClass("form-control is-invalid");
					$('#repassword').addClass("form-control is-valid");
					$('#validPWD').removeClass("valid-feedback");
					$('#validPWD').removeClass("invalid-feedback");
					$('#validPWD').addClass("valid-feedback");
					checkpassword.innerHTML = "비밀번호가 일치합니다";
					checkPass();
				} else {
					passPwd = false;
					$('#repassword').removeClass("form-control");
					$('#repassword').removeClass("form-control is-valid");
					$('#repassword').addClass("form-control is-invalid");
					$('#validPWD').removeClass("valid-feedback");
					$('#validPWD').removeClass("invalid-feedback");
					$('#validPWD').addClass("invalid-feedback");
					checkpassword.innerHTML = "비밀번호가 일치하지않습니다";
					checkPass();
				}
			});
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
		
		