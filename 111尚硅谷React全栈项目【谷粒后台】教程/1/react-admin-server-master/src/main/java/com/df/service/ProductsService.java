package com.df.service;

import com.df.mapper.ProductsMapper;
import com.df.pojo.Products;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author MFine
 * @version 1.0
 * @date 2020/11/18 23:37
 **/

@Service
public class ProductsService {

    @Resource
    private ProductsMapper productsMapper;


    /**
     * Delete by primary key int.
     *
     * @param id the id
     * @return the int
     */
    public int deleteByPrimaryKey(Integer id) {
        return productsMapper.deleteByPrimaryKey(id);
    }


    /**
     * Insert int.
     *
     * @param record the record
     * @return the int
     */
    public int insert(Products record) {
        if (record.getIdStr() == null) {
            record.setIdStr(UUID.randomUUID().toString().replace("-",""));
        }
        return productsMapper.insert(record);
    }


    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    public int insertSelective(Products record) {
        return productsMapper.insertSelective(record);
    }


    /**
     * Select by primary key products.
     *
     * @param id the id
     * @return the products
     */
    public Products selectByPrimaryKey(Integer id) {
        return productsMapper.selectByPrimaryKey(id);
    }


    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    public int updateByPrimaryKeySelective(Products record) {
        return productsMapper.updateByPrimaryKeySelective(record);
    }


    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    public int updateByPrimaryKey(Products record) {
        return productsMapper.updateByPrimaryKey(record);
    }


    public List<Products> findAll() {
        return productsMapper.findAll();
    }

    /**
     * Count by id greater than integer.
     *
     * @param minId the min id
     * @return the integer
     */
    public Integer countByIdGreaterThan(Integer minId) {
        return productsMapper.countByIdGreaterThan(minId);
    }

    /**
     * Find all by desc list.
     *
     * @param desc the desc
     * @return the list
     */
    public List<Products> findAllByDesc(String desc) {
        return productsMapper.findAllByDesc(desc);
    }

    /**
     * Find all by name list.
     *
     * @param name the name
     * @return the list
     */
    public List<Products> findAllByName(String name) {
        return productsMapper.findAllByName(name);
    }


    public List<Products> findAllByDescLike(String likeDesc) {
        return productsMapper.findAllByDescLike(likeDesc);
    }

    public List<Products> findAllByNameLike(String likeName) {
        return productsMapper.findAllByNameLike(likeName);
    }

    public int updateStatusById(Integer updatedStatus, Integer id) {
        return productsMapper.updateStatusById(updatedStatus, id);
    }

    /**
     * 更新商品图片
     *
     * @param updatedImages 图片字符串
     * @param id            逐渐
     * @return 0 失败  1 成功
     */
    public int updateImagesById(StringBuilder updatedImages, Integer id) {
        return productsMapper.updateImagesById(updatedImages.toString(), id);
    }

    /**
     * @param products 商品
     * @return 1 成功 -- 0 失败
     */
    public int updateProductById(Products products) {
        return productsMapper.updateByPrimaryKey(products);
    }

	public Integer count(){
		 return productsMapper.count();
	}



}


