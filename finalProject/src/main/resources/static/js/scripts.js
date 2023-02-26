/*!
* Start Bootstrap - Small Business v5.0.5 (https://startbootstrap.com/template/small-business)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-small-business/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

$(document).ready(function () {
    $.ajaxSetup({
        contentType: 'application/json',
    });

    $('#leave-offer-btn').click(function () {
        // Получаем введенный текст
        let requestBody = JSON.stringify({
            text: $('#offer-text-field').val(),
        });

        // Отправка запроса на бэк
        $.post('/offer', requestBody, function (status, data) {
            let textField = $('#offer-text-field');

            textField.hide();
            $('#success-message').toast('show');
            //textField.show();
        });
    });
});
