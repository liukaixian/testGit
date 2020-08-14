

const app=new Vue({
    el:".container",
    data:{
        navs:[{name:"用户列表",
                url:"/forward/forwardTo/list"
        },{
               name:"管理员操作",
                url:"/forward/forwardTo/admin"
        },{
               name:"后台数据管理",
                url:"/forward/forwardTo/mng"
        }],
        currentActive:""
    },
    methods:{
        changColor:function(index){
            this.currentActive=index;
        },
    }
})

$(function () {
    $("#delSelected").click(
        function () {
            var ids = [];
            $("input[name='uid']:checked").each(
                function () {
                    n = $(this).parents("tr").index();
                    id = $("#employee_table").find("tr").eq(n);
                    var id1 = id.find("td").eq(1).text();
                    ids.push(id1)
                }
            )
            $.post("/employee/BatchDeleteByIds", {ids: ids},function (data) {
                $(".form-inline").submit();
            })
        }

    )

    $("#file_upload_btn").click(
        function () {
            var fileInput = $('#upload1').get(0).files[0];
            console.info(fileInput);
            if(fileInput){
                $("#fileu_pload_form").submit();
            }else{
                alert("请选择上传文件！");
            }
        }
    )
})