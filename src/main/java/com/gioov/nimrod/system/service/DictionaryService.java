package com.gioov.nimrod.system.service;

import com.gioov.common.web.exception.BaseResponseException;
import com.gioov.nimrod.common.easyui.Pagination;
import com.gioov.nimrod.system.entity.DictionaryEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author godcheese [godcheese@outlook.com]
 * @date 2018-02-22
 */
public interface DictionaryService {

    /**
     * 高效：添加数据字典到 ServletContext（内存）
     */
    void addDictionaryToServletContext();

    /**
     * 通过数据库获取数据字典值
     *
     * @param key
     * @param valueSlug
     * @return
     */
    Object getFromDatabase(String key, String valueSlug);

    /**
     * 从内存获取数据字典值
     *
     * @param key       数据字典键
     * @param valueSlug 数据字典值别名
     * @return 数据字典值
     */
    Object get(String key, String valueSlug);

    /**
     * 从内存获取数据字典值
     *
     * @param key          数据字典键
     * @param valueSlug    数据字典值别名
     * @param defaultValue 数据字典默认值
     * @return 数据字典值
     */
    Object get(String key, String valueSlug, Object defaultValue);

    /**
     * 指定数据字典键，从内存获取所有数据字典
     *
     * @param key 数据字典键
     * @return List<DictionaryEntity>
     */
    List<DictionaryEntity> get(String key);

    /**
     * 将数据字典包装成 map
     *
     * @return Map<String, Map<String, Object>>
     */
    Map<String, Map<String, Object>> keyValueMap();


    /**
     * 指定父级数据字典分类 id ，分页获取所有数据字典
     *
     * @param dictionaryCategoryId 数据字典分类 id
     * @param page                 页
     * @param rows                 每页显示数量
     * @return Pagination<DictionaryEntity>
     */
    Pagination<DictionaryEntity> pageAllByDictionaryCategoryId(Long dictionaryCategoryId, Integer page, Integer rows);

    /**
     * 新增数据字典
     *
     * @param dictionaryEntity DictionaryEntity
     * @return DictionaryEntity
     */
    DictionaryEntity insertOne(DictionaryEntity dictionaryEntity);

    /**
     * 保存数据字典
     *
     * @param dictionaryEntity DictionaryEntity
     * @return DictionaryEntity
     */
    DictionaryEntity updateOne(DictionaryEntity dictionaryEntity);

    /**
     * 指定数据字典 id ，批量删除数据字典
     *
     * @param idList 数据字典 id list
     * @return 已删除数据字典个数
     */
    int deleteAll(List<Long> idList);

    /**
     * 指定数据字典 id ，获取数据字典信息
     *
     * @param id 数据字典 id
     * @return DictionaryEntity
     */
    DictionaryEntity getOne(Long id);

    void exportAllByDictionaryCategoryIdList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Long> idList) throws BaseResponseException;

    void importAllByDictionaryCategoryId(MultipartFile multipartFile, Long categoryId) throws BaseResponseException;
}
