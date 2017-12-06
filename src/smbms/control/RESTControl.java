package smbms.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RESTControl {

	// ��Ʒ�б�
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public ModelAndView getProduct(){
		System.out.println("��Ʒ�б���ʵ��");
		return null;
	}
	
	// ͨ��Id��ѯ��Ʒ
	@RequestMapping(value="/product/{id}",method=RequestMethod.GET)
	public ModelAndView productList(@PathVariable String id){
		System.out.println("��ѯ " + id +" ����Ʒ��Ϣ");
		return null;
	}
	
	// ��Ʒ���
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public ModelAndView addProduct(){
		System.out.println("����Ʒ���");
		return null;
	}
	
	// ��Ʒɾ��
	@RequestMapping(value="/product/{id}",method=RequestMethod.DELETE)
	public ModelAndView delProduct(){
		System.out.println("��Ʒɾ��");
		return null;
	}
		
	// ��Ʒ��Ϣ����
	@RequestMapping(value="/product",method=RequestMethod.PUT)
	public ModelAndView updateProduct(){
		System.out.println("��Ʒ���²���");
		return null;
	}
}
