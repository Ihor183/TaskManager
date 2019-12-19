$('#registerBtn').click(function () {
    var ids = ['username', 'lastName', 'your_email', 'password', 'confirm_password'];

    for(var i = 0; i < ids.length; i++) {
        if($('#' + ids[i]).val().trim() == '') {
            $('#' + ids[i]).val('');
            return;
        }
    }

    if($('#password').val() !== $('#confirm_password').val()) {
        $('#password').val('').attr('placeholder', 'Passwords isn\'t the same');
        $('#confirm_password').val('').attr('placeholder', 'Passwords isn\'t the same');
        setTimeout(deletePlaceholder, 3000);
    }
});

function deletePlaceholder() {
    $('#password').attr('placeholder', '');
    $('#confirm_password').attr('placeholder', '');
}

$('#loginBtn').click(function () {
    var ids = ['email', 'password'];

    for(var i = 0; i < ids.length; i++) {
        if($('#' + ids[i]).val().trim() == '') {
            $('#' + ids[i]).val('');
            return;
        }
    }
});