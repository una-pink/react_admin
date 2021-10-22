package com.df.service;

import com.df.mapper.CategoryMapper;
import com.df.pojo.Category;
import com.df.utils.PageRequest;
import com.df.utils.PageResult;
import com.df.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MFine
 */
@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;


    /**
     * Delete by primary key int.
     *
     * @param id the id
     * @return the int
     */
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }


    /**
     * 增加商品
     *
     * @param record 品类对象
     * @return the int
     */
    public int insert(Category record) {
        List<Integer> id = findIdByName(record.getName());
        if (id.size() != 0) {
            return -1;
        } else {
            return categoryMapper.insert(record);
        }
    }

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }


    /**
     * Select by primary key category.
     *
     * @param id the id
     * @return the category
     */
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }


    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }


    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }

    /**
     * @param parentId 父id
     * @return 品类数组
     */
    public List<Category> findAllByParentId(String parentId) {
        return categoryMapper.findAllByParentId(parentId);
    }

    /**
     * Find id by name list.
     *
     * @param name the name
     * @return the list
     */
    public List<Integer> findIdByName(String name) {
        return categoryMapper.findIdByName(name);
    }

    /**
     * Update by name int.
     *
     * @param updated the updated
     * @param name    the name
     * @return the int
     */
    public int updateByName(Category updated, String name) {
        return categoryMapper.updateByName(updated, name);
    }

    /**
     * Update name by name int.
     *
     * @param updatedName the updated name
     * @param name        the name
     * @return the int
     */
    public int updateNameByName(String updatedName, String name) {
        return categoryMapper.updateNameByName(updatedName, name);
    }

    public int updateNameById(String updatedName, Integer id) {
        return categoryMapper.updateNameById(updatedName, id);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    /**
     * @param pageRequest 获得分页请求信息
     * @return 返回分页信息
     */
    private PageInfo<Category> getPageInfo(PageRequest pageRequest) {
        int pageNumber = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNumber, pageSize);
        List<Category> categories = categoryMapper.findAll();
        return new PageInfo<>(categories);
    }

    /**
     * Find page page result.
     *
     * @param pageRequest the page request
     * @return the page result
     */
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }
}





