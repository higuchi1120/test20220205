package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.CustDataBean;
import com.example.demo.dto.CustDataRepositoryServiceDTO;
import com.example.demo.form.ControlForm;
import com.example.demo.form.ViewForm;
import com.example.demo.service.CustDataRepositoryService;

/**
 * @author 
 * 顧客テーブルController
 */
@Controller
@RequestMapping("/")
public class CustViewController {
	
	@Autowired
	CustDataRepositoryService _custDataRepositoryService;
	@Autowired
	ControlForm _controlForm;
	@Autowired
	ViewForm _viewForm;
	
	@ModelAttribute
	ControlForm controlForm() {
		return new ControlForm();
	}
	@ModelAttribute
	ViewForm viewForm() {
		return new ViewForm();
	}

	/**
	 * 初期表示/全件表示
	 * @param model
	 */
	private void init(Model model) {

		// リポジトリから全件取得し、結果をフォームにセット
		CustDataRepositoryServiceDTO _ret = _custDataRepositoryService.getAllCustData();
		_viewForm.setCustDataViewList(_ret.getCustDataViewList());
		model.addAttribute("viewForm",_viewForm);
		
	}
	

	/**
	 * 初期表示/全件表示
	 * @param model
	 * @return
	 */
	@GetMapping
	public String getCustData(Model model) {
		
		init(model);
		
		return "Main";
		
	}
	
	/**
	 * 検索系
	 * @param custname
	 * @param address
	 * @param telenum
	 * @param notes
	 * @param model
	 * @return
	 */
	@GetMapping("/select")
	public String searchCustData(@RequestParam String custname, @RequestParam String address,@RequestParam String telenum,@RequestParam String notes,Model model) {
		
		// リポジトリから検索結果を取得し、結果をフォームにセット
		CustDataRepositoryServiceDTO _ret = _custDataRepositoryService.searchCustData(custname,address,telenum,notes);
		_viewForm.setCustDataViewList(_ret.getCustDataViewList());
		model.addAttribute("viewForm",_viewForm);
		
		// 検索欄がリセットされるのでフォームに詰め直す
		_controlForm.setCustname(custname);
		_controlForm.setAddress(address);
		_controlForm.setTelenum(telenum);
		_controlForm.setNotes(notes);
		model.addAttribute(_controlForm);
		
		return "Main";
	}
	
	/**
	 * 登録系
	 * @param custname
	 * @param address
	 * @param telenum
	 * @param notes
	 * @param model
	 * @return
	 */
	@PostMapping("/insert")
	public String insertCustData(@RequestParam String custname, @RequestParam String address,@RequestParam String telenum,@RequestParam String notes,Model model) {
		
		// 登録情報をbeanにセット
		CustDataBean _bean = new CustDataBean();
		_bean.setCustname(custname);
		_bean.setAddress(address);
		_bean.setTelenum(telenum);
		_bean.setNotes(notes);
		
		// beanをリストに詰め、DTOに持たせる
		List<CustDataBean> custDataList = new ArrayList<CustDataBean>();
		custDataList.add(_bean);
		CustDataRepositoryServiceDTO _dto = new CustDataRepositoryServiceDTO(custDataList);
		
		// リポジトリで登録実行
		_custDataRepositoryService.insertCustData(_dto);
		
		//画面全件表示処理
		init(model);
		return "Main";
	}
	
	/**
	 * 削除系
	 * @param viewForm
	 * @param model
	 * @return
	 */
	@PostMapping("/delete")
	public String deleteCustData(ViewForm viewForm,Model model) {
		
		// チェックボックスで選択されたレコードを抽出し、チェック情報のないEntityBeanのリストに詰め直す
		List<CustDataBean> _beanList = viewForm.getCustDataViewList().stream().filter(chk -> chk.isChecked()).map(bean->bean.getCustDataBean()).collect(Collectors.toList());
		
		// 削除EntityのリストをDTOに持たせる
		CustDataRepositoryServiceDTO _dto = new CustDataRepositoryServiceDTO(_beanList);
		
		// リポジトリで削除実行
		_custDataRepositoryService.deleteCustData(_dto);
		
		//画面全件表示処理
		init(model);
		return "Main";
		
	}
	
	/**
	 * 更新系
	 * @param viewForm
	 * @param model
	 * @return
	 */
	@PostMapping("/update")
	public String updateCustData(ViewForm viewForm,Model model) {

		// チェックボックスで選択されたレコードを抽出し、チェック情報のないEntityBeanのリストに詰め直す
		List<CustDataBean> _beanList = viewForm.getCustDataViewList().stream().filter(chk -> chk.isChecked()).map(bean->bean.getCustDataBean()).collect(Collectors.toList());
		
		// 更新EntityのリストをDTOに持たせる
		CustDataRepositoryServiceDTO _dto = new CustDataRepositoryServiceDTO(_beanList);
		
		// リポジトリで更新実行
		_custDataRepositoryService.updateCustData(_dto);

		//画面全件表示処理
		init(model);
		return "Main";
	}
	
}
