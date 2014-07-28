$(document).ready(function() {
	
	var form = $("#studentForm");
	var wizard = $("#rootwizard");
	
	var $validator = $("#studentForm").validate();
	
	$.validator.addMethod("alpha", function(value,element)
	{
		return this.optional(element) || /^[a-zA-Z]+$/i.test(value); 
	}, "Please enter alphabets only");
	
	var handleTitle = function(tab, navigation, index) {
		var total = navigation.find('li').length;
		var current = index + 1;
		if (current == 1) {
			wizard.find('.button-previous').hide();
		} else {
			wizard.find('.button-previous').show();
		}

		if (current >= total) {
			wizard.find('.button-next').hide();
			wizard.find('.button-submit').show();
		} else {
			wizard.find('.button-next').show();
			wizard.find('.button-submit').hide();
		}
	};
	
	// Form wizard example
	wizard.bootstrapWizard({
		'nextSelector' : '.button-next',
		'previousSelector' : '.button-previous',
		onTabClick : function(tab, navigation, index, clickedIndex) {

			if (form.valid() == false) {
				return false;
			}
			handleTitle(tab, navigation, clickedIndex);
		},
		onNext : function(tab, navigation, index) {

			if (form.valid() == false) {
				return false;
			}
			handleTitle(tab, navigation, index);
		},
		onPrevious : function(tab, navigation, index) {
			handleTitle(tab, navigation, index);
		}
	});

	wizard.find('.button-previous').hide();
	$('#studentForm .button-submit').hide();
});