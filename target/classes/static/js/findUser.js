// 查看用户信息
    $(function () {

        $.ajax({

            type: "Get",

            url: "/khusedcar/user/getUser",

            dataType: "json",

            success: function (data) {


                var aa = data.data.username;
                var bb = data.data.name;
                var cc = data.data.companyName;
                var dd = data.data.phone;
                var ee = data.data.email;

                $("#username").append('<td width="15%">' + aa + '</td>');
                $("#name").append('<td width="15%">' + bb + '</td>');
                $("#companyName").append('<td width="15%">' + cc + '</td>');
                $("#phone").append('<td width="15%">' + dd + '</td>');
                $("#email").append('<td width="15%">' + ee + '</td>');

                $("#nameP").append('<div class="input_box">' + '<input type="text" id="pa" value='+  bb + '>' + '</div>');
                $("#companyNameP").append('<div class="input_box">'+ '<input type="text" id="pb" value='+  cc + '>' + '</div>');
                $("#phoneP").append('<div class="input_box">'+ '<input type="text" id="pc" value='+  dd + '>' + '</div>');
                $("#emailP").append('<div class="input_box">'+ '<input type="text" id="pd" value='+  ee + '>' + '</div>');

                $("#nameH").append('<a href="user.html">' + bb+ '</a>');

            }, error: function () {

                alert("加载失败");

            }

        })

    })
