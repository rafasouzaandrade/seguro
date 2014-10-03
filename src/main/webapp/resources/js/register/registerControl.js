$(document).ready(function() {
	runAllForms();
	// Validation
	$(function() {
		$("#smart-form-register").validate({
			rules : {
				nomeCorretora : {
					required : true
				},
				emailCorretora : {
					required : true,
					email : true
				},
				login : {
					required : true
				},
				senha : {
					required : true
				},
				nome : {
					required : true
				},
				sexo : {
					required : true
				}
			},

			messages : {
				nomeCorretora : {
					required : 'Please select the name of the corretora'
				},
				emailCorretora : {
					required : 'Please enter your email address',
					email : 'Please enter a VALID email address'
				},
				login : {
					required : 'Please enter your login'
				},
				senha : {
					required : 'Please enter your password'
				},
				nome : {
					required : 'Please select your first name'
				},
				sexo : {
					required : 'Please select your gender'
				}
			},

			// Ajax form submition
			submitHandler : function(form) {
				$(form).ajaxSubmit({
					success : function() {
						$("#smart-form-register").addClass('submited');
					}
				});
			},

			errorPlacement : function(error, element) {
				error.insertAfter(element.parent());
			}
		});

	});
});