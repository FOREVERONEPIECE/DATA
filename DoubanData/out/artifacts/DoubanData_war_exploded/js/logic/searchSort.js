layui.use(['jquery', 'table','layer','laydate'],function(){

    var table = layui.table,
        $ = layui.jquery,
        laydate=layui.laydate;
    laydate.render({
        elem:'#years',
        type:'year',
        min:'1896-01-01',
        max:Date(),
        range:true
    })
    //页面表格渲染
    table.render({
        elem:'#tblResult',
        data:[],
        cols:[[
            {field:'id',title:'id',align:'center',width:300},
            {field:'movieName',title:'片名',align:'center',width:300},
            {field:'director',title:'导演',align:'center',width:80},
            {field:'editor',title:'编剧',align:'center',width:150},
            {field:'actor',title:'演员',align:'center',width:150},
            {field:'times',title:'时间',align:'center',width:300},
            {field:'starttime',title:'上映时间',align:'center',width:200},
            {field:'evaluate',title:'评论人数',align:'center',width:100},
            {field:'country',title:'国家',align:'center',width:300},
            {field:'ratingNum',title:'电影评分' ,align:'center',width:150},
            {field:'languages',title:'语言',align:'center',width:300},
            {field:'summary',title:'介绍' ,align:'center',width:150},
            {field:'idd',title:'操作',align:'center',width:250,
                templet: function (data) {
                    var btn = "<button class='layui-btn-sm layui-btn-normal' lay-event='info>" + "<i class='layui-icon layui-icon-about'></i>详情</button>"+
                        "<button class='layui-btn layui-btn-sm layui-btn-danger' lay-event='forbidden'>"+"<i class='layui-icon layui=icon-close-fill'></i>屏蔽</button>";
                    return btn;
                }
            },

        ]],
        page: true
    });

    //编写页面检索按钮的事件响应
    $('#btnSearch').click(function(event){
        table.reload('tblResult',{
            url: '/logic/douban/search',
            method:'post',
            where:{
                'name' :$('#name').val(),
                'language' :$('#language').val(),
                'countrys' :$('#countrys').val(),
                'actor' :$('#actor').val()
            }
        });
    });
});