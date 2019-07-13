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
            {field:'numbers',title:'排名',align:'center',width:80},
            {field:'years',title:'年份',align:'center',width:150},
            {field:'area',title:'地区',align:'center',width:150},
            {field:'sorts',title:'分类',align:'center',width:300},
            {field:'movieName',title:'电影名称',align:'center',width:200},
            {field:'link',title:'豆瓣链接',align:'center',width:100,
                templet: function (data) {
                    return "<a href='" + data.link +"'target='_blank'>豆瓣详情</a>"

                }
            },
            {field:'descs',title:'引言',align:'center',width:300},
            {field:'ratingNum',title:'电影评分' ,align:'center',width:150},
            {field:'director',title:'导演及主演',align:'center',width:300},
            {field:'evaluate',title:'评论人数' ,align:'center',width:150},
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
            url: '/logic/imdb/search',
            method:'post',
            where:{
                'name' :$('#name').val(),
                'years':$('#years').val(),
                'sort' :$('#sort').val(),
                'areas' :$('#areas').val()
            }
        });
    });
});