var TableDatatablesEditable = function () {

    var handleTable = function () {

        function restoreRow(oTable, nRow) {
            var aData = oTable.fnGetData(nRow);
            var jqTds = $('>td', nRow);

            for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                oTable.fnUpdate(aData[i], nRow, i, false);
            }

            oTable.fnDraw();
        }

        function editRow(oTable, nRow) {
            var aData = oTable.fnGetData(nRow);
            var jqTds = $('>td', nRow);
            jqTds[1].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[1] + '">';
            jqTds[2].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[2] + '">';
            jqTds[3].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[3] + '">';
            jqTds[4].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[4] + '">';
            if (aData[4] == "等待付清")
                jqTds[4].innerHTML = '<select class="form-control input-small"><option value="0" selected>等待付清</option><option value="1">交易完成</option><option value="2">交易关闭</option></select>';
            if (aData[4] == "交易完成")
                jqTds[4].innerHTML = '<select class="form-control input-small"><option value="0" >等待付清</option><option value="1" selected>交易完成</option><option value="2">交易关闭</option></select>';
            if (aData[4] == "交易关闭")
                jqTds[4].innerHTML = '<select class="form-control input-small"><option value="0" >等待付清</option><option value="1">交易完成</option><option value="2" selected>交易关闭</option></select>';

            jqTds[5].innerHTML = '<a class="edit" href="">Save</a>';
            jqTds[6].innerHTML = '<a class="cancel" href="">Cancel</a>';
        }

        function saveRow(oTable, nRow) {
            var jqInputs = $('input', nRow);
            var jqSelect = $("select", nRow);
            oTable.fnUpdate(jqInputs[0].value, nRow, 1, false);
            oTable.fnUpdate(jqInputs[1].value, nRow, 2, false);
            oTable.fnUpdate(jqInputs[2].value, nRow, 3, false);
            if(jqSelect[0].value == 0)
                oTable.fnUpdate("等待付清", nRow, 4, false);
            if(jqSelect[0].value == 1)
                oTable.fnUpdate("交易完成", nRow, 4, false);
            if(jqSelect[0].value == 2)
                oTable.fnUpdate("交易关闭", nRow, 4, false);
            // oTable.fnUpdate(jqInputs[4].value.slice(0,10)+' '+jqInputs[4].value.slice(11), nRow, 4, false);
            oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 5, false);
            oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 6, false);
            oTable.fnDraw();
        }

        function cancelEditRow(oTable, nRow) {
            var jqInputs = $('input', nRow);
            oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
            oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
            oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
            oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
            oTable.fnUpdate(jqInputs[4].value, nRow, 4, false);
            oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 5, false);
            oTable.fnDraw();
        }

        var table = $('#sample_editable_1');

        var oTable = table.dataTable({

            lengthMenu: [
                [5, 15, 20, -1],
                [5, 15, 20, "All"] // change per page values here
            ],

            pageLength: 5,

            language: {
                // "lengthMenu": " _MENU_ records"
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            columnDefs: [{ // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
            order: [
                [0, "asc"]
            ], // set first column as a default sort by asc
            buttons: [{
                extend: "print",
                className: "btn dark btn-outline",
                text:"打印",
                exportOptions: {
                    columns:':visible'
                }
            }, {
                extend: "copy",
                className: "btn red btn-outline",
                text:"复制",
                exportOptions: {
                    columns:':visible'
                }
            }, {
                extend: "csv",
                className: "btn purple btn-outline ",
                text:"导出CSV",
                exportOptions: {
                    columns:':visible'
                }
            }],
            responsive: !0,
            fixedHeader: {
                header: !0,
                headerOffset: table
            },
            pagingType: "bootstrap_full_number",
            //dom控制datatables元素的位置,比如按钮,不设置的话元素不会显示
            dom: "<'row' <'col-md-12'B>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>"
        });

        var tableWrapper = $("#sample_editable_1_wrapper");

        var nEditing = null;
        var nNew = false;

        $('#sample_editable_1_new').click(function (e) {
            e.preventDefault();

            if (nNew && nEditing) {
                if (confirm("Previose row not saved. Do you want to save it ?")) {
                    saveRow(oTable, nEditing); // save
                    $(nEditing).find("td:first").html("Untitled");
                    nEditing = null;
                    nNew = false;

                } else {
                    oTable.fnDeleteRow(nEditing); // cancel
                    nEditing = null;
                    nNew = false;
                    
                    return;
                }
            }

            var aiNew = oTable.fnAddData(['', '', '', '', '', '', '']);
            var nRow = oTable.fnGetNodes(aiNew[0]);
            editRow(oTable, nRow);
            nEditing = nRow;
            nNew = true;
        });

        table.on('click', '.delete', function (e) {
            e.preventDefault();

            if (confirm("Are you sure to delete this row ?") == false) {
                return;
            }

            var nRow = $(this).parents('tr')[0];
            oTable.fnDeleteRow(nRow);
            alert("Deleted! Do not forget to do some ajax to sync with backend :)");
        });

        table.on('click', '.cancel', function (e) {
            e.preventDefault();
            if (nNew) {
                oTable.fnDeleteRow(nEditing);
                nEditing = null;
                nNew = false;
            } else {
                restoreRow(oTable, nEditing);
                nEditing = null;
            }
        });

        table.on('click', '.edit', function (e) {
            e.preventDefault();

            /* Get the row as a parent of the link that was clicked on */
            var nRow = $(this).parents('tr')[0];

            if (nEditing !== null && nEditing != nRow) {
                /* Currently editing - but not this row - restore the old before continuing to edit mode */
                restoreRow(oTable, nEditing);
                editRow(oTable, nRow);
                nEditing = nRow;
            } else if (nEditing == nRow && this.innerHTML == "Save") {
                /* Editing this row and want to save it */
                saveRow(oTable, nEditing);
                nEditing = null;
                var jqInputs = $('>td', nRow);
                /*$.ajax({
                    type:"POST",
                    url:"/transac/updateRow",
                    data:{transacVolumn:jqInputs[3].value,transacDate:jqInputs[4].value},
                    dataType:"json",
                    success:function(data){
                        console.log("更改完成");
                    }
                })*/
                alert("Updated! Do not forget to do some ajax to sync with backend :)");
            } else {
                /* No edit in progress - let's start one */
                editRow(oTable, nRow);
                nEditing = nRow;
            }
        });
    }

    return {

        //main function to initiate the module
        init: function () {
            handleTable();
        }

    };

}();

jQuery(document).ready(function() {
    TableDatatablesEditable.init();
});