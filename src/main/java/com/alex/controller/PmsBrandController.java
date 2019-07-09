package com.alex.controller;

import com.alex.common.IPage;
import com.alex.common.ResultData;
import com.alex.model.PmsBrand;
import com.alex.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "PmsBrandController", description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @PreAuthorize("hasAuthority('pms:brand:read')")
    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public ResultData<List<PmsBrand>> getBrandList() {
        return ResultData.success(demoService.listAllBrand());
    }

    @PreAuthorize("hasAuthority('pms:brand:create')")
    @ApiOperation("添加品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResultData createBrand(@RequestBody PmsBrand pmsBrand) {
        int count = demoService.createBrand(pmsBrand);
        if (count == 1) {
            LOGGER.debug("createBrand success:{}", pmsBrand);
            return ResultData.success(pmsBrand);
        } else {
            LOGGER.debug("createBrand failed:{}", pmsBrand);
            return ResultData.failed("操作失败");

        }
    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResultData updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        int count = demoService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            LOGGER.debug("updateBrand success:{}", pmsBrandDto);
            return ResultData.success(pmsBrandDto);
        } else {
            LOGGER.debug("updateBrand failed:{}", pmsBrandDto);
            return ResultData.failed("操作失败");
        }
    }

    @PreAuthorize("hasAuthority('pms:brand:update')")
    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResultData deleteBrand(@PathVariable("id") Long id) {
        int count = demoService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("deleteBrand success :id={}", id);
            return ResultData.success(null);
        } else {
            LOGGER.debug("deleteBrand failed :id={}", id);
            return ResultData.failed("操作失败");
        }
    }

    @PreAuthorize("hasAuthority('pms:brand:read')")
    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultData<IPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                 @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = demoService.listBrand(pageNum, pageSize);
        return ResultData.success(IPage.restPage(brandList));
    }
    @PreAuthorize("hasAuthority('pms:brand:read')")
    @ApiOperation("获取指定id的品牌详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData<PmsBrand> brand(@PathVariable("id") Long id) {
        return ResultData.success(demoService.getBrand(id));
    }
}
