layui.use(['jquery','form'], function (){
    var form = layui.form,
        $ = layui.jquery;

    form.on('submit(save)', function (data) {
        console.log(data.field);
        $.post(
            '/logic/user/add',
            data.field,
            function (msg) {
                alert(JSON.stringify(msg));
            }
        )
    });
    form.verify({
        pass: [
            /^[\S]{6,12}$/
            , '密码必须六到十二位，且不能出现空格'
        ],
        checkPass: function (value, item) {
            if (value != $('#tbxPwd').val())
                return '密码确认不正确，请重新输入'

        }
    });
});
