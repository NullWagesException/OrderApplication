//提交的方法名称
var method = "";
var listParam = "";
var saveParam = "";
$(function() {
    $('#win').window('close');  // close a window
    //加载表格数据
    $('#grid').datagrid({
        url: name + '/getAll' + listParam,
        columns: columns,
        singleSelect: true,
        pagination: true,
        toolbar: [{
            text: '新增',
            iconCls: 'icon-add',
            handler: function(){
                //设置保存按钮提交的方法为add
                method = "insert";
                //打开编辑窗口
                $('#win').dialog('open');
            }
        }]
    });

    //点击查询按钮
    $('#btnSearch').bind('click', function () {
        //把表单数据转换成json对象
        var formData = $('#searchForm').serializeJSON();
        $('#grid').datagrid('load', formData);
    });

    var h = 300;
    var w = 400;
    if (typeof (height) != "undefined") {
        h = height;
    }
    if (typeof (width) != "undefined") {
        w = width;
    }
    //初始化编辑窗口
    $('#win').dialog({
        title: '编辑',//窗口标题
        width: w,//窗口宽度
        height: h,//窗口高度
        closed: true,//窗口是是否为关闭状态, true：表示关闭
        modal: true//模式窗口
    });

    //点击保存按钮
    $('#btnSave').bind('click', function () {
        //做表单字段验证，当所有字段都有效的时候返回true。该方法使用validatebox(验证框)插件。
        var isValid = $('#editForm').form('validate');
        if (isValid == false) {
            return;
        }
        var file = $("#myfile").val();
        //获取文件上传文件的文件名和扩展名
        if (myfile.files[0] == undefined) {
            $('#itemImgPath').val(null);
        } else {
            var fileName = getFileName(file);

            function getFileName(o){
                var pos=o.lastIndexOf("\\");
                return o.substring(pos+1);
            }
            console.log(fileName);
            $('#itemImgPath').val(fileName);
        }
        var formData = $('#editForm').serializeJSON();
        $.ajax({
            url: name + '/' + method + saveParam,
            data: formData,
            dataType: 'json',
            type: 'post',
            success: function (rtn) {
                $.messager.alert("提示", rtn.message, 'info', function () {
                    //成功的话，我们要关闭窗口
                    $('#win').dialog('close');
                    //刷新表格数据
                    $('#grid').datagrid('reload');
                });
            }
        });
    });
});


    /**
     * 删除
     */
    function del(uuid) {
        $.messager.confirm("确认", "确认要删除吗？", function (yes) {
            if (yes) {
                $.ajax({
                    url: name + '/delete?itemid=' + uuid,
                    dataType: 'json',
                    type: 'post',
                    success: function (rtn) {
                        $.messager.alert("提示", rtn.message, 'info', function () {
                            //刷新表格数据
                            $('#grid').datagrid('reload');
                        });
                    }
                });
            }
        });
    }

/**
 * 删除
 */
function deluser(uuid) {
    $.messager.confirm("确认", "确认要删除吗？", function (yes) {
        if (yes) {
            $.ajax({
                url: name + '/delete?id=' + uuid,
                dataType: 'json',
                type: 'post',
                success: function (rtn) {
                    $.messager.alert("提示", rtn.message, 'info', function () {
                        //刷新表格数据
                        $('#grid').datagrid('reload');
                    });
                }
            });
        }
    });
}


    /**
     * 更新菜品
     */
    function upitem(uuid) {
        $('#fileid').val(uuid);
        $('#win').window('open');  // open a window
        method = "update";
    }



/**
 * 确认修改用户
 */
function upuserbtn() {
    var formData = $('#fileform').serializeJSON();
    $.ajax({
        url:"edituser",
        data: formData,
        dataType: 'json',
        type: 'post',
        success:function(data) {
            if (data){
                $.messager.alert('提示',"用户修改成功",'info',function () {
                    $('#win').window('close');
                    $('#grid').datagrid('reload');
                });
            }else{
                $.messager.alert('提示',"用户修改失败",'info');
            }
        }
    });

}