layui.use(['jquery','table','layer'], function (){

    var table= layui.table,
        $ = layui.jquery;
        form=layui.form,
        layer=layui.layer;
    //页面表渲染
    table.render({
        elem:'#tblResult',
        data:[],
        cols:[[
            {field:'uid',title:'用户名', align:'center', width:100},
            {field:'nickName',title:'显示名称', align:'center', width:110},
            {field:'userType',title:'账号类型', align:'center', width:115,
                templet:function (field) {
                    switch(field.userType){
                        case 1:
                            return '普通访问用户';
                        case 0:
                            return '平台管理员';
                    }
                }

            },
            {field:'iid', title:'操作', align: 'center',
                templet:function (d) {
                    var btn = "<button class='layui-btn layui-btn-sm layui-btn-warm' lay-event='reset' >" +
                        "<i class='layui-icom layui-icon-password'></i>密码重置</i><button>"+
                        "<button class='layui-btn layui-btn-sm layui-btn-normal' lay-event='info'>" +
                        "<i class='layui-icon layui-icon-about'></i>详情<button>"+
                        "<button class='layui-btn layui-btn-sm laui-btn-danger' lay-event='forbidden'>" +
                        "<i class='layui-icon layui-icon-close-fill'></i>屏蔽<button>";
                    return btn;
                }
            },

        ]],
        page: true
    });

    //详情页面js
    table.on('tool(tblResult)', function (obj) {
        if('info' === obj.event){
            $.post(
                "/logic/user/"+obj.data.id,
                {},
                function (result) {
                    form.val("userInfo",result);
                    layer.open({
                        type:1,
                        title:'<i class="layui-icon layui-icon-user"></i>用户信息',
                        offset:'auto',
                        content:$('#divUserInfo'),
                        btn:['保存','取消并关闭'],
                        btnAlign:'c',
                        shade:0,
                        yes: function (index, lo) {
                            $.post(
                                "/logic/user/edit",
                                {
                                    "id": $("#hidId").val(),
                                    "nickName":$("#tbxNickName").val()
                                },
                                function (result) {
                                    table.reload('tblResult');
                                    layer.closeAll();

                                }
                            )

                        }
                    });

                }
            );
        }

    });

    //编写页面检索按钮的事件响应
    $('#btnSearch').click(function(event){
        table.reload('tblResult',{
            url: '/logic/user/search',
            method:'post',
            where:{
                'uid' :$('#uid').val(),
                'usertype':$('#usertype').val()

            }
        });
    });


});
