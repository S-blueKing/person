package smbms.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;

import smbms.pojo.Provider;
import smbms.pojo.Role;
import smbms.pojo.User;
import smbms.service.ProviderService;
import smbms.service.ProviderServiceImpl;

@Controller
@RequestMapping("/provider")
public class ProviderControl {
	
	@Autowired
	private ProviderService providerservice;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView Provider(Integer pageIndex,
			String queryProName,String queryProCode) throws Exception {
		// 调用service查询方法
		List<Provider> list = providerservice.getProviderListByMap(null);
		Map<String, Object> map = new HashMap<String, Object>();
		int pageno = 1;
		if (pageIndex != null) {
			pageno = pageIndex.intValue();
		}
		map.put("start", pageno);
		map.put("size", 5);
		map.put("proName", queryProName);
		map.put("proCode", queryProCode);
		
		Page<Provider> proList = (Page<Provider>) providerservice.getProviderListByMap(map);
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("providerList", proList);
		model.put("totalCount", proList.getTotal());
		model.put("currentPageNo", pageno);
		model.put("totalPageCount", proList.getPages());
		// 结果存入model
		//model.put("providerlist", list);
		// 返回modelAndView，指定视图名(jsp文件名前缀)
		return new ModelAndView("providerlist", model);
	}

	
	 @RequestMapping(value="provideradd.html")
	 public ModelAndView proadd(){
		 return new ModelAndView("provideradd");
	 }
	
	 // 添加
	 @RequestMapping(method=RequestMethod.POST)
	 public ModelAndView proadd(@Valid Provider provider)
					 throws Exception{
		 ModelAndView mv=new ModelAndView();
		 int count =providerservice.insertProvider(provider);
		 if(count>0){
			 mv.setViewName("redirect:/provider");
		 }else{
			 mv.setViewName("provideradd");
		 }
		 return mv;
	 }


	 
	 @RequestMapping(value="providerview.html")
	 public ModelAndView seeView(){
		 return new ModelAndView("providerview");
	 }
	 
	 // 查看详细
	
	
	 
	 
	 @RequestMapping(value="/{pid}", method=RequestMethod.GET)
	 public ModelAndView getProvider(@PathVariable Integer pid) throws Exception{
		 Provider p=providerservice.getProviderById(pid);
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("provider", p);
		 ModelAndView mv=new ModelAndView();
		 mv.addObject(p);
		 mv.setViewName("providerview");
		 return mv;
		 
		 
	 }

}
