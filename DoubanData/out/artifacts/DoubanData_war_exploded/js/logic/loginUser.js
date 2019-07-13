layui.use(['jquery','form'], function () {
    var form = layui.form,
        $ = layui.jquery;
    form.on('submit(login)',function (data) {
        console.log(data.field);
        $.post(
            '/logic/user/login',
            data.field,
            function (msg) {
                alert(JSON.stringify(msg));
            }
        )
    });
    form.verify({
        pass: [
            /^[\S]{6,12}$/
            ,'密码必须6到12位，且不能出现空格'
        ]
    });
});
