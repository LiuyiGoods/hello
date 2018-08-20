$(function() {
	
	// 查询数据
	var queryAll = function(){
		commonUtil.initTable({
	        url : "list",
	        search : true,
	        detailView : true,
	        pagination : true,
	        columns: [
	            {checkbox: true},
	            {field: 'id', visible: false, title: 'ID'},
	            {field: 'proName',align: 'center', title: '产品名称',width:150},
	            {field: 'proYprice',align: 'center', title: '原价',width:150},
	            {field: 'proSprice',align: 'center', title: '实价',width:150},
	            {field: 'proCprice',align: 'center', title : '成本价',width:150},
	            {field: 'catId',align: 'center', title : '类别ID',width:150},
	            {field: 'proDetail',align: 'center', title : '商品详情',width:150},
	            {field: 'proNum',align: 'center', title : '库存',width:150},
	            {field: 'picId',align: 'center', title : '图片ID',width:150},
	            {field: 'proStatus',align: 'center', title : '产品状态',width:150},
	            {field: 'cTime',align: 'center', title : '时间',width:150}
	        ]
	    });
	}
	// 绑定按钮事件
	/*var btns = $("#btns").find("a");
	btns.each(function(index, domEle) {
		var btn = $(domEle);
		var code = btn.data("code");
		if (code == "user:setRole") {
			btn.on("click", setRole);
		} else if (code == "user:add") {
			btn.on("click", addData);
		} else if(code == "user:update"){
			btn.on("click", updateData);
		}else if (code == "user:delete") {
			btn.on("click", deleteData);
		}
	});*/
	$("#querybtn").click(function(){
		queryAll();
	});
	queryAll();
});