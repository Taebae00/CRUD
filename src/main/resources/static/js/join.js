function checkNickname() {
    $.ajax({
        type: "POST",
        url: "/checkName",
        dataType: "json",
        success: function (data) {

        }
    })
}