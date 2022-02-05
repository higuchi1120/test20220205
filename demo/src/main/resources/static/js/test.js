/**
 * 
 */
 
 // チェックボックス状態による入力可否切替
 function chkChkBox(st,checked){
	document.viewForm.elements["custDataViewList["+st+"].custDataBean.custname"].disabled=!checked;
	document.viewForm.elements["custDataViewList["+st+"].custDataBean.address"].disabled=!checked;
	document.viewForm.elements["custDataViewList["+st+"].custDataBean.telenum"].disabled=!checked;
	document.viewForm.elements["custDataViewList["+st+"].custDataBean.notes"].disabled=!checked;
}

// 全選択
function chkAll(checked){
	let _checks = document.viewForm.getElementsByClassName("checks");
	   
	for (let i = 0; i < _checks.length; i++) {
        _checks[i].checked = checked;
        chkChkBox(i,checked);
    }
}

// 削除確認
function chkDelete(){
	let _checks = document.viewForm.getElementsByClassName("checks");
	let _count=0;
	   
	for (let i = 0; i < _checks.length; i++) {
        if(_checks[i].checked){_count++;}
    }
	
	if(window.confirm("選択された "+_count+" 件を削除します。")){
		return true;
	}
	return false;
}

// 更新確認
function chkUpdate(){
	let _checks = document.viewForm.getElementsByClassName("checks");
	let _count=0;
	   
	for (let i = 0; i < _checks.length; i++) {
        if(_checks[i].checked){_count++;}
    }
	
	if(window.confirm("選択された "+_count+" 件を変更します。")){
		return true;
	}
	return false;
}

// 登録確認
function chkInsert(){
	
	// 登録欄入力内容取得
	let custname = document.controlForm.elements["custname"].value;
	let address = document.controlForm.elements["address"].value;
	let telenum = document.controlForm.elements["telenum"].value;
	let notes = document.controlForm.elements["notes"].value;
	
	if(custname==""){
		alert("顧客名は空欄で登録できません。");	// 嘘、本当はできる
		return false;
	}
	
	let msg = "顧客名  :"+custname+"\r\n"
			+ "住所    :"+address+"\r\n"
			+ "電話番号:"+telenum+"\r\n"
			+ "その他  :"+notes+"\r\n"
			+ "上記の内容で登録します。"
			
	if(window.confirm(msg)){
		return true;
	}
	return false
	
}

// 検索・登録入力クリア
function clrInput(){
	
	document.controlForm.elements["custname"].value="";
	document.controlForm.elements["address"].value="";
	document.controlForm.elements["telenum"].value="";
	document.controlForm.elements["notes"].value="";
	
}