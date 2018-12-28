$(function () {
    $('#written').click(function () {
        $.ajax({
            type: 'GET',
            data: null,
            dataType: 'json',
            url: '/khusedcar/user/written',
            success: function (result) {
                if (result.code == '0000') {
                    alert("注销成功！");
                    window.location.href = "login.html";
                } else if (result.code != '0000') {
                    alert("注销失败");
                }
            },
            error: function (result) {
                alert("操作失败");
            }
        });
    });
});
