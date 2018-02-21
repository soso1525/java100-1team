		var passID = false, passPwd = false, passEmail = false, passPhone = false;
		$('#logoutBtn').hide();
		$('#submitBtn').prop("disabled", true);
		
		var submitBtn = $('#submitBtn'),
			idItem = $('#id'),
			passwordItem = $('#password'),
			nameItem = $('#name'),
			emailItem = $('#email'),
			codeItem = $('#code'),
			telItem = $('#tel'),
			phoneBtn = $('#phoneAuth'),
			addressItem = $('#address');
		
		submitBtn.click(() => {
		    $.ajax('../json/member/iAdd', {
		        data: {
		        	email: emailItem.val(),
		        	password: passwordItem.val(),
		        	id: idItem.val(),
		        	tel: telItem.val(),
		        	address: addressItem.val(),
		        	name: nameItem.val(),
		        	birth: $('#year').val()+'-'+$('#month').val()+'-'+$('#day').val(),
		        	type: 1,
		        	loginType: 1
		        },
		        dataType: 'json',
		        method: 'POST',
		        success: (result) => {
		            location.href = "list.html";	
		        },
		        error: () => {
		            window.alert('서버 실행 오류!');
		        }
		    });
		});
		
		phoneBtn.click(() => {
			console.log('clicked');
			$('#id01').show();
			var phone = codeItem.val() + telItem.val();
			console.log(typeof(phone));
			console.log(codeItem.val() + telItem.val());
			if(phone.length != 0) {
				$('#phone-number').val(codeItem.val() + telItem.val());
				$('#label-for-phone').hide();
				updateSignInButtonUI();
			}
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
								console.log("fail");
								passID = false;
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
							console.log(data);
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
								document.querySelector('#validEmail').innerHTML = "사용 가능한 Email입니다";
								checkPass();
							} else {
								console.log("fail");
								passEmail = false;
								$('#email').removeClass("form-control");
								$('#email')
										.removeClass("form-control is-valid");
								$('#email').addClass("form-control is-invalid");
								$('#validEmail')
										.removeClass("invalid-feedback");
								$('#validEmail').removeClass("valid-feedback");
								$('#validEmail').addClass("invalid-feedback");
								document.querySelector('#validEmail').innerHTML = "이미 사용중인 Email입니다. 다른 Email을 입력해주세요";
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
			if (passID && passEmail && passPwd && passPhone) {
				$('#submitBtn').prop("disabled", false);
			} else {
				$('#submitBtn').prop("disabled", true);
			}
		}
		

		window.onload = function() {
	    // Listening for auth state changes.
	    firebase.auth().onAuthStateChanged(function(user) {
	      if (user) {
	        // User is signed in.
	        var uid = user.uid;
	        var email = user.email;
	        var photoURL = user.photoURL;
	        var phoneNumber = user.phoneNumber;
	        var isAnonymous = user.isAnonymous;
	        var displayName = user.displayName;
	        var providerData = user.providerData;
	        var emailVerified = user.emailVerified;
	      }
	      updateSignInButtonUI();
	      updateSignInFormUI();
	      updateSignOutButtonUI();
	      updateVerificationCodeFormUI();
	    });
	    // Event bindings.
	    document.getElementById('sign-out-button').addEventListener('click', onSignOutClick);
	    document.getElementById('phone-number').addEventListener('keyup', updateSignInButtonUI);
	    document.getElementById('phone-number').addEventListener('change', updateSignInButtonUI);
	    document.getElementById('verification-code').addEventListener('keyup', updateVerifyCodeButtonUI);
	    document.getElementById('verification-code').addEventListener('change', updateVerifyCodeButtonUI);
	    document.getElementById('verification-code-form').addEventListener('submit', onVerifyCodeSubmit);
	    document.getElementById('cancel-verify-code-button').addEventListener('click', cancelVerification);
	    // [START appVerifier]
	    window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier('sign-in-button', {
	      'size': 'invisible',
	      'callback': function(response) {
	        // reCAPTCHA solved, allow signInWithPhoneNumber.
	        onSignInSubmit();
	      }
	    });
	    // [END appVerifier]
	    recaptchaVerifier.render().then(function(widgetId) {
	      window.recaptchaWidgetId = widgetId;
	      updateSignInButtonUI();
	    });
	  };
	  /**
		 * Function called when clicking the Login/Logout button.
		 */
	  function onSignInSubmit() {
	    if (isPhoneNumberValid()) {
	      window.signingIn = true;
	      updateSignInButtonUI();
	      var phoneNumber = getPhoneNumberFromUserInput();
	      var appVerifier = window.recaptchaVerifier;
	      firebase.auth().signInWithPhoneNumber(phoneNumber, appVerifier)
	          .then(function (confirmationResult) {
	            // SMS sent. Prompt user to type the code from the message, then
				// sign the
	            // user in with confirmationResult.confirm(code).
	            window.confirmationResult = confirmationResult;
	            window.signingIn = false;
	            updateSignInButtonUI();
	            updateVerificationCodeFormUI();
	            updateVerifyCodeButtonUI();
	            updateSignInFormUI();
	          }).catch(function (error) {
	            // Error; SMS not sent
	            console.error('Error during signInWithPhoneNumber', error);
	            window.alert('Error during signInWithPhoneNumber:\n\n'
	                + error.code + '\n\n' + error.message);
	            window.signingIn = false;
	            updateSignInFormUI();
	            updateSignInButtonUI();
	          });
	    }
	  }
	  /**
		 * Function called when clicking the "Verify Code" button.
		 */
	  function onVerifyCodeSubmit(e) {
	    e.preventDefault();
	    if (!!getCodeFromUserInput()) {
	      window.verifyingCode = true;
	      updateVerifyCodeButtonUI();
	      var code = getCodeFromUserInput();
	      confirmationResult.confirm(code).then(function (result) {
	        // User signed in successfully.
	        var user = result.user;
	        window.verifyingCode = false;
	        window.confirmationResult = null;
	        updateVerificationCodeFormUI();
	      }).catch(function (error) {
	    	  passPhone = false;
	    	  checkPass();
	        // User couldn't sign in (bad verification code?)
	        console.error('Error while checking the verification code', error);
	        window.alert('Error while checking the verification code:\n\n'
	            + error.code + '\n\n' + error.message);
	        window.verifyingCode = false;
	        updateSignInButtonUI();
	        updateVerifyCodeButtonUI();
	      });
	    }
	  }
	  /**
		 * Cancels the verification code input.
		 */
	  function cancelVerification(e) {
	    e.preventDefault();
	    window.confirmationResult = null;
	    updateVerificationCodeFormUI();
	    updateSignInFormUI();
	  }
	  /**
		 * Signs out the user when the ign-out button is clicked.
		 */
	  function onSignOutClick() {
	    firebase.auth().signOut();
	    document.getElementById('id01').style.display='none';
	    updateSignInFormUI();
	  }
	  /**
		 * Reads the verification code from the user input.
		 */
	  function getCodeFromUserInput() {
	    return document.getElementById('verification-code').value;
	  }
	  /**
		 * Reads the phone number from the user input.
		 */
	  function getPhoneNumberFromUserInput() {
	    return document.getElementById('phone-number').value;
	  }
	  /**
		 * Returns true if the phone number is valid.
		 */
	  function isPhoneNumberValid() {
	    var pattern = /^\+[0-9\s\-\(\)]+$/;
	    var phoneNumber = getPhoneNumberFromUserInput();
	    return phoneNumber.search(pattern) !== -1;
	  }
	  /**
		 * Re-initializes the ReCaptacha widget.
		 */
	  function resetReCaptcha() {
	    if (typeof grecaptcha !== 'undefined'
	        && typeof window.recaptchaWidgetId !== 'undefined') {
	      grecaptcha.reset(window.recaptchaWidgetId);
	    }
	  }
	  /**
		 * Updates the Sign-in button state depending on ReCAptcha and form
		 * values state.
		 */
	  function updateSignInButtonUI() {
	    document.getElementById('sign-in-button').disabled =
	        !isPhoneNumberValid()
	        || !!window.signingIn;
	  }
	  /**
		 * Updates the Verify-code button state depending on form values state.
		 */
	  function updateVerifyCodeButtonUI() {
	    document.getElementById('verify-code-button').disabled =
	        !!window.verifyingCode
	        || !getCodeFromUserInput();
	  }
	  /**
		 * Updates the state of the Sign-in form.
		 */
	  function updateSignInFormUI() {
	    if (firebase.auth().currentUser || window.confirmationResult) {
	      document.getElementById('sign-in-form').style.display = 'none';
	    } else {
	      resetReCaptcha();
	      document.getElementById('sign-in-form').style.display = 'block';
	      $('#phone-number').val('');
	      $('#label-for-phone').show();
	    }
	  }
	  /**
		 * Updates the state of the Verify code form.
		 */
	  function updateVerificationCodeFormUI() {
	    if (!firebase.auth().currentUser && window.confirmationResult) {
	      document.getElementById('verification-code-form').style.display = 'block';
	    } else {
	      document.getElementById('verification-code-form').style.display = 'none';
	    }
	  }
	  /**
		 * Updates the state of the Sign out button.
		 */
	  function updateSignOutButtonUI() {
	    if (firebase.auth().currentUser) {
	      document.getElementById('sign-out-button').style.display = 'block';
	      passPhone = true;
	      checkPass();
	      $('phone-sign').val('인증이 완료되었습니다. 인증완료 버튼을 누르시면 창이 닫힙니다.');
	        
	    } else {
	      document.getElementById('sign-out-button').style.display = 'none';
	    }
	  }
