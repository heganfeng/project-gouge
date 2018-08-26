package com.gouge.service.impl;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.ApiMenu;
import com.gouge.dao.entity.SwingMenu;
import com.gouge.dao.mapper.SwingMenuMapper;
import com.gouge.dao.mapperext.ApiMenuMapperExt;
import com.gouge.dao.mapperext.SwingMenuMapperExt;
import com.gouge.dao.params.PageParam;
import com.gouge.dao.params.main.IdParam;
import com.gouge.dao.params.main.SwingMenuAdvancedParam;
import com.gouge.dao.vo.MenuVo;
import com.gouge.dao.vo.SwingMenuVo;
import com.gouge.exception.ApiException;
import com.gouge.kit.UUIDUtils;
import com.gouge.service.MenuService;
import com.gouge.util.BeanUtil;
import com.gouge.util.ObjectUtil;
import com.gouge.util.PageUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by grandfen on 17/8/3.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private ApiMenuMapperExt apiMenuMapperExt;
    @Autowired
    private SwingMenuMapperExt swingMenuMapperExt;
    @Autowired
    private SwingMenuMapper swingMenuMapper;

    @Override
    public SwingMenu getById(IdParam idParam) {
        return swingMenuMapper.selectByPrimaryKey(idParam.getId());
    }

    @Override
    public int saveOrUpdateMenu(SwingMenu menu) {
        int record = 0;
        if(null == menu.getId() || menu.getId().trim().equals("")) {
            menu.setCrtDate(new Date());
            menu.setId(UUIDUtils.generateUUID());
            record = swingMenuMapper.insertSelective(menu);
        }else{
            record = swingMenuMapper.updateByPrimaryKeySelective(menu);
        }
        return record;
    }

    @Override
    public int deleteSwingMenuById(IdParam idParam) {
        return swingMenuMapper.deleteByPrimaryKey(idParam.getId());
    }

    @Override
    public List<MenuVo> getMenus() {
        List<ApiMenu> menuList = apiMenuMapperExt.getAll();
        if (CollectionUtils.isEmpty(menuList))
            throw new ApiException("找不到菜单！");
        List<MenuVo> list = new ArrayList<>();
        for (ApiMenu menu: menuList){
            if(menu.getLevel() == 1){
                MenuVo vo = new MenuVo();
                BeanUtils.copyProperties(menu,vo);
                List<ApiMenu> apiMenus = new ArrayList<>();
                for (ApiMenu menusecond: menuList){
                    if(!StringUtils.isEmpty(menusecond.getParntId()) && menusecond.getParntId().equals(menu.getId())){
                        apiMenus.add(menusecond);
                    }
                }
                vo.setMenus(apiMenus);
                list.add(vo);
            }
        }
        return list;
    }

    @Override
    public List<SwingMenuVo> getSwingMenus() {
        List<SwingMenu> firstLists = swingMenuMapperExt.getFirstMenus();
        if (CollectionUtils.isEmpty(firstLists))
            throw new ApiException("找不到菜单！");
        List<SwingMenuVo> list = new ArrayList<>();
        iterationMenus(firstLists,list);
        return list;
    }

    /**
     * 迭代获取所以menus
     * @param firstLists
     * @param list
     */
    private void iterationMenus(List<SwingMenu> firstLists,List<SwingMenuVo> list){
        for (SwingMenu menu : firstLists){
            SwingMenuVo vo = new SwingMenuVo();
            BeanUtils.copyProperties(menu,vo);
            list.add(vo);
            List<SwingMenu> chindList = swingMenuMapperExt.getMenuForParantId(vo.getId());
            if(!chindList.isEmpty()){
                iterationMenus(chindList,vo.getMenus());
            }
        }
    }


    @Override
    public Page<SwingMenu> getPageMenus(SwingMenuAdvancedParam pageParam) {
        Integer pageNo = ObjectUtil.getPageNoIntValue(pageParam, PageUtil.PAGE_INDEX_STR, PageUtil.DEFAUL_PAGE_NO);
        Integer pageSize = ObjectUtil.getIntValue(pageParam, PageUtil.PAGE_SIZE_STR, PageUtil.DEFAUL_PAGE_SIZE);
        SwingMenu menu = new SwingMenu();
        BeanUtils.copyProperties(pageParam,menu);
        Map<String,Object> map = BeanUtil.transBean2Map(pageParam);
        return swingMenuMapperExt.getPageMenus(map,new RowBounds(pageNo,pageSize));
    }
}
