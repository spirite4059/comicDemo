package com.comic.web.controller;

import com.comic.web.base.controller.BaseController;
import com.comic.web.bean.PublicCai;
import com.comic.web.service.WebPublicCaiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/publicCai")
public class WebPublicCaiController extends BaseController
{
    @Autowired
    private WebPublicCaiService publicCaiService;

    //在主页第一个tab显示说明文件
    @RequestMapping("/gotoUpgradeIndex")
    public String gotoUpgradeIndex(Model model) throws Exception{
        return "admin/upgrade/index";
    }

    //用户相关操作
    @RequestMapping("/gotoList")
    public String gotoList(Model model) throws Exception{
        return "web/publicCai/list";
    }


    //请求分页;easyui自动进行处理
    @RequestMapping("/queryList")
    @ResponseBody
    public Map<String,Object> queryList(int page,int rows,PublicCai cai) throws Exception
    {
        Map<String,Object> data = new HashMap<String,Object>();
        PageHelper.startPage(page, rows);
        List<PublicCai> list = publicCaiService.getListByEntity(cai);
        PageInfo<PublicCai> pageInfo = new PageInfo<PublicCai>(list);

        data.put("rows", 		pageInfo.getList());
        data.put("pageSize", 	pageInfo.getPageSize());
        data.put("total", 		pageInfo.getTotal());
        return data;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/publicCaiSave")
    @ResponseBody
    public Map<String,Object>publicCaiSave(PublicCai cai){
        Map<String,Object> result = this.success(null);
        try{
                //cai.
                cai.setCreatDate(new Date());
                cai.setOp1Num(0);cai.setOp2Num(0);cai.setOp3Num(0);cai.setOp4Num(0);cai.setOp5Num(0);cai.setOp6Num(0);
                cai.setResultOpNum(-1); cai.setState(1);
                publicCaiService.insert(cai);

        }catch(Exception e){
            result = this.error(e.getMessage());
        }
        return result;
    }



    @RequestMapping("/update")   //admin/publicCai/update
    @ResponseBody
    public Map<String,Object> update(PublicCai cai){
        Map<String,Object> result = this.success(null);
        try{
                publicCaiService.update(cai); //服务直接更新
        }catch(Exception e){
            result = this.error(e.getMessage());
        }
        return result;
    }

//
//    @RequestMapping("/delete")
//    @ResponseBody
//    public Map<String,Object> delete(User user){
//        Map<String,Object> result = this.success(null);
//        try{
//            PublicCaiService.deleteByEntity(user);
//        }catch(Exception e){
//            result = this.error(e.getMessage());
//        }
//        return result;
//    }

}






